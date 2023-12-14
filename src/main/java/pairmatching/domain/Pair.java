package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Pair {
    private final List<Crew> pair = new ArrayList<>();

    public List<Crew> getPair() {
        return pair;
    }

    public boolean addCrew(Crew crew) {
        return pair.add(crew);
    }
}
