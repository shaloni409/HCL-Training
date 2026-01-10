package jdbc;
import java.sql.DriverManager;
import java.sql.*;
public class displayRecords {
public static void main(String[]args){
	Connection c=null;
	ResultSet rs=null;
	Statement s=null;
	try{Class.forName("com.mysql.cj.jdbc.Driver");
	c=DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","Sakshi@01");
	s=c.createStatement();
	String sql="SELECT branch from student"
			+ " where sem=7 AND branch='EC'";
	rs=s.executeQuery(sql);
	while (rs.next()) {
	    System.out.println(
	        rs.getInt("id") + " " +
	        rs.getString("name") + " " +
	        rs.getString("branch")+" "+
	        rs.getInt("sem")
	    );
	}
}catch(Exception e) {
	e.printStackTrace();

}
}
}
