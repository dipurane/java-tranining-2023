package com.encora.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycleServlet extends HttpServlet {

	    int counter = 0;
	    
	    // Declare your result list here
		@Override
		public void init() throws ServletException {
			System.out.println("############### Life Servlet Initiated #############");
			// populate your result List here
		}
	
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 counter ++;
		 System.out.println("###### Recieved the  "+ counter + " Request");
		}
		
		@Override
		public void destroy() {
			System.out.println("#$$$$$$$$$$$$$$$$$$$$$$$$$ Destroy Method Called $$$$$$$$$$$$$$");
		}
	
}
