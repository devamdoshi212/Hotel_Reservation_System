import java.awt.Label;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Array;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
// import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Database{
    
    String url = "jdbc:mysql://localhost/hotel_reservation_system";
    String username = "root";
    String password = "";

    int login_verify=0;
    int pnumber_verify=0;
    int hotel_manager_username_verify=0;
    int hotel_manager_login_verify=0;
    int db_hotel_manager_id;

    int db_room_id;
    int db_price;
    int db_aroom;
    int db_roomtype;
    
    String hotel_name;
    String db_name;
    String db_phone_number;
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

    public int retriveHotelId(int managerid)
    {
        String query = "SELECT hotel_id FROM hotel WHERE hotel_manager_id=?";
        int hotelid;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, managerid);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                hotelid = resultSet.getInt("hotel_id");
                return hotelid;
            }
        }
        catch (Exception e) {
            e.getStackTrace();
            return 0;
        }
        return 0;
    }

    public void dbconnect_Hotel_Room_details(int hotelid,int price,int aroom,int rtpye)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Conection done...");
            String sql = "INSERT INTO hotel_room (hotel_id, price_per_night, is_available, room_type) VALUES (?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, hotelid);
            statement.setInt(2, price);
            statement.setInt(3, aroom);
            statement.setInt(4, rtpye);

            int rowsAffected = statement.executeUpdate();
            System.out.println("Done"+ rowsAffected);
            System.out.println("Hotel Room Data added successfully");
            
            statement.close();
            connection.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void dbconnect_Hotel_Manager_Login(String user,String pass)
    {
        String query = "SELECT * FROM hotel_manager";
        String db_username;
        String db_password;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);

             while(resultSet.next())
             {
                db_username = resultSet.getString("username").trim();
                db_password = resultSet.getString("password").trim();
                if(db_username.equals(user) && db_password.equals(pass))
                {
                    hotel_manager_login_verify=1;
                    db_hotel_manager_id = resultSet.getInt("hotel_manager_id");
                    break;
                }
                else
                {
                    hotel_manager_login_verify=0;
                }
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void retriveHotelName(int managerid)
    {
        String query = "SELECT name FROM hotel WHERE hotel_manager_id=?";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, managerid);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                hotel_name = resultSet.getString("name");
            }
        }
        catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void retriveAllHotelRoomDetails(int managerid)
    {

        String query = "SELECT * FROM hotel_room WHERE hotel_id=?";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, retriveHotelId(managerid));
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                db_price = resultSet.getInt("price_per_night");
                db_aroom = resultSet.getInt("is_available");
                db_roomtype = resultSet.getInt("room_type");

            }
        }
        catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void updateroomdetails(int hotelid,int price,int aroom,int roomtype)
    {
        String query = "UPDATE hotel_room SET price_per_night=?,is_available=?,room_type=? WHERE hotel_id=?";

        try {
             Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, price);
            statement.setInt(2, aroom);
            statement.setInt(3, roomtype);
            statement.setInt(4, hotelid);
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (Exception e){
            e.getStackTrace();
        }
        
    }

    public String[] retriveRoomType()
    {
        String query = "SELECT * FROM hotel_room_type";
        String[] array = {"None"};
        String temp;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            int i=0;
            while(resultSet.next()){
                temp=resultSet.getString("room_type");
                Array.set(array, i, temp);
                i++;
            }
            return array;
        }
        catch (Exception e) {
            e.getStackTrace();
        }
        return array;
    }

    public void insertResDetails(Date checkindate,Date checkoutdate,String guest,String price,int roomid,int guestid )
    {
        String sql = "INSERT INTO reservation(guest_id, check_in_date, check_out_date, num_of_guests, total_price, room_id) VALUES (?,?,?,?,?,?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, guestid);
            statement.setDate(2, checkindate);
            statement.setDate(3, checkoutdate);
            statement.setInt(4, Integer.parseInt(guest));
            statement.setInt(5, Integer.parseInt(price));
            statement.setInt(6, roomid);

            int rowsAffected = statement.executeUpdate();
            System.out.println("Done"+ rowsAffected);
            System.out.println("Reservation successfully");
            
            statement.close();
            connection.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void retriveAllHotelRoomDetailsbyhotelid(int hotelid)
    {

        String query = "SELECT * FROM hotel_room WHERE hotel_id=?";
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, hotelid);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                db_room_id = resultSet.getInt("room_id");
                db_price = resultSet.getInt("price_per_night");
                db_aroom = resultSet.getInt("is_available");
                db_roomtype = resultSet.getInt("room_type");

            }
        }
        catch (Exception e) {
            e.getStackTrace();
        }
    }

    public int retriveguestId(String pnumber)
    {
        String query = "SELECT guest_id FROM guest WHERE phone_number=?";
        int id;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, pnumber);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                id = resultSet.getInt("guest_id");
                return id;
            }
        }
        catch (Exception e) {
            e.getStackTrace();
            return 0;
        }
        return 0;
    }
}
