<%-- 
    Document   : listar.jsp
    Created on : 29 de abr de 2022, 19:29:43
    Author     : henrique
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"
        import="java.util.*"
        import="modelo.Company"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de registros</title>
    </head>
    <body>
        <h1>Lista czynot?</h1>
        <% 
            ArrayList<Company> ListaCompanias = (ArrayList<Company>) request.getAttribute("lista");
        %>
        <% for (Company compania : ListaCompanias) { %>
            <h3>Empresa</h3>
            <p><b>Nome:</b></p><p><%= compania.nome %></p>
            <p><b>Site:</b></p><p><%= compania.dominio %></p>
            <p><b>Industria:</b></p><p><%= compania.industria %></p>
            <p><b>Localização:</b></p><p><%= compania.localizacao %></p>
            <p><b>Pais:</b></p><p><%= compania.pais %></p>
            <p><b>Empregados:</b></p><p><%= compania.empregados_atual %></p>
            </br>
        <% } %>
    </body>
</html>
