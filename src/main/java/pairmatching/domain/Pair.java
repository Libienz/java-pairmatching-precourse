package pairmatching.domain;

import java.util.List;

public class Pair {
    private final List<String> pair;

    public Pair(List<String> pair) {
        this.pair = pair;
    }

    public List<String> getPair() {
        return pair;
    }

    public void addPair(String name) {
        pair.add(name);
    }

    public int countSameCrew(Pair target) {
        return (int) pair.stream()
                .filter(target.pair::contains)
                .count();
    }
}
