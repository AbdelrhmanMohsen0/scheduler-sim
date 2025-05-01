package com.future.schedulersim.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewManager {
    // Singleton pattern
    private static ViewManager viewManager;
    private ViewManager(){}
    public static synchronized ViewManager getInstance() {
        if (viewManager == null)
            viewManager = new ViewManager();
        return viewManager;
    }

    public void showMainWindow() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/main-view.fxml"));
        WindowProperties window = new WindowProperties(fxmlLoader,"Priority Scheduling Simulator (Non-Preemptive)", 1000, 620);
        renderStage(window);
    }

    public void showAddProcessWindow() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/new-process-view.fxml"));
        WindowProperties window = new WindowProperties(fxmlLoader,"Add New Process", 550, 400);
        renderSubStage(window);
    }

    private void renderStage(WindowProperties window) {
        Stage stage = createStage(window);
        assert stage != null;
        stage.show();
    }

    private void renderSubStage(WindowProperties window) {
        Stage stage = createStage(window);
        assert stage != null;
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setMaxWidth(window.getWidth()*1.5);
        stage.setMaxHeight(window.getHeight()*1.5);
        stage.show();
    }

    private Stage createStage(WindowProperties window) {
        Scene scene;
        try {
            scene = new Scene(window.getLoader().load(), window.getWidth(), window.getHeight());
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
            return null;
        }
        Stage stage = new Stage();
        Image appIcon = new Image(Objects.requireNonNull(getClass().getResource("/icons/Clock.png")).toExternalForm());
        stage.setScene(scene);
        stage.setMinWidth(window.getWidth()*0.85);
        stage.setMinHeight(window.getHeight()*0.85);
        stage.setTitle(window.getTitle());
        stage.getIcons().add(appIcon);
        stage.setScene(scene);
        return stage;
    }
}
