package menu;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        Controller controller = new Controller(inputView);
        controller.run();
    }
}
