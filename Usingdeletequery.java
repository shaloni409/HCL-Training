package jdbc;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Usingdeletequery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection c=null;
		Statement s=null;
		ResultSet rs=null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				c=DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","Sakshi@01");
				s=c.createStatement();
				String sql="delete from student where year=2024 AND branch='Civil'";
				int rows=s.executeUpdate(sql);
				System.out.println("Successfully Displayed");

	}catch(SQLException e) {
		System.out.println("sql");
		e.printStackTrace();

	}
			catch(ClassNotFoundException  e) {
				System.out.println("cnf");
				e.printStackTrace();

			}
	}
}
