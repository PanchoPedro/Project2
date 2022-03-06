package com.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Airlines;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import booking.db.dbConnection;
import booking.db.FetchAirlines;

/**
 * Servlet implementation class AirlineServlet
 */
//@WebServlet("AirlineServlet")
public class AirlineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AirlineServlet() {
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
		String airlinename=request.getParameter("airlinename");
		int affectedRows=0;
		
		
		if (airaction!=null&&airlinename!=null) {
			Connection con = dbConnection.getConnection();
			String sql="insert into airlines (airline) values (?);";
			try {
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, airlinename);
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
				RequestDispatcher dispatcher=request.getRequestDispatcher("Airlines.jsp");
				dispatcher.forward(request, response);
			}
			else {
				RequestDispatcher dispatcher=request.getRequestDispatcher("/Error.jsp");
				dispatcher.forward(request, response);
			}
		}
		else {
			List<Airlines> listairlines;
			listairlines=FetchAirlines.getAllairlines();
			request.setAttribute("listairlines", listairlines);
			RequestDispatcher dispatcher=request.getRequestDispatcher("Airlines.jsp");
			dispatcher.forward(request, response);
		}
		}
	
	}



