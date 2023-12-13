package pairmatching.domain;

import java.util.List;

public class Pair {
    private final List<String> pair;

    public Pair(List<String> pair) {
        this.pair = pair;
    }

    public void addPair(String name) {
        pair.add(name);
    }
}
