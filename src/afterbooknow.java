import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class afterbooknow {

    public void try_1(ActionEvent event,String hname) throws Exception{

        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();

        BorderPane root = new BorderPane();
            root.setMaxHeight(Double.NEGATIVE_INFINITY);
            root.setMaxWidth(Double.NEGATIVE_INFINITY);
            root.setMinHeight(Double.NEGATIVE_INFINITY);
            root.setMinWidth(Double.NEGATIVE_INFINITY);
            root.setPrefHeight(490.0);
            root.setPrefWidth(566.0);
    
            Label hotelNameLabel = new Label(hname);
            hotelNameLabel.setAlignment(javafx.geometry.Pos.CENTER);
            hotelNameLabel.setPrefHeight(51.0);
            hotelNameLabel.setPrefWidth(515.0);
            Font hotelNameFont = new Font("MV Boli", 30.0);
            hotelNameLabel.setFont(hotelNameFont);
            BorderPane.setAlignment(hotelNameLabel, javafx.geometry.Pos.CENTER);
            root.setTop(hotelNameLabel);
    
            VBox centerVBox = new VBox();
            centerVBox.setPrefHeight(429.0);
            centerVBox.setPrefWidth(566.0);
            BorderPane.setAlignment(centerVBox, javafx.geometry.Pos.CENTER);
    
            Pane pane1 = new Pane();
            pane1.setPrefHeight(62.0);
            pane1.setPrefWidth(566.0);
    
            Pane pane2 = new Pane();
            pane2.setPrefHeight(62.0);
            pane2.setPrefWidth(566.0);
    
            Label availableRoomsLabel = new Label("Available Rooms");
            availableRoomsLabel.setLayoutX(97.0);
            availableRoomsLabel.setLayoutY(15.0);
            availableRoomsLabel.setPrefHeight(32.0);
            availableRoomsLabel.setPrefWidth(158.0);
            Font labelFont = new Font(20.0);
            availableRoomsLabel.setFont(labelFont);
    
            Label roomsCountLabel = new Label("5");
            roomsCountLabel.setAlignment(javafx.geometry.Pos.CENTER);
            roomsCountLabel.setLayoutX(332.0);
            roomsCountLabel.setLayoutY(15.0);
            roomsCountLabel.setPrefHeight(32.0);
            roomsCountLabel.setPrefWidth(175.0);
            roomsCountLabel.setFont(labelFont);
    
            pane2.getChildren().addAll(availableRoomsLabel, roomsCountLabel);
    
            Pane pane3 = new Pane();
            pane3.setPrefHeight(62.0);
            pane3.setPrefWidth(566.0);
    
            Label checkInLabel = new Label("Check in date");
            checkInLabel.setLayoutX(96.0);
            checkInLabel.setLayoutY(15.0);
            checkInLabel.setPrefHeight(32.0);
            checkInLabel.setPrefWidth(138.0);
            checkInLabel.setFont(labelFont);
    
            DatePicker checkInDatePicker = new DatePicker();
            checkInDatePicker.setLayoutX(333.0);
            checkInDatePicker.setLayoutY(19.0);
    
            pane3.getChildren().addAll(checkInLabel, checkInDatePicker);
    
            Pane pane4 = new Pane();
            pane4.setPrefHeight(62.0);
            pane4.setPrefWidth(566.0);
    
            Label checkOutLabel = new Label("Check out date");
            checkOutLabel.setLayoutX(96.0);
            checkOutLabel.setLayoutY(15.0);
            checkOutLabel.setPrefHeight(32.0);
            checkOutLabel.setPrefWidth(138.0);
            checkOutLabel.setFont(labelFont);
    
            DatePicker checkOutDatePicker = new DatePicker();
            checkOutDatePicker.setLayoutX(334.0);
            checkOutDatePicker.setLayoutY(19.0);
    
            pane4.getChildren().addAll(checkOutLabel, checkOutDatePicker);
    
            Pane pane5 = new Pane();
            pane5.setPrefHeight(62.0);
            pane5.setPrefWidth(566.0);
    
            Label guestsLabel = new Label("No. of Guests");
            guestsLabel.setLayoutX(97.0);
            guestsLabel.setLayoutY(14.0);
            guestsLabel.setPrefHeight(32.0);
            guestsLabel.setPrefWidth(133.0);
            guestsLabel.setFont(labelFont);
    
            ChoiceBox<String> guestsChoiceBox = new ChoiceBox<>();
            guestsChoiceBox.setLayoutX(335.0);
            guestsChoiceBox.setLayoutY(18.0);
            guestsChoiceBox.setPrefHeight(25.0);
            guestsChoiceBox.setPrefWidth(174.0);
    
            pane5.getChildren().addAll(guestsLabel, guestsChoiceBox);
    
            Pane pane6 = new Pane();
            pane6.setPrefHeight(62.0);
            pane6.setPrefWidth(566.0);
    
            Label totalPriceLabel = new Label("Total Price");
            totalPriceLabel.setLayoutX(98.0);
            totalPriceLabel.setLayoutY(14.0);
            totalPriceLabel.setPrefHeight(32.0);
            totalPriceLabel.setPrefWidth(133.0);
            totalPriceLabel.setFont(labelFont);
    
            Label priceLabel = new Label("10000/-");
            priceLabel.setAlignment(javafx.geometry.Pos.CENTER);
            priceLabel.setContentDisplay(ContentDisplay.CENTER);
            priceLabel.setLayoutX(337.0);
            priceLabel.setLayoutY(14.0);
            priceLabel.setPrefHeight(32.0);
            priceLabel.setPrefWidth(172.0);
            priceLabel.setFont(labelFont);
    
            pane6.getChildren().addAll(totalPriceLabel, priceLabel);
    
            Pane pane7 = new Pane();
            pane7.setPrefHeight(62.0);
            pane7.setPrefWidth(566.0);
    
            Button bookNowButton = new Button("Book Now");
            bookNowButton.setLayoutX(236.0);
            bookNowButton.setLayoutY(16.0);
            bookNowButton.setMnemonicParsing(false);
            Font buttonFont = new Font("System Bold", 15.0);
            bookNowButton.setFont(buttonFont);
            
            Button backButton = new Button("Back");
            backButton.setLayoutX(120.0);
            backButton.setLayoutY(16.0);
            backButton.setMnemonicParsing(false);
            backButton.setPrefHeight(31.0);
            backButton.setPrefWidth(71.0);
            backButton.setFont(buttonFont);
    
            bookNowButton.setOnAction(new EventHandler <ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // afterbooknow t1 = new afterbooknow();
                try {
                    System.out.println("Book Now button clicked!");
                    // t1.try_1(event,db_hotel_name);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

            backButton.setOnAction(new EventHandler <ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                afterbooknow t1 = new afterbooknow();
                try {
                    // mainwindow t4 = new mainwindow();
                    // t4.explore_hotel(event,d2.db_name);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("Back button clicked!");
            }
        });

            pane7.getChildren().addAll(bookNowButton,backButton);
    
            centerVBox.getChildren().addAll(pane1, pane2, pane3, pane4, pane5, pane6, pane7);
            root.setCenter(centerVBox);
    
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
    }


}
