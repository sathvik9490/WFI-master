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
  <link href="css/login.css" rel="stylesheet" type="text/css" />
 <title>Login</title>
</head>
<body>
<div class="row">
    <div class="col-md-3 col-xs-6">
    <img src="images/logof.PNG" style="height:150px;" alt="logo">
    </div>
  <div class="col-md-offset-3 col-xs-12">
  <p style="font-family: 'Economica', cursive;font-size:3rem;color:grey;margin-left:15%">LOGIN</h1>
  </div>
  </div>
  <div class="row">
<form action="Logincontroller" method="post">
    <div class="col-md-offset-4 col-md-3 col-xs-12">
  <table>
  
  <tr>
  <td><input type="text" placeholder="User Name" name="uname" required><td>
  <td><p style="font-family: 'Economica', cursive;font-size:1.7rem;color:red;margin-top:6%;">${error}</p></td>
  </tr>

<tr>
<td><input type="password" placeholder="Password" name="password" required></td>
 </tr>
 
 <tr>
  <td><input id="submit" type="submit" value="LOGIN"></td>
   </tr>
    </table>
  </form>
</div>
</div>
</body>
</html>