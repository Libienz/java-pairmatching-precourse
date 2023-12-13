package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.FunctionMode;
import pairmatching.domain.Procedure;

public class InputView {
    private final InputMapper inputMapper;

    public InputView(InputMapper inputMapper) {
        this.inputMapper = inputMapper;
    }

    public FunctionMode readFunctionMode() {
        System.out.println("기능을 선택하세요.");
        System.out.println("1. 페어 매칭\n"
                + "2. 페어 조회\n"
                + "3. 페어 초기화\n"
                + "Q. 종료");
        return inputMapper.mapToFunctionMode(Console.readLine());
    }

    public Procedure readProcedure() {
        System.out.println("과정, 레벨, 미션을 선택하세요.\n"
                + "ex) 백엔드, 레벨1, 자동차경주");
        return inputMapper.mapToProcedure(Console.readLine());
    }


}