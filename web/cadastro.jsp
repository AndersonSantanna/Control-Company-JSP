<%-- 
    Document   : cadastro
    Created on : 06/11/2018, 04:29:24
    Author     : Anderson Sant'Anna
--%>

<%@page import="br.unip.cc.trabalho.Model.Empresa"%>
<%@page import="br.unip.cc.trabalho.Model.TipoEmpresa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Controle de Empresa</title>
    </head>
    <body>
        <%@include file="header.jspf" %>
        <article class="container">
            <%
                Empresa empresa = (Empresa) request.getAttribute("empresa");
                String mensagem = (String) request.getAttribute("mensagem");
                String estiloMensagem = (String) request.getAttribute("estilo");
                if (mensagem == null) {
                    mensagem = "";
                }
                String idStr = "0";
                String cnpjStr = "";
                String razaoStr = "";
                String tipoStr = "";
                
            %>
            <div class="<%= estiloMensagem%>"><%= mensagem%></div>
            <h1 class="text-center mb-4 mt-3 display-4">Cadastro</h1>
            <form class="form-group ml-3 mr-3" action="salvar" method="post">
                <label>Id</label>
                <input class="form-control" disabled="true" value="#" type="text" name="idDisable">
                <input type="hidden" name="id" value="<%= idStr%>" /><br>
                <label>CNPJ</label>
                <input class="form-control" value="<%= cnpjStr%>" type="text" name="cnpj"><br>
                <label>Razão Social</label>
                <input class="form-control" value="<%= razaoStr%>" type="text" name="razao"><br>

                <div class="form-group">
                    <label>Tipo</label>
                    <select class="form-control" name="tipo">
                        
                        <% TipoEmpresa[] tipos = TipoEmpresa.values(); %>
                        <% for (TipoEmpresa tipo : tipos) {%>
                        <option><%=tipo.name()%></option>
                        <%}%>
                    </select><br>
                </div>
                <div class="text-center">
                    <a class="btn btn-secondary" href="http://localhost:8084/Controle_de_Estoque_web/" >Voltar</a>
                    <a class="btn btn-danger" href="buscar">Buscar <i class="fas fa-search"></i></a>
                    <button class="btn btn-primary" type="submit">Cadastrar <i class="fas fa-pen "></i></button>
                </div>
            </form>
        </article>
        <footer class="text-center bg-dark text-white">
            &copy; Copyright 2018 - Ciência da Computação - Anderson Sant'Anna
        </footer>
    </body>
</html>
