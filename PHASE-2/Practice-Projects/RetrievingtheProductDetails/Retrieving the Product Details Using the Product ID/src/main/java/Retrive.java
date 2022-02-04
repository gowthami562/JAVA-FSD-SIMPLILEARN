

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Retrive
 */
public class Retrive extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Retrive() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter pw=response.getWriter();
		 ProductsBean pb=new ProductsBean();
		 pb.setPid(Integer.parseInt(request.getParameter("pid")));
  		 pw.println("<html><body>");  
  		 response.setContentType("text/html");
  		
    	 try {
       		 Connection con=DbConnection.dbConn();
       		 String sql="select * from product where pid=(?)";
    		 PreparedStatement ps=con.prepareStatement(sql);
    		 ps.setInt(1,pb.getPid());
    		 ResultSet rs=ps.executeQuery();
    		 RequestDispatcher rd=request.getRequestDispatcher("index.html");
    		 rd.include(request, response);
       		// pw.print("<br><center><h3>Pr</h3><br></center>");
      		
       		 pw.println("<center><table border=1 width=14% height=10%>");  
             pw.println("<tr><th>Product Id</th><th>Product Name</th><th>Price</th>"); 
       		 while(rs.next()) {
       			
       			 //pw.println(rs.getInt(1)+"   "+rs.getString(2));
       			 pw.println("<tr><td>" + rs.getInt(1)+ "</td><td>" + rs.getString(2) +"</td><td>"+ rs.getDouble(3)+"</td></tr></center>");   
       			 
       		 }
       		 pw.println("</table>");  
       		 pw.println("</html></body>");  
       		 //rd.include(request, response);
       		 
       	 } catch (ClassNotFoundException e) {
       		 // TODO Auto-generated catch block
       		 e.printStackTrace();
       	 } catch (SQLException e) {
       		 // TODO Auto-generated catch block
       		 e.printStackTrace();
       	 }	 
    }

}
