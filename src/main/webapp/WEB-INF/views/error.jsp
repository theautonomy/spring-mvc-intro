<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h1>
	<fmt:message key="error.title" />
</h1>
<h2>
	<fmt:message key="error.caption" /> for URL: ${url}
</h2>

<h2><p>Exception Summary:</h2> ${exception}</p>

<h2>
Exception Stack Trace: </h2> ${exception.message}.

<c:forEach items="${exception.stackTrace}" var="ste"> ${ste}
</c:forEach>
