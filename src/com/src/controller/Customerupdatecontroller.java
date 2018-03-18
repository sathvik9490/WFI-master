package com.src.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

import com.src.modal.Customersregistermodel;
import com.src.modal.Producersregistermodel;
/**
 * Servlet implementation class Customerupdatecontroller
 */
@WebServlet("/Customerupdatecontroller")
public class Customerupdatecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Customerupdatecontroller() {
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
	   	 String password = request.getParameter("password");
	  	  String cpassword = request.getParameter("cpassword");
	       int i=0;
	      if(password==cpassword)
		{
			try {
			Context context = new InitialContext();
			DataSource ds=(DataSource)context.lookup("java:comp/env/jdbc/test");
			Connection connection = ds.getConnection();
			Statement statement = connection.createStatement();
			HttpSession session1=request.getSession(false); 
		    Customersregistermodel crm=(Customersregistermodel)session1.getAttribute("crm");
			
			if(!password.equals(""))
			{
		    int pa=statement.executeUpdate("update customer set password='"+password+"'where uname='"+crm.getUname()+"'");
			if(pa==0)
			{
			i++;	
			}
			}
			if(!pno.equals(""))
			{
				long pnoi=Long.parseLong(pno);
		    int p=statement.executeUpdate("update customer set pno='"+pnoi+"'where uname='"+crm.getUname()+"'");
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
	if(pno.equals("") && password.equals(""))
	{
		request.setAttribute("msg", "Enter the valid details");
	}
	
	request.getRequestDispatcher("customerupdatedetails.jsp").forward(request, response);
	
	
	}
}
