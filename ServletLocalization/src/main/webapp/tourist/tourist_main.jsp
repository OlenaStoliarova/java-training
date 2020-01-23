<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<html lang="${sessionScope.lang}">
<head>
    <%@ include file="/WEB-INF/jspf/head.jsp" %>
</head>
<body>
<%@ include file="/WEB-INF/jspf/langlinks.jsp" %>


<h2><fmt:message key="ui.tourist.hello" /></h2>

</body>
</html>
