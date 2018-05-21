<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: parkin9
  Date: 08.05.18
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Igrzyska Ścierki 0.1</title>
</head>
<body>
    <hr>
    <div>
        <h1>Igrzyska Ścierki 0.2</h1>
    </div>
    <hr>
            <%--@elvariable id="login" type="pl.parkin9.IgrzyskaScierki.model.Login"--%>
            <form:form modelAttribute="login">
    <table>
        <tr>
            <td>
                <label for="loginName">Login: </label>
            </td>
            <td>
                <form:input path="loginName"/>
            </td>
            <td>
                <form:errors path="loginName"/>
            </td>
            <td>
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
                <button type="submit">Zaloguj</button>
            </form:form>
    <a href="/registration"><button>Zarejestruj się</button></a>
    <h4>${validErrorPass}</h4>
</body>
</html>
