<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: parkin9
  Date: 08.05.18
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Igrzyska Ścierki 0.2</title>
</head>
<body>
    <hr>
    <div>
        <h1>Igrzyska Ścierki 0.2</h1>
    </div>
    <hr>
    <div>
        <a href="/"><button>Logowanie</button></a>
    </div>
    <hr>
            <%--@elvariable id="playerGroup" type="pl.parkin9.IgrzyskaScierki.model.PlayerGroup"--%>
            <form:form modelAttribute="playerGroup">
    <table>
        <tr>
            <td>
                <label for="name">Nazwa konta: </label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
            <td>
                <form:errors path="name"/>
            </td>
        </tr>
        <tr>
            <td>
                <label for="password">Hasło: </label>
            </td>
            <td>
                <form:password path="password"/>
            </td>
            <td>
                <form:errors path="password"/>
            </td>
        </tr>
    </table>
                <button type="submit">Zarejestruj</button>
            </form:form>
    <h4>${message}</h4>
</body>
</html>
