package pairmatching.domain;

import java.util.Arrays;

public enum RematchConfirm {
    YES("네"),
    NO("아니오");

    private static final String NO_SUCH_CONFIRM_MESSAGE = "[ERROR] 해당하는 내용이 없습니다";
    private String code;

    RematchConfirm(String code) {
        this.code = code;
    }

    public RematchConfirm from(String code) {
        return Arrays.stream(RematchConfirm.values())
                .filter(rematchConfirm -> rematchConfirm.code.equals(code))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NO_SUCH_CONFIRM_MESSAGE));
    }
}
