package com.future.schedulersim.controller;

import com.future.schedulersim.core.ProcessManager;
import com.future.schedulersim.model.Process;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddNewProcessController implements Initializable {

    public TextField processNameField;
    public Spinner<Integer> arrivalTimeSpinner;
    public Spinner<Integer> burstTimeSpinner;
    public Spinner<Integer> prioritySpinner;
    public Label processNameError;
    public Label priorityError;
    public Button addProcessButton;
    public Button cancelButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addProcessButton.setOnAction(_ -> onAdd());
        cancelButton.setOnAction(_ -> onCancel());
        setSpinners(burstTimeSpinner, prioritySpinner);
        arrivalTimeSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Integer.MAX_VALUE, 0, 1));
        processNameField.setText(ProcessManager.getInstance().getRecommendedProcessName());
        processNameField.setOnKeyTyped(_ -> processNameError.setVisible(false));
    }

    @SafeVarargs
    private void setSpinners(Spinner<Integer>... spinners) {
        for (Spinner<Integer> spinner : spinners) {
            spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, Integer.MAX_VALUE, 1, 1));
        }
    }

    private void onAdd() {
        Process process = new Process();
        if (ProcessManager.getInstance().isProcessNameExist(processNameField.getText())) {
            processNameError.setVisible(true);
            return;
        }
        loadProcessData(process);
        ProcessManager.getInstance().addProcess(process);
        ((Stage) cancelButton.getScene().getWindow()).close();
    }

    private void onCancel() {
        ((Stage) cancelButton.getScene().getWindow()).close();
    }

    private void loadProcessData(Process process) {
        process.setProcessName(processNameField.getText());
        process.setArrivalTime(arrivalTimeSpinner.getValue());
        process.setBurstTime(burstTimeSpinner.getValue());
        process.setPriority(prioritySpinner.getValue());
    }

}
