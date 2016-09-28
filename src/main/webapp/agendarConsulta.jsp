<%-- 
    Document   : agendarConsulta
    Created on : 28/08/2016, 11:16:01
    Author     : Edilva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="listaMedicos" class="br.edu.ifpb.padroes.projeto.modelo.ListarBo" scope="page"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src='http://code.jquery.com/jquery-2.1.3.min.js'></script>
        <script src='//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js'></script>
        <script src="js/jquery.maskedinput.min.js" type="text/javascript"></script>
        <script src="js/funcoes.js"></script>
        <script src="js/jquery.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div><jsp:include page="paginaDoAtendente.jsp"/></div>
        <div class="container text-center">
            <h1>Dados do Agendamento</h1>
            <br>
        </div>
        <div class="container" style="width:45%">
            <div class="row">
                <form method="post" id="cadastroFuncionario" action="Controller?command=CadastrarConsulta&cpfPac=${requestScope.cpfPac}" name="formConsulta">
                    <div class="form-group col-md-6">
                        <label for="data">Data: </label>
                        <input type="date" class="form-control" name="data" id="data" autofocus required>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="hora">Hora: </label>
                        <input type="text" class="form-control" name="hora" id="hora" required>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="medico">Médico: </label>
                        <select class="form-control" name="medico" id="medico">
                            <c:forEach var="medico" items="${listaMedicos.listarMedico()}">
                                <option value="${medico.cpf}">${medico.nome}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="valor">Valor: </label>
                        <input type="text" class="form-control" name="valor" id="valor" required>
                    </div>
                    <div class="form-group col-md-4">
                        <input id="btnCadastrar" type="submit" value="Agendar" class="btn btn-primary btn-block">
                    </div>
                </form>
            </div>
        </div>
        <script src="js/jquery.min.js"></script>
 	<script src="js/bootstrap.min.js"></script>
        <script src="js/funcoes.js"></script>
    </body>
</html>
