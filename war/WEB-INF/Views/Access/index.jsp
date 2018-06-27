<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.entity.Access"%>
<%@ page import="java.util.List"%>
<%
	List<Access> access = (List<Access>) request.getAttribute("access");
%>
<!DOCTYPE html>
<html>
<title>Access</title>
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
  <h1>Lista de Access</h1>
  <div class="w3-container w3-sidebar w3-collapse w3-large w3-padding"> 
  	<h4 style="color:blue"><a href="/access/add">Crear access</a></h4><br>
  </div>
 <div class="w3-main" style="margin-left:210px;margin-right:10px	"> 
	<%
		if (access!=null && access.size() > 0) {
	%>
	<table border="0" cellspacing="1" cellpadding="5" width="100%">
			<tr>
				<td style="color:blue" class="title">Id</td>
				<td style="color:blue" class="title">Rol</td>
				<td style="color:blue" class="title">Url</td>
				<td style="color:blue" class="title">Status</td>
				<td style="color:blue" class="title">Fecha de creación</td>
				<td style="color:blue">Acciones</td>
			</tr>
			<%
				for (int i = access.size() - 1; i >= 0; i--) {
			%>
			<tr>
				<td><%=access.get(i).getId()%></td>
				<td><%=access.get(i).getIdRole()%></td>
				<td><%=access.get(i).getIdUrl()%></td>
				<td><%=access.get(i).isStatus()%></td>
				<td><%=access.get(i).getCreated()%></td>
				<td><a href="access/view?id=<%=access.get(i).getId()%>">View</a>
					<a href="access/edit?id=<%=access.get(i).getId()%>">Edit</a> <a
					href="access/delete?id=<%=access.get(i).getId()%>">Delete</a></td>
			</tr>
		<%
				}
			%>
		</table>
	
	<%
		} else {
	%>
	
		<h3>No hay access</h3>

	<%
		}
	%>
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