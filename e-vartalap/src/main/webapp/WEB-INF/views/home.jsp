<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link rel="stylesheet" type="text/css" href="../../css/bootstrap.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="common.jsp" />

	<div class="container">
		<div class="col-sm-10">
			<div class="jumbotron">
				<form class="form-horizontal" method="post" action=/submit>
					<div class="form-group input-group">

						<textarea class="form-control" name="post"
							placeholder="Enter your post" rows="5" cols="160"></textarea>
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-first" value="submit">
						<input type="button" class="btn btn-first" value="clear">

					</div>

				</form>
				<div id="allPost">

					<c:forEach items="${allPost}" var="post">
						<div>${post.post_text}</div>

						<form class="form-horizontal" method="post" action=/submit>
							<div class="form-group input-group">

								<textarea class="form-control" name="post"
									placeholder="Enter your comment" rows="5" cols="160"></textarea>
							</div>
							<div class="form-group">
								<input type="submit" class="btn btn-first" value="submit">
								<input type="button" class="btn btn-first" value="clear">

							</div>

						</form>
					</c:forEach>

				</div>


			</div>
		</div>

	</div>



	<script src="js/bootstrap.min.js" type="text/javasript"></script>
</body>
</body>
</html>