package pairmatching.view;

import pairmatching.dto.MatchResultDto;
import pairmatching.dto.PairReadResponseDto;

public class OutputView {
    private final MessageResolver messageResolver;

    public OutputView(MessageResolver messageResolver) {
        this.messageResolver = messageResolver;
    }

    public void printPairMatchResult(MatchResultDto matchResultDto) {
        System.out.println(messageResolver.resolvePairMatchResultMessage(matchResultDto));
    }

    public void printPairRead(PairReadResponseDto pairReadResponseDto) {
        System.out.println(messageResolver.resolvePairReadMessage(pairReadResponseDto));
    }

    public void printPairReset() {
        System.out.println(messageResolver.resolvePairResetMessage());
    }

    public void printCourse() {
        System.out.println(messageResolver.resolveCourseAndMissionMessage());
    }
}
