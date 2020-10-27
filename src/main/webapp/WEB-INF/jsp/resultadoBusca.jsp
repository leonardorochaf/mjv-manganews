<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!doctype html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Resultados da busca</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    <link href="/css/styles.css" rel="stylesheet">
</head>
<body>

    <nav class="navbar sticky-top navbar-expand-lg navbar-dark">
        <div class="container">
            <a href="/" type="button" class="navbar-brand">MangáNews</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
                <form class="form-inline my-2 my-lg-0" action="busca" method="get">
                    <input class="form-control mr-sm-2" type="search" placeholder="Procurar notícias" aria-label="Search" name="parametro">
                    <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Procurar</button>
                </form>
            </div>
        </div>
    </nav>

    <main>
        <div class="container">
            <h1 class="my-4">Resultados da busca</h1>
            <div class="row">
                <c:forEach items="${noticiasResultado}" var="noticia">
                    <div class="col-sm-4">
                        <div class="card" style="width: 18rem;">
                            <img src="${noticia.urlImagem}" class="card-img-top" alt="...">
                            <div class="card-body">
                                <a href="#"><h5 class="card-title">${noticia.titulo}</h5></a>
                                <div class="mt-2 mb-2 card-subtitle">
                                    <a href="#"><span class="card-subtitle-author">${noticia.autor.nome}</span></a>
                                    <span class="card-subtitle-date"> - <fmt:formatDate value="${noticia.dataLançamento}" pattern="dd/MM/yyyy"></fmt:formatDate></span>
                                </div>
                                <p class="card-text">${noticia.corpo}</p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </main>

</body>
</html>