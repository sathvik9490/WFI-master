package com.src.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * Servlet implementation class Profiledeletecontroller
 */
@WebServlet("/Profiledeletecontroller")
public class Profiledeletecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profiledeletecontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("uname");
		int i=0;
		
		try {
			Context context = new InitialContext();
			DataSource ds=(DataSource)context.lookup("java:comp/env/jdbc/test");
			Connection connection = ds.getConnection();
			PreparedStatement pst1= connection.prepareStatement("delete from producer where uname ='"+uname+"'");
            int r1 = pst1.executeUpdate();
					  if (r1>0){
				      		  i=i+1;
					  }
		PreparedStatement pst2= connection.prepareStatement("delete from trader where uname ='"+uname+"'");
	   int r2 = pst2.executeUpdate();
	          if (r2>0){
						 i=i+1;
					  }
	  PreparedStatement pst3= connection.prepareStatement("delete from nprofits where uname ='"+uname+"'");
	  int r3 = pst3.executeUpdate();
		     if (r3>0){
						 i=i+1;
		     }
		     PreparedStatement pst4= connection.prepareStatement("delete from fsuppliers where uname ='"+uname+"'");
			 int r4 = pst4.executeUpdate();
			 if (r4>0){	
				 i=i+1;
				 }		
			 PreparedStatement pst5= connection.prepareStatement("delete from customer where uname ='"+uname+"'");
	       int r5 = pst5.executeUpdate();			
	       if (r5>0) {
	    	   i=i+1;
					 }
	           if(i>0)
	           {
	        	   request.setAttribute("deletemsg", "The profile is removed from the website");
	           }
	           else {
		    request.setAttribute("deletemsg", "The profile is not removed from the website");
		   }
	           request.getRequestDispatcher("adminpage.jsp").forward(request, response);			
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}
