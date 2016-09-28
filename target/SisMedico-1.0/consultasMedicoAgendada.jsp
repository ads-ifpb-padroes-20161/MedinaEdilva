<%-- 
    Document   : consultasMedicoAgendada
    Created on : 27/09/2016, 19:41:53
    Author     : Edilva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.edu.ifpb.padroes.projeto.entidades.StatusConsulta" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="listaConsulta" class="br.edu.ifpb.padroes.projeto.dao.ConsultaDao" scope="page"/>
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
        <div><jsp:include page="paginaDoMedico.jsp"/></div>
        <div class="container text-center">
            <h1>Consultas</h1>
            <br>
        </div>
        <div class="container" style="width:95%">
            <div class="row">
                <div class="form-group col-md-12">
                    <table class="table table-striped">
                        <tr class="row">
                            <td>DATA</td>
                            <td>HORA</td>
                            <td>CPF DO PACIENTE</td>
                            <td>NOME DO PACIENTE</td>
                            <td>MEDICO</td>
                            <td>VALOR</td>
                            <td>STATUS</td>
                            <td>REALIZAR CONSULTA</td>
                        </tr>
                        <c:forEach var="consulta" items="${listaConsulta.buscarTodos()}">
                            <c:set var="statusConsulta" value="<%=StatusConsulta.AGENDADA %>"/>
                            <c:if test="${statusConsulta == consulta.status and consulta.medico == sessionScope.medico}">
                                <tr class="row">
                                    <td>${consulta.data}</td>
                                    <td>${consulta.hora}</td>
                                    <td>${consulta.paciente.cpf}</td>
                                    <td>${consulta.paciente.nome}</td>
                                    <td>${consulta.medico.nome}</td>
                                    <td>${consulta.valor}</td>
                                    <td>${consulta.status}</td>
                                    <td><a class="btn btn-success btn-block" href="Controller?command=RealizarConsulta&id=${consulta.id}">Realizar</a></td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </table>
                </div>    
            </div>
        </div>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/funcoes.js"></script>
    </body>
