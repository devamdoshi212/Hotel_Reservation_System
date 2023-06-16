import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
 
public class App extends Application {
    
    @Override
    public void start(Stage primaryStage)throws Exception{
        try{
            Parent root = FXMLLoader.load(getClass().getResource("newmain.fxml"));
            
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("Hotel Reservation System");
            primaryStage.show();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
