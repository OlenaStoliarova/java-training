<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<html lang="${sessionScope.lang}">
<%@ include file="/WEB-INF/fragments/head.jsp" %>
<body>
<%@ include file="/WEB-INF/fragments/langlinks.jsp" %>


<h2><fmt:message key="ui.tourist.hello"/></h2>

<a href="${pageContext.request.contextPath}/app/logout"><fmt:message key="ui.main.logout" /></a>

<br/>
<a href="${pageContext.request.contextPath}/app/tourist/cruises"><fmt:message key="ui.cruises.view" /></a>

</body>
</html>
