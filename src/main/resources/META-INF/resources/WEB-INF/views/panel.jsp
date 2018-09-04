<%--@elvariable id="player" type="pl.parkin9.IgrzyskaScierki.model.Player"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: parkin9
  Date: 08.05.18
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Modern+Antiqua&amp;subset=latin-ext" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>Igrzyska Ścierki</title>

</head>
<body>
<div id="container">
    <div id="gameName">
        <h1>${sessionScope.loggedInPlayerGroup.name}</h1>
    </div>
    <div id="menu">
        <a href="<c:url value="/game"/>"><button><b>Gra</b></button></a>
        <a href="<c:url value="/addTask"/>"><button>Zarządzaj Zadaniami</button></a>
        <a href="<c:url value="/addPlayer"/>"><button>Zarządzaj Graczami</button></a>
        <a href="<c:url value="/logout"/>"><button>Wyloguj</button></a>
    </div>
    <div id="currentScore">
        <table>
            <tr>
                <th>Aktualna rozgrywka</th>
            </tr>
            <c:forEach items="${playerList}" var="player">
            <tr>
                <td>
                <c:out value="${player.name}"/>
                <c:out value=" - "/>
                <c:out value="${player.score}"/>
                </td>
            </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
