package pairmatching;

import pairmatching.config.Config;

public class Application {
    public static void main(String[] args) {
        Config config = new Config();
        config.mainController().run();
    }
}
