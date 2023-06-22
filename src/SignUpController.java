import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.Node;
import javafx.stage.Stage;

public class SignUpController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField first_name;
    @FXML
    private TextField last_name;
    @FXML
    private TextField email;
    @FXML
    private TextField phone_number;
    @FXML
    private TextField aadhar_number;
    @FXML
    private TextField city;
    @FXML
    private TextField password;
    @FXML
    private PasswordField confirm_password;
    @FXML
    private Label pass_status;

    public void Home(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("newmain.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public boolean validateFirstName(String firstName) {
    // Regular expression pattern to match only letters
    String pattern = "^[a-zA-Z]+$";
    
    // Check if the first name matches the pattern and is not empty
    return firstName.matches(pattern) && !firstName.isEmpty();
    }

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
    public static boolean aadharIsValid(String s)
    {
        Pattern p = Pattern.compile("^\\d{12}$");
        Matcher m = p.matcher(s);
 
        return (m.matches());
    }

    public boolean validatePassword(String password) {
    // Check minimum length
    // if (password.length() < 8) {
    //     return false;
    // }
    
    // Check if it contains at least one uppercase letter
    // if (!password.matches(".*[A-Z].*")) {
    //     return false;
    // }
    
    // Check if it contains at least one lowercase letter
    if (!password.matches(".*[a-z].*")) {
        return false;
    }
    
    // Check if it contains at least one digit
    if (!password.matches(".*\\d.*")) {
        return false;
    }
    
    // // Check if it contains at least one special character
    // if (!password.matches(".*[!@#$%^&*].*")) {
    //     return false;
    // }
    
    return true;
}


    public void SignUp(ActionEvent event) throws Exception{
        final String fname = first_name.getText();
        final String lname = last_name.getText();
        final String e_mail = email.getText();
        final String pnumber = phone_number.getText();
        final String anumber = aadhar_number.getText();
        final String cityname = city.getText();
        final String pass = password.getText().trim();
        final String conpass = confirm_password.getText().trim();

        int password_verify=0;

        if(password.getText().trim().equals(confirm_password.getText().trim()))
        {
            password_verify=1;
        }
        else
        {
            password_verify=0;
        }
        Database d1 = new Database();
        d1.phone_number_verify(pnumber);
        if((fname==null)||(fname=="")||(lname==null)||(e_mail==null)||(pnumber==null)||(anumber==null)||(cityname==null)||(pass==null)||(conpass==null))
        {
            pass_status.setText("All fields must be required");
        }
        else
        {
            if(validateFirstName(fname))
            {
                if(validateFirstName(lname))
                {
                    if(emailIsValid(e_mail))
                    {
                        if(phoneIsValid(pnumber))
                        {
                            if(aadharIsValid(anumber))
                            {
                                if(validateFirstName(cityname))
                                {
                                    if(validatePassword(pass))
                                    {
                                        if((d1.pnumber_verify==0)&&(password_verify==1))
                                        {
                                                d1.dbconnect_SignUp(fname,lname,e_mail,pnumber,anumber,cityname,pass);
                                                pass_status.setText("Successfully account created");
                                                first_name.setText("");
                                                last_name.setText("");
                                                email.setText("");
                                                phone_number.setText("");
                                                aadhar_number.setText("");
                                                city.setText("");
                                                password.setText("");
                                                confirm_password.setText("");

                                                //redirect to home page
                                                // SignUpController home2 = new SignUpController();
                                                // home2.Home(event);

                                                //redirect to main window
                                                mainwindow t1 = new mainwindow();
                                                t1.explore_hotel(event,fname,pnumber);
                                        }
                                        else if(d1.pnumber_verify==1)
                                        {
                                            pass_status.setText("User Already Exist");
                                            confirm_password.setText("");
                                        }
                                        else if(password_verify==0)
                                        {
                                            pass_status.setText("Password and Confirm Password must be same");
                                            confirm_password.setText("");
                                        }
        
                                    }
                                    else
                                    {
                                        pass_status.setText("Set Secure Password");
                                    }
                                }
                                else
                                {
                                    pass_status.setText("Invalid value in city name");
                                }
                            }
                            else
                            {
                                pass_status.setText("Invalid value in aadhar number");
                            }
                        }
                        else
                        {
                            pass_status.setText("Invalid value in phone number");
                        }
                    }
                    else
                    {
                        pass_status.setText("Invalid value in email");                    
                    }
                }
                else
                {
                    pass_status.setText("Invalid value in last name");
                }
            }
            else
            {
                pass_status.setText("Invalid value in first name");
            }
        }
        
    


    }
}
