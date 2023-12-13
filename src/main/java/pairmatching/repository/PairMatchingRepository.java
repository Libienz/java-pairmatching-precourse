package pairmatching.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import pairmatching.domain.Pair;
import pairmatching.domain.Pairs;
import pairmatching.domain.Procedure;

public class PairMatchingRepository {
    public Map<Procedure, Pairs> map = new HashMap<>();
    public List<Pair> pairHistory = new ArrayList<>();

    public Pairs findByProcedure(Procedure procedure) {
        return map.getOrDefault(procedure, null);
    }

    public void savePairs(Procedure procedure, Pairs pairs) {
        map.put(procedure, pairs);
    }

    public void resetPairs() {
        map.clear();
        pairHistory.clear();
    }

    public void savePairHistory(Pairs pairs) {
        pairHistory.addAll(pairs.getPairs());
    }

    public boolean cannotSave(Pair pair) {
        return pairHistory.stream()
                .map(pair::countSameCrew)
                .anyMatch(same -> same >= 2);
    }
}
