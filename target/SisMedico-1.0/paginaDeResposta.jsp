<%-- 
    Document   : paginaDeResposta
    Created on : 26/08/2016, 17:26:55
    Author     : Edilva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <jsp:include page="paginaDoAtendente.jsp"/>
            <div class="container text-center">
                <h3>${mensagem}</h3>
                <div class="col-md-12 text-center">
                    <a href="${pagina}" class="btn btn-primary">Voltar</a>
                </div>
            </div>
        </div>
    </body>
</html>
