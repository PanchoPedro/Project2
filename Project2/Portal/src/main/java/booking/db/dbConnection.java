package booking.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {


	public static Connection getConnection(){
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flyair",
						"root", "mysql");
				System.out.println("DB Connected ..");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		}
		catch (ClassNotFoundException e)
		{
		 e.printStackTrace();
		}
		return con;

}
}