package pairmatching.domain;

import java.util.Arrays;

public enum Function {
    PAIR_MATCH("1", "페어 매칭"),
    PAIR_READ("2", "페어 조회"),
    PAIR_RESET("3", "페어 초기화"),
    QUIT("Q", "종료");

    private static final String NO_SUCH_FUNCTION_MESSAGE = "[ERROR] 해당하는 기능을 찾을 수 없습니다";
    private String code;
    private String name;

    Function(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static Function from(String code) {
        return Arrays.stream(Function.values())
                .filter(function -> function.code.equals(code))
                .findFirst()
                .orElseThrow((() -> new IllegalArgumentException(NO_SUCH_FUNCTION_MESSAGE)));
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
