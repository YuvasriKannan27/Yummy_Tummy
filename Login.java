package serv;


import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connect.DataConnect;
import java.sql.*;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out=response.getWriter();
			String id=request.getParameter("id");
			
			String password=request.getParameter("password");
			Connection cn=DataConnect.getCn();
			PreparedStatement ps=cn.prepareStatement("select id,password from Register where id=? and password=?  ");
			ps.setString(1, id);
			
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				
				HttpSession ses1=request.getSession();
				ses1.setAttribute("id",rs.getString(1));
				HttpSession ses2=request.getSession();
				ses2.setAttribute("password",rs.getString(2));
				RequestDispatcher rd=request.getRequestDispatcher("Home.html");
				rd.forward(request, response);
			}else {
				out.print("wrong userid or username");
				RequestDispatcher rd=request.getRequestDispatcher("Login.html");
				rd.include(request, response);
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
			
