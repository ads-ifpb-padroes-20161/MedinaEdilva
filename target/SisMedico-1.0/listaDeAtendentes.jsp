<%-- 
    Document   : listaDeAtendentes
    Created on : 29/08/2016, 08:27:56
    Author     : Edilva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="lista" class="br.edu.ifpb.padroes.projeto.modelo.ListarAtendentesBo"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src='http://code.jquery.com/jquery-2.1.3.min.js'></script>
        <script src='//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js'></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div><jsp:include page="paginaDoAtendente.jsp"/></div>
        <div class="container text-center">
            <h1>Atendentes</h1>
            <br>
        </div>
        <div class="container" style="width:95%">
            <div class="row">
                <div class="form-group col-md-12">
                    <table class="table table-striped">
                        <tr class="row">
                                <td>CPF</td>
                                <td>MATRÍCULA</td>
                                <td>NOME</td>
                                <td>RG</td>
                                <td>DATA DE NASC</td>
                                <td>EMAIL</td>
                                <td>UF</td>
                                <td>CIDADE</td>
                                <td>BAIRRO</td>
                                <td>RUA</td>
                                <td>NÚMERO</td>
                            </tr>
                        <c:forEach var="atendente" items="${lista.listar()}">
                            <tr class="row">
                                <td>${atendente.cpf}</td>
                                <td>${atendente.matricula}</td>
                                <td>${atendente.nome}</td>
                                <td>${atendente.rg}</td>
                                <td>${atendente.dataNasc}</td>
                                <td>${atendente.email}</td>
                                <td>${atendente.endereco.estado}</td>
                                <td>${atendente.endereco.cidade}</td>
                                <td>${atendente.endereco.bairro}</td>
                                <td>${atendente.endereco.rua}</td>
                                <td>${atendente.endereco.numero}</td>
                                <td>
                                    <a href="Controller?command=RemoverAtendente&cpf=${atendente.cpf}">Remover</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>    
            </div>
        </div>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/funcoes.js"></script>
    </body>
</html>
