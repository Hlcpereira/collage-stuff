<%-- 
    Document   : form_create_pessoa
    Created on : 3 de jun de 2022, 18:48:29
    Author     : henrique
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"
        import="java.util.*"
        import="com.hlcpereira.ifc.av2.model.Eletronico"
        import="com.hlcpereira.ifc.av2.model.OpSys"
        import="com.hlcpereira.ifc.av2.model.Tecnico"
        %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar tecnico</title>
    </head>
    <body>
        <h1>Cadastrar manutenção</h1>

        <form action="ManutencaoController?op=post" method="post">
            Eletronico: <select name="eletronico">
            <%
            ArrayList<Eletronico> eletronicos = (ArrayList<Eletronico>) request.getAttribute("eletronicos");
            for(Eletronico j : eletronicos) {
            %>
		<option value=<%=j.getId()%>> <%=j.getNome()%> </option>																
            <%
                }
            %>
            Sistema Operacional: <select name="op_sys">
            <%
            ArrayList<OpSys> op_systems = (ArrayList<OpSys>) request.getAttribute("op_systems");
            for(OpSys j : op_systems) {
            %>
		<option value=<%=j.getId()%>> <%=j.getNome()%> </option>																
            <%
                }
            %>
            Tecnico: <select name="tecnico">
            <%
            ArrayList<Tecnico> tecnicos = (ArrayList<Tecnico>) request.getAttribute("tecnicos");
            for(Tecnico j : tecnicos) {
            %>
		<option value=<%=j.getId()%>> <%=j.getNome()%> </option>																
            <%
                }
            %>
            </select><br>
            <input type="submit" value="Cadastrar">
        </form>
    </body>
</html>
