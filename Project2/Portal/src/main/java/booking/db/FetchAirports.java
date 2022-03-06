package booking.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Airports;

public class FetchAirports {
	
	public static List<Airports> getAllairports()
	{
		System.out.println("getAllairports");
		List<Airports> airports = new ArrayList<Airports>();
		Connection con = dbConnection.getConnection();
		String sql = "select * from airports Order by airport ASC;";
		try {
			System.out.println("try con:"+con);
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				Airports airport = new Airports();
				airport.setId(rs.getInt(1));
				airport.setAirport(rs.getString(2));
				airports.add(airport);
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
		return airports;

}

}
