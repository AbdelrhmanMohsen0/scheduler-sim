module com.future.schedulersim {
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.logging;
    requires atlantafx.base;

    opens com.future.schedulersim to javafx.fxml;
    exports com.future.schedulersim;
    exports com.future.schedulersim.controller;
    opens com.future.schedulersim.controller to javafx.fxml;
}