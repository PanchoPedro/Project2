package booking.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Users;

public class FetchUsers {
		public static List<Users> getAllusers()
		{
			List<Users> users = new ArrayList<Users>();
			Connection con = dbConnection.getConnection();
			String sql = "select * from users";
			try {
				PreparedStatement st = con.prepareStatement(sql);
				ResultSet rs = st.executeQuery();
				while(rs.next())
				{
					Users user = new Users();
					user.setId(rs.getInt(1));
					user.setFirstname(rs.getString(2));
					user.setSurname(rs.getString(3));
					user.setEmail(rs.getString(4));
					user.setPhone(rs.getString(5));
					user.setDateofbirth(rs.getString(6));
					user.setPassword(rs.getString(7));
					user.setType(rs.getString(8));
					users.add(user);
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
			return users;

	}
	
	

}
