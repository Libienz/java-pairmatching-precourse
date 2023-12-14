package pairmatching.domain;

import static pairmatching.domain.Level.LEVEL1;
import static pairmatching.domain.Level.LEVEL2;
import static pairmatching.domain.Level.LEVEL4;

import java.util.Arrays;

public enum Mission {
    CAR_RACE("자동차경주", LEVEL1),
    LOTTO("로또", LEVEL1),
    NUMBER_BASEBALL("숫자야구", LEVEL1),
    SHOP_CART("장바구니", LEVEL2),
    PAYMENT("결제", LEVEL2),
    SUBWAY("지하철노선도", LEVEL2),
    PERFORMANCE_ENHANCEMENT("성능개선", LEVEL4),
    PUBLISH("배포", LEVEL4);

    private static final String NO_SUCH_MISSION_MESSAGE = "[ERROR] 해당하는 미션을 찾을 수 없습니다";
    private String name;
    private Level level;

    Mission(String name, Level level) {
        this.name = name;
        this.level = level;
    }

    public static Mission from(String name, Level level) {
        return Arrays.stream(Mission.values())
                .filter(mission -> mission.name.equals(name) && mission.level.equals(level))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NO_SUCH_MISSION_MESSAGE));
    }

    public String getName() {
        return name;
    }

    public Level getLevel() {
        return level;
    }
}
