

import java.beans.Statement;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DBOperations")
public class DBOperations extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        
        try {
                 PrintWriter out = response.getWriter();
                 out.println("<html><body>");
                 
                InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
                Properties props = new Properties();
                props.load(in);
                
                
                DBConnection conn = new DBConnection(props.getProperty("url"), props.getProperty("userid"), props.getProperty("password"));
                java.sql.Statement stmt = conn.getConnection().createStatement();
                stmt.executeUpdate("create database mydatabase");
                out.println("Created database: mydatabase<br>");
                stmt.executeUpdate("use mydatabase");
                out.println("Selected database: mydatabase<br>");
                stmt.executeUpdate("drop database mydatabase");
                stmt.close();
                out.println("Dropped database: mydatabase<br>");
                
                
                
                
                
                conn.closeConnection();
                
                
                out.println("</body></html>");
                conn.closeConnection();
                
        } catch (ClassNotFoundException e) {
                e.printStackTrace();
        } catch (SQLException e) {
                e.printStackTrace();
        }
}

/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
}

}

	