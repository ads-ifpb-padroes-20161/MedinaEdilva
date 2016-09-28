<%-- 
    Document   : detalhesDaConsulta
    Created on : 27/09/2016, 19:55:35
    Author     : Edilva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            <h1>Dados da Consulta</h1>
            <br>
        </div>
        <div class="container" style="width:95%">
            <div class="row">
                <div class="form-group">
                    <p><strong>Data:</strong> ${consulta.data}</p>
                    <p><strong>Hora:</strong> ${consulta.hora}</p>
                    <p><strong>Valor:</strong> ${consulta.valor}</p>
                    <p><strong>Status:</strong> ${consulta.status}</p>
                    <h3>Paciente</h3>
                    <p><strong>CPF:</strong> ${consulta.paciente.cpf}</p>
                    <p><strong>Nome:</strong> ${consulta.paciente.nome}</p>
                    <p><strong>RG:</strong> ${consulta.paciente.rg}</p>
                    <p><strong>Data de Nascimento:</strong> ${consulta.paciente.dataNasc}</p>
                    <p><strong>Email:</strong> ${consulta.paciente.email}</p>
                    <p><strong>Endereço</strong></p>
                    <p><strong>UF:</strong> ${consulta.paciente.endereco.estado}</p>
                    <p><strong>Cidade:</strong> ${consulta.paciente.endereco.cidade}</p>
                    <p><strong>Bairro:</strong> ${consulta.paciente.endereco.bairro}</p>
                    <p><strong>Rua:</strong> ${consulta.paciente.endereco.rua}</p>
                    <p><strong>Número:</strong> ${consulta.paciente.endereco.numero}</p>
                    <p>
                        <strong>Telefones:</strong><br>
                        <c:forEach var="tel" items="${consulta.paciente.telefones}">
                            ${tel}<br>
                        </c:forEach>
                    </p>
                    <h3>Médico</h3>
                    <p><strong>Nome:</strong> ${consulta.medico.nome}</p>
                    <p><strong>CRM:</strong> ${consulta.medico.crm}</p>
                    <p><strong>Especialidade:</strong> ${consulta.medico.especialidade}</p>
                    <div class="col-md-12 text-center">
                        <a class="btn btn-primary" href="listaDeConsultas.jsp">Voltar</a>
                    </div>
                </div>
            </div>
        </div>
        <br>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/funcoes.js"></script>
    </body>
</html>
