import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
            root.setPrefHeight(477.0);
            root.setPrefWidth(461.0);
    
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
            availableRoomsLabel.setLayoutX(57.0);
            availableRoomsLabel.setLayoutY(27.0);
            availableRoomsLabel.setPrefHeight(32.0);
            availableRoomsLabel.setPrefWidth(158.0);
            Font labelFont = new Font(20.0);
            availableRoomsLabel.setFont(labelFont);
    
            TextField availableRoomsTextField = new TextField();
            //set 
            availableRoomsTextField.setText(Integer.toString(loginClient.db_aroom));
            availableRoomsTextField.setLayoutX(267.0);
            availableRoomsTextField.setLayoutY(27.0);
            availableRoomsTextField.setPrefHeight(33.0);
            availableRoomsTextField.setPrefWidth(149.0);
            pane2.getChildren().addAll(availableRoomsLabel, availableRoomsTextField);
            
            Pane pane3 = new Pane();
            pane3.setPrefHeight(82.0);
            pane3.setPrefWidth(462.0);
    
            Label pricePerNightLabel = new Label("Price per Night");
            pricePerNightLabel.setLayoutX(56.0);
            pricePerNightLabel.setLayoutY(25.0);
            pricePerNightLabel.setPrefHeight(32.0);
            pricePerNightLabel.setPrefWidth(158.0);
            pricePerNightLabel.setFont(labelFont);
    
            TextField pricePerNightTextField = new TextField();
            //set
            pricePerNightTextField.setText(Integer.toString(loginClient.db_price));
            pricePerNightTextField.setLayoutX(268.0);
            pricePerNightTextField.setLayoutY(25.0);
            pricePerNightTextField.setPrefHeight(33.0);
            pricePerNightTextField.setPrefWidth(149.0);
    
            pane3.getChildren().addAll(pricePerNightLabel, pricePerNightTextField);

            Pane pane4 = new Pane();
            pane4.setPrefHeight(69.0);
            pane4.setPrefWidth(462.0);
    
            Label roomTypeLabel = new Label("Room Type");
            roomTypeLabel.setLayoutX(59.0);
            roomTypeLabel.setLayoutY(19.0);
            roomTypeLabel.setPrefHeight(32.0);
            roomTypeLabel.setPrefWidth(158.0);
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
    
            roomTypeChoiceBox.setLayoutX(267.0);
            roomTypeChoiceBox.setLayoutY(16.0);
            roomTypeChoiceBox.setPrefHeight(32.0);
            roomTypeChoiceBox.setPrefWidth(150.0);
    
            pane4.getChildren().addAll(roomTypeLabel, roomTypeChoiceBox);

            Pane pane6 = new Pane();
            pane6.setPrefHeight(28.0);
            pane6.setPrefWidth(462.0);

            Label status_Label = new Label("");
            status_Label.setAlignment(javafx.geometry.Pos.CENTER);
            status_Label.setLayoutX(59.0);
            status_Label.setLayoutY(5.0);
            status_Label.setPrefHeight(31.0);
            status_Label.setPrefWidth(343.0);
            status_Label.setTextFill(Color.web("#f40000"));
            status_Label.setFont(new Font("System Bold", 15.0));
    
            pane6.getChildren().add(status_Label);

            Pane pane5 = new Pane();
            pane5.setPrefHeight(74.0);
            pane5.setPrefWidth(462.0);
    
            Button logoutButton = new Button("Logout");
            logoutButton.setLayoutX(84.0);
            logoutButton.setLayoutY(18.0);
            logoutButton.setPrefWidth(107.0);
            logoutButton.setPrefHeight(38.0);
            Font logoutButtonFont = new Font("System Bold", 15.0);
            logoutButton.setFont(logoutButtonFont);

            
            Button submitButton = new Button("Submit");
            submitButton.setLayoutX(268.0);
            submitButton.setLayoutY(18.0);
            submitButton.setPrefWidth(107.0);
            submitButton.setPrefHeight(38.0);
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
