<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://fonts.googleapis.com/css?family=Economica" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="css/producerregistration.css" rel="stylesheet" type="text/css" />
  <title>Traders Registration</title>
</head>
<body>
<div class="row">
  <div class="col-md-3 col-xs-6">
  <img src="images/logof.PNG" style="height:150px;" alt="logo">
  </div>
<div class="col-md-offset-3 col-xs-12">
<p style="font-family: 'Modak', cursive;font-size:2rem;color:grey;">REGISTRATION IN TRADERS COMMUNITY</p>
</div>
</div>
<div class="row">
  <div class="col-md-offset-3 col-md-5 col-xs-12">
<form action="Traderregistercontroller" method="post">
<table>

<tr>
<td><input type="text" placeholder="Name" name="name" value="${name}" required></td>
<td><p style="font-family: 'Economica', cursive;font-size:1.7rem;color:red;">${errors['name']}</p></td>
</tr>

<tr>
<td><input type="text" placeholder="User Name"  name="uname" value="${uname}" required></td>
<td><p style="font-family: 'Economica', cursive;font-size:1.7rem;color:red;">${errors['uname']}</p></td>
</tr>

<tr>
<td><input type="text" placeholder="Ph_No" name="pno" value="${pno}"  required></td>
<td><p style="font-family: 'Economica', cursive;font-size:1.7rem;color:red;">${errors['pno']}</p></td>
</tr>

<tr>
<td><input type="text" placeholder="Locality" name="locality" value="${locality}"  required></td>
<td><p style="font-family: 'Economica', cursive;font-size:1.7rem;color:red;">${errors['locality']}</p></td>
</tr>

<tr>
<td><textarea placeholder=" Enter your postal address with pin code" name="address" value="${address}"cols="30" rows="5"></textarea></td>
<td><p style="font-family: 'Economica', cursive;font-size:1.7rem;color:red;">${errors['address']}</p></td>
</tr>

<tr>
<td><input type="text" placeholder="Occupation" name="occupation" required value="${occupation}" ></td>
<td><p style="font-family: 'Economica', cursive;font-size:1.7rem;color:red;">${errors['occupation']}</p></td>
</tr>

<tr>
<td><input type="text" placeholder="Products" name="products" value="${products}" required></td>
<td><p style="font-family: 'Economica', cursive;font-size:1.7rem;color:red;">${errors['products']}</p></td>
</tr>

<tr>
<td><input type="Password" placeholder="Password" name="password" required></td>
<td><p style="font-family: 'Economica', cursive;font-size:1.7rem;color:red;">${errors['password']}</p></td>
</tr>

<tr>
<td><input type="Password" placeholder="Confirm Password" name="cpassword" required></td>
</tr>

<tr>
<td><p style="font-family: 'Economica', cursive;font-size:2rem;color:black">Please upload your picture</h2>
</td>
</tr>

<tr>
<td><input type = "file" name = "file" size = "50" / required></td>
</tr>

<tr>
<td><input id="submit" type="submit" value="Register"></td>
</tr>

<tr>
<td>
<p style=" width:100%;font-family: 'Economica', cursive;font-size:1.7rem;color:grey;">
  <b>Note:</b>
  The mobile number given above receives an OTP during registration.Give the valid mobile number and Enter all the products you are dealing.Remember the user name and password.</p>
 </td>
 </tr>

</table>
</form>
</div>
</div>
</body>
</html>
