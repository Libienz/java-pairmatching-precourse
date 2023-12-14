package pairmatching.dto;

import java.util.List;
import java.util.stream.Collectors;
import pairmatching.domain.Crew;
import pairmatching.domain.Pair;

public class PairDto {
    private final List<String> crewNames;

    private PairDto(List<String> crewNames) {
        this.crewNames = crewNames;
    }

    public static PairDto from(Pair pair) {
        return new PairDto(pair.getPair().stream()
                .map(Crew::getName)
                .collect(Collectors.toList()));
    }

    public List<String> getCrewNames() {
        return crewNames;
    }
}
