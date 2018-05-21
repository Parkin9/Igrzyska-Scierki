<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: parkin9
  Date: 08.05.18
  Time: 14:32
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
        <h1>Zarządzanie Zadaniami</h1>
    </div>
    <div id="menu">
        <a href="/panel"><button>Wróć do Panelu</button></a>
    </div>
        <%--@elvariable id="task" type="pl.parkin9.IgrzyskaScierki.model.Task"--%>
        <form:form modelAttribute="task">
    <table>
        <tr>
            <td>
                <label for="name">Nazwa Zadania: </label>
            </td>
            <td>
                <form:input path="name" id="name"/>
            </td>
            <td>
                <form:errors path="name"/><br>
            </td>
        </tr>
        <tr>
            <td>
                <label for="pointsValue">Wartość punktowa: </label>
            </td>
            <td>
                <form:input path="pointsValue" id="pointsValue"/>
            </td>
            <td>
                <form:errors path="pointsValue"/><br>
            </td>
        </tr>
    </table>
            <button type="submit">Dodaj</button>
        </form:form>
    <hr>
    <div id="currentScore">
        <table>
            <tr>
                <th>Zadanie</th>
                <th>Punkty</th>
                <th></th>
            </tr>
            <c:forEach items="${taskList}" var="task">
                <tr>
                    <td><c:out value="${task.name}"/></td>
                    <td><c:out value="${task.pointsValue}"/></td>
                    <td><a href="/deleteTask/${task.id}"><button>Usuń</button></a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
