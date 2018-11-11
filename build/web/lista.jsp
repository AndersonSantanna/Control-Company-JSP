<%-- 
    Document   : buscar
    Created on : 06/11/2018, 05:40:34
    Author     : Anderson Sant'Anna
--%>

<%@page import="java.util.List"%>
<%@page import="br.unip.cc.trabalho.Model.Empresa"%>
<%@page import="br.unip.cc.trabalho.Model.TipoEmpresa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controle de Estoque</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
        <link rel="stylesheet" href="css/estilo.css">
        <style>
            body { overflow-x: hidden; }
        </style>
    </head>
    <body>
        <%@include file="header.jspf" %>
        
        <% List<Empresa> lista = (List<Empresa>) request.getAttribute("lista");%>
        
        <main class="mt-4">
            <h1 class="text-center mb-4 display-4">Lista de Empresas</h1>
            <form name="form" action="buscar">
                <div class="contaneir">
                    <div class="row">
                    <span class="text-center offset-lg-4 offset-sm-3 offset-2   mt-3">TIPO EMPRESA: </span>
                    <select class="form-control col-3 ml-2 mt-2" name="tipo">
                        <option>TODOS</option>
                        <% TipoEmpresa[] tipos = TipoEmpresa.values(); %>
                        <% for (TipoEmpresa tipo : tipos) {%>
                        <option><%=tipo.name()%></option>
                        <%}%>

                    </select>
                    <input type="submit" class="btn btn-secondary mb-4 mt-2" value="buscar"/>
                    </div>
                </div>
            </form>
            <article class="contner">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <td>ID</td>
                            <td>CNPJ</td>
                            <td>Razão Social</td>
                            <td>Tipo</td>
                            <td>Editar</td>
                            <td>Apagar</td>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Empresa empresa : lista) {%>
                            <tr>
                                <td><%= empresa.getId()%></td>
                                <td><%= empresa.getCnpj()%></td>
                                <td><%= empresa.getRazaoSocial() %></td>
                                <td><%= empresa.getTipoEmpresa() %></td>
                                <td>
                                    <a href="editar?id=<%= empresa.getId()%>" title="Clique para editar">
                                        <i class="far fa-edit"></i>   
                                    </a>
                                </td>
                                <td>
                                    <a href="excluir?id=<%= empresa.getId()%>" title="Clique para excluir">
                                        <i class="fas fa-trash-alt"></i>   
                                    </a>
                                </td>
                            </tr>
                        <%}%>
                    </tbody>
                </table>
                <div class="text-center">
                    <a class="btn btn-secondary mb-5" href="http://localhost:8084/Controle_de_Estoque_web/" >Voltar</a>
                    <button class="btn btn-primary mb-5" onclick="window.location.reload()">Atualizar <i class="fas fa-redo"></i></button>
                    <a class="btn btn-danger mb-5" href="cadastro.jsp">Novo <i class="fas fa-plus"></i></a>
                </div>
            </article>
            <footer class="text-center mt-4 bg-dark text-white fixed-bottom">
                &copy; Copyright 2018 - Ciência da Computação - Anderson Sant'Anna
            </footer>
        </main>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>
