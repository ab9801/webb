import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		final String dbClassName = "com.mysql.jdbc.Driver";
	    final String CONNECTION ="jdbc:mysql://127.0.0.1/db1";
	    PrintWriter out = response.getWriter();
	    String email=request.getParameter("emailID");
	    String pass=request.getParameter("pass");
	    try
	    {
		    Class.forName(dbClassName);
		    Properties p = new Properties();
		    p.put("user","root");
		    String pa="";
		    p.put("password","student");
		 	Connection c = (Connection) DriverManager.getConnection(CONNECTION,p);
		    Statement stmt = (Statement) c.createStatement();
		    String query = "select password from signup where email="+'"'+email+'"'+";";
		    ResultSet rs = (ResultSet) stmt.executeQuery(query);
		    while(rs.next())
		    {
		    	pa=rs.getString(1);
		    	
		    }
		    if(pass.equals(pa))
	    	{
				response.sendRedirect("success.html");
	    	}
	    	else
	    	{
	    		response.sendRedirect("loginpage.html");
	    	}
		    c.close();
		 }
	
	    catch(Exception e)
	    
	    {
	    	out.print(e);
	    }
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}