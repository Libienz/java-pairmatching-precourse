package pairmatching.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.domain.Crew;
import pairmatching.domain.Pair;
import pairmatching.domain.Pairs;
import pairmatching.domain.Procedure;
import pairmatching.dto.PairsDto;
import pairmatching.repository.PairMatchingRepository;

public class PairMatchService {

    private final PairMatchingRepository pairMatchingRepository;

    public PairMatchService(PairMatchingRepository pairMatchingRepository) {
        this.pairMatchingRepository = pairMatchingRepository;
    }

    public PairsDto match(Procedure procedure, List<Crew> crews) {
        boolean cannotMatch = false;
        List<Pair> pairs = new ArrayList<>();
        while (!cannotMatch) {
            List<String> shuffled = Randoms.shuffle(mapToNames(crews));
            pairs = new ArrayList<>();
            for (int i = 0; i + 1 < shuffled.size(); i += 2) {
                String crew1 = shuffled.get(i);
                String crew2 = shuffled.get(i + 1);
                pairs.add(new Pair(List.of(crew1, crew2)));
            }

            if (shuffled.size() % 2 == 1) {
                pairs.get(pairs.size() - 1).addPair(shuffled.get(shuffled.size() - 1));
            }
            boolean cannotSave = pairs.stream()
                    .anyMatch(pairMatchingRepository::cannotSave);
        }

        Pairs result = new Pairs(pairs);
        pairMatchingRepository.savePairHistory(result);
        pairMatchingRepository.savePairs(procedure, result);
        return PairsDto.from(result);
    }

    public PairsDto findPairs(Procedure procedure) {
        Pairs pairs = pairMatchingRepository.findByProcedure(procedure);
        return PairsDto.from(pairs);
    }

    public void resetPairs() {
        pairMatchingRepository.resetPairs();
    }

    private List<String> mapToNames(List<Crew> crews) {
        return crews.stream()
                .map(Crew::getName)
                .collect(Collectors.toList());
    }
}
