import java.awt.image.RenderedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import javax.imageio.ImageIO;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.Node;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

public class HotelManagerSignUp extends Thread{

    public static boolean emailIsValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
                              
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
    public static boolean phoneIsValid(String s)
    {
        Pattern p = Pattern.compile("^\\d{10}$");
        Matcher m = p.matcher(s);
 
        return (m.matches());
    }

    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private TextField hotelname;
    @FXML
    private TextArea hoteladdress;
    @FXML
    private TextField hotelemail;
    @FXML
    private TextField hotelphonenumber;
    @FXML
    private TextField hotelcity;
    @FXML
    private TextField username;
    @FXML
    private TextField pass;
    @FXML
    private PasswordField confirmpassword;
    @FXML
    private Label filelabel;
    @FXML
    private Label pass_status;
    @FXML
    private ImageView imageView;
    
    private File selectedFile;
    private Image image;
    private WritableImage destinationImage;
    private FileInputStream fs;
    private File f;

    @FXML
    private void handleFileUpload(ActionEvent event) throws FileNotFoundException {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select File");
        fileChooser.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg","*.jpeg", "*.gif")
        );
        fileChooser.setInitialDirectory(new File("C:/Programming/Java_Dev/Java_Project_1/src/hotel_image"));

        Window window = null;
        selectedFile = fileChooser.showOpenDialog(window);

