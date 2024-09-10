

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public register() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String gender=request.getParameter("gender");
		String country=request.getParameter("country");
		String confirmpassword=request.getParameter("confirmpassword");
		String[] hobbies=request.getParameterValues("hobbies");
		Connection con = null;
		PreparedStatement ps= null;
		
		
//		CREATE TABLE student (
//			
//			    name VARCHAR(100) NOT NULL,
//			    email VARCHAR(100) NOT NULL UNIQUE,
//			    password VARCHAR(100) NOT NULL,
//			    confirmpassword VARCHAR(100) NOT NULL,
//			    hobbies VARCHAR(255),
//			    gender ENUM('Male', 'Female', 'Other') NOT NULL,
//			    country VARCHAR(50) NOT NULL
//			);

		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");	
//			con=DriverManager.getConnection("jdbc:mysql://128.66.203.247/imsc7it236","imsc7it236","sumo@123");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentcec","root","Farman@123");

			ps = con.prepareStatement("insert into student values(?,?,?,?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, password);
			ps.setString(4, confirmpassword);
			String selectedhobbies=(hobbies!=null ? String.join(",",hobbies):"");
			ps.setString(5,  selectedhobbies);
			ps.setString(6, gender);
			ps.setString(7, country);

			
			int rs = ps.executeUpdate();
			
			
			if(rs>0)
			{
				response.sendRedirect("login.jsp");
			}
			else
			{
				response.sendRedirect("error.jsp");
			}
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
	}

}
