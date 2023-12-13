package pairmatching.repository;

import java.util.HashMap;
import java.util.Map;
import pairmatching.domain.Pairs;
import pairmatching.domain.Procedure;

public class PairMatchingRepository {
    public Map<Procedure, Pairs> map = new HashMap<>();

    public Pairs findByProcedure(Procedure procedure) {
        return map.getOrDefault(procedure, null);
    }

    public void savePairs(Procedure procedure, Pairs pairs) {
        map.put(procedure, pairs);
    }

    public void resetPairs() {
        map.clear();
    }
}
