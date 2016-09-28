<%-- 
    Document   : detalhesDaClinica
    Created on : 24/09/2016, 10:18:10
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
            <h1>Clínica</h1>
            <br>
        </div>
        <div class="container" style="width:95%">
            <div class="row">
                <div class="form-group">
                    <p><strong>CNPJ:</strong> ${clinica.cnpj}</p>
                    <p><strong>Nome:</strong> ${clinica.nome}</p>
                    <p><strong>Email:</strong> ${clinica.email}</p>
                    <p><strong>Endereço</strong></p>
                    <p><strong>UF:</strong> ${clinica.enderecoClinica.estado}</p>
                    <p><strong>Cidade:</strong> ${clinica.enderecoClinica.cidade}</p>
                    <p><strong>Bairro:</strong> ${clinica.enderecoClinica.bairro}</p>
                    <p><strong>Rua:</strong> ${clinica.enderecoClinica.rua}</p>
                    <p><strong>Número:</strong> ${clinica.enderecoClinica.numero}</p>
                    <p>
                        <strong>Telefones:</strong><br>
                        <c:forEach var="tel" items="${clinica.telefones}">
                            ${tel}<br>
                        </c:forEach>
                    </p>  
                    <div class="col-md-12 text-center">
                        <a class="btn btn-primary" href="listaDeClinicas.jsp">Voltar</a>
                        <a class="btn btn-danger" href="Controller?command=RemoverClinica&cnpj=${clinica.cnpj}">Excluir</a>
                    </div>
                </div>
            </div>
        </div>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/funcoes.js"></script>
    </body>
</html>
