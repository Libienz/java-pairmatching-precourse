package pairmatching.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Level;
import pairmatching.domain.Pair;
import pairmatching.domain.PairMissionCourse;
import pairmatching.domain.Pairs;
import pairmatching.dto.MatchResultDto;
import pairmatching.dto.PairDto;
import pairmatching.dto.PairReadResponseDto;
import pairmatching.repository.CrewRepository;
import pairmatching.repository.PairsRepository;

public class PairMatchingService {
    private static final int MAX_MATCH_TRY_COUNT = 3;
    private static final String PAIR_MATCH_FAIL_MESSAGE = "[ERROR] 페어 매칭에 실패했습니다";
    private final PairsRepository pairsRepository;
    private final CrewRepository crewRepository;

    public PairMatchingService(PairsRepository pairsRepository, CrewRepository crewRepository) {
        this.pairsRepository = pairsRepository;
        this.crewRepository = crewRepository;
    }

    public boolean matchExist(PairMissionCourse pairMissionCourse) {
        return pairsRepository.findPairsByCourse(pairMissionCourse).isPresent();
    }

    public MatchResultDto matchPair(PairMissionCourse pairMissionCourse) {
        List<Crew> crews = crewRepository.findByCourse(pairMissionCourse.getCourse());
        List<String> names = mapToNames(crews);

        int tryCount = 0;
        while (tryCount < MAX_MATCH_TRY_COUNT) {
            List<String> shuffled = shuffle(names);
            Pairs pairs = linearMatch(shuffled, pairMissionCourse.getCourse());
            boolean invalidPair = isInvalidPair(pairs, pairMissionCourse.getLevel());
            if (!invalidPair) {
                pairsRepository.addPair(pairMissionCourse, pairs);
                return MatchResultDto.from(pairs);
            }
            tryCount++;
        }
        throw new IllegalArgumentException(PAIR_MATCH_FAIL_MESSAGE);
    }

    public Pairs linearMatch(List<String> names, Course course) {
        List<Pair> pairs = new ArrayList<>();

        for (int i = 0; i < names.size(); i += 2) {
            if (i + 1 >= names.size()) {
                Crew crew1 = new Crew(course, names.get(i));
                pairs.get(pairs.size() - 1).addCrew(crew1);
                break;
            }
            Pair pair = Pair.of(new Crew(course, names.get(i)), new Crew(course, names.get(i + 1)));
            pairs.add(pair);
        }

        return new Pairs(pairs);
    }

    public PairReadResponseDto readPair(PairMissionCourse pairMissionCourse) {
        if (!matchExist(pairMissionCourse)) {
            return new PairReadResponseDto(false, null);
        }
        Pairs pairs = pairsRepository.findPairsByCourse(pairMissionCourse).get();
        List<PairDto> pairsDto = pairs.getPairs().stream()
                .map(PairDto::from)
                .collect(Collectors.toList());
        return new PairReadResponseDto(true, pairsDto);

    }

    public void resetPairs() {
        pairsRepository.resetPairs();
    }

    private List<String> shuffle(List<String> crews) {
        return Randoms.shuffle(crews);
    }

    private List<String> mapToNames(List<Crew> crews) {
        return crews.stream()
                .map(Crew::getName)
                .collect(Collectors.toList());
    }

    private boolean isInvalidPair(Pairs pairs, Level level) {
        List<Pair> existPairs = pairsRepository.findPairByLevel(level);
        for (Pair newPair : pairs.getPairs()) {
            boolean invalidPair = existPairs.stream()
                    .map(existPair -> existPair.sameCrewCount(newPair))
                    .anyMatch(sameNumber -> sameNumber > 2);
            if (invalidPair) {
                return false;
            }
        }
        return true;
    }
}
