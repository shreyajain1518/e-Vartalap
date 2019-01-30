<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta charset="utf-8">
	 <title>userlist form</title>
	 <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
</head>
<body>
   <jsp:include page="common.jsp" />
    <div class="container">
	    <div class="col-sm-10" style="width: 600px;margin-left:250px;margin-top:5">
	        <div class="jumbotron">
               <div class="form-group" style="margin-top: -50px;">
                 <h2 style="margin-left: 150px;">
                       User List
                </h2>
      
              </div>
            
              <form class="form-horizontal" style="margin-left: 10px;">
        
                <table style="background-color: rgb(245, 159, 219); margin: auto;" border="1">
                    <c:forEach var="u" items="${requestScope.userlist}">
                        <tr>
                            <td>${u.user_id}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                            <td>${u.user_name}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                            <td>${u.user_email}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                            <td><a href="<spring:url value='delete?uid=${u.user_id}'/>">Delete</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            </td>
                        </tr>
                    </c:forEach>
                </table>
              </form>
	        </div>    
      </div>
   </div>
    <script src="js/bootstrap.min.js" type="text/javasript"></script>
</body>
</html>