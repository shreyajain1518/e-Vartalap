<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta charset="utf-8">
	 <title>Login form</title>
	 <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
</head>
<body>
   <div class="container">
	    <div class="col-sm-10" style="width: 600px;margin-left:250px;margin-top:5">
	        <div class="jumbotron">
               <div class="form-group" style="margin-top: -50px;">
                 <h2 style="margin-left: 150px;">
                       Update profile
                </h2>
      
              </div>
            
              <form class="form-horizontal" style="margin-left: 50px;" method = "post">
                 
                 <div class="form-group input-group">   
                 </h6>Please enter your new password<h6>
                 </div>
                 <div class="form-group input-group">
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-lock"></span>
                    </span>
                    <input type="password" class="form-control"
                     name="user_password" placeholder="Enter password... " required>
                 </div>
            
                 <div class="form-group">
                   <input type="submit" class="btn btn-primary" style="width:100px;" value="reset"></button>
                 </div>
            
              </form>
	        </div>    
      </div>
   </div>
    <script src="js/bootstrap.min.js" type="text/javasript"></script>
   
</body>
</html>