package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class CacheCalculator extends Application {

    @Override
    public void start(Stage primaryStage) {

        Pane root = new Pane();
        root.setStyle("-fx-background-color: #2b4457;");

        HBox MMBox = new HBox(5);
        Label MMprompt = createLabel("Main Memory Address Size (Gb): ");
        TextField MMsize = new TextField();
        MMBox.getChildren().addAll(MMprompt, MMsize);
        MMBox.setTranslateX(135);
        MMBox.setTranslateY(80);

        HBox CMBox = new HBox(68);
        Label CMprompt = createLabel("Cache Memory Size (Mb): ");
        TextField CMsize = new TextField();
        CMBox.getChildren().addAll(CMprompt, CMsize);
        CMBox.setTranslateX(135);
        CMBox.setTranslateY(130);

        HBox WordBox = new HBox(135);
        Label WordPrompt = createLabel("Word Size (byte): ");
        TextField WordSize = new TextField();
        WordBox.getChildren().addAll(WordPrompt, WordSize);
        WordBox.setTranslateX(135);
        WordBox.setTranslateY(180);

        HBox KSetBox = new HBox(24);
        Label KSetPrompt = createLabel("k-way (set associative cache): ");
        TextField KsetWay = new TextField();
        KSetBox.getChildren().addAll(KSetPrompt, KsetWay);
        KSetBox.setTranslateX(135);
        KSetBox.setTranslateY(230);

        Button DMapBtn = createButton("Direct Mapping");
        Button FAMapBtn = createButton("Fully/Associative\n      Mapping");
        Button SAMapBtn = createButton("Set-Associative\n     Mapping");

        HBox BtnBox = new HBox(10);
        BtnBox.setAlignment(Pos.CENTER);
        BtnBox.getChildren().addAll(DMapBtn, FAMapBtn, SAMapBtn);
        BtnBox.setTranslateX(350 - 182.5);
        BtnBox.setTranslateY(300);
        
        Rectangle BitsBox = new Rectangle(100, 400, 500, 77);
        BitsBox.setFill(Color.web("#f1fa8c"));
        BitsBox.setStroke(Color.BLACK);

        root.getChildren().addAll(MMBox, CMBox, WordBox, KSetBox, BtnBox, BitsBox);

        Scene scene = new Scene(root, 700, 550);

        primaryStage.setTitle("Cache Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Label createLabel(String text) {
        Label label = new Label(text);
        label.setTextFill(Color.WHITE);
        label.setFont(Font.font("Verdana", FontWeight.BOLD, 15.5));
        return label;
    }

    private Button createButton(String text) {
        Button button = new Button(text);
        button.setPrefWidth(115);
        button.setPrefHeight(42);
        button.setAlignment(Pos.CENTER);
        return button;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
