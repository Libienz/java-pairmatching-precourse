package pairmatching;

import java.io.IOException;
import pairmatching.config.Config;

public class Application {
    public static void main(String[] args) {
        Config config = new Config();
        try {
            config.mainController().run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
