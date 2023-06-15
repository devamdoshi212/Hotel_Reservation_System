import java.awt.Label;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
// import java.sql.SQLException;
import java.sql.Statement;

public class Database{
    
    String url = "jdbc:mysql://localhost/hotel_reservation_system";
    String username = "root";
    String password = "";
    int login_verify=0;
    int pnumber_verify=0;
    int hotel_manager_username_verify=0;
    String db_name;
    Database(){}

    public void dbconnect_SignUp(String fname,String lname,String e_mail,String pnumber,String anumber,String cityname,String pass) throws Exception{

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Conection done...");
            String sql = "INSERT INTO guest (first_name, last_name, email, phone_number, adhar_number, city, password) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, fname);
            statement.setString(2, lname);
            statement.setString(3, e_mail);
            statement.setString(4, pnumber);
            statement.setString(5, anumber);
            statement.setString(6, cityname);
            statement.setString(7, pass);
            
            int rowsAffected = statement.executeUpdate();

            System.out.println("Done"+ rowsAffected);
            statement.close();
            connection.close();
             
        }
        catch(Exception e)
        {
            e.getStackTrace();
            System.out.println("Connection Failed.....");
        }

    }
    public void dbconnect_Login(String pnumber,String pass)
    {
        String query = "SELECT * FROM guest";
        String db_phone_number;
        String db_password;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);

             while(resultSet.next())
             {
                db_phone_number = resultSet.getString("phone_number").trim();
                db_password = resultSet.getString("password").trim();
                if(db_phone_number.equals(pnumber) && db_password.equals(pass))
                {
                    db_name = resultSet.getString("first_name");
                    login_verify=1;
                    break;
                }
                else
                {
                    login_verify=0;
                }
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void phone_number_verify(String pnumber)
    {
        String query = "SELECT * FROM guest";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);

             while(resultSet.next()){
                if(pnumber.equals(resultSet.getString("phone_number").trim())){
                    pnumber_verify=1;
                }
             }
        }
        catch (Exception e) {
            e.getStackTrace();
        }
    }

    public int retriveUserId(String user)
    {
        String query = "SELECT hotel_manager_id FROM hotel_manager WHERE username=?";
        int id;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                id = resultSet.getInt("hotel_manager_id");
                return id;
            }
        }
        catch (Exception e) {
            e.getStackTrace();
            return 0;
        }
        return 0;
    }

    public boolean dbconnect_Hotel_Manager_details(String husername,String hpassword,javafx.scene.control.Label pass_status)
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Conection done Hotel manager");
            String sql = "INSERT INTO hotel_manager (username, password) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, husername);
            statement.setString(2, hpassword);
            int rowsAffected = statement.executeUpdate();
            System.out.println("Done"+ rowsAffected);
            statement.close();
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
        
    }

    public void dbconnect_Hotel_Manager_SignUp(String hname, String hadd, String hemail, String hphonenumber,
            String hcity, String hfilepath, File f, FileInputStream fs, javafx.scene.control.Label pass_status,int userId) {

    try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            // System.out.println("Conection done...");
            String sql = "INSERT INTO hotel (name, address, city, phone_number, email, hotel_image,hotel_manager_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, hname);
            statement.setString(2, hadd);
            statement.setString(3, hcity);
            statement.setString(4, hphonenumber);
            statement.setString(5, hemail);
            statement.setString(6, hfilepath);
            statement.setInt(7, userId);

            
            // File fi=new File("C:\\Programming\\Java_Dev\\Java_Project_1\\src " + hname + ".jpg");
		    // fs=new FileOutputStream(fi);
	    	// blob=.getBlob("SavePic");
	    	// b=blob.getBytes(1, (int)blob.length());
	    	// fs.write(b);

            int rowsAffected = statement.executeUpdate();
            System.out.println("Done"+ rowsAffected);
            
            pass_status.setText("Successfully account created");
            System.out.println("Hotel Data added successfully");
            
            statement.close();
            connection.close();
        }
        catch(Exception e)
        {
            e.getStackTrace();
            pass_status.setText("account didn't create");

            System.out.println("Connection of Signup Failed.....");
        }

    }

}
