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
 * Servlet implementation class Regist
 */
@WebServlet("/Regist")
public class Regist extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		PrintWriter out=response.getWriter();
		int Id=(int)(Math.random()*10000);
		String n=request.getParameter("Name");
		String pw=request.getParameter("Password");
		String l=request.getParameter("Location");
		String e=request.getParameter("EmailId");
		String p=request.getParameter("Phn");
		
		
		
		
		Connection cn=DataConnect.getCn();
		PreparedStatement ps=cn.prepareStatement("insert into Register values(?,?,?,?,?,?)");
		ps.setInt(1, Id);
		ps.setString(2, n);
		ps.setString(3, pw);
		ps.setString(4, l);
		ps.setString(5, e);
		ps.setString(6, p);
		ps.execute();
		out.print("Registration success for ID :"+Id);
		RequestDispatcher rd=request.getRequestDispatcher("Home.html");
		rd.include(request, response);
		
	}catch(Exception e) {
		System.out.println(e);
	}
}
	}


