<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Meus Mangás</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    <link href="/css/styles.css" rel="stylesheet">
</head>
<body>

    <nav class="navbar sticky-top navbar-expand-lg navbar-dark">
        <div class="container">
            <a href="/usuario/<c:out value="${usuarioLogado.id}"/>/noticias" type="button" class="navbar-brand">MangáNews</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="/usuario/<c:out value="${usuarioLogado.id}"/>/noticias">Notícias</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="/usuario/<c:out value="${usuarioLogado.id}"/>/meusmangas">Meus mangás</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container">
        <c:forEach items="${mangasPossui}" var="manga">
            <p style="color: white;">${manga.id}</p>
            <p style="color: white;">${manga.nome}</p>
        </c:forEach>
    </div>

    <div class="container">
        <c:forEach items="${mangasNaoPossui}" var="manga">
            <p style="color: white;">${manga.id}</p>
            <p style="color: white;">${manga.nome}</p>
        </c:forEach>
    </div>

</body>
</html>