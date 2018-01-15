<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
<h1>Register <spring:message code="spitter.register" /> </h1>
<%--<form method="post">--%>
<%--First Name:<input type="text" name="firstName"/><br/>--%>
<%--Last Name:<input type="text" name="lastName"/><br/>--%>
<%--Username:<input type="text" name="username"/><br/>--%>
<%--Password:<input type="text" name="password"/><br/>--%>
<%--<input type="submit" value="Register"/>--%>
<%--</form>--%>
<form:form method="post" commandName="spitter" action="/toRegister">

    <form:label path="firstName" cssErrorClass="error"> First Name:</form:label>
    <form:input path="firstName"/> <br/>

    <form:label path="lastName" cssErrorClass="error">Last Name:</form:label>
    <form:input path="lastName"/> <br/>

    <form:label path="email" cssErrorClass="error">Email:</form:label>
    <form:input path="email"/> <br/>

    <form:label path="username" cssErrorClass="error">Username:</form:label>
    <form:input path="username"/> <br/>

    <form:label path="password" cssErrorClass="error">Password:</form:label>
    <form:password path="password"/> <br/>

    <input type="submit" value="Register">
</form:form>
</body>
</html>
