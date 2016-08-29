<%-- 
    Document   : paginaDoAdministrador
    Created on : 26/08/2016, 17:29:02
    Author     : Edilva
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src='http://code.jquery.com/jquery-2.1.3.min.js'></script>
        <script src='//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js'></script>
        
        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container">

                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> 
                        <span class="sr-only">Toggle navigation</span> 
                    </button> 
                    <a class="navbar-brand" href="paginaDoAtendente.jsp">Medina - Atendente</a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="dropdown">
                            <a href="" class="dropdown-toggle" data-toggle="dropdown">Atendente</a>
                            <ul class="nav dropdown-menu">
                                <li><a href="cadastroAtendente.jsp">Cadastrar Atendente</a></li>
                                <li><a href="listaDeAtendentes.jsp">Listar Atendentes</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="" class="dropdown-toggle" data-toggle="dropdown">Médico</a>
                            <ul class="nav dropdown-menu">
                                <li><a href="cadastroMedico.jsp">Cadastrar Médico</a></li>
                                <li><a href="listaDeMedicos.jsp">Listar Médicos</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="" class="dropdown-toggle" data-toggle="dropdown">Paciente</a>
                            <ul class="nav dropdown-menu">
                                <li><a href="cadastroPaciente.jsp">Cadastrar Paciente</a></li>
                                <li><a href="listaDePacientes.jsp">Listar Pacientes</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="" class="dropdown-toggle" data-toggle="dropdown">Cliníca</a>
                            <ul class="nav dropdown-menu">
                                <li><a href="cadastroClinica.jsp">Cadastrar Clínica</a></li>
                                <li><a href="listarClinicas.jsp">Listar Clínicas</a></li>
                            </ul>
                        </li>
                        <li>
                            <a >Sair</a>
                        </li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container -->
        </nav>
        <br><br><br>
        <div><jsp:include page="footer.html"/></div>
    </body>
</html>
