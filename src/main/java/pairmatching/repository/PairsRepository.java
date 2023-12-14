package pairmatching.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import pairmatching.domain.Level;
import pairmatching.domain.Pair;
import pairmatching.domain.PairMissionCourse;
import pairmatching.domain.Pairs;

public class PairsRepository {
    private final Map<PairMissionCourse, Pairs> matchedPairs = new HashMap<>();

    public void addPair(PairMissionCourse course, Pairs pairs) {
        matchedPairs.put(course, pairs);
    }

    public Optional<Pairs> findPairsByCourse(PairMissionCourse course) {
        return Optional.ofNullable(matchedPairs.get(course));
    }

    public List<Pair> findPairByLevel(Level level) {
        return matchedPairs.keySet().stream()
                .filter(pairMissionCourse -> pairMissionCourse.getLevel().equals(level))
                .map(matchedPairs::get)
                .map(Pairs::getPairs)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public void resetPairs() {
        matchedPairs.clear();
    }
}
