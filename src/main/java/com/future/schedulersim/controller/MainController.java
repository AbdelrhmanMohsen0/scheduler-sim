package com.future.schedulersim.controller;

import com.future.schedulersim.core.ProcessManager;
import com.future.schedulersim.model.ProcessNodeData;
import com.future.schedulersim.view.ComponentGenerator;
import com.future.schedulersim.view.ViewManager;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import com.future.schedulersim.model.Process;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    public VBox processesContainer;
    public Button addNewProcessButton;
    public Button ganttChartButton;
    public Button reportButton;
    public Button clearButton;
    public StackPane noProcessesPane;
    private final ObservableList<Process> processList = ProcessManager.getInstance().getProcessList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addNewProcessButton.setOnAction(_ -> onAddNewProcess());
        clearButton.setOnAction(_ -> onClear());
        ganttChartButton.setOnAction(_ -> onGanttChart());
        processList.addListener((ListChangeListener<Process>) _ -> {
            processesContainer.getChildren().clear();
            if (processList.isEmpty()) {
                handleNoProcesses();
                return;
            }
            noProcessesPane.setVisible(false);
            noProcessesPane.setManaged(false);
            ganttChartButton.setDisable(false);
            reportButton.setDisable(false);
            for (Process process : processList) {
                processesContainer.getChildren().add(createProcessPane(process));
            }
        });

    }

    private void onGanttChart() {
        ViewManager.getInstance().showGanttChartWindow();
    }

    private void onClear() {
        processList.clear();
        handleNoProcesses();
    }

    private Node createProcessPane(Process process) {
        return ComponentGenerator.generateCell("/fxml/process-cell-view.fxml", controller ->
                ((ProcessCellController) controller).setProcessData(process));
    }

    private void onAddNewProcess() {
        ViewManager.getInstance().showAddProcessWindow();
    }

    private void handleNoProcesses() {
        noProcessesPane.setVisible(true);
        noProcessesPane.setManaged(true);
        ganttChartButton.setDisable(true);
        reportButton.setDisable(true);
    }
}