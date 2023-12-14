package pairmatching.domain;

import java.util.Arrays;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private static final String NO_SUCH_LEVEL_MESSAGE = "[ERROR] 해당하는 레벨을 찾을 수 없습니다";
    private String name;

    Level(String name) {
        this.name = name;
    }

    public static Level from(String name) {
        return Arrays.stream(Level.values())
                .filter(level -> level.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NO_SUCH_LEVEL_MESSAGE));
    }
}
