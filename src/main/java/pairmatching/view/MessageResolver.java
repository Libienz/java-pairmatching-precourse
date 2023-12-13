package pairmatching.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.dto.PairDto;
import pairmatching.dto.PairsDto;

public class MessageResolver {
    public String resolveCourseMessage() {
        StringBuilder message = new StringBuilder();
        message.append("#############################################");
        message.append("과정: " + Course.BACKEND + " | " + Course.FRONTEND + "\n");
        message.append("미션:\n");

        for (Level level : Level.values()) {
            message.append("  - ").append(level.getName()).append(": ");

            // Filter missions by level
            Stream<Mission> missions = Stream.of(Mission.values())
                    .filter(mission -> mission.getLevel() == level);

            // Collect mission names into a comma-separated string
            String missionNames = missions.map(Mission::getName)
                    .collect(Collectors.joining(" | "));

            message.append(missionNames).append("\n");
        }
        message.append("#############################################");
        return message.toString();
    }

    public String resolvePairMatchResultMessage(PairsDto pairsDto) {
        StringBuilder message = new StringBuilder("페어 매칭 결과입니다.\n");

        List<PairDto> pairs = pairsDto.getPairs();
        for (PairDto pairDto : pairs) {
            List<String> crews = pairDto.getCrews();
            String joinedCrews = String.join(" : ", crews);
            message.append(joinedCrews).append("\n");
        }
        return message.toString();
    }

}
