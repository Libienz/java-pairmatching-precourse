package pairmatching.domain;

import java.util.Objects;

public class Procedure {
    private final Course course;
    private final Mission mission;

    public Procedure(Course course, Mission mission) {
        this.course = course;
        this.mission = mission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Procedure procedure = (Procedure) o;
        return course.equals(procedure.course) && mission.equals(procedure.mission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, mission);
    }
}
