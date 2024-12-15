package FlightReservationSystem_1;
import java.sql.*;
public class Connect {
    Connection c;
    Statement s;
    public Connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql:///flightreservation","root","WWQr23117$$");
            s=c.createStatement();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

}
