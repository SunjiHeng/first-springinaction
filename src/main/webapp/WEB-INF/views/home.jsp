<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2018/1/9
  Time: 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spittr</title>
    <link rel="stylesheet" type="text/css" href="<c:url value= "/resources/style.css"/>" >
</head>
<body>
    <h1>welcome!</h1>
    <a href="<c:url value="/spittle"/> ">Spittles</a>
    <a href="<c:url value="/spitter/register"/> ">Register</a>
    <spring:form method="post" commandName="spitter" >
        First Name:<spring:input path="firstName" /><br/>
        Last Name:<spring:input path="LastName" /> <br/>
        Email:<spring:input path="email"/> <br/>
        Username:<spring:input path="username" /> <br/>
        <input type="submit" value="Register">
    </spring:form>
</body>
</html>