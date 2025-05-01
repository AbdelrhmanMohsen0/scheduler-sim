package com.future.schedulersim.view;

import javafx.fxml.FXMLLoader;

public class WindowProperties {
    private FXMLLoader loader;
    private String title;
    private double width;
    private double height;

    public WindowProperties(FXMLLoader loader, String title, double width, double height) {
        this.loader = loader;
        this.title = title;
        this.width = width;
        this.height = height;
    }

    public FXMLLoader getLoader() {
        return loader;
    }

    public void setLoader(FXMLLoader loader) {
        this.loader = loader;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
