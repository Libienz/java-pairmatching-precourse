package pairmatching.controller;

import static pairmatching.domain.Confirm.NO;
import static pairmatching.domain.Function.PAIR_MATCH;
import static pairmatching.domain.Function.PAIR_READ;
import static pairmatching.domain.Function.PAIR_RESET;
import static pairmatching.domain.Function.QUIT;

import pairmatching.domain.Function;
import pairmatching.domain.PairMissionCourse;
import pairmatching.dto.MatchResultDto;
import pairmatching.dto.PairReadResponseDto;
import pairmatching.service.PairMatchingService;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MainController {
    private final InputView inputView;
    private final OutputView outputView;
    private final PairMatchingService pairMatchingService;

    public MainController(InputView inputView, OutputView outputView, PairMatchingService pairMatchingService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.pairMatchingService = pairMatchingService;
    }

    public void run() {
        Function function = inputView.readFunction();
        while (!function.equals(QUIT)) {
            execFunction(function);
            function = inputView.readFunction();
        }
    }

    public void execFunction(Function function) {
        if (function.equals(PAIR_MATCH)) {
            PairMissionCourse pairMissionCourse = inputView.readPairMissionCourse();
            if (pairMatchingService.matchExist(pairMissionCourse) && inputView.readConfirm().equals(NO)) {
                return;
            }
            MatchResultDto matchResultDto = pairMatchingService.matchPair(pairMissionCourse);
            outputView.printPairMatchResult(matchResultDto);
        }
        if (function.equals(PAIR_READ)) {
            PairMissionCourse pairMissionCourse = inputView.readPairMissionCourse();
            PairReadResponseDto pairReadResponseDto = pairMatchingService.readPair(pairMissionCourse);
            outputView.printPairRead(pairReadResponseDto);
        }
        if (function.equals(PAIR_RESET)) {
            pairMatchingService.resetPairs();
            outputView.printPairReset();
        }
    }
}
