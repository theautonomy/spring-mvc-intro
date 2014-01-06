<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet" media="screen"></link>
<script src="http://code.jquery.com/jquery.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<title>Book List Page</title>
</head>

<body>
<div style="padding: 50px 0px 0px 100px">
<h1>Book List Page</h1>
<table style="text-align: center;" border="5" cellpadding="10"
	cellspacing="10">
<thead>
<tr>
<th>Id</th>
<th>Title</th>
<th>Author</th>
<th>&nbsp;</th>
</tr>
</thead>
<tbody>
<c:forEach var="book" items="${books.books}">
	<tr>
	<td>${book.id}</td>
	<td>${book.title}</td>
	<td>${book.author}</td>
	<td> <a	href="${pageContext.request.contextPath}/book/edit/${book.id}.html">Edit</a></td>
	</tr>
</c:forEach>
</tbody>
</table>
<br />
<a href="${pageContext.request.contextPath}/book/list.xml">XML</a>, 
<a href="${pageContext.request.contextPath}/book/list.json">JSon</a>
<a href="${pageContext.request.contextPath}/book/list.pdf">PDF</a>
<a href="${pageContext.request.contextPath}/book/list.xls">Excel</a>
<br />
${executeTime}
<br />
<a href="${pageContext.request.contextPath}/">Home Page</a>
</div>
</body>
</html>

