<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: parkin9
  Date: 10.05.18
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Igrzyska Ścierki 0.2</title>
</head>
<body>

    <div>
        <h1>Nowa Gra</h1>
    </div>
    <hr>
    <div>
        <a href="/panel"><button>Wróć do Panelu</button></a>
    </div>
    <hr>
    <%--@elvariable id="game" type="pl.parkin9.IgrzyskaScierki.model.Game"--%>
    <form:form modelAttribute="game">
        <table>
            <tr>
                <td>
                    <label for="end">Do kiedy ma trwać gra: </label>
                </td>
                <td>
                    <form:input type="date" path="end" id="end"/>
                </td>
                <td>
                    <form:errors path="end"/><br>
                </td>
            </tr>
        </table>
        <button type="submit">START</button>
    </form:form>

</body>
</html>
