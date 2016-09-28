<%-- 
    Document   : loginMedico
    Created on : 26/09/2016, 07:45:03
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
        <div><jsp:include page="index.html"/></div>
        <div class="container text-center">
            <h2>Login</h2>
            <br>
        </div>
        <div class="container" style="width:30%">
            <div class="row">
                <form method="post" id="login" action="Controller?command=LogarMedico">
                    <div class="form-group col-md-12">
                        <label for="matricula">Matricula</label>
                        <input type="text" class="form-control" name="matricula" id="email" required>
                    </div>
                    <div class="form-group col-md-12">
                        <label for="senha">Senha</label>
                        <input type="password" class="form-control" name="senha" id="senha" required>
                    </div>
                    <div class="form-group col-md-12">
                        <input id="btnCadastrar" type="submit" value="Entrar" class="btn btn-primary btn-block">
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
