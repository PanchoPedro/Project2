package booking.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Flights;


public class FetchFlights {
	
	public static List<Flights> getAllflights()
	{
		List<Flights> flights = new ArrayList<Flights>();
		Connection con = dbConnection.getConnection();
		String sql = "select * from flights";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				Flights flight = new Flights();
				flight.setId(rs.getInt(1));
				flight.setSource(rs.getString(2));
				flight.setDestination(rs.getString(3));
				flight.setAirline(rs.getString(4));
				flight.setPrice(rs.getInt(5));
				flight.setDate_time(rs.getString(6));
				flight.setSeats(rs.getInt(7));
				flights.add(flight);
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
		return flights;

}
}
