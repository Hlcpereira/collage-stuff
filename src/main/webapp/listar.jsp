<%-- 
    Document   : listar.jsp
    Created on : Mar 18, 2022, 5:32:43 AM
    Author     : friend
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"
        import="java.util.*"
        import="ifc.edu.br.mv9hib2.model.Pessoa" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listagem de pessoas</h1>
        <%
            
        // goncalves2007, pg 420
        ArrayList<Pessoa> registros = (ArrayList<Pessoa>) request.getAttribute("registros");
                 
        for (Pessoa i : registros) {
        
        %>

        <%= i.getId() %>, <%= i.getNome() %>, 
        <%= i.getEmail() %>, <%= i.getPeso() %> 
        
        <a href="PessoaController?op=d&q=<%= i.getId() %>">remover</a> | 
        <a href="PessoaController?op=r&q=<%= i.getId() %>">exibir</a> | 
        <a href="PessoaController?op=a&q=<%= i.getId() %>">atualizar</a> <br>

        <%
            }
        %>

        Fim da listagem

    </body>
</html>
