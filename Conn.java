package University.work.OOP.Project.HotelManagmentSystem;
import java.sql.*;
public class Conn {
    Connection c;
    Statement s;

    Conn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmangementsystem","root","basitali@666");
            s=c.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
