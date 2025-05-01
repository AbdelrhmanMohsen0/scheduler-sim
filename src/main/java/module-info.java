module com.future.schedulersim {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.future.schedulersim to javafx.fxml;
    exports com.future.schedulersim;
}