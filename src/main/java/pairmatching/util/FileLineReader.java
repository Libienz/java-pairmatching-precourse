package pairmatching.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileLineReader {

    public static List<String> readFileFromPath(String path) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line); // 파일의 각 줄을 읽고 출력
            }
        } catch (IOException e) {
            e.printStackTrace(); // 파일 읽기 중 오류 발생 시 예외 처리
        }
        return lines;
    }
}
