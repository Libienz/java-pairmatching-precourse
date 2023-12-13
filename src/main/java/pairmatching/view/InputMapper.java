package pairmatching.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import pairmatching.domain.Course;
import pairmatching.domain.FunctionMode;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.Procedure;

public class InputMapper {
    private static final String INVALID_FORM_MESSAGE = "[ERROR] 입력 폼이 올바르지 않습니다";
    private static final String PROCEDURE_INPUT_REGEX = "([^,]+),\\s*([^,]+),\\s*([^,]+)";

    public FunctionMode mapToFunctionMode(String input) {
        return FunctionMode.from(input);
    }

    public Procedure mapToProcedure(String input) {
        validateProcedureInput(input);
        String[] parts = input.split(",");

        String courseName = parts[0].trim();
        String levelName = parts[1].trim();
        String missionName = parts[2].trim();

        Course course = Course.from(courseName);
        Level level = Level.from(levelName);
        Mission mission = Mission.from(missionName, level);

        return new Procedure(course, mission);
    }

    private void validateProcedureInput(String input) {
        Pattern pattern = Pattern.compile(PROCEDURE_INPUT_REGEX);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(INVALID_FORM_MESSAGE);
        }

    }
}
