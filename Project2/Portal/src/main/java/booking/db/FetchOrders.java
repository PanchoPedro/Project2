package booking.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Orders;

public class FetchOrders {
	public static List<Orders> getAllorders()
	{
		List<Orders> orders = new ArrayList<Orders>();
		Connection con = dbConnection.getConnection();
		String sql = "SELECT users.firstname,users.surname,users.email,flights.id,flights.source,flights.destination,flights.date_time FROM users,flights,orders where users.id=orders.userid and flights.id=orders.flightid;";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				Orders order = new Orders();
				order.setFirstname(rs.getString(1));
				order.setSurname(rs.getString(2));
				order.setEmail(rs.getString(3));
				order.setFlightid(rs.getInt(4));
				order.setSource(rs.getString(5));
				order.setDestination(rs.getString(6));
				order.setDate_time(rs.getString(7));
				orders.add(order);
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
		return orders;

}
}
