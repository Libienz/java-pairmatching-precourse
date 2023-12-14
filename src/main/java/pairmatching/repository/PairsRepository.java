package pairmatching.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
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
}
