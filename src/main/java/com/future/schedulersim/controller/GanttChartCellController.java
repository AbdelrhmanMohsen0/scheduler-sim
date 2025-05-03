package com.future.schedulersim.controller;

import javafx.scene.control.Label;

public class GanttChartCellController {
    public Label processNameLabel;
    public Label endTimeLabel;

    public void setCellData(String processName, int endTime) {
        processNameLabel.setText(processName);
        endTimeLabel.setText(String.valueOf(endTime));
    }
}
