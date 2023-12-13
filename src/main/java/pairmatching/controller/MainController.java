package pairmatching.controller;

import pairmatching.domain.FunctionMode;
import pairmatching.domain.Procedure;
import pairmatching.domain.RematchConfirm;
import pairmatching.dto.PairsDto;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

public class MainController {

    private final InputView inputView;
    private final OutputView outputView;
    private final PairMatchController pairMatchController;

    public MainController(InputView inputView, OutputView outputView, PairMatchController pairMatchController) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.pairMatchController = pairMatchController;
    }

    public void run() {
        FunctionMode functionMode = inputView.readFunctionMode();
        while (functionMode != FunctionMode.QUIT) {
            if (functionMode.equals(FunctionMode.PAIR_READ)) {
                Procedure procedure = inputView.readProcedure();
                if (pairMatchController.read(procedure) != null) {
                    RematchConfirm rematchConfirm = inputView.readRematch();
                    if (rematchConfirm.equals(RematchConfirm.NO)) {
                        continue;
                    }
                }
                PairsDto read = pairMatchController.read(procedure);
                outputView.printPairMatchResult(read);
            }
            if (functionMode.equals(FunctionMode.PAIR_MATCH)) {
                Procedure procedure = inputView.readProcedure();
                PairsDto match = pairMatchController.match(procedure);
                outputView.printPairMatchResult(match);
            }
            if (functionMode.equals(FunctionMode.PAIR_RESET)) {
                pairMatchController.reset();
                outputView.printPairReset();
            }
            functionMode = inputView.readFunctionMode();
        }
    }
}
