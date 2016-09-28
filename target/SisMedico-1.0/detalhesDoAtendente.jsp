<%-- 
    Document   : detalhesDoAtendente
    Created on : 24/09/2016, 17:24:46
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
            <h1>Atendente</h1>
            <br>
        </div>
        <div class="container" style="width:95%">
            <div class="row">
                <div class="form-group">
                    <p><strong>CPF:</strong> ${atendente.cpf}</p>
                    <p><strong>Matrícula:</strong> ${atendente.matricula}</p>
                    <p><strong>Nome:</strong> ${atendente.nome}</p>
                    <p><strong>RG:</strong> ${atendente.rg}</p>
                    <p><strong>Data de Nascimento:</strong> ${atendente.dataNasc}</p>
                    <p><strong>Email:</strong> ${atendente.email}</p>
                    <p><strong>Endereço</strong></p>
                    <p><strong>UF:</strong> ${atendente.endereco.estado}</p>
                    <p><strong>Cidade:</strong> ${atendente.endereco.cidade}</p>
                    <p><strong>Bairro:</strong> ${atendente.endereco.bairro}</p>
                    <p><strong>Rua:</strong> ${atendente.endereco.rua}</p>
                    <p><strong>Número:</strong> ${atendente.endereco.numero}</p>
                    <p>
                        <strong>Telefones:</strong><br>
                        <c:forEach var="tel" items="${atendente.telefones}">
                            ${tel}<br>
                        </c:forEach>
                    </p> 
                    <div class="col-md-12 text-center">
                        <a class="btn btn-primary" href="listaDeAtendentes.jsp">Voltar</a>
                        <a class="btn btn-danger" href="Controller?command=RemoverPaciente&cpf=${paciente.cpf}">Excluir</a>
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