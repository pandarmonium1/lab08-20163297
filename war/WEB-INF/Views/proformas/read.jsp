<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="controller.*" %>
<%@ page import = "model.entity.*"  %>
<%@ page import = "java.util.Date"  %>
<%@ page import = "java.text.SimpleDateFormat"  %>
<% 
	Proforma proforma = (Proforma) request.getAttribute("proformas");
	SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");	
	String fecha = formato.format(proforma.getDate());

%>


<!DOCTYPE html>
<html>
<title>Ver proforma</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body,h1,h2,h3,h4,h5,h6,p,td {color:gray; font-family: "Lato", sans-serif}
.w3-bar,h1,button,td {font-family: "Montserrat", sans-serif}
.fa-anchor,.fa-coffee {font-size:200px}
</style>
<body>
	<!-- Navbar -->
<div class="w3-top">
  <div class="w3-bar w3-blue w3-card w3-left-align w3-large">
    <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-red" href="javascript:void(0);" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
    <a href="/index.html" class="w3-bar-item w3-button w3-padding-large w3-white">Home</a>
    <a href="/roles" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Roles</a>
    <a href="/users" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Users</a>
    <a href="/resources" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Resources</a>
    <a href="/access" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Access</a>
    <a href="/proformas" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Proformas</a>
   <a href="/users/login" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Sign In</a>
    <a href="/users/logout" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Sign Out</a>
  </div>

  <!-- Navbar on small screens -->
  <div id="navDemo" class="w3-bar-block w3-white w3-hide w3-hide-large w3-hide-medium w3-large">
    <a href="/roles" class="w3-bar-item w3-button w3-padding-large">Roles</a>
    <a href="/users" class="w3-bar-item w3-button w3-padding-large">Users</a>
    <a href="/resources" class="w3-bar-item w3-button w3-padding-large">Resources</a>
    <a href="/access" class="w3-bar-item w3-button w3-padding-large">Access</a>
    <a href="/proformas" class="w3-bar-item w3-button w3-padding-large">Proformas</a>
    <a href="/users/login" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Sign In</a>
    <a href="/users/logout" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white">Sign Out</a>
  </div>
</div>

<header class="w3-container w3-white w3-center" style="padding:80px 16px">
	<div class="table">
	<h3>Proforma con ID:  <%= proforma.getId() %></h3>
		<table class="vertical-table">
		<tbody>	
				<tr>
					<th scope="row">Nombre: </th>
					<td><%= proforma.getName() %></td>
				</tr>
				<tr>
					<th scope="row">Dirección: </th>
					<td><%= proforma.getDireccion() %></td>
				</tr>
					<tr>
					<th scope="row">Teléfono:</th>
					<td><%= proforma.getTelefono() %></td>
					</tr>
				<tr>
								<th scope="row">Fecha de creación:</th>
								<td><%= fecha %></td>
							</tr>
							<tr>
								<th scope="row">Objeto a comprar: </th>
								<td>Mesa para Comedor</td>
							</tr>
							<tr>
								<th scope="row">Precio por unidad: </th>
								<td>S/. 15.00 </td>
							</tr>
							<tr>
								<th scope="row">Cantidad de Objetos: </th>
								<td><%= proforma.getCant() %></td>
							</tr>
							<tr>
								<th scope="row">Total a pagar: </th>
								<td><%= proforma.gettPrecio() %></td>
							</tr>
						</tbody>
					</table>
					<a href="../proformas/view" class="btn btn-info"  role="button"  >Retornar a la lista de proformas</a>
				</div>
	
  
</header>
<!-- Footer -->
<footer class="w3-container w3-padding-64 w3-center w3-opacity w3-white">  
 
 <p>Powered by Salo and w33</p>
</footer>

<script>
// Used to toggle the menu on small screens when clicking on the menu button
function myFunction() {
    var x = document.getElementById("navDemo");
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
    } else { 
        x.className = x.className.replace(" w3-show", "");
    }
}
</script>
</body>
</html>