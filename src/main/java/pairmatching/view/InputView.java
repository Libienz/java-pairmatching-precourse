package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.Confirm;
import pairmatching.domain.Function;
import pairmatching.domain.PairMissionCourse;

public class InputView {
    private final InputMapper inputMapper;
    private final MessageResolver messageResolver;

    public InputView(InputMapper inputMapper, MessageResolver messageResolver) {
        this.inputMapper = inputMapper;
        this.messageResolver = messageResolver;
    }

    public Function readFunction() {
        System.out.println(messageResolver.resolveFunctionsMessage());
        return inputMapper.mapToFunction(Console.readLine());
    }

    public PairMissionCourse readPairMissionCourse() {
        System.out.println(messageResolver.resolveInputCourseMessage());
        return inputMapper.mapToPairsCourse(Console.readLine());
    }

    public Confirm readConfirm() {
        System.out.println(messageResolver.resolveConfirmMessage());
        return inputMapper.mapToConfirm(Console.readLine());
    }
}
