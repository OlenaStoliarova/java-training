<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<html lang="${sessionScope.lang}">
<head>
    <%@ include file="/WEB-INF/fragments/head.jsp" %>
</head>
<body>
<div class="container text-center">
    <h3>500</h3>
    <h1><fmt:message key="ui.error.500.title" /></h1>
    <h5><fmt:message key="ui.error.500.description1" /></h5>
    <h5><fmt:message key="ui.error.500.description2" /></h5>
    <a href="${pageContext.request.contextPath}/app/main"><fmt:message key="ui.main.tomain" /></a>
</div>
</body>
</html>