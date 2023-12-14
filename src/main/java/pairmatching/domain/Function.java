package pairmatching.domain;

public enum Function {
    PAIR_MATCH("1", "페어 매칭"),
    PAIR_READ("2", "페어 조회"),
    PAIR_RESET("3", "페어 초기화"),
    QUIT("Q", "종료");

    private String code;
    private String name;

    Function(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
