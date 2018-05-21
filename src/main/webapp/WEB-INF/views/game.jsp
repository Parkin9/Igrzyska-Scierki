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
    <title>Igrzyska Ścierki 0.2</title>
</head>
<body>
    <div>
        <h1>Aktualna Gra</h1>
    </div>
    <hr>
    <div>
        <a href="/panel"><button>Wróć do Panelu</button></a>
    </div>
    <hr>
    <div>
        <form action="#" method="post">
            <table>
                <tr>
                    <td></td>
                    <td><u>Gracze</u></td>
                </tr>
                <%--@elvariable id="playerList" type="java.util.List"--%>
                <c:forEach items="${playerList}" var="player">
                <tr>
                    <td><input type="radio" name="whichPlayerDo" value="${player.id}"></td>
                    <td><c:out value=" ${player.name}"/></td>
                </tr>
                </c:forEach>
            </table>
            <br>
            <table>
                <tr>
                    <td></td>
                    <td><u>Zadania</u></td>
                </tr>
                <%--@elvariable id="taskList" type="java.util.List"--%>
                <c:forEach items="${taskList}" var="task">
                <tr>
                    <td><input type="checkbox" name="whichTaskIsDone" value="${task.id}"></td>
                    <td><c:out value="${task.name}"/></td>
                </tr>
                </c:forEach>
            </table>
            <br>
            <button type="submit">Wykonane</button>
        </form>
    </div>
</body>
</html>
