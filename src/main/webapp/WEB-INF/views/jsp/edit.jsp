<%@ page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" media="screen"></link>
<script src="http://code.jquery.com/jquery.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<title>Edit Book Page</title>
</head>
<body>
<div style="padding: 50px 0px 0px 100px">
<h1>Edit Book Page</h1>
<form:form method="POST" commandName="book" action="${pageContext.request.contextPath}/book/edit/${book.id}.html" >
<table>
<tbody>
<tr>
<td>Book Title:</td>
<td><form:input path="title" /></td>
<td><form:errors path="title" cssStyle="color: red;"/></td>
</tr>
<tr>
<td>Book Author:</td>
<td><form:input path="author" /></td>
<td><form:errors path="author" cssStyle="color: red;"/></td>
</tr>
<tr>
<td><input type="submit" value="Upate" /></td>
<td></td>
<td></td>
</tr>
</tbody>
</table>
</form:form>
<a href="${pageContext.request.contextPath}/">Home Page</a>
</div>
</body>
</html>