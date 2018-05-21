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
    <link href="https://fonts.googleapis.com/css?family=Modern+Antiqua&amp;subset=latin-ext" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>Igrzyska Ścierki 0.3</title>
</head>
<body>
<div id="container">
    <div id="gameName">
        <h1>Igrzyska Ścierki 0.3</h1>
    </div>
    <div id="menu">
        <a href="/"><button>Logowanie</button></a>
    </div>
    <div>
        <%--@elvariable id="playerGroup" type="pl.parkin9.IgrzyskaScierki.model.PlayerGroup"--%>
        <form:form modelAttribute="playerGroup">
        <div>
            <table>
                <tr>
                    <td>
                        <label for="name">Nazwa konta: </label>
                    </td>
                    <td>
                        <form:input path="name"/>
                        <form:errors path="name"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="password">Hasło: </label>
                    </td>
                    <td>
                        <form:password path="password"/>
                        <form:errors path="password"/>
                    </td>
                </tr>
            </table>
        </div>
        <span class="logButton">
            <button type="submit">Zarejestruj</button>
        </span>
        </form:form>
        <div class="errorDiv">
            ${message}
        </div>
    </div>
</div>
</body>
</html>
