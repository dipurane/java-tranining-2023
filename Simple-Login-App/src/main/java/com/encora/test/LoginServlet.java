package com.encora.test;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPut(req, resp);
		PrintWriter pw = resp.getWriter();
		
		String u = req.getParameter("username");
		String p = req.getParameter("password");
		DBConnector db = new DBConnector();
		db.getConnection();
		System.out.println(u);
		System.out.println(p);
		if(u.equals(p)) {
			
			resp.sendRedirect("welcome.html");
		}else {
			
			pw.print("<h4> Incorrect password</h4>");
			RequestDispatcher disp = req.getRequestDispatcher("index.html");
			disp.forward(req, resp);
			}
	}
	
}
