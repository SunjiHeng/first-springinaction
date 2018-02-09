<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2018/2/5
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Spitter</title>
    <link rel="stylesheet" type="text/css" th:href="@{/resources/style.css}"/>
</head>
<body onload="document.f.username.focus();">
<div id="header" th:include="page::header"></div>
<div id="content">
    <form name="f" th:action="@{/login}" method="post">
        <table>
            <security:authentication var="loginId" property="principal.username" scope="request"/>
            <tr>
                <td><label for="user-name-label" class="dijitInline">User:</label></td>
                <td><input type="text" name="username" id="user-name-label" value=""></td>
            </tr>
            <tr>
                <td><label for="password" class="dijitInline">Password:</label></td>
                <td><input type="password" name="password" id="password"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Login"></td>
            </tr>
            <tr>
                <td>
                    <input type="checkbox" id="remember_me" name="remember_me"/>
                    <label for="remember_me" class="inline">Remember me</label>
                </td>
            </tr>
            <input type="hidden" name="_csrf" value="6823blae">
        </table>
    </form>
    </div>
<div id="footer" th:include="page::copy"></div>

</body>
</html>
