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
  <link href="css/otp.css" rel="stylesheet" type="text/css" />
  <title>OTP Verification</title>
</head>
<body>
<div class="row">
    <div class="col-md-3 col-xs-6">
    <img src="images/logof.PNG" style="height:150px;" alt="logo">
  </div>
</div>
  <div class="row">
  <div class="col-md-offset-4 col-md-3 col-xs-12">
  <p style="font-family: 'Economica', cursive;font-size:1.7rem;color:grey;margin-top:23%;">Enter the OTP that has been sent to your Registered mobile number.</p>
<form action="Producerotpcontroller" method="post">
 <input type="text" placeholder="Enter your OTP" name="otps" required>
  <input id="submit" type="submit" value="Submit"></input>
<a class="button" href="Producerresendcontroller" style="margin-left:20%;color:black">Resend</a>
</form>
</div>
</div>
</body>
</html>