        if (selectedFile != null) 
        {
            InputStream stream = new FileInputStream(selectedFile.getAbsolutePath());
            image = new Image(stream);
            imageView.setImage(image);
            destinationImage = new WritableImage((int) image.getWidth(), (int) image.getHeight());

            f=new File(selectedFile.getAbsolutePath());
    	    fs=new FileInputStream(f);
    
            filelabel.setText(selectedFile.getAbsolutePath());
        } 
        else 
        {
            // System.out.println("No file selected.");
            imageView.setImage(null);
            filelabel.setText("");
        }
    }


    public void Home(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("hotelmanagermain.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void SignUp(ActionEvent event) throws Exception{
        
        int userId;
        // h shows hotel 
        final String hname = hotelname.getText();
        final String hadd = hoteladdress.getText();
        final String hemail = hotelemail.getText();
        final String hphonenumber = hotelphonenumber.getText();
        final String hcity = hotelcity.getText();
        final String husername = username.getText();
        final String hfilepath = filelabel.getText();
        final String hpassword = pass.getText();
        final String hconfirmpassword = confirmpassword.getText();
        
        
        if((hname==null)||(hadd==null)||(hemail==null)||(hphonenumber==null)||(hcity==null)||(husername==null)||(hfilepath==null)||(hpassword==null)||(hconfirmpassword==null)||(selectedFile==null)||(image==null))
        {
            pass_status.setText("All fields must be required");
        }
        else
        {
            if(emailIsValid(hemail))
            {
                if(phoneIsValid(hphonenumber))
                {
                    if(pass.getText().trim().equals(confirmpassword.getText().trim()))
                    {
                        Database d3 = new Database();
                        if(d3.dbconnect_Hotel_Manager_details(husername, hpassword, pass_status))
                        {
                            userId=d3.retriveUserId(husername);
                            d3.dbconnect_Hotel_Manager_SignUp(hname, hadd, hemail, hphonenumber, hcity, hfilepath,f,fs,pass_status,userId);
                            hotelname.setText(null);
                            hoteladdress.setText(null);
                            hotelemail.setText(null);
                            hotelphonenumber.setText(null);
                            hotelcity.setText(null);
                            username.setText(null);
                            pass.setText(null);
                            confirmpassword.setText(null);
                            imageView.setImage(null);
                            filelabel.setText(null);
                            
                            roomdetails(event,hname);
                        }
                        else
                        {
                            pass_status.setText("User Already Exist");
                        }
                    }
                    else
                    {
                        pass_status.setText("Password and Confirm Password must be same");
                    }
                }
                else
                {
                    pass_status.setText("Phone number is invalid");
                }
            }
            else
            {
                pass_status.setText("Invalid Email");
            }
        }
        
        
        

        //check user exist or not
        //int userexist = d3.hotel_manager_verify(husername,hpassword);
        //System.out.println(userexist);
        
            // File file = new File("C:/Programming/Java_Dev/Java_Project_1/src/image.jpg");
            // saveImageToFile(image, file);
            // Threadtry t1 = new Threadtry();
            // Thread case1 = new Thread(t1);
            
            // System.out.println("d3.hotel_manager_username_verify = "+d3.hotel_manager_username_verify);
        
        
        //d3.dbconnect_Hotel_Manager_details(husername,hpassword);
        
        
        
        // Parent root = FXMLLoader.load(getClass().getResource("hotelmanagermain.fxml"));
        // stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        // scene = new Scene(root);
        // scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        // stage.setScene(scene);
        // stage.setTitle("SignUp Dashboard");
        // stage.show();
    }


    private void saveImageToFile(Image image, File file) {
        try 
        {
        java.awt.image.BufferedImage bufferedImage = SwingFXUtils.fromFXImage(destinationImage, null);
        PixelReader pixelReader = image.getPixelReader();
        PixelWriter pixelWriter = destinationImage.getPixelWriter();

        pixelWriter.setPixels(0, 0, (int) image.getWidth(), (int) image.getHeight(), pixelReader, 0, 0);
        ImageIO.write(bufferedImage, "jpg", file);
        System.out.println("Image saved successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the image: " + e.getMessage());
        }
    }


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

    public void roomdetails(ActionEvent event,String hname) throws Exception
    {

        try {
            Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            BorderPane root = new BorderPane();
            root.setMaxHeight(Double.NEGATIVE_INFINITY);
            root.setMaxWidth(Double.NEGATIVE_INFINITY);
            root.setMinHeight(Double.NEGATIVE_INFINITY);
            root.setMinWidth(Double.NEGATIVE_INFINITY);
            root.setPrefHeight(477.0);
            root.setPrefWidth(461.0);
    
            Label hotelNameLabel = new Label(hname);
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
            availableRoomsTextField.setLayoutX(267.0);
            availableRoomsTextField.setLayoutY(27.0);
            availableRoomsTextField.setPrefHeight(33.0);
            availableRoomsTextField.setPrefWidth(149.0);
            pane2.getChildren().addAll(availableRoomsLabel, availableRoomsTextField);
            //getting value from textfield
            storeavailableRoomsTextField=availableRoomsTextField.getText();
            
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
            pricePerNightTextField.setLayoutX(268.0);
            pricePerNightTextField.setLayoutY(25.0);
            pricePerNightTextField.setPrefHeight(33.0);
            pricePerNightTextField.setPrefWidth(149.0);
    
            pane3.getChildren().addAll(pricePerNightLabel, pricePerNightTextField);
            //getting value from textfield
            storepricePerNightTextField=pricePerNightTextField.getText();

            Pane pane4 = new Pane();
            pane4.setPrefHeight(69.0);
            pane4.setPrefWidth(462.0);
    
            Label roomTypeLabel = new Label("Room Type");
            roomTypeLabel.setLayoutX(59.0);
            roomTypeLabel.setLayoutY(19.0);
            roomTypeLabel.setPrefHeight(32.0);
            roomTypeLabel.setPrefWidth(158.0);
            roomTypeLabel.setFont(labelFont);
    
            String st[] ={"Delux","Normal"}; 
            ChoiceBox roomTypeChoiceBox = new ChoiceBox (FXCollections.observableArrayList(st));
            roomTypeChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue ov, Number value, Number new_value)
            {
 
                // set the text for the label to the selected item
                //  (st[new_value.intValue()] + " selected");
                System.out.println(st[new_value.intValue()]);
                System.out.println(new_value.intValue());
                System.out.println(new_value);
                storeroomtype=new_value.intValue()+1;
            }
        });
    
            roomTypeChoiceBox.setLayoutX(267.0);
            roomTypeChoiceBox.setLayoutY(16.0);
            roomTypeChoiceBox.setPrefHeight(32.0);
            roomTypeChoiceBox.setPrefWidth(150.0);
    
            pane4.getChildren().addAll(roomTypeLabel, roomTypeChoiceBox);

            Pane pane5 = new Pane();
            pane5.setPrefHeight(74.0);
            pane5.setPrefWidth(462.0);
    
            Button submitButton = new Button("Submit");
            submitButton.setLayoutX(177.0);
            submitButton.setLayoutY(18.0);
            submitButton.setMnemonicParsing(false);
            submitButton.setPrefHeight(38.0);
            submitButton.setPrefWidth(107.0);
            Font buttonFont = new Font("System Bold", 15.0);
            submitButton.setFont(buttonFont);
    
            pane5.getChildren().add(submitButton);


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
            
            submitButton.setOnAction(new EventHandler <ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
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
                                aroom=Integer.parseInt(storeavailableRoomsTextField);
                                price=Integer.parseInt(storepricePerNightTextField);

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
        
        centerVBox.getChildren().addAll(pane1, pane2, pane3, pane4, pane5, pane6);
        root.setCenter(centerVBox);
    
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}


