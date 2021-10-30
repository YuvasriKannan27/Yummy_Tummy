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
 * Servlet implementation class AddFood
 */
@WebServlet("/AddFood")
public class AddFood extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out=response.getWriter();
			
			String food=request.getParameter("food");
			int price=Integer.parseInt(request.getParameter("price"));
			
			
			Connection cn=DataConnect.getCn();
			PreparedStatement ps=cn.prepareStatement("insert into addfood values(?,?)");
		
			ps.setString(1, food);
			ps.setInt(2, price);
			
			ps.execute();
			out.print("Food Items Added...");
			RequestDispatcher rd=request.getRequestDispatcher("AdminHome.html");
			rd.include(request, response);
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
