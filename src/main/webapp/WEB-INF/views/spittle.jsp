<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2018/1/10
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>spittle</title>
</head>
<body>
    <c:forEach var="spittle" items="${spittleList}">
        <div class="spittleMessage">
            <c:out value="${spittle.message}"/>
        </div>
        <div>
            <span class="spittleTime">
                <c:out value="${spittle.time}"/>
            </span>
            <span class="spittleLocation">
                (<c:out value="${spittle.latitude} "/>,
                <c:out value="${spittle.longitude}"/> )
            </span>
        </div>
    </c:forEach>
</body>
</html>
