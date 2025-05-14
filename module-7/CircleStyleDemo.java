// Adrian Marquez
// 05/13/2025
// Module 7.2

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleStyleDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create four circles
        Circle circle1 = new Circle(50);
        circle1.getStyleClass().add("plaincircle");

        Circle circle2 = new Circle(50);
        circle2.setId("redcircle");

        Circle circle3 = new Circle(50);  javafx-sdk-24.0.1
        circle3.setId("greencircle");

        Circle circle4 = new Circle(50);
        circle4.getStyleClass().addAll("plaincircle", "circleborder");

        // Layout
        HBox hbox = new HBox(20, circle1, circle2, circle3, circle4);
        hbox.getStyleClass().add("border");
        hbox.setStyle("-fx-padding: 20; -fx-alignment: center;");

        // Scene
        Scene scene = new Scene(hbox);
        scene.getStylesheets().add("mystyle.css"); // Load external CSS

        primaryStage.setTitle("Styled Circles");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

