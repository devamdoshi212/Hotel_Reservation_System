import java.io.IOException;

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

public class HotelManagerLogin {

    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private Label Status;
    @FXML
    private TextField userName;
    @FXML
    private PasswordField passWord;
    @FXML
    private Label usernamestatus;
    @FXML
    private Label passwordstatus;

    public void Home(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("hotelmanagermain.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void HoterlManagerLoginSumbit(ActionEvent event) throws Exception
    {
        
        Database d5 = new Database();
        d5.dbconnect_Hotel_Manager_Login(userName.getText(),passWord.getText());
        if(d5.hotel_manager_login_verify==1)
        {
            Status.setText("Login Success");
            afterhotelmanagerlogin manager2 = new afterhotelmanagerlogin();
            manager2.managerupdate(event, userName.getText(),d5.db_hotel_manager_id);
        }
        else
        {
            passWord.setText("");
            Status.setText("Invalid Credentials");
        }
    }
}
