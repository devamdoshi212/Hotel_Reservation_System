import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class afterhotelmanagerlogin {

     //avail rooms and price validation
    public static boolean onlyDigits(String str, int n)
	{
		for (int i = 0; i < n; i++) 
        {
			if (str.charAt(i) < '0' || str.charAt(i) > '9') 
            {
				return false;
			}
		}
		return true;
	}
    
    String storeavailableRoomsTextField;
    String storepricePerNightTextField;
    int storeroomtype;

    int aroom;
    int price;
    int hotelid;

    //after login
    //user = username of hotel manager
    public void managerupdate(ActionEvent event,String user,int managerid) throws Exception
    {
        Database loginClient = new Database();
        loginClient.retriveHotelName(managerid);
        loginClient.retriveAllHotelRoomDetails(managerid);
        try {
            Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            BorderPane root = new BorderPane();
            root.setMaxHeight(Double.NEGATIVE_INFINITY);
            root.setMaxWidth(Double.NEGATIVE_INFINITY);
            root.setMinHeight(Double.NEGATIVE_INFINITY);
            root.setMinWidth(Double.NEGATIVE_INFINITY);
            root.setPrefHeight(700.0);
            root.setPrefWidth(900.0);
            root.setPadding(new Insets(10));

    
            Label hotelNameLabel = new Label(loginClient.hotel_name);
            hotelNameLabel.setAlignment(javafx.geometry.Pos.CENTER);
            hotelNameLabel.setPrefHeight(60.0);
            hotelNameLabel.setPrefWidth(417.0);

            Font hotelNameFont = new Font("MV Boli", 33.0);
            hotelNameLabel.setFont(hotelNameFont);
            BorderPane.setAlignment(hotelNameLabel, javafx.geometry.Pos.CENTER);
    
            root.setTop(hotelNameLabel);
    
            VBox centerVBox = new VBox();
            centerVBox.setPrefHeight(200.0);
            centerVBox.setPrefWidth(100.0);
            BorderPane.setAlignment(centerVBox, javafx.geometry.Pos.CENTER);
    
            Pane pane1 = new Pane();
            pane1.setPrefHeight(65.0);
            pane1.setPrefWidth(462.0);
    
            Pane pane2 = new Pane();
            pane2.setPrefHeight(78.0);
            pane2.setPrefWidth(462.0);
    
            Label availableRoomsLabel = new Label("Available Rooms");
            availableRoomsLabel.setPrefHeight(32);
            availableRoomsLabel.setPrefWidth(158);
            availableRoomsLabel.setLayoutX(279);
            availableRoomsLabel.setLayoutY(28);
            Font labelFont = new Font(20.0);
            availableRoomsLabel.setFont(labelFont);
    
            TextField availableRoomsTextField = new TextField();
            //set 
            availableRoomsTextField.setText(Integer.toString(loginClient.db_aroom));
            availableRoomsTextField.setPrefHeight(33);
            availableRoomsTextField.setPrefWidth(149);
            availableRoomsTextField.setLayoutX(527);
            availableRoomsTextField.setLayoutY(28);
            pane2.getChildren().addAll(availableRoomsLabel, availableRoomsTextField);
            
            Pane pane3 = new Pane();
            pane3.setPrefHeight(82.0);
            pane3.setPrefWidth(462.0);
    
            Label pricePerNightLabel = new Label("Price per Night");
            pricePerNightLabel.setPrefHeight(32);
            pricePerNightLabel.setPrefWidth(158);
            pricePerNightLabel.setLayoutX(278);
            pricePerNightLabel.setLayoutY(25);
            pricePerNightLabel.setFont(labelFont);
    
            TextField pricePerNightTextField = new TextField();
            //set
            pricePerNightTextField.setText(Integer.toString(loginClient.db_price));
            pricePerNightTextField.setPrefHeight(33);
            pricePerNightTextField.setLayoutX(526);
            pricePerNightTextField.setPrefWidth(149);
            pricePerNightTextField.setLayoutY(25);
    
            pane3.getChildren().addAll(pricePerNightLabel, pricePerNightTextField);

            Pane pane4 = new Pane();
            pane4.setPrefHeight(69.0);
            pane4.setPrefWidth(462.0);
    
            Label roomTypeLabel = new Label("Room Type");
            roomTypeLabel.setPrefHeight(32);
            roomTypeLabel.setPrefWidth(158);
            roomTypeLabel.setLayoutX(277);
            roomTypeLabel.setLayoutY(19);
            roomTypeLabel.setFont(labelFont);
    
            String st[] ={"Normal","Delux"}; 
            ChoiceBox roomTypeChoiceBox = new ChoiceBox (FXCollections.observableArrayList(st));
            //set
            roomTypeChoiceBox.setValue(st[loginClient.db_roomtype-1]);
            storeroomtype=loginClient.db_roomtype;
            roomTypeChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue ov, Number value, Number new_value)
            {
                storeroomtype=new_value.intValue()+1;
            }
        });
    
            roomTypeChoiceBox.setPrefHeight(32);
            roomTypeChoiceBox.setPrefWidth(146);
            roomTypeChoiceBox.setLayoutX(527);
            roomTypeChoiceBox.setLayoutY(19);
    
            pane4.getChildren().addAll(roomTypeLabel, roomTypeChoiceBox);

            Pane pane6 = new Pane();
            pane6.setPrefHeight(63.0);
            pane6.setPrefWidth(900.0);

            Label status_Label = new Label("");
            status_Label.setAlignment(javafx.geometry.Pos.CENTER);
            status_Label.setPrefHeight(31);
            status_Label.setPrefWidth(872);
            status_Label.setLayoutX(14);
            status_Label.setLayoutY(16);
            status_Label.setTextFill(Color.web("#f40000"));
            status_Label.setFont(new Font("System Bold", 15.0));
    
            pane6.getChildren().add(status_Label);

            Pane pane5 = new Pane();
            pane5.setPrefHeight(99.0);
            pane5.setPrefWidth(900.0);
    
            Button logoutButton = new Button("Logout");
            logoutButton.setPrefHeight(55);
            logoutButton.setPrefWidth(137);
            logoutButton.setLayoutX(267);
            logoutButton.setLayoutY(30);
            Font logoutButtonFont = new Font("System Bold", 15.0);
            logoutButton.setFont(logoutButtonFont);

            
            Button submitButton = new Button("Submit");
            submitButton.setPrefHeight(55);
            submitButton.setPrefWidth(137);
            submitButton.setLayoutX(532);
            submitButton.setLayoutY(30);
            Font submitButtonFont = new Font("System Bold", 15.0);
            submitButton.setFont(submitButtonFont);
            
            pane5.getChildren().addAll(submitButton, logoutButton);

            logoutButton.setOnAction(new EventHandler <ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                try {
                    ScreenController s4 = new ScreenController();
                    s4.HotelManager(event); 
                } catch (Exception e) {
                    e.getStackTrace();
                }   
                }
            });
            
            submitButton.setOnAction(new EventHandler <ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                                storeavailableRoomsTextField=availableRoomsTextField.getText();
                                storepricePerNightTextField=pricePerNightTextField.getText();

                    try 
                    {
                        System.out.println("Submmit button clicked!");
                        if((availableRoomsTextField==null)||(pricePerNightTextField==null)||(storeroomtype==0))
                        {
                            status_Label.setText("All Fields are required");
                        }
                        else
                        {
                            if(onlyDigits(storeavailableRoomsTextField, storeavailableRoomsTextField.length()))
                            {
                                if(onlyDigits(storepricePerNightTextField, storepricePerNightTextField.length()))
                                {
                                    status_Label.setText("");
                                    aroom = Integer.valueOf(storeavailableRoomsTextField);
                                    price = Integer.valueOf(storepricePerNightTextField);

                                    // Database d4 = new Database();
                                    // // hotelid = d4.retriveHotelId(userId);
                                    // d4.dbconnect_Hotel_Room_details(hotelid, price, aroom, storeroomtype);
                                    // dailogbox d1 = new dailogbox();
                                    // d1.afterroomdetails();
                                    
                                    // primaryStage.close();
                                    Database d7 = new Database();
                                    d7.updateroomdetails(d7.retriveHotelId(managerid), price, aroom, storeroomtype);
                                    status_Label.setText(" Details Successfully Updated");
                                    System.out.println(aroom+" "+price+" "+storeroomtype);
                                }
                                else
                                {
                                    status_Label.setText("Invalid value in Price Per Night");
            
                                }
                            }
                            else
                            {
                                status_Label.setText("Invalid value in Available Rooms");
                            }
                        }
                    
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        });
        
        centerVBox.getChildren().addAll(pane1, pane2, pane3, pane4, pane6, pane5);
        root.setCenter(centerVBox);
    
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
