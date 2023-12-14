package pairmatching.view;

import pairmatching.domain.Confirm;
import pairmatching.domain.Course;
import pairmatching.domain.Function;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.PairMissionCourse;

public class InputMapper {
    private static final String PAIR_COURSE_INPUT_DELIMITER = ",";
    private static final int COURSE_IDX = 0;
    private static final int LEVEL_IDX = 1;
    private static final int MISSION_IDX = 2;

    public Function mapToFunction(String input) {
        return Function.from(input);
    }

    public PairMissionCourse mapToPairsCourse(String input) {
        String[] split = input.split(PAIR_COURSE_INPUT_DELIMITER);

        Course course = Course.from(split[COURSE_IDX]);
        Level level = Level.from(split[LEVEL_IDX]);
        Mission mission = Mission.from(split[MISSION_IDX], level);

        return new PairMissionCourse(course, mission);
    }

    public Confirm mapToConfirm(String input) {
        return Confirm.from(input);
    }
}
