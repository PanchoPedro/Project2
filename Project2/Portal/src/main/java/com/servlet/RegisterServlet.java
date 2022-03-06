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
 * Servlet implementation class RegisterServlet
 */
//@WebServlet("RegisteServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String totalprice=request.getParameter("totalprice");
		String totalperson=request.getParameter("totalperson");
		String flightid=request.getParameter("flightid");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String firstname=request.getParameter("firstname");
		String surname=request.getParameter("surname");
		String phone=request.getParameter("phone");
		String date=request.getParameter("dob");
		int affectedRows=0;
		
		//List<Users> users = new ArrayList<Users>();
		Connection con = dbConnection.getConnection();
			String sql="insert into users (firstname,surname,email,phone,dateofbirth,password) values (?,?,?,?,?,?);";
			try {
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, firstname);
				st.setString(2, surname);
				st.setString(3, email);
				st.setString(4, phone);
				st.setString(5, date);
				st.setString(6, password);
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
	
		request.setAttribute("totalprice",totalprice);
		request.setAttribute("totalperson",totalperson);
		request.setAttribute("flightid",flightid);
		request.setAttribute("email",email);
		request.setAttribute("password",password);
		RequestDispatcher dispatcher=request.getRequestDispatcher("LoginServlet");
		dispatcher.forward(request, response);
		}
		else {
			String URLredirect = "/Portal/register.jsp?totalprice="+totalprice+"&totalperson="+totalperson+"&flightid="+flightid+"&error=Registration failed";
   		 	response.sendRedirect(URLredirect);
		}
		}
	}



