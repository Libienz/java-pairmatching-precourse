package pairmatching.repository;

import static pairmatching.domain.Course.BACKEND;
import static pairmatching.domain.Course.FRONTEND;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;

public class CrewRepository {
    private static final String BACKEND_CREW_FILE_PATH = "src/main/resources/backend-crew.md";
    private static final String FRONTEND_CREW_FILE_PATH = "src/main/resources/frontend-crew.md";

    private final List<Crew> crews;

    public CrewRepository() throws IOException {
        crews = new ArrayList<>();
        init();
    }

    public void init() throws IOException {
        FileReader fileReader = new FileReader(BACKEND_CREW_FILE_PATH);
        BufferedReader br = new BufferedReader(fileReader);
        String line = "";
        while ((line = br.readLine()) != null) {
            crews.add(new Crew(BACKEND, line));
        }

        fileReader = new FileReader(FRONTEND_CREW_FILE_PATH);
        br = new BufferedReader(fileReader);
        line = "";
        while ((line = br.readLine()) != null) {
            crews.add(new Crew(FRONTEND, line));
        }
    }

    public List<Crew> findByCourse(Course course) {
        return crews.stream()
                .filter(crew -> crew.getCourse().equals(course))
                .collect(Collectors.toList());
    }
}
