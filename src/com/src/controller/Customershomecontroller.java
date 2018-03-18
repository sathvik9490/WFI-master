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
import java.util.Arrays;

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

import com.src.modal.Complaintregistermodel;

import com.src.modal.Producersregistermodel;
import com.src.modal.Tradersregistermodel;

@WebServlet("/Customershomecontroller")
public class Customershomecontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Customershomecontroller() {
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
		String products=request.getParameter("product");
		String name=request.getParameter("uname");
		String locality=request.getParameter("locality");
		
				
		ArrayList<Producersregistermodel> prm=new ArrayList<>();
		ArrayList<Tradersregistermodel> trm=new ArrayList<>();
				
	  
		try {
			Context context = new InitialContext();
			DataSource ds=(DataSource)context.lookup("java:comp/env/jdbc/test");
			Connection connection = ds.getConnection();
			connection.setAutoCommit(false);
			Statement statement1 = connection.createStatement();
			Statement statement2 = connection.createStatement();
			Statement statement3 = connection.createStatement();
			Statement statement4 = connection.createStatement();

			if(!locality.equals(""))
			{		
				String producerLocalityQuery="select * from producer where locality='"+locality+"'";
				String producerProductQuery="select * from producer where locality='"+locality+"' and products='"+products+"'"; 
				String traderLocalityQuery="select * from trader where locality='"+locality+"'";
				String traderProducQuery="select * from trader where locality='"+locality+"' and products='"+products+"'";
				ResultSet resultSet1=null;
				ResultSet resultSet2=null;
				
				if(products.length()<=0) {
					
				resultSet1 = statement1.executeQuery(producerLocalityQuery);
				  resultSet2 = statement2.executeQuery(traderLocalityQuery);;
				
				}
				else {

				  resultSet1 = statement1.executeQuery(producerProductQuery);
				  resultSet2 = statement2.executeQuery(traderProducQuery);
				
				}
				 
				 ResultSet resultSet3 = statement3.executeQuery("select * from nprofits where locality='"+locality+"'");	
				ResultSet resultSet4 = statement4.executeQuery("select * from fsuppliers where locality='"+locality+"'");
				connection.commit(); 
			while(resultSet1.next()){
					
					Producersregistermodel p=new Producersregistermodel(resultSet1.getString("name"),resultSet1.getString("uname"),Long.toString(resultSet1.getLong("pno")),locality,resultSet1.getString("address"),resultSet1.getString("occupation"),resultSet1.getString("products"),resultSet1.getString("password"),resultSet1.getString("image"));
						        prm.add(p);
							
						}
                      
										
					while(resultSet2.next()){
						
						Tradersregistermodel t=new Tradersregistermodel(resultSet2.getString("name"),resultSet2.getString("uname"),Long.toString(resultSet2.getLong("pno")),locality,resultSet2.getString("address"),resultSet2.getString("occupation"),resultSet2.getString("products"),resultSet2.getString("password"),resultSet2.getString("image"));
						        trm.add(t);
							
						}
					

			}
					
			

			request.setAttribute("producer",prm);
			request.setAttribute("trm",trm);

			request.getRequestDispatcher("customerprofilesearch.jsp").forward(request, response); 
		}catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
	}

}