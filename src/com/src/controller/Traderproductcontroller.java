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
import com.src.modal.Producersregistermodel;
import com.src.modal.Productregistermodel;
import com.src.modal.Tradersregistermodel;
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
 * Servlet implementation class Traderproductcontroller
 */
@WebServlet("/Traderproductcontroller")
public class Traderproductcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Traderproductcontroller() {
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
		 String pname = request.getParameter("pname");
	   	  String quantity = request.getParameter("quantity");
	   	 String description = request.getParameter("description");
	  	  String price = request.getParameter("price");
	  	HttpSession session1=request.getSession(false); 
	    Tradersregistermodel trm=(Tradersregistermodel)session1.getAttribute("trm");
	    HashMap<String,String> error=new HashMap<>();
	    
	   if(pname==null|pname.length()==0){
	   		
	       error.put("pname"," Product name must not be blank");
	      	
	   }
	   else{
	   	request.setAttribute("pname", pname);
	   	
	   	
	   }	
	   
	   if(quantity==null|quantity.length()==0){
	  		
	       error.put("quantity","Quantity must not be blank");
	      	
	   }

		   	else{
			   	request.setAttribute("quantity",quantity);
			   	
			  }		       
	   if(description==null|description.length()==0){
	  		
	       error.put("description"," Description must not be blank");
	      	
	   }

		   	else{
			   	request.setAttribute("description",description);
			   	
			  }		       
	   if(price==null|price.length()==0){
	  		
	       error.put("price","Price must not be blank");
	      	
	   }

		   	else{
			   	request.setAttribute("price",price);
			   	
			  }		       
	   if(error.isEmpty()){

	       
	       Productregistermodel p=new Productregistermodel();
	       p.setUname(trm.getUname());
	       p.setUtype("Trader");
	       p.setPname(pname);
	       p.setQuantity(quantity);
	       p.setPrice(price);
	       p.setDescription(description);
	       p.setLocality(trm.getLocality());
	       p.setAddress(trm.getAddress());
	       
	        try {
	    		Context context = new InitialContext();
	    		DataSource ds=(DataSource)context.lookup("java:comp/env/jdbc/test");
	    		Connection connection = ds.getConnection();
	    		PreparedStatement prepareStatement = connection.prepareStatement("insert into product values(null,?,?,?,?,?,?,?,?,'images/9.jpg')");
	    		prepareStatement.setString(1,p.getUname());
	    		prepareStatement.setString(2,p.getUtype());
	    		prepareStatement.setString(3,p.getPname());
	    		prepareStatement.setString(4,p.getQuantity());
	    		prepareStatement.setString(5,p.getPrice());
	    		prepareStatement.setString(6,p.getDescription());
	    		prepareStatement.setString(7,p.getLocality());
	    		prepareStatement.setString(8,p.getAddress());
	    		
	    	   int result =prepareStatement.executeUpdate();
	    	   	
	       		if(result>0){

	       			request.getRequestDispatcher("traderaddproduct.jsp").forward(request, response);
	       			
	       		}
	       		else{
	       			
	       			request.setAttribute("error", "Product could not be Registered");
	       			request.getRequestDispatcher("traderaddproduct.jsp").forward(request, response);
	       			
	       		}
	           
	           } 
	         catch (NamingException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		} catch (SQLException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    			request.setAttribute("error", "registration failed");
	    	   		request.getRequestDispatcher("traderaddproduct.jsp").forward(request, response);
	    		}
	   }
		
	 else{
	   		request.setAttribute("errors", error);
	   		request.getRequestDispatcher("traderaddproduct.jsp").forward(request, response);
	   }
		}
	}
	       
	  

		