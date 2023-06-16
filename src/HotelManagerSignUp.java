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
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Dialog;
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
                            
                            afterhotelmanagersignup manager1 = new afterhotelmanagersignup();
                            manager1.roomdetails(event, hname, userId);
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


   

}


