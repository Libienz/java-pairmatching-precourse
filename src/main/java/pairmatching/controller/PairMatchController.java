package pairmatching.controller;

import java.util.List;
import pairmatching.domain.Crew;
import pairmatching.domain.Procedure;
import pairmatching.dto.PairsDto;
import pairmatching.repository.CrewRepository;
import pairmatching.service.PairMatchService;

public class PairMatchController {
    private final PairMatchService pairMatchService;
    private final CrewRepository crewRepository;

    public PairMatchController(PairMatchService pairMatchService, CrewRepository crewRepository) {
        this.pairMatchService = pairMatchService;
        this.crewRepository = crewRepository;
    }

    public PairsDto match(Procedure procedure) {
        List<Crew> crews = crewRepository.findByCourse(procedure.getCourse());
        return pairMatchService.match(procedure, crews);
    }

    public void reset() {
        pairMatchService.resetPairs();
    }

    public PairsDto read(Procedure procedure) {
        return pairMatchService.findPairs(procedure);
    }
}
