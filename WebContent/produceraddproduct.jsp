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
<title>Add a product</title>
</head>
<body>
<div class="row">
  <div class="col-md-3 col-xs-6">
  <img src="images/logof.PNG" style="height:150px;" alt="logo">
  </div>
<div class="col-md-offset-3 col-xs-12">
<p style="font-family: 'Economica', cursive;font-size:2rem;color:grey;">Product Information</p>
</div>
</div>
<div class="row">
  <div class="col-md-offset-3 col-md-5 col-xs-12">
<form action="Producerproductcontroller" method="post">
<table>

<tr>
<td><input type="text" placeholder="Product Name" name="pname" value="${pname}" required></td>
<td><p style="font-family: 'Economica', cursive;font-size:1.7rem;color:red;">${errors['pname']}</p></td>
</tr>

<tr>
<td><input type="text" placeholder="Quantity"  name="quantity" value="${quantity}" required></td>
<td><p style="font-family: 'Economica', cursive;font-size:1.7rem;color:red;">${errors['quantity']}</p></td>
</tr>


<tr>
<td><textarea placeholder=" Description " name="description" value="${description}"cols="30" rows="5" required></textarea></td>
<td><p style="font-family: 'Economica', cursive;font-size:1.7rem;color:red;">${errors['description']}</p></td>
</tr>


<tr>
<td><input type="number" placeholder="Price" name="price" value="${price}"  required></td>
<td><p style="font-family: 'Economica', cursive;font-size:1.7rem;color:red;">${errors['price']}</p></td>
</tr>


<tr>
<td><p style="font-family: 'Economica', cursive;font-size:2rem;color:black">Please upload the product picture</h2>
</td>
</tr>

<tr>
<td><input type = "file" name = "file" size = "50" / required></td>
</tr>

<tr>
<td><input id="submit" type="submit" value="Add Product"></td>
</tr>

</table>
</form>
</div>
</div>
</body>
</html>