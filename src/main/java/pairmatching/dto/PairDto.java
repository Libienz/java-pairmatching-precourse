package pairmatching.dto;

import java.util.ArrayList;
import java.util.List;
import pairmatching.domain.Pair;

public class PairDto {
    private final List<String> crews;

    private PairDto(List<String> crews) {
        this.crews = crews;
    }

    public static PairDto from(Pair pair) {
        List<String> crews = new ArrayList<>(pair.getPair());
        return new PairDto(crews);
    }

    public List<String> getCrews() {
        return crews;
    }
}
