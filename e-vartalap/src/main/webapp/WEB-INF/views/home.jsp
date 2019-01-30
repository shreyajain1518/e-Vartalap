
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c1"%>

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
						<input type="submit" class="btn btn-first" value="Post">
						<input type="button" class="btn btn-first" value="clear">
				  </div>

				</form>
				<div id="allPost" class="jumbotron">
					All Posts
					<c:forEach items="${allPost}" var="post">
					
						<table>
							<tr>
								<td><div>${post.user_name} posted on ${post.post_date} <a href = "/postabusive?post_id=${post.post_id}">Abusive</a></div>
								<td>
							</tr>
							<tr>
								<td>
									<div>${post.post_text}</div>
																<c:forEach items="${allComment}" var="comment">
												<c:if test="${post.post_id==comment.postId}">
									<div>${comment.comment_text}<br> <a href = "/commentlike?comment_id=${comment.comment_id}">Like</a> <a href = "/commentdislike?comment_id=${comment.comment_id}">DisLike</a>
									<a href = "/commentabusive?comment_id=${comment.comment_id}">Abusive</a></div>
									</c:if>
										</c:forEach>
										</td>
							</tr>
							<tr>
							<td>
							<form class="form-horizontal" method="post" action=/comment>
								<div class="form-group input-group">
									<textarea class="form-control" name="comment"
										placeholder="Enter your comment" rows="4" cols="180"></textarea>
										<input type="hidden" name= "newid" value = ${post.post_id} />
																		</div>
								<div class="form-group">
									<input type="submit" class="btn btn-first" value="Comment" name="${post.post_id}">
									<input type="button" class="btn btn-first" value="clear">
								</div>
							</form>
							</td>
							</tr>
							<tr>
							<td><div id="all comments">
							<%-- <c:forEach items="${post.comments}" var="comment">
							<div>${comment.user_name}commented on ${comment.comment_date}</div>
							<div>${comment.comment_text}</div>
							<div>Liked By ${comment.comment_like}  : Disliked By ${comment.comment_dislike}</div>
							</c:forEach> --%>
							
							</div>
							<td>
							</tr>
						</table>
						
			
					</c:forEach>
							

				</div>


			</div>
		</div>

	</div>



	<script src="js/bootstrap.min.js" type="text/javasript"></script>
</body>
</body>
</html>