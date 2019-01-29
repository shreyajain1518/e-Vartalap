<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
     <meta charset="utf-8">
	 <title>Login1 form</title>
	 <link rel="stylesheet" type="text/css" href="../../css/bootstrap.css">
	     <meta name="_csrf" content="${_csrf.token}"/>
    <!-- default header name is X-CSRF-TOKEN -->
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
	 
  </head>
  
  <body>
  <jsp:include page="common_user.jsp"/>
    <div class="container">
	    <div class="col-sm-10" style="width: 600px;margin-left:250px;margin-top:5">
	        <div class="jumbotron">
               <div class="form-group" style="margin-top: -50px;">
                 <h2 style="margin-left: 150px;">
                        Login
                </h2>
              </div>
              <form class="form-horizontal" style="margin-left: 50px;" method="post" action="/login1">
                 <div class="form-group input-group">
                   <span class="input-group-addon">
                       <span class="glyphicon glyphicon-user"></span>
                   </span>
                   <input type="email" class="form-control" 
                   name="user_email" placeholder="Enter email... " required>
                 </div>
                 <div class="form-group input-group">
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-lock"></span>
                    </span>
                    <input type="password" class="form-control"
                     name="user_password" placeholder="Enter password... " required>
                 </div>
                 <div class="form-group">
                    <label>
                      <input type="checkbox">
                      Remember me
                    </label>
                 </div>
                 <div class="form-group">
                 <input type = "submit" class="btn btn-first" value = "submit">
                   <!--  <button class="btn btn-primary" style="width:90px;">Login</button>-->
                 </div>
                 <div class="form-group">
                    <a href="/forgetpassword" style="margin-left: 310px;">Forget password</a>
                 </div>
                 <div class="form-group">
                    <a href="/register" style="margin-left">Register here</a>
                 </div>
              </form>
        
	        </div>    
      </div>
   </div>
    <script src="js/bootstrap.min.js" type="text/javasript"></script>
  </body>

</html>