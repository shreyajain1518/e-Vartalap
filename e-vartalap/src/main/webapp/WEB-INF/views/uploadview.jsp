<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"></meta>
<title>Insert title here</title>
</head>
<body>

    <form action="/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="files" multiple>
    <input type="submit" value="Upload Photo"></input>
    </form>

</body>
</html>