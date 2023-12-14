package pairmatching.domain;

import java.util.Arrays;

public enum Confirm {
    YES("네", true),
    NO("아니오", false);

    private static final String NO_SUCH_CONFIRM_MESSAGE = "[ERROR] 해당하는 응답을 찾을 수 없습니다";
    private String name;
    private boolean confirmed;

    Confirm(String name, boolean confirmed) {
        this.name = name;
        this.confirmed = confirmed;
    }

    public static Confirm from(String name) {
        Arrays.stream(Confirm.values())
                .filter(confirm -> confirm.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NO_SUCH_CONFIRM_MESSAGE));
    }
}
