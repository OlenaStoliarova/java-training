<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="messages"/>

<html lang="${sessionScope.lang}">
<%@ include file="/WEB-INF/fragments/head.jsp" %>
<body>
<%@ include file="/WEB-INF/fragments/langlinks.jsp" %>

<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <br/>
            <c:if test = "${unknown_user == true}">
                <div class="text-danger">
                    <fmt:message key="ui.login.error" />
                </div>
            </c:if>
            <div class="card" style="margin-top:45px">
                <div class="card-header">
                    <h3 class="card-title"><fmt:message key="ui.login.invitation" /></h3>
                </div><br/>
                <div class="card-body">
                    <form action="${pageContext.request.contextPath}/app/login" method="post">
                        <div class="form-group">
                            <label for="username"><fmt:message key="ui.login.userName" /></label>
                            <input type="email" class="form-control" id="username" name="username" required="required" value="${param.username}">
                        </div>
                        <div class="form-group">
                            <label for="password"><fmt:message key="ui.login.password" /></label>
                            <input type="password" class="form-control" id="password" name="password" required="required">
                        </div>
                        <input type="submit" class="btn btn-primary" value='<fmt:message key="ui.login.login"/>' />
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
