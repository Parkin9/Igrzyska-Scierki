<%--
  Created by IntelliJ IDEA.
  User: parkin9
  Date: 23.05.18
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Modern+Antiqua&amp;subset=latin-ext" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>Igrzyska Ścierki</title>
</head>
<body>
<div id="container">
    <div id="gameName">
        <h1>Gratulację!</h1>
    </div>
    <div id="menu">
        <a href="/panel"><button>Wróć do Panelu</button></a>
    </div>
    <div style="text-align: center">
        Zwycięzcą zostaje ${winner}!<br/>
        Osiągnięty wynik to ${maxScore} punktów.
    </div>

</div>
</body>
</html>
