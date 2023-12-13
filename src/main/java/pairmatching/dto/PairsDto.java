package pairmatching.dto;

import java.util.List;
import java.util.stream.Collectors;
import pairmatching.domain.Pairs;

public class PairsDto {
    public final List<PairDto> pairs;

    private PairsDto(List<PairDto> pairs) {
        this.pairs = pairs;
    }

    public static PairsDto from(Pairs pairs) {
        List<PairDto> pairsDto = pairs.getPairs().stream()
                .map(PairDto::from)
                .collect(Collectors.toList());
        return new PairsDto(pairsDto);
    }

    public List<PairDto> getPairs() {
        return pairs;
    }
}
