<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<html lang="${sessionScope.lang}">
<%@ include file="/WEB-INF/jspf/head.jsp" %>
<body>
<%@ include file="/WEB-INF/jspf/langlinks.jsp" %>

<h2><fmt:message key="ui.main.greeting" /></h2>

<a class="btn btn-info" href="tourist/tourist_main.jsp">Login</a>

</body>
</html>
