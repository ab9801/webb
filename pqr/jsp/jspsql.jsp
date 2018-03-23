<%@ page language ="java" import="java.sql.*" %>
<%@ page import ="javax.sql.*" %>

<%
String user=request.getParameter("name");
String passwrd=request.getParameter("pass");

try{

    Class.forName("com.mysql.jdbc.Driver");
    java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8080/languagetest", "root", "password");
    Statement st=con.createStatement();
    ResultSet rs=st.executeQuery("select userid,password from Users");
    while(rs.next())
    {
        String userid=rs.getString(1);
        String password=rs.getString(2);
        if(user.equals(userid) && passwrd.equals(password))
        {
            out.println("welcome");

            %>
            <jsp:forward page="Mainmenu.html"/>
        <%}
    }
}catch(Exception e1)
{}

%>
