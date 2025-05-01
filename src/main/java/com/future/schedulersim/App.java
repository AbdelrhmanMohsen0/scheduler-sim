package com.future.schedulersim;

import atlantafx.base.theme.PrimerLight;
import com.future.schedulersim.view.ViewManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        Application.setUserAgentStylesheet(new PrimerLight().getUserAgentStylesheet());
        ViewManager.getInstance().showMainWindow();
    }
}