package datos;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VerCliente
 */
@WebServlet("/VerCliente")
public class VerCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			String url= "jdbc:mysql://localhost:3306/tienda";
			String user= "root";
			String password = "";
			
			Connection connect = DriverManager.getConnection(url, user, password);
			Statement statement = connect.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from clientes");
			 
			 out.println("<table border=\"1\">");
			 
			             while(resultSet.next()) {
			 
			               out.println("<tr>");
			 
			               out.println("<td>" + resultSet.getString("nombre") + "</td>");
			 
			               out.println("<td>" + resultSet.getString("ciudad") + "</td>");
			 
			               out.println("<td>" + resultSet.getString("telefono") + "</td>");
			               
			               out.println("<td>" + resultSet.getString("mail") + "</td>");
			 
			               out.println("</tr>");
			 
			             }
			 
			             out.println("</table>");
			 
			         } catch (ClassNotFoundException e) {
			 
			             e.printStackTrace();
			 
			         } catch (SQLException e) {
			 
			             e.printStackTrace();
			 
			         } finally {
			 
			             if(out != null)
			 
			                 out.close();
			 
			         }


		}
		
		
		
	}


