package pairmatching.domain;

import java.util.List;

public class Pair {
    private final List<Crew> pair;

    private Pair(List<Crew> pair) {
        this.pair = pair;
    }

    public static Pair of(Crew crew1, Crew crew2) {
        return new Pair(List.of(crew1, crew2));
    }

    public List<Crew> getPair() {
        return pair;
    }

    public boolean addCrew(Crew crew) {
        return pair.add(crew);
    }
}
