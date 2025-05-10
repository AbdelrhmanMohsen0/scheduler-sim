package com.future.schedulersim.controller;

import com.future.schedulersim.core.ProcessManager;
import com.future.schedulersim.model.Process;
import com.future.schedulersim.view.ComponentGenerator;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static com.future.schedulersim.util.ProcessMetricsCalc.*;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MetricsController implements Initializable {

    public VBox processesContainer;
    public Button closeButton;

    private final List<Process> processes = ProcessManager.getInstance().getGanttChartList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        closeButton.setOnAction(_ -> onClose());
        loadProcesses();
        processesContainer.getChildren().add(createAveragePane());
    }

    private void loadProcesses() {
        for (Process process : processes) {
            processesContainer.getChildren().add(createMetricsPane(process));
        }
    }

    private Node createMetricsPane(Process process) {
        String secondCell = String.valueOf(calcWaitingTime(process));
        String thirdCell = String.valueOf(calcTurnaroundTime(process));
        String fourthCell = String.valueOf(calcResponseTime(process));
        return ComponentGenerator.generateCell("/fxml/metrics-cell-view.fxml", controller ->
                ((MetricsCellController) controller).setRowData(process.getProcessName(), secondCell, thirdCell, fourthCell));
    }

    private Node createAveragePane() {
        String secondCell = String.valueOf(calcAverageWaitingTime(processes));
        String thirdCell = String.valueOf(calcAverageTurnaroundTime(processes));
        String fourthCell = String.valueOf(calcAverageResponseTime(processes));

        Node node =  ComponentGenerator.generateCell("/fxml/metrics-cell-view.fxml", controller ->
                ((MetricsCellController) controller).setRowData("Average", secondCell, thirdCell, fourthCell));
        node.setStyle("-fx-background-color: #eee; -fx-text-fill: white");
        return node;
    }

    private void onClose() {
        ((Stage) closeButton.getScene().getWindow()).close();
    }
}
