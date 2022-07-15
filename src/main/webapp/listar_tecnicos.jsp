<%-- 
    Document   : listar.jsp
    Created on : Mar 18, 2022, 5:32:43 AM
    Author     : friend
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"
        import="java.util.*"
        import="com.hlcpereira.ifc.av2.model.Tecnico" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listagem de pessoas</h1>
        <%
        ArrayList<Tecnico> registros = (ArrayList<Tecnico>) request.getAttribute("registros");
                 
        for (Tecnico i : registros) {
        
        %>

        <%= i.getId() %>, <%= i.getNome() %>, 
        <%= i.getEmail() %>, <%= i.getCpf() %>
        <br>

        <%
            }
        %>

        Fim da listagem

    </body>
</html>
