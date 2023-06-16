import java.awt.event.ActionListener;
// import java.beans.EventHandler;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
// import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class dailogbox {
    public void afterroomdetails()
    {
        Stage primaryStage = new Stage();
        // primaryStage.initStyle(StageStyle.UNDECORATED);
        BorderPane borderPane = new BorderPane();
        borderPane.setMaxHeight(Double.NEGATIVE_INFINITY);
        borderPane.setMaxWidth(Double.NEGATIVE_INFINITY);
        borderPane.setMinHeight(Double.NEGATIVE_INFINITY);
        borderPane.setMinWidth(Double.NEGATIVE_INFINITY);
        borderPane.setPrefHeight(138.0);
        borderPane.setPrefWidth(444.0);

        Pane topPane = new Pane();
        topPane.setPrefHeight(27.0);
        topPane.setPrefWidth(444.0);
        BorderPane.setAlignment(topPane, javafx.geometry.Pos.CENTER);

        Label topLabel = new Label("Hotel Room Details Confirmation");
        topLabel.setLayoutX(5.0);
        topLabel.setPrefHeight(29.0);
        topLabel.setPrefWidth(438.0);
        topLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        topLabel.setFont(new Font("System Bold", 12.0));

        topPane.getChildren().add(topLabel);
        borderPane.setTop(topPane);

        VBox centerVBox = new VBox();
        centerVBox.setPrefHeight(200.0);
        centerVBox.setPrefWidth(100.0);
        BorderPane.setAlignment(centerVBox, javafx.geometry.Pos.CENTER);

        Pane centerPane1 = new Pane();
        centerPane1.setPrefHeight(80.0);
        centerPane1.setPrefWidth(444.0);

        Label centerLabel = new Label("Your Hotel Room details successfully added.");
        centerLabel.setAlignment(javafx.geometry.Pos.CENTER);
        centerLabel.setLayoutX(10.0);
        centerLabel.setLayoutY(18.0);
        centerLabel.setPrefHeight(39.0);
        centerLabel.setPrefWidth(413.0);
        centerLabel.setTextFill(javafx.scene.paint.Color.web("#02841a"));
        centerLabel.setFont(new Font("System Bold", 19.0));

        centerPane1.getChildren().add(centerLabel);

        Pane centerPane2 = new Pane();
        centerPane2.setPrefHeight(30.0);
        centerPane2.setPrefWidth(444.0);

        Button button = new Button("Ok");
        button.setLayoutX(368.0);
        button.setLayoutY(-1.0);
        button.setMnemonicParsing(false);
        button.setFont(new Font("System Bold", 14.0));

        centerPane2.getChildren().add(button);

        centerVBox.getChildren().addAll(centerPane1, centerPane2);
        borderPane.setCenter(centerVBox);

        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.show();

        button.setOnAction(new EventHandler <ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    ScreenController s1 = new ScreenController();
                    try {

                        s1.HotelManager(event);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        });

    }
}
