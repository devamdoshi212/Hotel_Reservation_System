import java.io.IOException;
import javafx.event.ActionEvent;
// import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;


public class ScreenController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    public void Login(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Login Dashboard");
        stage.show();

    }
    public void SignUp(ActionEvent event) throws IOException 
    {
        Parent root = FXMLLoader.load(getClass().getResource("Signup.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("SignUp Dashboard");
        stage.show();
    }
    public void HotelManager(ActionEvent event) throws IOException 
    {
        Parent root = FXMLLoader.load(getClass().getResource("hotelmanagermain.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Hotel Manager");
        stage.show();
    }
}
