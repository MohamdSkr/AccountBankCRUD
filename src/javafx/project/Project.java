package javafx.project;

import View.ViewManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class Project extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        ViewManager.openRegisterPage();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
