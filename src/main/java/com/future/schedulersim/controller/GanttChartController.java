package com.future.schedulersim.controller;

import com.future.schedulersim.core.ProcessManager;
import com.future.schedulersim.model.Process;
import com.future.schedulersim.view.ComponentGenerator;
import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class GanttChartController implements Initializable {
    public Button closeButton;
    public HBox ganttChartCellsContainer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        closeButton.setOnAction(_ -> onClose());
        Platform.runLater(() -> {
            List<Process> processes = ProcessManager.getInstance().getGanttChartList();
            Process firstProcess = processes.getFirst();
            ganttChartCellsContainer.getChildren().add(ComponentGenerator.generateCell(
                    "/fxml/first-gantt-chart-cell-view.fxml",
                    controller -> ((FirstGanttChartCellController) controller).setCellData(
                            firstProcess.getProcessName(),
                            firstProcess.getStartTime(),
                            firstProcess.getEndTime()
            )));
            for (int i = 1; i < processes.size(); ++i) {
                int index = i;
                ganttChartCellsContainer.getChildren().add(ComponentGenerator.generateCell(
                        "/fxml/gantt-chart-cell-view.fxml",
                        controller -> ((GanttChartCellController) controller).setCellData(
                                processes.get(index).getProcessName(),
                                processes.get(index).getEndTime()
                )));
            }

        });
    }

    private void onClose() {
        ((Stage) closeButton.getScene().getWindow()).close();
    }
}
