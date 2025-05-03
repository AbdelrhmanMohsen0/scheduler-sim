package com.future.schedulersim.controller;

import javafx.scene.control.Label;

public class FirstGanttChartCellController {
    public Label processNameLabel;
    public Label startTimeLabel;
    public Label endTimeLabel;

    public void setCellData(String processName, int startTime, int endTime) {
        processNameLabel.setText(processName);
        startTimeLabel.setText(String.valueOf(startTime));
        endTimeLabel.setText(String.valueOf(endTime));
    }
}
