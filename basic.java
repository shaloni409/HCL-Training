package jdbc;
import java.sql.*;
public class basic {
	    public static void main(String[] args) {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            System.out.println("Driver Loaded Successfully");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	            System.out.println("Unable to connect");
	        }
	    }
	}


