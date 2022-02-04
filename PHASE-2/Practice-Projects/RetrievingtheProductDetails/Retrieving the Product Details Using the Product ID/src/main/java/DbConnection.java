import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	public static Connection dbConn() throws ClassNotFoundException, SQLException {
	   	 Class.forName("com.mysql.jdbc.Driver");
	   	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Products","root","Gowthi@20");
	   	 return con;
	    }
}
