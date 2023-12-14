package pairmatching.domain;

import java.util.List;

public class Pairs {
    private final List<Pairs> pairs;

    public Pairs(List<Pairs> pairs) {
        this.pairs = pairs;
    }

    public List<Pairs> getPairs() {
        return pairs;
    }
}
