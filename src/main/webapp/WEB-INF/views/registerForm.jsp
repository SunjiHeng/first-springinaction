<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2018/1/10
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spittr</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css"/>">
</head>
<body>
<h1>Register</h1>
<%--<form method="post">--%>
    <%--First Name:<input type="text" name="firstName"/><br/>--%>
    <%--Last Name:<input type="text" name="lastName"/><br/>--%>
    <%--Username:<input type="text" name="username"/><br/>--%>
    <%--Password:<input type="text" name="password"/><br/>--%>
    <%--<input type="submit" value="Register"/>--%>
<%--</form>--%>
<spring:form method="post" commandName="spitter" action="/toRegister">
    First Name:<spring:input path="firstName"/>  <br/>
    Last Name:<spring:input path="lastName"/>    <br/>
    Email:<spring:input path="email"/>           <br/>
    Username:<spring:input path="username"/>     <br/>
    <input type="submit" value="Register">
</spring:form>
</body>
</html>
