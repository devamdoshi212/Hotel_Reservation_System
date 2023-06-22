import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class afterbooknow {

    public void try_1(ActionEvent event,String hname,String username,int hotel_id,String pnumber) throws Exception{

        Database d9 = new Database();
        d9.retriveAllHotelRoomDetailsbyhotelid(hotel_id);
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();

        BorderPane root = new BorderPane();

        Label hotelNameLabel = new Label(hname);
        hotelNameLabel.setAlignment(javafx.geometry.Pos.CENTER);
        hotelNameLabel.setPrefHeight(51.0);
        hotelNameLabel.setPrefWidth(900.0);
        hotelNameLabel.setFont(new Font("MV Boli", 30.0));
        root.setTop(hotelNameLabel);

        VBox centerVBox = new VBox();
        centerVBox.setPrefHeight(429.0);
        centerVBox.setPrefWidth(566.0);
        root.setCenter(centerVBox);

        Pane pane1 = new Pane();
        pane1.setPrefHeight(62.0);
        pane1.setPrefWidth(566.0);
        centerVBox.getChildren().add(pane1);

        Pane pane2 = new Pane();
        pane2.setPrefHeight(62.0);
        pane2.setPrefWidth(566.0);
        centerVBox.getChildren().add(pane2);

        Label availableRoomsLabel = new Label("Available Rooms");
        availableRoomsLabel.setLayoutX(227.0);
        availableRoomsLabel.setLayoutY(15.0);
        availableRoomsLabel.setPrefHeight(32.0);
        availableRoomsLabel.setPrefWidth(158.0);
        availableRoomsLabel.setFont(new Font(20.0));

        Label availableRoomsValueLabel = new Label(Integer.toString(d9.db_aroom));
        availableRoomsValueLabel.setAlignment(javafx.geometry.Pos.CENTER);
        availableRoomsValueLabel.setLayoutX(502.0);
        availableRoomsValueLabel.setLayoutY(15.0);
        availableRoomsValueLabel.setPrefHeight(32.0);
        availableRoomsValueLabel.setPrefWidth(175.0);
        availableRoomsValueLabel.setFont(new Font(20.0));
        pane2.getChildren().addAll(availableRoomsLabel, availableRoomsValueLabel);

        Pane pane3 = new Pane();
        pane3.setPrefHeight(62.0);
        pane3.setPrefWidth(566.0);
        centerVBox.getChildren().add(pane3);

        Label checkInDateLabel = new Label("Check in date");
        checkInDateLabel.setLayoutX(226.0);
        checkInDateLabel.setLayoutY(15.0);
        checkInDateLabel.setPrefHeight(32.0);
        checkInDateLabel.setPrefWidth(138.0);
        checkInDateLabel.setFont(new Font(20.0));
        

        DatePicker checkInDatePicker = new DatePicker();
        checkInDatePicker.setLayoutX(503.0);
        checkInDatePicker.setLayoutY(19.0);
        checkInDatePicker.setDayCellFactory(picker-> new DateCell(){
            public void updateItem(LocalDate date,boolean empty)
            {
                super.updateItem(date, empty);
                LocalDate today = LocalDate.now();
                setDisable(empty|| date.compareTo(today)<0);
            }
        });
        pane3.getChildren().addAll(checkInDateLabel, checkInDatePicker);

        Pane pane4 = new Pane();
        pane4.setPrefHeight(62.0);
        pane4.setPrefWidth(566.0);
        centerVBox.getChildren().add(pane4);

        Label checkOutDateLabel = new Label("Check out date");
        checkOutDateLabel.setLayoutX(224.0);
        checkOutDateLabel.setLayoutY(15.0);
        checkOutDateLabel.setPrefHeight(32.0);
        checkOutDateLabel.setPrefWidth(138.0);
        checkOutDateLabel.setFont(new Font(20.0));

        DatePicker checkOutDatePicker = new DatePicker();
        checkOutDatePicker.setLayoutX(504.0);
        checkOutDatePicker.setLayoutY(19.0);
        checkOutDatePicker.setDayCellFactory(picker-> new DateCell(){
            public void updateItem(LocalDate date,boolean empty)
            {
                super.updateItem(date, empty);
                LocalDate today = LocalDate.now();
                setDisable(empty|| date.compareTo(today)<0);
            }
        });
        pane4.getChildren().addAll(checkOutDateLabel, checkOutDatePicker);

        Pane pane5 = new Pane();
        pane5.setPrefHeight(62.0);
        pane5.setPrefWidth(566.0);
        centerVBox.getChildren().add(pane5);

        Label numOfGuestsLabel = new Label("No. of Guests");
        numOfGuestsLabel.setLayoutX(225.0);
        numOfGuestsLabel.setLayoutY(14.0);
        numOfGuestsLabel.setPrefHeight(32.0);
        numOfGuestsLabel.setPrefWidth(133.0);
        numOfGuestsLabel.setFont(new Font(20.0));

        String[] sct = {"1","2","3"}; 
        ChoiceBox numOfGuestsChoiceBox = new ChoiceBox(FXCollections.observableArrayList(sct));
        numOfGuestsChoiceBox.setPrefHeight(25);
        numOfGuestsChoiceBox.setPrefWidth(176);
        numOfGuestsChoiceBox.setLayoutX(505.0);
        numOfGuestsChoiceBox.setLayoutY(18.0);
        pane5.getChildren().addAll(numOfGuestsLabel, numOfGuestsChoiceBox);

        Pane pane6 = new Pane();
        pane6.setPrefHeight(62.0);
        pane6.setPrefWidth(566.0);
        centerVBox.getChildren().add(pane6);

        Label totalPriceLabel = new Label("Total Price");
        totalPriceLabel.setLayoutX(225.0);
        totalPriceLabel.setLayoutY(14.0);
        totalPriceLabel.setPrefHeight(32.0);
        totalPriceLabel.setPrefWidth(133.0);
        totalPriceLabel.setFont(new Font(20.0));

        Label totalPriceValueLabel = new Label(Integer.toString(d9.db_price));
        totalPriceValueLabel.setAlignment(javafx.geometry.Pos.CENTER);
        totalPriceValueLabel.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        totalPriceValueLabel.setLayoutX(507.0);
        totalPriceValueLabel.setLayoutY(14.0);
        totalPriceValueLabel.setPrefHeight(32.0);
        totalPriceValueLabel.setPrefWidth(172.0);
        totalPriceValueLabel.setFont(new Font(20.0));
        pane6.getChildren().addAll(totalPriceLabel, totalPriceValueLabel);

        Pane pane7 = new Pane();
        pane7.setPrefHeight(78.0);
        pane7.setPrefWidth(900.0);
        centerVBox.getChildren().add(pane7);

        Button bookNowButton = new Button("Book Now");
        bookNowButton.setLayoutX(523.0);
        bookNowButton.setLayoutY(18.0);
        bookNowButton.setMnemonicParsing(false);
        bookNowButton.setPrefHeight(43.0);
        bookNowButton.setPrefWidth(132.0);
        bookNowButton.setFont(new Font("System Bold", 15.0));

        Button backButton = new Button("Back");
        backButton.setLayoutX(247.0);
        backButton.setLayoutY(18.0);
        backButton.setMnemonicParsing(false);
        backButton.setPrefHeight(42.0);
        backButton.setPrefWidth(132.0);
        backButton.setFont(new Font("System Bold", 15.0));
        pane7.getChildren().addAll(bookNowButton, backButton);

        backButton.setOnAction(new EventHandler <ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    mainwindow t4 = new mainwindow();
                    t4.explore_hotel(event,username,pnumber);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("Back button clicked!");
            }
        });

        bookNowButton.setOnAction(new EventHandler <ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    int gid = d9.retriveguestId(pnumber);
                    d9.insertResDetails(checkInDatePicker.getValue(), checkOutDatePicker.getValue(), numOfGuestsChoiceBox.getValue(), Integer.toString(d9.db_price), d9.db_room_id,gid);
                    System.out.println("Book Now button clicked!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        primaryStage.setTitle("Booking");
        primaryStage.setScene(new Scene(root, 900, 700));
        primaryStage.show();    
    }


}
