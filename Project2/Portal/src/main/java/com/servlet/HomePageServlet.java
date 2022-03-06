package com.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Flights;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import booking.db.dbConnection;;

/**
 * Servlet implementation class HomePageServlet
 */
//@WebServlet("HomePageServlet")
public class HomePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public HomePageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String origin=request.getParameter("source");
		String destination=request.getParameter("destination");
		String date=request.getParameter("fdate");
		String totalPerson=request.getParameter("seats");
		
		List<Flights> flights = new ArrayList<Flights>();
		Connection con = dbConnection.getConnection();
			String sql="select flights.*, SUM(orders.seats) from flights left join orders ON flights.id=orders.flightid where flights.source=? and flights.destination=? and CAST(flights.date_time as date)=? GROUP BY orders.flightid Order by date_time ASC;";
			try {
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, origin);
				st.setString(2, destination);
				st.setString(3, date);
				System.out.println(st);
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
					flight.setTakenseats(rs.getInt(8));
					flights.add(flight);
				}
				//System.out.println(flights);
				for (int i = 1; i <= flights.size(); i++) {
					System.out.println(flights.get(i-1).getTakenseats());
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
			request.setAttribute("flights", flights);
			request.setAttribute("totalPerson", totalPerson);
		RequestDispatcher dispatcher=request.getRequestDispatcher("/FlightDetails.jsp");
		dispatcher.forward(request, response);
			
		}
	}



