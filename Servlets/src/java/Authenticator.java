import java.sql.*;

public class Authenticator {
    public static boolean loginValidate(String username ,String password) {
        boolean valid_combination = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");  
            String url = "jdbc:mysql://localhost:3306/mysql";
            String db_username =  "root" ;
            String db_password = "password";
            Connection con = DriverManager.getConnection(url , db_username , db_password);
            PreparedStatement stmt = con.prepareStatement("select * from login_details where username=? and password=?");
            stmt.setString(1,username);
            stmt.setString(2,password);
            ResultSet rs = stmt.executeQuery();
            valid_combination = rs.next();
            con.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return valid_combination;
    }
    
    public static boolean signUpValidate(String uname, String pw, String cpw) {
        boolean isValid = false;
        if(pw.equals(cpw) == false) {
            return isValid;
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");  
            String url = "jdbc:mysql://localhost:3306/mysql";
            String db_username =  "root" ;
            String db_password = "password";
            Connection con = DriverManager.getConnection(url , db_username , db_password);
            PreparedStatement stmt = con.prepareStatement("select * from login_details where username=?");
            stmt.setString(1,uname);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                return isValid;
            } 
            stmt = con.prepareStatement("insert into login_details (username,password) values(?,?)");
            stmt.setString(1,uname);
            stmt.setString(2, pw);
            stmt.execute();
            con.close();
            isValid = true;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return isValid;
    }
    
    
}
