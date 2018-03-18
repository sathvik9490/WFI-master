package com.src.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.src.services.Send_sms;

/**
 * Servlet implementation class Producerresendcontroller
 */
@WebServlet("/Producerresendcontroller")
public class Producerresendcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Producerresendcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	doPost(request,response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		Send_sms s=new Send_sms();
		
		HttpSession session1=request.getSession(false);  
        int otp2=s.sms((String)session1.getAttribute("pno"));
        int otp=(int)session1.getAttribute("otp");  
         otp=otp2;
         session1.setAttribute("otp",otp);
         request.getRequestDispatcher("producersotp.jsp").forward(request, response);
	}
	 catch (NumberFormatException nfe) {     
	     nfe.printStackTrace();
	 }
		catch(NullPointerException n)
		{
			n.printStackTrace();
		}
}
}