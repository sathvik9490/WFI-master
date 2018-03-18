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
 * Servlet implementation class Traderupdatecontroller
 */

import com.src.modal.Producersregistermodel;
import com.src.modal.Tradersregistermodel;
@WebServlet("/Traderupdatecontroller")
public class Traderupdatecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Traderupdatecontroller() {
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
		 String pno = request.getParameter("pno");
	   	  String locality = request.getParameter("locality");
	   	 String password = request.getParameter("password");
	  	  String cpassword = request.getParameter("cpassword");
	      String products=request.getParameter("products");
	       int i=0;
	      if(password==cpassword)
		{
			try {
			Context context = new InitialContext();
			DataSource ds=(DataSource)context.lookup("java:comp/env/jdbc/test");
			Connection connection = ds.getConnection();
			Statement statement = connection.createStatement();
			HttpSession session1=request.getSession(false); 
		    Tradersregistermodel trm=(Tradersregistermodel)session1.getAttribute("trm");
			if(!locality.equals(""))
			{
		    int l=statement.executeUpdate("update trader set locality='"+locality+"'where uname='"+trm.getUname()+"'");
			if(l==0)
			{
			i++;	
			}
			}
			if(!password.equals(""))
			{
		    int pa=statement.executeUpdate("update trader set password='"+password+"'where uname='"+trm.getUname()+"'");
			if(pa==0)
			{
			i++;	
			}
			}
			if(!products.equals(""))
			{
		    int pr=statement.executeUpdate("update trader set products='"+products+"'where uname='"+trm.getUname()+"'");
			if(pr==0)
			{
			i++;	
			}
			}
			if(!pno.equals(""))
			{
				long pnoi=Long.parseLong(pno);
		    int p=statement.executeUpdate("update trader set pno='"+pnoi+"'where uname='"+trm.getUname()+"'");
			if(p==0)
			{
			i++;	
			}
			}
			
			}
		   catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	else {
		
	            request.setAttribute("msg","Password and confirm password should be same");
	        	
	}
	if(i>0)
	{
		request.setAttribute("msg", "updation failed");
		
	}
	else {
		request.setAttribute("msg", "Response has been recorded and all are updated");
		
	}
	if(products.equals("")&& pno.equals("") && locality.equals("") && password.equals(""))
	{
		request.setAttribute("msg", "Enter the valid details");
	}
	
	request.getRequestDispatcher("traderupdatedetails.jsp").forward(request, response);
	
	
	}
}
