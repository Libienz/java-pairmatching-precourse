package pairmatching.domain;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private static final String NO_SUCH_COURSE_MESSAGE = "[ERROR] 해당하는 코스를 찾을 수 없습니다";
    private String name;

    Course(String name) {
        this.name = name;
    }

    public static Course from(String name) {
        return Arrays.stream(Course.values())
                .filter(course -> course.name.equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NO_SUCH_COURSE_MESSAGE));
    }

    public String getName() {
        return name;
    }
}