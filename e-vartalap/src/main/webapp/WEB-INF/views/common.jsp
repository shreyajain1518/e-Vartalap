
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>e-Vartalap</title>
<link rel="stylesheet" type="text/css" href="../../css/style.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<header class="header">
<nav class="navbar navbar-style">
<div class="container"></div>
<div class="navbar-header">

<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#micron" >
<span class="icon-bar"></span>
<span class="icon-bar"></span>
<span class="icon-bar"></span>
</button>
<table> 
<tr>
<td>
<a href=""><img class="logo" src="../../images/image.jpg"></a>
</td>
<td>
<h3>Hello ${user.user_name} </h3>
</td>
<td>
<h1 class="big-text">Welcome to e-Vartalap</h1>
</td>
</tr>
</table>
</div>
<div class="collapse navbar-collapse" id="micron">
<ul class="nav navbar-nav navbar-right">


<li><a href="/home">Home</a></li>
<li><a href="/profile">View Profile</a></li>

<li><a href="/userlogout">Logout</a></li>
</ul>
</div>
</nav>


</header>
</body>
</html>