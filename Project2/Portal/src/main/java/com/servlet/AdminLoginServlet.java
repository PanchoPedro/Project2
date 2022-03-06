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
 * Servlet implementation class AdminLoginServlet
 */
//@WebServlet("AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		List<Users> users = new ArrayList<Users>();
		Connection con = dbConnection.getConnection();
			String sql="select * from users where users.email=? and users.password=? and users.type='admin';";
			try {
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, email);
				st.setString(2, password);
				System.out.println(st);
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
				
				for (int i = 1; i <= users.size(); i++) {
					System.out.println(users.get(i-1).getId());
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
			
		if (users.size()==1) {
			HttpSession session=request.getSession();
			session.setAttribute("email", email);
			response.sendRedirect("AdminHome.jsp");
		}
		else {
			String URLredirect = "/Portal/adminlogin.jsp?error=Invalid Credentials";
   		 	response.sendRedirect(URLredirect);
		}
		}
	}



