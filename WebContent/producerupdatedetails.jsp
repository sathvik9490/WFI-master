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
  <link href="css/update.css" rel="stylesheet" type="text/css" />
  <title>Update your details</title>
</head>
<body>
<div class="row">
    <div class="col-md-3 col-xs-6">
    <img src="images/logof.PNG" style="height:150px;" alt="logo">
  </div>
  </div>
 
  <div style="margin-left:30%;width:400px;">
  <form action="Producerupdatecontroller" method="post">
  <table>
  <tr>
<td>
<p style=" font-family: 'Economica', cursive;font-size:2rem;color:blue;">
  Update your Details</p>
 </td>
 </tr>
<tr>
<td><input style="width:400px;" type="text" placeholder="Ph_No" name="pno"></td>
<tr>
<tr>
<td><input style="width:400px;"  type="text" placeholder="locality" name="locality"></td>
</tr>
<tr>
<td><input style="width:400px;"  type="text" placeholder="Products" name="products"></td>
</tr>
<tr>
<tr>
<td><input style="width:400px;"  type="password" placeholder="Password" name="password"></td>
</tr>
<tr>
<td><input style="width:400px;"  type="password" placeholder="Confirm Password" name="cpassword"></td>
</tr>
 <tr>
<td><input id="submit" style="margin-left:20%;" type="submit" value="Update"></input></td>
</tr>
 <tr>
<td>
<p style=" width:100%;font-family: 'Economica', cursive;font-size:2rem;color:black;">
  ${msg}</p>
 </td>
 </tr>
 </table>
  </form>
  </div>
</body>
</html>