<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
	 <title>Admin form</title>
	 <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
</head>
<body>
    <div class="container">
	    <div class="col-sm-10" style="width: 600px;margin-left:250px;margin-top:5">
	        <div class="jumbotron">
               <div class="form-group" style="margin-top: -50px;">
                 <h2 style="margin-left: 150px;">
                       Admin
                </h2>
              </div>
              <table class="form-horizontal" style="margin-left: 50px;">
                 <tr class="form-group input-group">   
                 <th><b>All users</b> &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp;  &nbsp; &nbsp;  &nbsp; &nbsp;</th>
                
                 <td><input type="submit" class="btn btn-primary" style="width:90px;" value="user" formaction="userlist"></td>
                 </tr>  

                 <tr class="form-group input-group">   
                    <th><b>All posts</b>&nbsp; &nbsp; &nbsp; &nbsp;  &nbsp;  &nbsp; &nbsp;  &nbsp; &nbsp;  &nbsp; &nbsp;</th>
                    <td><input type="submit" class="btn btn-primary" style="width:90px;" value="posts" formaction="postlist"></td>
                 </tr>  

                 <tr class="form-group input-group">   
                    <th><b>All comments</b>&nbsp; &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp;</th>
                    <td><input type="submit" class="btn btn-primary" style="width:90px;" value="comments" formaction="commentlist"></td>
                 </tr>  
              </table>
	        </div>    
      </div>
   </div>
    
    <script src="js/bootstrap.min.js" type="text/javasript"></script>
</body>
</html>