package com.src.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Producerotpcontroller
 */
@WebServlet("/Producerotpcontroller")
public class Producerotpcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Producerotpcontroller() {
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
	
		HttpSession session1=request.getSession(false);  
        int otp=(int)session1.getAttribute("otp");  
          String otps=request.getParameter("otps");
     try {
          if(otp==Integer.parseInt(otps))
          {
        	  
        	  if (session1 != null) {
        	      session1.invalidate();
        	  }
        	  request.getRequestDispatcher("index.jsp").forward(request, response);
          }
          else {
        	  if (session1 != null) {
        	      session1.invalidate();
        	  }
        	  request.getRequestDispatcher("producersregistration.jsp").forward(request, response);
          }
	
	} catch (NumberFormatException nfe) {     
	     nfe.printStackTrace();
	 }
	}

}
