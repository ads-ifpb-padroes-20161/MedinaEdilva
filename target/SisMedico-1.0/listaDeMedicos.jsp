<%-- 
    Document   : listaDeMedicos
    Created on : 29/08/2016, 08:36:18
    Author     : Edilva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="listaMedico" class="br.edu.ifpb.padroes.projeto.modelo.ListarBo" scope="page"/>
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
            <h1>Médicos</h1>
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
                            <td>CRM</td>
                            <td>ESPECIALIDADE</td>
                            <td>DETALHAR</td>
                            <td>REMOVER</td>
                        </tr>
                        <c:forEach var="medico" items="${listaMedico.listarMedico()}">
                            <tr class="row">
                                <td>${medico.cpf}</td>
                                <td>${medico.matricula}</td>
                                <td>${medico.nome}</td>
                                <td>${medico.rg}</td>
                                <td>${medico.dataNasc}</td>
                                <td>${medico.email}</td>
                                <td>${medico.crm}</td>
                                <td>${medico.especialidade}</td>
                                <td>
                                    <a class="btn btn-primary btn-block" href="Controller?command=ExibirMedico&cpf=${medico.cpf}">Detalhar</a>
                                </td>
                                <td>
                                    <a class="btn btn-danger btn-block" href="Controller?command=RemoverMedico&cpf=${medico.cpf}">Remover</a>
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
