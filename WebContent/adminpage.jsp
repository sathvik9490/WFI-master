<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page import="java.util.ArrayList" %>  
  <%@page import="com.src.modal.*" %>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <link href="https://fonts.googleapis.com/css?family=Economica" rel="stylesheet">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link href="css/admin.css" rel="stylesheet" type="text/css" />
  <title>Admin Access</title>
</head>
<body>
<div class="row">
    <div class="col-md-3 col-xs-6">
    <img src="images/logof.PNG" style="height:150px;" alt="logo">
    </div>
  </div>
  <div class="row">
    <div class="col-md-offset-3 col-md-5 col-xs-6">
  <p style="font-family:'Economica',cursive;font-size:3rem;color:grey;">Enter the Govt Schemes in the form</p>
  <form action="Admincontroller" method="post">
  <table>
  <tr>
  <td><textarea placeholder="Scheme Description" name="scheme" cols="30" rows="5" required></textarea></td>
  </tr>
  <tr>
  <td><p style="font-family: 'Modak', cursive;font-size:1.2rem;color:black;">Please upload the picture of the scheme</p></td>
  </tr>
  <tr>
  <td><input type = "file" name = "file" size = "50" / required></td>
  </tr>
  <tr>
  <td><input value="submit" type="submit" id="submit"></td>
  </tr>
    <tr>
<td><p style="font-family:'Economica', cursive;font-size:2rem;color:blue;margin-left:4%">${schememsg}</p></td>
</tr>
</table>
</form>
</div>
</div>
<div class="row">
<form action="Profiledeletecontroller" method="post">
  <div class="col-md-offset-3 col-md-3 col-xs-12">
<input type="text" name="uname" placeholder="User_Name" name="uname" required>
</div>
<div class="col-md-3 col-xs-12">
  <input type="submit" value="Delete" id="submit1">
  <br>
</div>
</form>
</div>
<div class="row">
<div class="col-md-3 col-xs-12">
 <p style="font-family:'Economica', cursive;float:left;font-size:2rem;color:blue;">${deletemsg}</p>
</div>
</div>
<a href="Complaintdispalyer"><p style="font-family:'Economica', cursive;font-size:3rem;color:black;margin-left:3%"><b>Complaints</b></p></a>
<c:forEach items="${complaints}" var="pt">
<div class="row">
  <div class="col-md-12 col-xs-12">
  <p style="font-family:'Economica', cursive;font-size:2rem;color:black;margin-left:4%">${pt.complaint}</p>
<br>
</c:forEach>  
</div>
</div>
</body>
</html>