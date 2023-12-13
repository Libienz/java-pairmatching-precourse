package pairmatching.config;

import java.io.IOException;
import pairmatching.controller.MainController;
import pairmatching.controller.PairMatchController;
import pairmatching.repository.CrewRepository;
import pairmatching.repository.PairMatchingRepository;
import pairmatching.service.PairMatchService;
import pairmatching.view.InputMapper;
import pairmatching.view.InputView;
import pairmatching.view.MessageResolver;
import pairmatching.view.OutputView;

public class Config {

    public InputView inputView() {
        return new InputView(inputMapper());
    }

    public MessageResolver messageResolver() {
        return new MessageResolver();
    }

    public InputMapper inputMapper() {
        return new InputMapper();
    }

    public OutputView outputView() {
        return new OutputView(messageResolver());
    }

    public PairMatchController pairMatchController() throws IOException {
        return new PairMatchController(pairMatchService(), crewRepository());
    }

    public CrewRepository crewRepository() throws IOException {
        return new CrewRepository();
    }

    public PairMatchService pairMatchService() {
        return new PairMatchService(pairMatchingRepository());
    }

    public PairMatchingRepository pairMatchingRepository() {
        return new PairMatchingRepository();
    }

    public MainController mainController() throws IOException {
        return new MainController(inputView(), outputView(), pairMatchController());
    }
}
