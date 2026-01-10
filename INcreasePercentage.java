package jdbc;
import java.sql.*;
public class INcreasePercentage {
public static void main(String[]args) {
	Connection c=null;
	ResultSet rs=null;
	Statement s=null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		c=DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","Sakshi@01");
		s=c.createStatement();
	String sql="Update student SET percentage=percentage+(percentage*0.05)"+
		"where branch='CSE'"; 
	int rows=s.executeUpdate(sql);
	System.out.println("Successfully Displayed");

	}catch(Exception e) {
		e.printStackTrace();
	}
}			
}
