package pairmatching.dto;

import java.util.List;

public class PairReadResponseDto {
    private final boolean pairExist;
    private final List<PairDto> pairs;

    public PairReadResponseDto(boolean pairExist, List<PairDto> pairs) {
        this.pairExist = pairExist;
        this.pairs = pairs;
    }

    public boolean isPairExist() {
        return pairExist;
    }

    public List<PairDto> getPairs() {
        return pairs;
    }
}
