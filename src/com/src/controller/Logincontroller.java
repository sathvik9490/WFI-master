package com.src.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.src.modal.LoginModel;
import com.src.modal.*;


@WebServlet("/Logincontroller")

public class Logincontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logincontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String uname=request.getParameter("uname");
		String password=request.getParameter("password");
		LoginModel lm=new LoginModel();
		lm.setUname(uname);
		lm.setPassword(password);
		int i=4;
		 HttpSession session1 = request.getSession(true);
		try {
			Context context = new InitialContext();
			DataSource ds=(DataSource)context.lookup("java:comp/env/jdbc/test");
			Connection connection = ds.getConnection();
			Statement statement = connection.createStatement();
			ResultSet rs1=statement.executeQuery("select * from producer where uname='"+lm.getUname()+"' and password='"+lm.getPassword()+"'");
	        boolean result1=rs1.next();
		    if(result1){
			Producersregistermodel prm=new Producersregistermodel();
				prm.setAddress(rs1.getString("address"));
		        prm.setLocality(rs1.getString("locality"));
		        prm.setName(rs1.getString("name"));
		        prm.setOccupation(rs1.getString("occupation"));
		        prm.setPassword(rs1.getString("password"));
		        prm.setPno(Long.toString(rs1.getLong("pno")));
		        prm.setProducts(rs1.getString("products"));
		        prm.setUname(rs1.getString("uname"));
       		    session1.setAttribute("prm",prm);
       			request.getRequestDispatcher("producershome.jsp").forward(request, response);
			}
			else{
				i=i-1;			
							}
			ResultSet rs2=statement.executeQuery("select * from trader where uname='"+lm.getUname()+"' and password='"+lm.getPassword()+"'");
	        boolean result2=rs2.next();
			if(result2){
			Tradersregistermodel trm=new Tradersregistermodel();
				trm.setAddress(rs2.getString("address"));
		        trm.setLocality(rs2.getString("locality"));
		        trm.setName(rs2.getString("name"));
		        trm.setOccupation(rs2.getString("occupation"));
		        trm.setPassword(rs2.getString("password"));
		        trm.setPno(Long.toString(rs2.getLong("pno")));
		        trm.setProducts(rs2.getString("products"));
		        trm.setUname(rs2.getString("uname"));
       			
       			session1.setAttribute("trm",trm);
       			request.getRequestDispatcher("tradershome.jsp").forward(request, response);
			}
			else{
				i=i-1;			
							}
			ResultSet rs3=statement.executeQuery("select * from customer where uname='"+lm.getUname()+"' and password='"+lm.getPassword()+"'");
	        boolean result3=rs3.next();
			if(result3){
			Customersregistermodel crm=new Customersregistermodel();
				crm.setName(rs3.getString("name"));
		        crm.setPassword(rs3.getString("password"));
		        crm.setPno(Long.toString(rs3.getLong("pno")));
		        crm.setUname(rs3.getString("uname"));
		       
		        session1.setAttribute("crm",crm);
       			request.getRequestDispatcher("customershome.jsp").forward(request, response);
			}
			else{
				i=i-1;			
							}
		    ResultSet rs6=statement.executeQuery("select * from admin where uname='"+lm.getUname()+"' and password='"+lm.getPassword()+"'");
	        boolean result6=rs6.next();
			if(result6){
			Adminloginmodel arm=new Adminloginmodel();
				arm.setUname(rs6.getString("uname"));
		        arm.setPassword(rs6.getString("password"));
		     
       		session1.setAttribute("arm",arm);
       			request.getRequestDispatcher("Complaintdispalyer").forward(request, response);
			}
			else{
	               i=i-1;			
							}
			
			if(i==0)
            {
            	
            	request.setAttribute("error", "Enter the valid username and password");
    	   		request.getRequestDispatcher("login.jsp").forward(request, response);
            	
            }	
		
			
			
			connection.close();			
		}
			

			 catch (NamingException e) {
				// TODO Auto-generated catch block
			System.out.println("naming ex");
				 e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
