package serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connect.DataConnect;
import java.sql.*;

/**
 * Servlet implementation class Interpay
 */
@WebServlet("/Interpay")
public class Interpay extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out=response.getWriter();
			
			String n=request.getParameter("Name");
			String b=request.getParameter("Bank");
			String a=request.getParameter("AccountNo");
			String c=request.getParameter("Contact");
			
			
			
			
			
			Connection cn=DataConnect.getCn();
			PreparedStatement ps=cn.prepareStatement("insert into Intpay values(?,?,?,?)");
			ps.setString(1,n);
			ps.setString(2, b);
			ps.setString(3, a);
			ps.setString(4, c);
			
			ps.execute();
			out.print("Payment process is Successfully Done.....");
			RequestDispatcher rd=request.getRequestDispatcher("feedback.html");
			rd.include(request, response);
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	}


