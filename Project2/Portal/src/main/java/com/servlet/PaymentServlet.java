package com.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Users;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import booking.db.dbConnection;;

/**
 * Servlet implementation class PaymentServlet
 */
//@WebServlet("PaymentServlet")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public PaymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userid=Integer.parseInt((String)request.getParameter("userid"));
		int totalperson=Integer.parseInt((String)request.getParameter("totalperson"));
		int flightid=Integer.parseInt((String)request.getParameter("flightid"));
		int affectedRows=0;
		
		//List<Users> users = new ArrayList<Users>();
		Connection con = dbConnection.getConnection();
			String sql="insert into orders (userid,flightid,seats) values (?,?,?);";
			try {
				PreparedStatement st = con.prepareStatement(sql);
				st.setInt(1, userid);
				st.setInt(2, flightid);
				st.setInt(3, totalperson);
				System.out.println(st);
				affectedRows = st.executeUpdate();
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
			
		if (affectedRows==1) {
		RequestDispatcher dispatcher=request.getRequestDispatcher("/Success.jsp");
		dispatcher.forward(request, response);
		}
		else {
			RequestDispatcher dispatcher=request.getRequestDispatcher("/Error.jsp");
			dispatcher.forward(request, response);
		}
		}
	}



