package pairmatching.dto;

import java.util.List;
import java.util.stream.Collectors;
import pairmatching.domain.Pairs;

public class MatchResultDto {
    private final List<PairDto> pairsDto;

    private MatchResultDto(List<PairDto> pairsDto) {
        this.pairsDto = pairsDto;
    }

    public static MatchResultDto from(Pairs pairs) {
        return new MatchResultDto(pairs.getPairs().stream()
                .map(PairDto::from)
                .collect(Collectors.toList()));
    }

    public List<PairDto> getPairsDto() {
        return pairsDto;
    }
}
