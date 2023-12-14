package pairmatching.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.util.FileLineReader;

public class CrewRepository {
    private static final String BACKEND_CREW_FILE_PATH = "src/main/resources/backend-crew.md";
    private static final String FRONTEND_CREW_FILE_PATH = "src/main/resources/frontend-crew.md";

    private final List<Crew> crews;

    public CrewRepository() {
        crews = new ArrayList<>();
        init();
    }

    public List<Crew> findByCourse(Course course) {
        return crews.stream()
                .filter(crew -> crew.getCourse().equals(course))
                .collect(Collectors.toList());
    }

    private void init() {
        List<String> backendCrewNames = FileLineReader.readFileFromPath(BACKEND_CREW_FILE_PATH);
        List<String> frontendCrewNames = FileLineReader.readFileFromPath(FRONTEND_CREW_FILE_PATH);

        saveCrews(backendCrewNames, Course.BACKEND);
        saveCrews(frontendCrewNames, Course.FRONTEND);
    }

    private void saveCrews(List<String> backendCrewNames, Course course) {
        List<Crew> frontendCrews = backendCrewNames.stream()
                .map(name -> new Crew(course, name))
                .collect(Collectors.toList());
    }
}
