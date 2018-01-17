package datos;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AltaCliente
 */
@WebServlet("/AltaCliente")
public class AltaCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nombre = request.getParameter("nombre");
		String ciudad = request.getParameter("ciudad");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
		String url= "jdbc:mysql://localhost:3306/tienda";
		String user= "root";
		String password = "";
		
		Connection connect = DriverManager.getConnection(url, user, password);
		PreparedStatement ps = connect.prepareStatement("INSERT INTO clientes (nombre, ciudad, telefono, mail) VALUES (?,?,?,?)");
		    
        ps.setString(1, nombre);

  		ps.setString(2, ciudad);

  		ps.setString(3, telefono);
  		
  		ps.setString(4, email);

  		ps.executeUpdate();

    } catch (ClassNotFoundException e) {

        e.printStackTrace();

    } catch (SQLException e) {

        e.printStackTrace();

    } 

	}

}
