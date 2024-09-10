

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
 * Servlet implementation class delete
 */
@WebServlet("/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String email=request.getParameter("email");
		
		
		
		Connection con = null;
		PreparedStatement ps= null;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");	
			con=DriverManager.getConnection("jdbc:mysql://128.66.203.247/imsc7it236","imsc7it236","sumo@123");
			ps = con.prepareStatement("delete from student where email=? ");
			
			
			ps.setString(1, email);
			
			
			int rs = ps.executeUpdate();
			
			
			if(rs>0)
			{
				response.sendRedirect("deleted.jsp");
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
		doGet(request, response);
	}

}