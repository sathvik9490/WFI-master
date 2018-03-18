package com.src.services;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class Send_message {

	public void sms(String msg,String number){

		
	     String username = "navashfsahkfh";

		            String password = "ndsfbjs";
		            //Multiple mobiles numbers separated by comma
		            String sendto = number;
		            //Sender ID,While using route4 sender id should be 6 characters long.
		            String sender ="ROTRCT";
		            //Your message to send, Add URL encoding here.
		            String message = msg;
		            //define route
		            String route="default";

		            //Prepare Url
		            URLConnection myURLConnection=null;
		            URL myURL=null;
		            BufferedReader reader=null;

		            //encoding message
		            String encoded_message=URLEncoder.encode(message);

		            //Send SMS API
		            String mainUrl="http://103.16.142.193/api.php?";

		            //Prepare parameter string
		            StringBuilder sbPostData= new StringBuilder(mainUrl);
		            sbPostData.append("username="+username);
		             sbPostData.append("&password="+password);
		            sbPostData.append("&sendto="+sendto);
		            sbPostData.append("&message="+encoded_message);
		            sbPostData.append("&route="+route);
		            sbPostData.append("&sender="+sender);

		            //final string
		            mainUrl = sbPostData.toString();
		            try
		            {
		                //prepare connection
		                myURL = new URL(mainUrl);
		                myURLConnection = myURL.openConnection();
		                myURLConnection.connect();
		                reader= new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
		                //reading response
		                String response;
		                while ((response = reader.readLine()) != null)
		                //print response
		                //System.out.println(response);

		                //finally close connection
		                reader.close();
		            }
		            catch (IOException e)
		            {
		                    e.printStackTrace();
		            }
      
	}


}
