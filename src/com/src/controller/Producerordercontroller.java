package com.src.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.src.services.Send_message;

/**
 * Servlet implementation class Producerordercontroller
 */
@WebServlet("/Producerordercontroller")
public class Producerordercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Producerordercontroller() {
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
		{
		String msg1="H.No%20345/2%20mysore%20road,kengeri,Bangalore,560059";
		String no1="9900166467";
		String no2="9900166467";
		String no3="9900166467";
		String msg2="H.No%2068/3%20srinivas%20colony,sri%20ranga%20patna,Mysore,560051";
		
         Send_message s=new Send_message();
		s.sms("Kisaan%20Bazaar-Deliver%20the%20order%20from"+msg1+"%20to%20"+msg2,no1);
		s.sms("Kisaan%20Bazaar-Your%20product%20has%20been%20ordered%20and%20will%20be%20picked%20within%2048%20Hrs.",no1);	
		s.sms("Kisaan%20Bazaar-You%20have%20ordered%20the%20product%20and%20it%20will%20be%20delivered%20within%2048%20Hrs.",no1);
		request.getRequestDispatcher("producershome.jsp").forward(request, response); 
		}
		
		
}
}