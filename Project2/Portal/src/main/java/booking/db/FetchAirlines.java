package booking.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Airlines;

public class FetchAirlines {
	public static List<Airlines> getAllairlines()
	{	
		System.out.println("getAllairlines");
		List<Airlines> airlines = new ArrayList<Airlines>();
		Connection con = dbConnection.getConnection();
		String sql = "select * from airlines";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				Airlines airline = new Airlines();
				airline.setId(rs.getInt(1));
				airline.setAirline(rs.getString(2));
				airlines.add(airline);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return airlines;

}

}
