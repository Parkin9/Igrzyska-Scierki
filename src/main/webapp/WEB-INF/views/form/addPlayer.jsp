<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: parkin9
  Date: 09.05.18
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Modern+Antiqua&amp;subset=latin-ext" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>Igrzyska Ścierki 0.3</title>
</head>
<body>
<div id="container">
    <div id="gameName">
        <h1>Zarządzanie Graczami</h1>
    </div>
    <div id="menu">
        <a href="/panel"><button>Wróć do Panelu</button></a>
    </div>
        <%--@elvariable id="player" type="pl.parkin9.IgrzyskaScierki.model.Player"--%>
        <form:form modelAttribute="player">
        <table>
            <tr>
                <td>
                    <label for="name">Nazwa Gracza: </label>
                </td>
                <td>
                    <form:input path="name" id="name"/>
                </td>
                <td>
                    <form:errors path="name"/><br>
                </td>
            </tr>
        </table>
            <button type="submit">Dodaj</button>
        </form:form>
    <hr>
    <div id="currentScore">
        <table>
            <tr>
                <th>Gracz</th>
                <th></th>
            </tr>
            <c:forEach items="${playerList}" var="player">
                <tr>
                    <td><c:out value="${player.name}"/></td>
                    <td><a href="/deletePlayer/${player.id}"><button>Usuń</button></a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
