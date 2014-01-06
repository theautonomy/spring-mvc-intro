<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Spring MVC Simple Demo Application</title>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" media="screen"></link>
<script src="http://code.jquery.com/jquery.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
</head>
<body>
<div style="padding: 50px 0px 0px 100px">
	<h1>
		<fmt:message key="login.title" />
	</h1>

	<c:if test="${!empty param.login_error}">
		<div style="color: red; margin-bottom: 1em; font-size: large;">
			<fmt:message key="login.failure" />
		</div>
	</c:if>

	<table style="background-color: white">
		<tr>
			<td>
				<h2>
					<fmt:message key="login.caption" />
				</h2>

				<form action="<c:url value='/j_spring_security_check'/>" method="post">
					<table>
						<tr>
							<td><fmt:message key="login.username" />:</td>
							<td><input type="text" name="j_username" /></td>
						</tr>
						<tr>
							<td><fmt:message key="login.password" />:</td>
							<td><input type="password" name="j_password" /></td>
						</tr>
						<tr>
							<td colspan='2'><input name="submit" type="submit" value="Login" /></td>
						</tr>
					</table>
				</form>
			</td>
			
		</tr>
	</table>
	
	<a href="${pageContext.request.contextPath}/">Home page</a>
</div>

</body>
</html>
