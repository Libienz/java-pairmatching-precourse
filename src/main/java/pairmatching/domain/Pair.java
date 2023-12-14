package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Pair {
    private List<Crew> pair;

    private Pair(List<Crew> pair) {
        this.pair = pair;
    }

    public static Pair of(Crew crew1, Crew crew2) {
        List<Crew> crews = new ArrayList<>();
        crews.add(crew1);
        crews.add(crew2);
        return new Pair(crews);
    }

    public List<Crew> getPair() {
        return pair;
    }

    public boolean addCrew(Crew crew) {
        return pair.add(crew);
    }

    public boolean containCrew(Crew crew) {
        return pair.stream()
                .anyMatch(crew::equals);
    }

    public int sameCrewCount(Pair newPair) {
        return (int) newPair.getPair().stream()
                .filter(this.pair::contains)
                .count();
    }

}
