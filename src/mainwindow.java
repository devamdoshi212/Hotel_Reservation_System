// import java.io.IOException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.skin.DatePickerSkin;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class mainwindow{

String url = "jdbc:mysql://localhost/hotel_reservation_system";
String username = "root";
String password = "";
String query = "SELECT * FROM hotel";
String query1 = "SELECT * FROM hotel_room";

public void explore_hotel(ActionEvent event,String db_name,String pnumber) throws Exception
{
    try 
    {
        //database connection
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = (Statement) connection.createStatement();
        Statement statement1 = (Statement) connection.createStatement();

        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));

        HBox topBox = new HBox();
        topBox.setPrefHeight(49);
        topBox.setPrefWidth(900);
        topBox.setAlignment(Pos.CENTER);

        Label appNameLabel = new Label("StayEase");
        appNameLabel.setAlignment(Pos.CENTER);
        appNameLabel.setPrefHeight(46);
        appNameLabel.setPrefWidth(146);
        appNameLabel.setFont(new Font("MV Boli", 24));

        Button homeButton = new Button("Home");
        homeButton.setAlignment(Pos.CENTER);
        homeButton.setContentDisplay(ContentDisplay.CENTER);
        homeButton.setPrefHeight(34);
        homeButton.setPrefWidth(90);
        homeButton.setFont(Font.font("System Bold", 12));
        HBox.setMargin(homeButton, new Insets(10, 0, 0, 450));

        Button aboutButton = new Button("About Us");
        aboutButton.setAlignment(Pos.CENTER);
        aboutButton.setContentDisplay(ContentDisplay.CENTER);
        aboutButton.setPrefHeight(34);
        aboutButton.setPrefWidth(90);
        aboutButton.setFont(Font.font("System Bold", 12));
        HBox.setMargin(aboutButton, new Insets(10, 10, 0, 10));

        Button logoutButton = new Button("Logout");
        logoutButton.setAlignment(Pos.CENTER);
        logoutButton.setContentDisplay(ContentDisplay.CENTER);
        logoutButton.setPrefHeight(34);
        logoutButton.setPrefWidth(90);
        logoutButton.setFont(Font.font("System Bold", 12));
        HBox.setMargin(logoutButton, new Insets(10, 0, 0, 0));

            logoutButton.setOnAction(new EventHandler <ActionEvent>()  {
                @Override
                public void handle(ActionEvent event) {
                    LoginController home1 = new LoginController();
                    try{
                        home1.Home(event);
                    }
                    catch(Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                }
            });

        topBox.getChildren().addAll(appNameLabel, homeButton, aboutButton, logoutButton);

        VBox centerBox = new VBox();
        centerBox.setPrefHeight(200);
        centerBox.setPrefWidth(100);
        centerBox.setAlignment(Pos.CENTER);

        HBox mainBox = new HBox();
        mainBox.setPrefHeight(651);
        mainBox.setPrefWidth(900);

        Pane leftPane = new Pane();
        leftPane.setPrefHeight(100);
        leftPane.setPrefWidth(298);

        VBox leftsidecontent = new VBox();
        leftsidecontent.setPrefHeight(668);
        leftsidecontent.setPrefWidth(299);

        Pane user = new Pane();
        user.prefHeight(114);
        user.prefWidth(300);

        Label userNameLabel = new Label("Welcome "+db_name);
        userNameLabel.setLayoutX(14);
        userNameLabel.setLayoutY(21);
        userNameLabel.setPrefHeight(59);
        userNameLabel.setPrefWidth(278);
        userNameLabel.setFont(Font.font("Symbol", 23));

        user.getChildren().add(userNameLabel);

        Pane date = new Pane();
        date.prefHeight(270);
        date.prefWidth(300);
        
        DatePickerSkin datePickerSkin = new DatePickerSkin(new DatePicker(LocalDate.now()));
        // datePickerSkin.getPopupContent();
        // datePickerSkin.setEditable(false);
        // datePickerSkin.setLayoutX(14.0);
        // datePickerSkin.setLayoutY(110.0);
        // datePickerSkin.setPrefHeight(25.0);
        // datePickerSkin.setPrefWidth(268.0);
        
        // leftPane.getChildren().addAll(userNameLabel,datePickerSkin.getPopupContent());
        
        date.getChildren().add(datePickerSkin.getPopupContent());

        leftsidecontent.getChildren().addAll(user,date);
        leftPane.getChildren().add(leftsidecontent);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setPrefHeight(578);
        scrollPane.setPrefWidth(598);

        VBox scrollContent = new VBox();
        scrollContent.setPrefHeight(650);
        scrollContent.setPrefWidth(596);
        
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) 
        {
            ResultSet resultSet1 = statement1.executeQuery(query1);

            String db_hotel_id = resultSet.getString("hotel_id");
            String db_hotel_name = resultSet.getString("name");
            String db_hotel_address = resultSet.getString("address");
            String db_city = resultSet.getString("city");
            String db_phone_number = resultSet.getString("phone_number");
            String db_email = resultSet.getString("email");
            String db_hotel_image = resultSet.getString("hotel_image");

        HBox hotelBox = new HBox();
        hotelBox.setPrefHeight(162);
        hotelBox.setPrefWidth(596);

        ImageView hotelImage = new ImageView();
        hotelImage.setFitHeight(162);
        hotelImage.setFitWidth(200);
        hotelImage.setPickOnBounds(true);
        Image image = new Image(db_hotel_image);
        hotelImage.setImage(image);

        Pane hotelInfoPane = new Pane();
        hotelInfoPane.setPrefHeight(162);
        hotelInfoPane.setPrefWidth(246);

        Label hotelNameLabel = new Label(db_hotel_name);
        hotelNameLabel.setLayoutX(5);
        hotelNameLabel.setLayoutY(14);
        hotelNameLabel.setPrefHeight(38);
        hotelNameLabel.setPrefWidth(213);
        hotelNameLabel.setFont(Font.font("System Bold", 15));

        Label hotelLocationLabel = new Label(db_hotel_address);
        hotelLocationLabel.setLayoutX(8);
        hotelLocationLabel.setLayoutY(52);
        hotelLocationLabel.setPrefHeight(42);
        hotelLocationLabel.setPrefWidth(209);

        Label hotelInfoLabel = new Label("Breakfast included | Free wifi in Room");
        hotelInfoLabel.setLayoutX(4);
        hotelInfoLabel.setLayoutY(117);
        hotelInfoLabel.setPrefHeight(31);
        hotelInfoLabel.setPrefWidth(213);
        hotelInfoLabel.setTextFill(Color.web("#43b704"));
        hotelInfoLabel.setFont(Font.font("System Bold", 11));

        hotelInfoPane.getChildren().addAll(hotelNameLabel, hotelLocationLabel, hotelInfoLabel);

        Pane pricePane = new Pane();
        pricePane.setPrefHeight(200);
        pricePane.setPrefWidth(200);
        
        Label priceLabel = new Label();
        priceLabel.setAlignment(Pos.CENTER);
        priceLabel.setLayoutX(35);
        priceLabel.setLayoutY(18);
        priceLabel.setPrefHeight(53);
        priceLabel.setPrefWidth(101);
        priceLabel.setFont(Font.font("System Bold Italic", 17));

        while(resultSet1.next())
        {
            String db_2_hotel_id=resultSet1.getString("hotel_id");
            String value = resultSet1.getString("price_per_night");
            if(db_2_hotel_id.equals(db_hotel_id))
            {
                priceLabel.setText(value+"/-");
                break;
            }
        }

        Label averageNightLabel = new Label("average per night");
        averageNightLabel.setLayoutX(37);
        averageNightLabel.setLayoutY(63);
        averageNightLabel.setPrefHeight(17);
        averageNightLabel.setPrefWidth(101);

        Label cancellationLabel = new Label("Free Cancellation");
        cancellationLabel.setLayoutX(42);
        cancellationLabel.setLayoutY(98);
        cancellationLabel.setPrefHeight(17);
        cancellationLabel.setPrefWidth(92);

        Button bookButton = new Button("Book Now");
        bookButton.setLayoutX(45);
        bookButton.setLayoutY(123);
        bookButton.setPrefHeight(31);
        bookButton.setPrefWidth(86);
        bookButton.setFont(Font.font("System Bold", 12));

        bookButton.setOnAction(new EventHandler <ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                afterbooknow t1 = new afterbooknow();
                try {
                    t1.try_1(event,db_hotel_name,db_name,Integer.parseInt(db_hotel_id),pnumber);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("Book Now button clicked!");
            }
        });
        
        pricePane.getChildren().addAll(priceLabel, averageNightLabel, cancellationLabel, bookButton);

        hotelBox.getChildren().addAll(hotelImage, hotelInfoPane, pricePane);
        scrollContent.getChildren().add(hotelBox);

        }
        scrollPane.setContent(scrollContent);

        mainBox.getChildren().addAll(leftPane, scrollPane);

        centerBox.getChildren().add(mainBox);

        root.setTop(topBox);
        root.setCenter(centerBox);

        Scene scene = new Scene(root, 900, 700);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Hotel Reservation System");
        primaryStage.show();
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }

    


}
    
    
}