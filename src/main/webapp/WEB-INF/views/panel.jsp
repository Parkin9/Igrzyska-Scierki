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
    <title>Igrzyska Ścierki 0.2</title>
    <script>
        function clock() {

            var toDay = new Date();

            var day = toDay.getDate();
            var month = toDay.getMonth()+1;
            var year = toDay.getFullYear();

            var hour = toDay.getHours();
            if(hour < 10) hour = "0" + hour;

            var minute = toDay.getMinutes();
            if(minute < 10) minute = "0" + minute;

            var sec = toDay.getSeconds();
            if(sec < 10) sec = "0" + sec;

            document.getElementById("clock").innerHTML =
                day + "/" + month + "/" + year + " | " + hour + ":" + minute + ":" + sec;

            setTimeout("clock()", 1000);
        }
    </script>
</head>
<body onload="clock()">
    <div id="clock" style="position:absolute; right:10px; top:10px"></div>
    <div>
        <h1>${sessionScope.loggedInPlayerGroup.name}</h1>
    </div>
    <hr>
    <div>
        <table>
            <td>
                <a href="/game"><button><b>Gra</b></button></a>
            </td>
            <td>
                <a href="/addTask"><button>Zarządzaj Zadaniami</button></a>
            </td>
            <td>
                <a href="/addPlayer"><button>Zarządzaj Graczami</button></a>
            </td>
            <td>
                <a href="/logout"><button>Wyloguj</button></a>
            </td>
        </table>
    </div>
    <hr>
    <table>
        <tr>
            <td><u>Gracz</u></td>
            <td><u>Wynik</u></td>
        </tr>
        <c:forEach items="${playerList}" var="player">
            <tr>
                <td><c:out value="${player.name}"/></td>
                <td><c:out value="${player.score}"/></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
