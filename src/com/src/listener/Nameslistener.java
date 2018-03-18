package com.src.listener;
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
import java.util.*;

/**
 * Application Lifecycle Listener implementation class Nameslistener
 *
 */
@WebListener
public class Nameslistener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public Nameslistener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	try {
    		Context context = new InitialContext();
    		DataSource ds=(DataSource)context.lookup("java:comp/env/jdbc/test");
    		Connection connection = ds.getConnection();
    		Statement statement = connection.createStatement();
    	
    		ResultSet resultSet1 = statement.executeQuery("select uname from producer");
    		List<String> data1=new ArrayList<>();
    		while(resultSet1.next()){
    			data1.add(resultSet1.getString(1));
    		}
    		List<String> produceruname=data1;
    		
    		
    		ResultSet resultSet2 = statement.executeQuery("select uname from trader");
    		List<String> data2=new ArrayList<>();
    		while(resultSet2.next()){
    			data2.add(resultSet2.getString(1));
    		}
    		List<String> traderuname=data2;
    		
    		ResultSet resultSet3 = statement.executeQuery("select uname from nprofits");
    		List<String> data3=new ArrayList<>();
    		while(resultSet3.next()){
    			data3.add(resultSet3.getString(1));
    		}
    		List<String> nprofitsuname=data3;
    		
    		ResultSet resultSet4 = statement.executeQuery("select uname from fsuppliers");
    		List<String> data4=new ArrayList<>();
    		while(resultSet4.next()){
    			data4.add(resultSet4.getString(1));
    		}
    		List<String> fsuppliersuname=data4;
    		
    		ResultSet resultSet5 = statement.executeQuery("select uname from customer");
    		List<String> data5=new ArrayList<>();
    		while(resultSet5.next()){
    			data5.add(resultSet5.getString(1));
    		}
    		List<String> customeruname=data5;
    	
    		List<String> namesList = new ArrayList<String>();
    		namesList.addAll(customeruname);
    		namesList.addAll(fsuppliersuname);
    		namesList.addAll(nprofitsuname);
    		namesList.addAll(traderuname);
    		namesList.addAll(produceruname);


    		ResultSet result1 = statement.executeQuery("select locality from producer");
    		List<String> d1=new ArrayList<>();
    		while(result1.next()){
    			d1.add(result1.getString(1));
    		}
    		List<String> producerlocality=d1;
    		
    		ResultSet result2 = statement.executeQuery("select locality from trader");
    		List<String> d2=new ArrayList<>();
    		while(result2.next()){
    			d2.add(result2.getString(1));
    		}
    		List<String> traderlocality=d2;
    		
    		ResultSet result3 = statement.executeQuery("select locality from nprofits");
    		List<String> d3=new ArrayList<>();
    		while(result3.next()){
    			d3.add(result3.getString(1));
    		}
    		List<String> nprofitslocality=d3;
    		
    		ResultSet result4 = statement.executeQuery("select locality from fsuppliers");
    		List<String> d4=new ArrayList<>();
    		while(result4.next()){
    			d4.add(result4.getString(1));
    		}
    		List<String> fsupplierslocality=d4;
    		
    	    List<String> localityList = new ArrayList<String>();
    	    localityList.addAll(fsupplierslocality);
    		localityList.addAll(nprofitslocality);
    		localityList.addAll(traderlocality);
    		localityList.addAll(producerlocality);
    		ResultSet r1 = statement.executeQuery("select products from producer");
    		List<String> c1=new ArrayList<>();
    		while(r1.next()){
    			c1=new ArrayList<String>(Arrays.asList(r1.getString(1).split(",")));
    		}
    		List<String> producerproducts=c1;
    		
    		ResultSet r2 = statement.executeQuery("select products from trader");
    		List<String> c2=new ArrayList<>();
    		while(r2.next()){
    			c2=new ArrayList<String>(Arrays.asList(r2.getString(1).split(",")));
    		}
    		List<String> traderproducts=c2;
    		
    	    List<String> productList = new ArrayList<String>();
    	    productList.addAll(producerproducts);
    		productList.addAll(traderproducts);
    		ServletContext scontext = arg0.getServletContext();
    		scontext.setAttribute("namesList",namesList);
    		scontext.setAttribute("localityList",localityList);
    		scontext.setAttribute("productList",productList);
    		
    		} catch (NamingException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    }
}

	

