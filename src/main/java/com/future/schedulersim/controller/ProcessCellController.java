package com.future.schedulersim.controller;

import com.future.schedulersim.core.ProcessManager;
import com.future.schedulersim.model.Process;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ProcessCellController implements Initializable {
    public Label processNameLabel;
    public Label arrivalTimeLabel;
    public Label burstTimeLabel;
    public Label priorityLabel;
    public Button deleteButton;
    private Process process;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        deleteButton.setOnAction(_ -> onDelete());
    }

    private void onDelete() {
        ProcessManager.getInstance().getProcessList().remove(process);
    }

    public void setProcessData(Process process) {
        this.process = process;
        processNameLabel.setText(process.getProcessName());
        arrivalTimeLabel.setText(String.valueOf(process.getArrivalTime()));
        burstTimeLabel.setText(String.valueOf(process.getBurstTime()));
        priorityLabel.setText(String.valueOf(process.getPriority()));
    }
}
