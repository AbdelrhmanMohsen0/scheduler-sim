package com.future.schedulersim.controller;

import com.future.schedulersim.core.ProcessManager;
import com.future.schedulersim.model.Process;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

public class AddNewProcessController implements Initializable {

    public TextField processNameField;
    public Spinner<Integer> arrivalTimeSpinner;
    public Spinner<Integer> burstTimeSpinner;
    public Spinner<Integer> prioritySpinner;
    public Label processNameError;
    public Label arrivalError;
    public Button addProcessButton;
    public Button cancelButton;

    private final UnaryOperator<TextFormatter.Change> numericFilter = change -> {
        String newText = change.getControlNewText();
        return newText.matches("\\d*") ? change : null;
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addProcessButton.setOnAction(_ -> onAdd());
        cancelButton.setOnAction(_ -> onCancel());
        setSpinners(burstTimeSpinner, prioritySpinner);
        arrivalTimeSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Integer.MAX_VALUE, 0, 1));
        arrivalTimeSpinner.getEditor().setTextFormatter(new TextFormatter<>(numericFilter));
        processNameField.setText(ProcessManager.getInstance().getRecommendedProcessName());
        processNameField.setOnKeyTyped(_ -> processNameError.setVisible(false));
        arrivalTimeSpinner.setOnKeyTyped(_ -> arrivalError.setVisible(false));
    }

    @SafeVarargs
    private void setSpinners(Spinner<Integer>... spinners) {
        for (Spinner<Integer> spinner : spinners) {
            spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, Integer.MAX_VALUE, 1, 1));
            spinner.getEditor().setTextFormatter(new TextFormatter<>(numericFilter));
        }
    }

    private void onAdd() {
        Process process = new Process();
        if (ProcessManager.getInstance().isProcessNameExist(processNameField.getText())) {
            processNameError.setVisible(true);
            return;
        }
        if (ProcessManager.getInstance().isProcessArrivalTimeExist(arrivalTimeSpinner.getValue())) {
            arrivalError.setVisible(true);
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
