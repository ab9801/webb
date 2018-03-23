import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class first
{
  private static final String dbClassName = "com.mysql.jdbc.Driver";
  private static final String CONNECTION = "jdbc:mysql://127.0.0.1/webLab3009";
  static ArrayList<String> stuDet  = new ArrayList<String>();
  public static String getGrade(int marks)
  {
	  if(marks>=50)
	  {
		  if(marks>=50 && marks<=59)
			  return "B";
		  if(marks>=60 && marks<=69)
			  return "B+";
		  if(marks>=70 && marks<=79)
			  return "A";
		  if(marks>=80 && marks<=89)
			  return "A+";
		  if(marks>=90)
			  return "O";
	  }
	  else
		  return "RA";
	return null;
  }
  public static void main(String[] args) throws
                             ClassNotFoundException,SQLException, IOException
  {
	   	System.out.println("Name\tReg No\tSub1\tSub2\tSub3");
	    Class.forName(dbClassName);
	    Properties p = new Properties();
	    p.put("user","root");
	    p.put("password","deepakcr$$$###");
	    Connection c = DriverManager.getConnection(CONNECTION,p);
	    Statement stmt = c.createStatement() ;
	    String query = "select * from student ;" ;
	    ResultSet rs = stmt.executeQuery(query) ;
	    FileWriter fw=new FileWriter("src/dets.txt");         
	    while(rs.next())
	    {
	    	System.out.println(rs.getString(1)+"\t"+rs.getInt(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4)+"\t"+rs.getInt(5));
	    	int m1=rs.getInt(3);
	    	int m2=rs.getInt(4);
	    	int m3=rs.getInt(5);
	    	String g1,g2,g3;
	    	g1 = getGrade(m1);
	    	g2 = getGrade(m2);
	    	g3 = getGrade(m3);
	    	int total = m1+m2+m3;
	    	float avg = (float) (total/3.0);
	    	String s = g1+","+g2+","+g3+","+String.valueOf(total)+","+String.valueOf(avg);
	    	stuDet.add(s);
	    	fw.write(s+"\n");
	    }
	    fw.close();
	    c.close();
  }

}