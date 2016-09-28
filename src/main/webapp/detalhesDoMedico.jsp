<%-- 
    Document   : detalhesDoMedico
    Created on : 24/09/2016, 17:41:23
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
            <h1>Paciente</h1>
            <br>
        </div>
        <div class="container" style="width:95%">
            <div class="row">
                <div class="form-group">
                    <p><strong>CPF:</strong> ${medico.cpf}</p>
                    <p><strong>Matrícula:</strong> ${medico.matricula}</p>
                    <p><strong>Nome:</strong> ${medico.nome}</p>
                    <p><strong>RG:</strong> ${medico.rg}</p>
                    <p><strong>Data de Nascimento:</strong> ${medico.dataNasc}</p>
                    <p><strong>Email:</strong> ${medico.email}</p>
                    <p><strong>CRM:</strong> ${medico.crm}</p>
                    <p><strong>Especialidade:</strong> ${medico.especialidade}</p>
                    <p><strong>Endereço</strong></p>
                    <p><strong>UF:</strong> ${medico.endereco.estado}</p>
                    <p><strong>Cidade:</strong> ${medico.endereco.cidade}</p>
                    <p><strong>Bairro:</strong> ${medico.endereco.bairro}</p>
                    <p><strong>Rua:</strong> ${medico.endereco.rua}</p>
                    <p><strong>Número:</strong> ${medico.endereco.numero}</p>
                    <p>
                        <strong>Telefones:</strong><br>
                        <c:forEach var="tel" items="${medico.telefones}">
                            ${tel}<br>
                        </c:forEach>
                    </p> 
                    <div class="col-md-12 text-center">
                        <a class="btn btn-primary" href="listaDeMedicos.jsp">Voltar</a>
                        <a class="btn btn-danger" href="Controller?command=RemoverMedico&cpf=${paciente.cpf}">Excluir</a>
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
