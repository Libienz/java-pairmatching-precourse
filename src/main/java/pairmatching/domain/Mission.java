package pairmatching.domain;

import static pairmatching.domain.Level.*;

public enum Mission {
    CAR_RACE("자동차경주", LEVEL1),
    LOTTO("로또", LEVEL1),
    BASEBALL("숫자야구", LEVEL1),
    SHOP("장바구니", LEVEL2),
    PAYMENT("결제", LEVEL2),
    SUBWAY("지하철노선도", LEVEL2),
    ENHANCEMENT("성능개선", LEVEL4),
    PUBLISH("배포", LEVEL4);

    private String name;
    private Level level;

    Mission(String name, Level level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public Level getLevel() {
        return level;
    }
}
