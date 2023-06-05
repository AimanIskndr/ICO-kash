package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class CacheCalculator extends Application {

    @Override
    public void start(Stage primaryStage) {

        Pane root = new Pane();
        root.setStyle("-fx-background-color: #1E1E1A;");

        HBox MMBox = new HBox(5);
        Label MMprompt = createLabel("Main Memory Address Size (GB): ");
        TextField MMsize = new TextField();
        MMBox.getChildren().addAll(MMprompt, MMsize);
        MMBox.setTranslateX(185);
        MMBox.setTranslateY(80);

        HBox CMBox = new HBox(68);
        Label CMprompt = createLabel("Cache Memory Size (MB): ");
        TextField CMsize = new TextField();
        CMBox.getChildren().addAll(CMprompt, CMsize);
        CMBox.setTranslateX(185);
        CMBox.setTranslateY(130);

        HBox WordBox = new HBox(135);
        Label WordPrompt = createLabel("Word Size (byte): ");
        TextField WordSize = new TextField();
        WordBox.getChildren().addAll(WordPrompt, WordSize);
        WordBox.setTranslateX(185);
        WordBox.setTranslateY(180);

        HBox KSetBox = new HBox(24);
        Label KSetPrompt = createLabel("k-way (set associative cache): ");
        TextField KsetWay = new TextField();
        KSetBox.getChildren().addAll(KSetPrompt, KsetWay);
        KSetBox.setTranslateX(185);
        KSetBox.setTranslateY(230);

        Button DMapBtn = createButton("Direct Mapping");
        Button FAMapBtn = createButton("Fully/Associative\n      Mapping");
        Button SAMapBtn = createButton("Set-Associative\n     Mapping");

        HBox BtnBox = new HBox(10);
        BtnBox.setAlignment(Pos.CENTER);
        BtnBox.getChildren().addAll(DMapBtn, FAMapBtn, SAMapBtn);
        BtnBox.setTranslateX(400 - 182.5);
        BtnBox.setTranslateY(300);
        
        HBox BitsBox = new HBox(0);
        BitsBox.setTranslateX(100);
        BitsBox.setTranslateY(400);
        
        DMapBtn.setOnAction(e -> {
        	
            if(!(!checkFields(MMsize) || !checkFields(CMsize) || !checkFields(WordSize, false))){
            	
                int MMbits = 30 + (int) (Math.log(Double.parseDouble(MMsize.getText())) / Math.log(2));
                int Cachebits = 20 + (int) (Math.log(Double.parseDouble(CMsize.getText())) / Math.log(2));
                int Wordbits = (int) (Math.log(Double.parseDouble(WordSize.getText()) * 8.0) / Math.log(2));

                int tagBits = MMbits - Cachebits;
                int lineBits = Cachebits - Wordbits;

                BitsBox.getChildren().clear();
                KsetWay.setStyle("");

                LabelBox tagBox = new LabelBox("  Tag\n" + tagBits + " bits", (600.0 * tagBits/MMbits));
                LabelBox lineBox = new LabelBox("  Line\n" + lineBits + " bits", (600.0 * lineBits/MMbits));
                LabelBox wordBox = new LabelBox("Word\n" + Wordbits + " bits", (600.0 * Wordbits/MMbits));
                
                BitsBox.getChildren().addAll(tagBox, lineBox, wordBox);
            }
        });

        FAMapBtn.setOnAction(e -> {
        	
            if(checkFields(MMsize) && checkFields(CMsize) && checkFields(WordSize, false)){
            	
                int MMbits = 30 + (int) (Math.log(Double.parseDouble(MMsize.getText())) / Math.log(2));
                int Wordbits = (int) (Math.log(Double.parseDouble(WordSize.getText()) * 8.0) / Math.log(2));
                int tagBits = MMbits - Wordbits;

                BitsBox.getChildren().clear();
                KsetWay.setStyle("");

                LabelBox tagBox = new LabelBox("  Tag\n" + tagBits + " bits", (600.0 * tagBits/MMbits));
                LabelBox wordBox = new LabelBox("Word\n" + Wordbits + " bits", (600.0 * Wordbits/MMbits));
                BitsBox.getChildren().addAll(tagBox, wordBox);
            }
        });

        SAMapBtn.setOnAction(e -> {
        	
            if(checkFields(MMsize) && checkFields(CMsize) && checkFields(WordSize, false) && checkFields(KsetWay, true)){
            	
                int MMbits = 30 + (int) (Math.log(Double.parseDouble(MMsize.getText())) / Math.log(2));
                int Cachebits = 20 + (int) (Math.log(Double.parseDouble(CMsize.getText()) / Double.parseDouble(KsetWay.getText())) / Math.log(2));
                int Wordbits = (int) (Math.log(Double.parseDouble(WordSize.getText()) * 8.0) / Math.log(2));

                int tagBits = MMbits - Cachebits;
                int lineBits = Cachebits - Wordbits;

                BitsBox.getChildren().clear();

                LabelBox tagBox = new LabelBox("  Tag\n" + tagBits + " bits", (600.0 * tagBits/MMbits));
                LabelBox lineBox = new LabelBox("  Line\n" + lineBits + " bits", (600.0 * lineBits/MMbits));
                LabelBox wordBox = new LabelBox("Word\n" + Wordbits + " bits", (600.0 * Wordbits/MMbits));
                
                BitsBox.getChildren().addAll(tagBox, lineBox, wordBox);
            }
        });

        root.getChildren().addAll(MMBox, CMBox, WordBox, KSetBox, BtnBox, BitsBox);

        Scene scene = new Scene(root, 800, 600);

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
    
    private boolean checkFields(TextField field){
    	
    	if(field.getText().isEmpty()){
    		field.setStyle("-fx-border-color: red;");
            return false;
    	}
        
        try {
            double value = (Math.log(Double.parseDouble(field.getText())) / Math.log(2));
            if(value != (int) value){
                field.setStyle("-fx-border-color: red;");
                return false;
            }
            else {
                field.setStyle("");
            }
        } catch (NumberFormatException e) {
            field.setStyle("-fx-border-color: red;");
            return false;
        }
        return true;
    }
    
    private boolean checkFields(TextField field, boolean flag){
    	
    	if(field.getText().isEmpty()){
    		field.setStyle("-fx-border-color: red;");
            return false;
    	}
        
        try {
            double value = Double.parseDouble(field.getText());
            
            if(value <= 0 || (flag && value <= 1)){
                field.setStyle("-fx-border-color: red;");
                return false;
            }
            
            if(flag) {
            	value = Math.log(value) / Math.log(2);
            	if(value != (int) value) return false;
            }
            
            else {
                field.setStyle("");
            }
        } catch (NumberFormatException e) {
            field.setStyle("-fx-border-color: red;");
            return false;
        }
        return true;
    }
    
    class LabelBox extends StackPane {

        private Rectangle rectangle;
        private Label label;

        public LabelBox(String labelText, double x) {
        	
            rectangle = new Rectangle(x, 69);
            rectangle.setFill(Color.web("#dec50b"));
            rectangle.setStroke(Color.WHITE);
            rectangle.setStrokeWidth(2.5);
            rectangle.setStrokeType(StrokeType.OUTSIDE);

            label = new Label(labelText);
            label.setStyle("-fx-font-size: 14px;");

            getChildren().addAll(rectangle, label);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
