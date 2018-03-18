package com.src.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.src.modal.Customersregistermodel;
import com.src.modal.Producersregistermodel;
import com.src.services.Send_sms;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * Servlet implementation class Customerregistercontroller
 */
@WebServlet("/Customerregistercontroller")
public class Customerregistercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Customerregistercontroller() {
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
		 String name = request.getParameter("name");
	   	  String uname = request.getParameter("uname");
	   	 String pno = request.getParameter("pno");
	   	String address = request.getParameter("address");
	   	 String password=request.getParameter("password");
		String cpassword=request.getParameter("cpassword");
		ArrayList<String> products2=null;
		ServletContext scontext = getServletContext();
	   	List<String> namesList= (List<String>)scontext.getAttribute("namesList");
	   	List<String> localityList= (List<String>)scontext.getAttribute("localityList");
	   	List<String> productList= (List<String>)scontext.getAttribute("productList");
	   	long pnoi=0;
	    HashMap<String,String> error=new HashMap<>();
	    
	   if(name==null|name.length()==0){
	   		
	       error.put("name","name must Not be blank");
	      	
	   }
	   else{
	   	request.setAttribute("name", name);
	   	
	   	
	   }	
	   
	   if(address==null|address.length()==0){
			
	       error.put("address","address must not be blank");
	       
	   	
	   }
	       	
	   else{
	   	
	   	request.setAttribute("address", address);
	   	
	   }	
	   try{
	   if(uname==null|uname.length()==0){
	  		
	       error.put("uname"," user name must not be blank");
	      	
	   }
	    
		  else if(namesList.contains(uname)){
		   	
		   	error.put("uname","username already taken");
		  }
		   	else{
			   	request.setAttribute("uname", uname);
			   	
			  }		       
		   	
		   
		}
	   catch(NullPointerException e ){
		      e.printStackTrace();
		      }
	   
	   if(password==null|password.length()<=5){
			
	       error.put("password","invalid password");
	       
	   	
	   }
	   else if(!password.equals(cpassword)){

	       error.put("password","password must be same as confirm password");
	       
	   }
	   else{
	   	
		   request.setAttribute("password", password);
	   	
	   }	
	   
	 if(pno==null|pno.length()!=10){
			
	       error.put("pno","Enter a valid Phone Number");
	       
	   	
	   }	
	   	  else{
	   	try{
	   	pnoi=Long.parseLong(pno);
	   request.setAttribute("pno", pnoi);
	   				
	   	}catch(NumberFormatException nfe){
	   		

	           error.put("pno","Phone Number contains only numbers");
	           
	   	}
	   }	
	 	
	   
	   if(error.isEmpty()){

	       
	       Customersregistermodel crm=new Customersregistermodel();
	        
	       crm.setAddress(address);
	        
	        crm.setName(name);
	        crm.setPassword(password);
	        crm.setPno(pno);
		    crm.setUname(uname);
	       
	       
	        namesList.add(uname);
	        scontext.setAttribute("namesList", namesList);
	       
	        try {
	    		Context context = new InitialContext();
	    		DataSource ds=(DataSource)context.lookup("java:comp/env/jdbc/test");
	    		Connection connection = ds.getConnection();
	    		PreparedStatement prepareStatement = connection.prepareStatement("insert into customer values(null,?,?,?,?,?)");
	    		prepareStatement.setString(1, crm.getName());
	    		prepareStatement.setString(2, crm.getUname());
	    		prepareStatement.setLong(3,pnoi);
	    	    prepareStatement.setString(4,crm.getPassword());
	    	    prepareStatement.setString(5,crm.getAddress());
	    	   int result =prepareStatement.executeUpdate();
	    	   	
	       		if(result>0){
	       			Send_sms s=new Send_sms();
	       			int otp=s.sms(pno);
	       			HttpSession session1 = request.getSession(true);
	       			session1.setAttribute("uname",uname);
	       			session1.setAttribute("otp",otp);
	       			session1.setAttribute(pno,pno);
	       			request.setAttribute("register", crm);
	       			request.getRequestDispatcher("producersotp.jsp").forward(request, response);
	       			
	       		}
	       		else{
	       			
	       			request.setAttribute("error", "registration failed");
	       			request.getRequestDispatcher("customersregistration.jsp").forward(request, response);
	       			
	       		}
	           
	           } 
	         catch (NamingException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		} catch (SQLException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    			request.setAttribute("error", "registration failed");
	    	   		request.getRequestDispatcher("customersregistration.jsp").forward(request, response);
	    		}
	   }
		
	 else{
	   		request.setAttribute("errors", error);
	   		request.getRequestDispatcher("customersregistration.jsp").forward(request, response);
	   }
		}
	
	       
	  
	}


