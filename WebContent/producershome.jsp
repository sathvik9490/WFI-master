<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@page import="java.util.ArrayList" %>  
  <%@page import="com.src.modal.*" %>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Search Products</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link href="css/home.css" rel="stylesheet" type="text/css" />
  <link href="https://fonts.googleapis.com/css?family=Economica" rel="stylesheet">
  <link rel="stylesheet" href="css/searchbox.css">
 <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  </head>
<body>
 <form id="myform" action="Producershomecontroller1" method="POST">
<nav id="nav-bar" class="navbar navbar-default">
    <div class="container-fluid">
  <div class="navbar-form navbar-left">
        <img  src="images/logo2.png" alt="logo"/>
        <img  src="images/logo3.PNG" alt="company"/>
            <div class="input-group">
              <ul class="nav navbar-nav navbar-left">
              <li id="searchbar1"><input id="sb1" type="text" class="form-control" name="product" placeholder="Search by products"></li>
              <li id="searchbar3"><input  id="sb3" type="text"  class="form-control" name="locality" placeholder="Search by location" required></li>
              <li id="glyphicon"><div class="input-group-btn"><button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button></div></li>
            </div>
          </div>
          <div class="nav navbar-nav navbar-right">
        <li id="dropdown" class="dropdown" id="right"><a style="background-color:#228B22"class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="caret"></span></a>
        <ul style="font-size:2rem  font-family: 'Economica', sans-serif;" class="dropdown-menu">
          <li style="font-size:2rem  font-family: 'Economica', sans-serif;"><a href="producerupdatedetails.jsp">Update details</a></li>
          <li style="font-size:2rem  font-family: 'Economica', sans-serif;"><a href="producerprofilesearch.jsp">Search By profiles</a></li>
          <li style="font-size:2rem  font-family: 'Economica', sans-serif;"><a href="produceraddproduct.jsp">Add a Product</a></li>
          <li style="font-size:2rem  font-family: 'Economica', sans-serif;"><a href="Schemecontroller">Log out</a></li>
        </ul>
      </li>
    </div>
    </ul>
    </div>
  </nav>
  </form>
  
  
  
<!--style of producers copy for all templates  -->  
  <c:forEach  items="${product}" var="p">
  
   <div  class="container">
<div style="border:1.2px solid black;border-radius:10px;margin-bottom:20px;" class="row"> 
 <div  class="col-md-4" style="padding-top:10px;height:400px;">
              <img style="width:85%" src="${p.image}" alt="profile picture"/>
              
          </div>
              <div style="font-size:1.3rem;padding-top:10px;" class="col-md-6" >
                    <p><b>Owner:</b>${p.uname}</p>
                    <p><b>Type of Account:</b>${p.utype}</p>
                    <p><b>Name of Product:</b>${p.pname}</p>
                    <p><b>Quantity:</b>${p.quantity}</p>
                    <p><b>Price:</b>${p.price}(Included with shipping charges)</p>
                    <p><b>Description:</b>${p.description}</p>
                    <p><b>Locality:</b>${p.locality}</p>
                    <p><b>Address:</b>${p.address}</p>
              <a class="button" href="Producerordercontroller">Order Now</a>
              </div>
              </div>
          
</div>

  </c:forEach>
  <!-- end of products  -->
  
</body>
</html>