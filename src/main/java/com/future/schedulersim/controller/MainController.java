package com.future.schedulersim.controller;

import com.future.schedulersim.view.ViewManager;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    public VBox processesContainer;
    public Button addNewProcessButton;
    public Button ganttChartButton;
    public Button reportButton;
    public Button clearButton;
    public StackPane noProcessesPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addNewProcessButton.setOnAction(_ -> onAddNewProcess());
    }

    private void onAddNewProcess() {
        ViewManager.getInstance().showAddProcessWindow();
    }
}