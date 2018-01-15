<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--<%@ taglib prefix="tiles" uri="http://tiles.apche.org/tags-tiles"%>--%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2018/1/16
  Time: 5:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spittr</title>
    <link rel="stylesheet" type="text/css" href="<spring:url value="/resources/style.css"/> ">
</head>
    <body>
        <div id="header">
            <tiles:insertAttribute name="header"/>
        </div>

        <div id="content">
            <tiles:insertAttribute name="body"/>
        </div>

        <div id="footer">
            <tiles:insertAttribute name="footer"/>
        </div>

    </body>
</html>
