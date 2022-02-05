

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import org.hibernate.SessionFactory;


@WebServlet("/ListProduct")
public class ListProduct extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
         try {
                SessionFactory factory = HibernateUtil.getSessionFactory();
                
                Session session = (Session) factory.openSession();
                // using HQL
                List<EProduct> list = ((org.hibernate.Session) session).createQuery("from EProduct").list();
                
                session.close();
                
                 PrintWriter out = response.getWriter();
                 out.println("<html><body>");
                 out.println("<b>Product Listing</b><br>");
                 for(EProduct p: list) {
                         out.println("ID: " + String.valueOf(p.getID()) + ", Name: " + p.getName() +
                                         ", Price: " + String.valueOf(p.getPrice()) + ", Date Added: " + p.getDateAdded().toString() + "<br>");
                 }
                 
             out.println("</body></html>");
             
             
         } catch (Exception ex) {
                 throw ex;
         }
            
}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
}

}

