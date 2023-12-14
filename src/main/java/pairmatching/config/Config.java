package pairmatching.config;

import pairmatching.controller.MainController;
import pairmatching.repository.CrewRepository;
import pairmatching.repository.PairsRepository;
import pairmatching.service.PairMatchingService;
import pairmatching.view.InputMapper;
import pairmatching.view.InputView;
import pairmatching.view.MessageResolver;
import pairmatching.view.OutputView;

public class Config {
    public InputView inputView() {
        return new InputView(inputMapper(), messageResolver());
    }

    public InputMapper inputMapper() {
        return new InputMapper();
    }

    public MessageResolver messageResolver() {
        return new MessageResolver();
    }

    public OutputView outputView() {
        return new OutputView(messageResolver());
    }

    public PairMatchingService pairMatchingService() {
        return new PairMatchingService(pairsRepository(), crewRepository());
    }

    public PairsRepository pairsRepository() {
        return new PairsRepository();
    }

    public CrewRepository crewRepository() {
        return new CrewRepository();
    }

    public MainController mainController() {
        return new MainController(inputView(), outputView(), pairMatchingService());
    }

}
