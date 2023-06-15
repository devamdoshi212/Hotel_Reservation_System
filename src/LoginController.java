import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label Status;
    @FXML
    private TextField phoneNumber;
    @FXML
    private PasswordField password;
    @FXML
    private Label phonenumberstatus;
    @FXML
    private Label passwordstatus;

    public void LoginSumbit(ActionEvent event) throws Exception{
        int phone_number_length = phoneNumber.getText().length();
        // int  password_number_length = password.getText().length();
        if((phone_number_length==10))
        {
                    Database d2 = new Database();
                    d2.dbconnect_Login(phoneNumber.getText(), password.getText());
                    if(d2.login_verify==1)
                    {
                        Status.setText("Login Success");
                        mainwindow t1 = new mainwindow();
                        t1.explore_hotel(event,d2.db_name);
                    }
                    else
                    {
                        Status.setText("Invalid Credentials");
                    }
        }
        else 
        {
            phonenumberstatus.setText("Phone Number is invalid");
        }
    }


    public void Home(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("newmain.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
