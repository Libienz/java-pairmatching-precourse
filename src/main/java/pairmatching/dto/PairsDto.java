package pairmatching.dto;

import java.util.List;
import java.util.stream.Collectors;
import pairmatching.domain.Pairs;

public class PairsDto {
    private final List<PairDto> pairsDto;

    private PairsDto(List<PairDto> pairsDto) {
        this.pairsDto = pairsDto;
    }

    public static PairsDto from(Pairs pairs) {
        return new PairsDto(pairs.getPairs().stream()
                .map(PairDto::from)
                .collect(Collectors.toList()));
    }

    public List<PairDto> getPairsDto() {
        return pairsDto;
    }
}
