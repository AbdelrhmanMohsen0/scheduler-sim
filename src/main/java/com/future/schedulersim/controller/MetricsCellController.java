package com.future.schedulersim.controller;

import javafx.scene.control.Label;

public class MetricsCellController {

    public Label firstCell;
    public Label secondCell;
    public Label thirdCell;
    public Label fourthCell;

    public void setRowData(String... cells) {
        firstCell.setText(cells[0]);
        secondCell.setText(cells[1]);
        thirdCell.setText(cells[2]);
        fourthCell.setText(cells[3]);
    }
}
