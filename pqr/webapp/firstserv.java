import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/firstserv")
public class firstserv extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public firstserv() {
    	
    	
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 	final String dbClassName = "com.mysql.jdbc.Driver";
		    final String CONNECTION ="jdbc:mysql://127.0.0.1/db1";
		    int i=0;
		    PrintWriter out = response.getWriter();
		    ArrayList<String> sturec = new ArrayList<String>();
		    String fname=request.getParameter("firstname");
		    String lname=request.getParameter("lastname");
		    String email=request.getParameter("emailID");
		    String pass=request.getParameter("pass");
		    /*
		    try
		    {
			    Class.forName(dbClassName);
			    Properties p = new Properties();
			    p.put("user","root");
			    p.put("password","student");
			 	Connection c = DriverManager.getConnection(CONNECTION,p);
			    Statement stmt = c.createStatement();
			    String query = "select * from student";
			    ResultSet rs = stmt.executeQuery(query);
			    while(rs.next())
			    {
			    	String q = rs.getString(1)+"\t"+rs.getInt(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4)+"\t"+rs.getInt(5);
			    	sturec.add(q);
			    }
			    c.close();
			 }
		
		    catch(Exception e)
		    
		    {
		    	out.print(e);
		    }
		    */
		    /*
			response.setContentType("text/html");
			out.print("<html><body>");
			out.print("<h3> Hello there Servlet</h3>");
			for(i=0;i<sturec.size();i++)
			{
				out.print("<h4>"+sturec.get(i)+"</h4>");
			}
			out.print("</body></html>");
			*/
			try
		    {
			    Class.forName(dbClassName);
			    Properties p = new Properties();
			    p.put("user","root");
			    p.put("password","student");
			 	Connection c = DriverManager.getConnection(CONNECTION,p);
			    Statement stmt = c.createStatement();
			    String query = "insert into signup values("+
			    		'"'+fname+'"'+","+
			    		'"'+lname+'"'+","+
			    		'"'+email+'"'+","+
			    		'"'+pass+'"'+
			    		");";
			    stmt.executeUpdate(query);
			    c.close();
			 }
		    catch(Exception e)
		    
		    {
		    	out.print(e);
		    }
			response.setContentType("text/html");
			out.print("<html><body>");
			out.print("<h3> Hello there Servlet</h3>");
			out.print("<p>"+fname+"<br>"+lname+"<br>"+email+"<br>"+pass+"</p>");
			out.print("</body></html>");
			response.sendRedirect("loginpage.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}