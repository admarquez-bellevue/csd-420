
// Adrian Marquez
// 03/29/2026
// Module 1.2

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardViewer extends Application {

    private ImageView[] cardViews = new ImageView[4];

    @Override
    public void start(Stage stage) {

        // Container for cards
        HBox cardsBox = new HBox(10);

        for (int i = 0; i < 4; i++) {
            cardViews[i] = new ImageView();
            cardViews[i].setFitWidth(120);
            cardViews[i].setFitHeight(180);
            cardViews[i].setPreserveRatio(true);
            cardsBox.getChildren().add(cardViews[i]);
        }

        // Refresh button
        Button refreshBtn = new Button("Refresh Cards");

        refreshBtn.setOnAction(e -> displayRandomCards());

        VBox root = new VBox(15);
        root.getChildren().addAll(cardsBox, refreshBtn);

        // First load
        displayRandomCards();

        Scene scene = new Scene(root, 600, 300);
        stage.setTitle("Random Card Viewer");
        stage.setScene(scene);
        stage.show();
    }

    private void displayRandomCards() {

        // Build deck
        List<Integer> deck = new ArrayList<>();
        for (int i = 1; i <= 52; i++) {
            deck.add(i);
        }

        Collections.shuffle(deck);

        String basePath = "module-1/module-1.2/src/cards/";

        for (int i = 0; i < 4; i++) {

            File f = new File(basePath + deck.get(i) + ".png");

            System.out.println("Loading: " + f.getAbsolutePath());
            System.out.println("Exists: " + f.exists());

            Image image = new Image(f.toURI().toString());
            cardViews[i].setImage(image);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}