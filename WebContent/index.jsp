<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.util.ArrayList" %>  
  <%@page import="com.src.modal.*" %>
 <%@page import="com.src.modal.*" %>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>kissan bazzar</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="css/index-js-image-slider.css" rel="stylesheet" type="text/css" />
<link href="css/index-navbar.css" rel="stylesheet" type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Economica" rel="stylesheet">
<script src="js/index-js-image-slider.js" type="text/javascript"></script>
<script>$(document).ready(function(){
	$('a[href^="#"]').on('click',function (e) {
	    e.preventDefault();

	    var target = this.hash;
	    var $target = $(target);

	    $('html, body').stop().animate({
	        'scrollTop': $target.offset().top
	    }, 1500, 'swing', function () {
	        window.location.hash = target;
	    });
	});
});</script>
</head>
<body>
<nav id="nav-bar" class="navbar navbar-default">
      <div class="container-fluid">
        <ul class="nav navbar-nav navbar-left">
          <li><a href="#Reg-text">Home</a></li>
          <li><a href="#aboutus">About Us</a></li>
          <li><a href="#scroll1">Schemes</a></li>
          <li><a href="#contactus">Contact Us</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
          <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        </ul>
      </div>
    </nav>
    <div class="row" id="logo">
  <div class="col-md-3 col-xs-12">
      <img src="images/logof.PNG" style="margin-left:14%;" alt="logo">
   </div>
      <div class="col-md-4 col-xs-12">
    <div id="sliderFrame">
        <div id="slider">
            <img src="images/image-slider-2.jpg" />
            <img src="images/image-slider-1.jpg" />
            <img src="images/image-slider-7.jpg" />
            <img src="images/image-slider-8.jpg" />
            <img src="images/image-slider-14.jpg"/>
            <img src="images/image-slider-15.jpg"/>
        </div>
      </div>
    </div>
  </div>
        <div id="Reg-text"><p>Register here</p> </div>
        <div class="row">
    <div id="Registrations">
    <div class="col-md-4 col-xs-12" ><a class="button" href="producersregistration.jsp">Producers</a></div>
    <div class="col-md-4 col-xs-12"><a class="button" href="tradersregistration.jsp">Traders</a></div>
    <div class="col-md-4 col-xs-12" ><a class="button" href="customersregistration.jsp">Customers</a></div>
    </div>
  </div>
<div id="aboutus">
  <h5>About us</h5>
  <h4>Motto</h4>
<p>This project is intended to establish the connection between the communities involved in the food processing and the food community.
  There by reducing the food wastage by making the various communities and feeding the people who are in need.Register and find out who else is in your location.</p>
</div>

<h4>Producers</h4>
<div class="row">
  <div class="col-md-6 col-xs-12">
<img id="producersimg" src="images/image-1.jpg"/> </div>
<div  id="producersp" class="col-md-6 col-xs-12" class="container text-justify">
 <p>Register in the producer community where farmers,fishermen,sericulture workers and many more are present and get benefits in relationship with the different communities in the food processing sector in your region.</p></div>
</div>


<h4>Traders</h4>
<div class="row">
  <div class="col-md-6 col-xs-12">   <img id="tradersimg" src="images/image-7.jpg" /></div>
    <div id="tradersp" class="col-md-6 col-xs-12" class="container text-justify"> <p>Register in the Traders community where Retailers,WholeSalers,Manufacturers and many more are present and get benefits in relationship with the different communities in the food processing sector in your region.</p></div>
</div>


<h4>Customers</h4>
<div class="row">
  <div  class="col-md-6 col-xs-12">  <img id="customersimg" src="images/image-3.jpg" /></div>

  <div id="customersp" class="col-md-6 col-xs-12" class="container text-justify">  <p>Register in the customers community where prospective customers are present and present and get benefits in relationship with the different communities in the food processing sector in your region.</p></div>
</div>
    <a href="Schemecontroller"><h4>Govt Schemes in food processing</h4></a>
    <div  class="row" id="scroll1">
    <c:forEach items="${schemes}" var="s">
      <div class="col-md-6 col-xs-12"> <img id="schemesimg" style="width:45%" src="${s.image}" /></div> 
        <div class="container text-justify" id="schemesp" class="col-md-6 col-xs-12">
           <p></p>${s.scheme}</div>
  </div>
  <br>
 </c:forEach>  
  <div id="contactus">
  <div class="container-fluid">
					<div class="row">
				<div class="container text-justify">
          <div class="col-xs-12 col-md-8 col-lg-8">
            <h4  style="font-size:6rem">Contact Us</h4>
						<h4 style="font-size:4rem">LIVE SUPPORT</h2>
						<h4 style="font-size:3rem">24 hours | 7 days a week | 365 days a year Live Technical Support</h4>
						<p style="font-size:3rem">We can help you out in any problems related to OTP and change in the phone number and the spam users.The spam users will be blocked if we receive the message about them for uploading fake goods.Feel free to share the information about the username of them so we can take action on them.Our company is striving it's best to have the best customer care with the customers.We will be there 24*7 for your support.</p>
					</div>
					<div class="col-xs-12 col-md-2 col-lg-2">
						<center><img src="https://openclipart.org/download/249826/first_responder_04_operator.svg" height="400" width="400" alt="Contact Us"/></center>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="container">
					<div class="col-xs-12 col-md-8 col-lg-8" style="margin-bottom:10px;">
						<h2>CONTACT US</h2>
						<form role="form" action="Complaintcontroller" method="POST">

							<div class="form-group">
								<label  style="font-size:2rem">Message:</label>
								<textarea class="form-control" rows="5" name="message" required = "true"></textarea>
							</div>
						  <button   style="font-size:2.5rem" type="submit" name="submit" class="btn btn-primary">Submit</button>
						<p style="font-size:2rem;color:blue;font-family:'Economica',cursive">${msg}</p>
						</form>
					</div>
					<div  style="font-size:2rem" class="col-xs-12 col-md-4 col-lg-4">
						<h2>Company Information :</h2>
            <p>Kissan Bazaar,Taj Mansingh Hotel Rd</p>
						<p>South Block,New Delhi, Delhi 110001</p>
						<p>Phone:(91+)100-15600</p>
						<p>Fax: (487) 123 47 690</p>
						<p>Email: info@kissanbazaar.com</p>
						<p>Follow us on: Facebook, Twitter<p>
 					</div>
				</div>
			</div>
		</div>
</div>
</body>
</html>