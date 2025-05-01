package com.future.schedulersim.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ComponentGenerator {

    /**
     * Generates an AnchorPane view from the specified FXML file and allows
     * additional setup of the associated controller.
     *
     *
     * @param <T> The type of the controller associated with the FXML view.
     * @param fxmlPath The path to the FXML file, relative to the classpath.
     *                 For example, "/fxml/student/course.fxml".
     * @param controllerSetup A {@code Consumer<T>} that accepts the controller
     *                        for additional setup or configuration. Can be null
     *                        if no setup is required.
     * @return The loaded {@code AnchorPane} view, or {@code null} if an exception occurs.
     *
     * @throws RuntimeException If the FXML file cannot be loaded or the controller
     *                          cannot be retrieved, an exception is logged and a
     *                          null value is returned.
     *
     * <p><strong></strong></p>
     * <pre>{@code
     * AnchorPane courseCard = ComponentGenerator.generateView(
     *     "/fxml/student/course.fxml",
     *     controller -> ((CourseController) controller).setCourseData(course, student.getID())
     * );
     * }</pre>
     */
    public static <T> AnchorPane generateCell(String fxmlPath, Consumer<T> controllerSetup) {
        AnchorPane view = null;
        try {
            FXMLLoader loader = new FXMLLoader(ComponentGenerator.class.getResource(fxmlPath));
            view = loader.load();

            // Retrieve the controller and perform additional setup
            T controller = loader.getController();
            if (controllerSetup != null) {
                controllerSetup.accept(controller);
            }
        } catch (Exception e) {
            Logger.getLogger(ComponentGenerator.class.getName()).log(Level.SEVERE, null, e);
        }
        return view;
    }
}
