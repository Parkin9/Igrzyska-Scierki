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
    <title>Igrzyska Ścierki 0.2</title>
</head>
<body>
    <div>
        <h1>Zarządzanie Graczami</h1>
    </div>
    <hr>
    <div>
        <a href="/panel"><button>Wróć do Panelu</button></a>
    </div>
    <hr>
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
    <table>
        <tr>
            <td><u>Gracz</u></td>
            <td></td>
        </tr>
        <c:forEach items="${playerList}" var="player">
            <tr>
                <td><c:out value="${player.name}"/></td>
                <td><a href="/deletePlayer/${player.id}"><button>Usuń</button></a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
