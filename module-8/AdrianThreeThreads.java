// Adrian Marquez
// 05/13/2025
// Module 8.2 

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Random;

public class AdrianThreeThreads extends Application {

    private static final int COUNT = 10000;

    @Override
    public void start(Stage primaryStage) {
        TextArea textArea = new TextArea();
        textArea.setWrapText(true);

        BorderPane pane = new BorderPane();
        pane.setCenter(textArea);

        Scene scene = new Scene(pane, 600, 400);
        primaryStage.setTitle("Three Threads Output");
        primaryStage.setScene(scene);
        primaryStage.show();

        Thread letterThread = new Thread(() -> appendRandomLetters(textArea));
        Thread numberThread = new Thread(() -> appendRandomDigits(textArea));
        Thread symbolThread = new Thread(() -> appendRandomSymbols(textArea));

        letterThread.start();
        numberThread.start();
        symbolThread.start();
    }

    private void appendRandomLetters(TextArea textArea) {
        Random rand = new Random();
        for (int i = 0; i < COUNT; i++) {
            char c = (char) ('a' + rand.nextInt(26));
            appendText(textArea, String.valueOf(c));
        }
    }

    private void appendRandomDigits(TextArea textArea) {
        Random rand = new Random();
        for (int i = 0; i < COUNT; i++) {
            char c = (char) ('0' + rand.nextInt(10));
            appendText(textArea, String.valueOf(c));
        }
    }

    private void appendRandomSymbols(TextArea textArea) {
        char[] symbols = {'!', '@', '#', '$', '%', '&', '*'};
        Random rand = new Random();
        for (int i = 0; i < COUNT; i++) {
            char c = symbols[rand.nextInt(symbols.length)];
            appendText(textArea, String.valueOf(c));
        }
    }

    private void appendText(TextArea textArea, String text) {
        javafx.application.Platform.runLater(() -> textArea.appendText(text));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
