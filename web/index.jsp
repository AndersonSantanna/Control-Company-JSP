<%-- 
    Document   : index
    Created on : 06/11/2018, 03:46:15
    Author     : Anderson Sant'Anna
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controle de Estoque</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
    </head>
    <body>
        <%@include file="header.jspf" %>
        <a href="cadastro.jsp">
            <div class="cadastrar btn btn-primary">
                <i class="fas fa-pen display-4"> Cadastrar</i>
            </div>
        </a>
        <a href="buscar">
            <div class="buscar btn btn-danger">
                <i class="fas fa-search display-4"> Buscar</i>
            </div>
        </a>
        <footer class="text-center fixed-bottom bg-dark text-white">
            &copy; Copyright 2018 - Ciência da Computação - Anderson Sant'Anna
        </footer>
    </body>
</html>
