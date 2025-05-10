package com.future.schedulersim.controller;

import com.future.schedulersim.core.ProcessManager;
import com.future.schedulersim.model.Process;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ProcessCellController implements Initializable {
    public Label firstCell;
    public Label secondCell;
    public Label thirdCell;
    public Label fourthCell;
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
        firstCell.setText(process.getProcessName());
        secondCell.setText(String.valueOf(process.getArrivalTime()));
        thirdCell.setText(String.valueOf(process.getBurstTime()));
        fourthCell.setText(String.valueOf(process.getPriority()));
    }
}
