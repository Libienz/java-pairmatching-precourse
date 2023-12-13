package pairmatching.view;

import pairmatching.dto.PairsDto;

public class OutputView {

    private final MessageResolver messageResolver;

    public OutputView(MessageResolver messageResolver) {
        this.messageResolver = messageResolver;
    }

    public void printPairMatchResult(PairsDto pairsDto) {
        System.out.println(messageResolver.resolvePairMatchResultMessage(pairsDto));
    }

    public void printPairReset() {
        System.out.println("초기화 되었습니다.");
    }
}
