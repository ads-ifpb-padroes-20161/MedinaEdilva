<%-- 
    Document   : ListarClinicas
    Created on : 29/08/2016, 12:51:28
    Author     : Edilva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="listaClinica" class="br.edu.ifpb.padroes.projeto.modelo.ListarBo" scope="page"/>
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
            <h1>Clínicas</h1>
            <br>
        </div>
        <div class="container" style="width:95%">
            <div class="row">
                <div class="form-group col-md-12">
                    <table class="table table-striped">
                        <tr class="row">
                            <td>CNPJ</td>
                            <td>NOME</td>
                            <td>EMAIL</td>
                            <td>UF</td>
                            <td>CIDADE</td>
                            <td>DETALHAR</td>
                            <td>REMOVER</td>
                        </tr>
                        <c:forEach var="clinica" items="${listaClinica.listarClinica()}">
                            <tr class="row">
                                <td>${clinica.cnpj}</td>
                                <td>${clinica.nome}</td>
                                <td>${clinica.email}</td>
                                <td>${clinica.enderecoClinica.estado}</td>
                                <td>${clinica.enderecoClinica.cidade}</td>
                                <td>
                                    <a class="btn btn-primary btn-block" href="Controller?command=ExibirClinica&cnpj=${clinica.cnpj}">Detalhar</a>
                                </td>
                                <td>
                                    <a class="btn btn-danger btn-block" href="Controller?command=RemoverClinica&cnpj=${clinica.cnpj}">Remover</a>
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
