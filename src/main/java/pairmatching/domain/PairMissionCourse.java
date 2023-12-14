package pairmatching.domain;

import java.util.Objects;

public class PairMissionCourse {
    private final Course course;
    private final Mission mission;

    public PairMissionCourse(Course course, Mission mission) {
        this.course = course;
        this.mission = mission;
    }

    public Course getCourse() {
        return course;
    }

    public Mission getMission() {
        return mission;
    }

    public Level getLevel() {
        return mission.getLevel();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PairMissionCourse that = (PairMissionCourse) o;
        return course.equals(that.course) && mission.equals(that.mission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, mission);
    }
}
