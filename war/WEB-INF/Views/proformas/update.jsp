<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="controller.proform.*" %>

<%@ page import="model.entity.*" %>
<%@ page import="java.util.List" %>
<% Proforma r = (Proforma)request.getAttribute("proformas");%>
<%//Aca mandariamos junto con los datos al servlet %>
<!DOCTYPE html>
<html>
<title>Editar proforma</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
 function checkSubmit() {
	    document.getElementById("btsubmit").value = "Enviando...";
	    document.getElementById("btsubmit").disabled = true;
	    return true;
	}
 </script> 
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

<header class="w3-container w3-white" style="padding:80px 16px">
	<form method="post" action="/proformas/update?proformaId=<%=r.getId() %>"  onsubmit="return checkSubmit();">
	
		<input type="hidden" name="action" value="editarProforma"  />
		<table border="0" cellspacing="1" cellpadding="5" bgcolor="#CCCCCC">
			<p>No se aceptan caracteres que no sean letras o numeros</p>
			<tr>
				<td style="color: blue;">Nombre de la empresa o persona: </td>
				<td bgcolor="#ffffff"><input type="input" value="<%= r.getName() %>" name="name" pattern="[A-Za-z0-9 ]*"required> </td>
			</tr>
			<tr>
				<td style="color: blue;">Direccion:</td>
				<td><input type="input" name="direccion" value="<%= r.getDireccion() %>" pattern="[A-Za-z0-9. ]*" required></td>
			</tr>
			<tr>
				<td style="color: blue;">Teléfono:</td>
				<td><input type="number" name="telefono" value="<%=r.getTelefono() %>" min="100000" max="1000000000" ></td>
			</tr>
			<tr>
				<td style="color: blue;">Cantidad de productos:</td>
				<td><input type="number" name="cantidad" value="<%=r.getCant() %>" min="1" max="15" required></td>
			</tr>
		

			<tr>
				<td colspan="2" align="center"><input
					type="submit" value="Submit" id="btsubmit"></td>
			</tr>
		</table>
	</form>

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