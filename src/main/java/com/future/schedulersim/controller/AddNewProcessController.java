package com.future.schedulersim.controller;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;

public class AddNewProcessController {

    public TextField processNameField;
    public Spinner<Integer> arrivalTimeSpinner;
    public Spinner<Integer> burstTimeSpinner;
    public Spinner<Integer> prioritySpinner;
    public Label processNameError;
    public Label priorityError;
    public Button addProcessButton;
    public Button cancelButton;
}
