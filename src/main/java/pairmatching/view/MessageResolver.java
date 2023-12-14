package pairmatching.view;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import pairmatching.domain.Confirm;
import pairmatching.domain.Course;
import pairmatching.domain.Function;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;

public class MessageResolver {
    private static final String INPUT_FUNCTION_MESSAGE = "기능을 선택하세요.\n";
    private static final String INPUT_CONFIRM_MESSAGE = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n";

    public String resolveFunctionsMessage() {
        return INPUT_FUNCTION_MESSAGE + Arrays.stream(Function.values())
                .map(function -> function.getCode() + ". " + function.getName())
                .collect(Collectors.joining("\n"));
    }

    public String resolveCourseAndMissionMessage() {
        return "#############################################\n"
                + resolveCourseMessage()
                + resolveMissionMessage()
                + "\n#############################################";
    }

    public String resolveConfirmMessage() {
        return INPUT_CONFIRM_MESSAGE + Arrays.stream(Confirm.values())
                .map(Confirm::getName)
                .collect(Collectors.joining(" | "));
    }

    private String resolveCourseMessage() {
        return Arrays.stream(Course.values())
                .map(Course::getName)
                .collect(Collectors.joining("과정: ", " | ", "\n"));
    }

    private String resolveMissionMessage() {
        Map<Level, String> missionsByLevel = Arrays.stream(Mission.values())
                .collect(Collectors.groupingBy(Mission::getLevel,
                        Collectors.mapping(Mission::getName, Collectors.joining(" | "))));

        return Stream.of(Level.values())
                .map(level -> "  - " + level.getName() + ": " + missionsByLevel.getOrDefault(level, ""))
                .collect(Collectors.joining("\n", "미션:\n", "\n"));
    }
}
