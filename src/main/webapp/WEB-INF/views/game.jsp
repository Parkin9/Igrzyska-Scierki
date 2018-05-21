<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: parkin9
  Date: 14.05.18
  Time: 13:13
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
        <h1>Aktualna Gra</h1>
    </div>
    <div id="menu">
        <a href="/panel"><button>Wróć do Panelu</button></a>
    </div>
    <div id="currentScore">
        <form action="#" method="post">
            <div style="float: left">
                <table>
                    <tr>
                        <th></th>
                        <th>Gracze</th>
                    </tr>
                    <%--@elvariable id="playerList" type="java.util.List"--%>
                    <c:forEach items="${playerList}" var="player">
                    <tr>
                        <td><input type="radio" name="whichPlayerDo" value="${player.id}"></td>
                        <td><c:out value=" ${player.name}"/></td>
                    </tr>
                    </c:forEach>
                </table>
            </div>
            <div style="float: left">
                <table>
                    <tr>
                        <th></th>
                        <th>Zadania</th>
                    </tr>
                    <%--@elvariable id="taskList" type="java.util.List"--%>
                    <c:forEach items="${taskList}" var="task">
                    <tr>
                        <td><input type="checkbox" name="whichTaskIsDone" value="${task.id}"></td>
                        <td><c:out value="${task.name}"/></td>
                    </tr>
                    </c:forEach>
                </table>
            </div>
            <div style="clear: both">
                <button type="submit">Wykonane</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
