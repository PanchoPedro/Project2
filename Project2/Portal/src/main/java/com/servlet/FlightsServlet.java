package com.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Flights;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import booking.db.dbConnection;
import booking.db.FetchFlights;

/**
 * Servlet implementation class FlightServlet
 */
//@WebServlet("AirportServlet")
public class FlightsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FlightsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("email")==null){
			response.sendRedirect("index.jsp");}
		String airaction=request.getParameter("airaction");
		String source=request.getParameter("source");
		
		int affectedRows=0;
		
		
		
		
		if (airaction!=null&&source!=null) {
			String destination=request.getParameter("destination");
			String airline=request.getParameter("airline");
			int price=Integer.parseInt((String)request.getParameter("price"));
			String fdate=request.getParameter("fdate");
			int seats=Integer.parseInt((String)request.getParameter("seats"));
			fdate=fdate.replace("T"," ");
			fdate=fdate+":00";
			
			Connection con = dbConnection.getConnection();
			String sql="insert into flights (source,destination,airline,price,date_time,seats) values (?,?,?,?,?,?);";
			try {
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, source);
				st.setString(2, destination);
				st.setString(3, airline);
				st.setInt(4, price);
				st.setString(5, fdate);
				st.setInt(6, seats);
				System.out.println(st);
				affectedRows = st.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (affectedRows==1) {
				RequestDispatcher dispatcher=request.getRequestDispatcher("Flights.jsp");
				dispatcher.forward(request, response);
			}
			else {
				RequestDispatcher dispatcher=request.getRequestDispatcher("/Error.jsp");
				dispatcher.forward(request, response);
			}
		}
		else {
			List<Flights> listflights;
			listflights=FetchFlights.getAllflights();
			request.setAttribute("listflights", listflights);
			RequestDispatcher dispatcher=request.getRequestDispatcher("Flights.jsp");
			dispatcher.forward(request, response);
		}
		}
	
	}



