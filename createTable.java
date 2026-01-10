package jdbc;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class createTable {
public static void main(String[]args) {
	try {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "Sakshi@01");
		Statement stmt=con.createStatement();
		/*
		String sql="CREATE TABLE test("+
		"id int PRIMARY KEY,"+
		"name VARCHAR(50),"+
		"age int)";
		stmt.execute(sql);
		System.out.println("create table sucessfully");
		con.close();
		
		
	}catch(SQLException e) {
		e.printStackTrace();
	}*/
		String sql="insert into test values(9,'rahul',22)";
		String sql2="insert into test values(10,'ram',26)";


		stmt.executeUpdate(sql);
		stmt.executeUpdate(sql2);
        System.out.println("Data Inserted Successfully!");

	ResultSet rs=stmt.executeQuery("select * from test");
	while(rs.next()) {
		System.out.println(rs.getInt("id")+" "+
	rs.getString("name")+" "+
				rs.getInt("age")
	);
	}
	}catch(SQLException e) {
		e.printStackTrace();
	}
}
}
