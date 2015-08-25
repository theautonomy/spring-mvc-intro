<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

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
 <h1>JSP - <spring:message code="title"/></h1>

 <p/>
 Local time is ${time}
 <br/>
 <br/>

 <a href="${pageContext.request.contextPath}/book/create.html">Add New Book</a><br/>
 <a href="${pageContext.request.contextPath}/book/list.html">List Books</a><br/>
 <br/>

 <security:authorize access="isAuthenticated()">
 Welcome <%= request.getUserPrincipal().getName() %>
 <a href="<c:url value="/logout"/>">Logout</a><br/>
 </security:authorize>

 <p/>
 <a href="?lang=en">en</a> | <a href="?lang=de">de</a>
 <br/>

</div>
</body>
</html>

