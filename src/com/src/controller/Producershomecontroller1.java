package com.src.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


import com.src.modal.Producersregistermodel;
import com.src.modal.Productregistermodel;
import com.src.modal.Tradersregistermodel;
/**
 * Servlet implementation class Producershomecontroller1
 */
@WebServlet("/Producershomecontroller1")
public class Producershomecontroller1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Producershomecontroller1() {
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
		
				
		ArrayList<Productregistermodel> prm=new ArrayList<>();
	

		
	  
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
				String productLocalityQuery="select * from product where locality='"+locality+"'";
				String productProductQuery="select * from locality where locality='"+locality+"' and pname='"+products+"'"; 
				ResultSet resultSet1=null;
			
				
				if(products.length()<=0) {
					
				resultSet1 = statement1.executeQuery(productLocalityQuery);
				  
				
				}
				else {

				  resultSet1 = statement1.executeQuery(productProductQuery);
				
				}
				 
			connection.commit(); 
			while(resultSet1.next()){
					
					Productregistermodel p=new Productregistermodel(resultSet1.getString("uname"),resultSet1.getString("utype"),resultSet1.getString("pname"),resultSet1.getString("quantity"),resultSet1.getString("price"),resultSet1.getString("description"),locality,resultSet1.getString("address"),resultSet1.getString("image"));
						        prm.add(p);
							
						}
                      				
					
			  }
			
			
			request.setAttribute("product",prm);
		
			
			request.getRequestDispatcher("producershome.jsp").forward(request, response); 
		}catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
	}

}

