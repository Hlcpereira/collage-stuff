<%-- 
    Document   : form
    Created on : Mar 17, 2022, 3:09:25 PM
    Author     : friend
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"
        import="com.hlcpereira.ifc.av2.model.Tecnico"
        import="com.hlcpereira.ifc.av2.model.Nacionalidade"
        %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar pessoa</title>
    </head>
    <body>
        <h1>Editar pessoa</h1>
        <%
        Pessoa i = (Pessoa) request.getAttribute("alguem");
        %>

        <form action="PessoaController?op=put" method="post">
            Id: <input type="text" name="id" value="<%= i.getId() %>" readonly> <br>
            Nome: <input type="text" name="nome" value="<%= i.getNome() %>"> <br>
            Email: <input type="text" name="email" value="<%= i.getEmail() %>"> <br>
            Peso: <input type="text" name="peso" value="<%= i.getPeso() %>"> <br>
            Nacionalidade: <select name="nacionalidade">
            <%
            ArrayList<Nacionalidade> nacionalidades = (ArrayList<Nacionalidade>) request.getAttribute("nacionalidades");
            for(Nacionalidade j : nacionalidades) {
                Linha linhaLocal = linhas.get(i);
            %>
		<option value=<%=j.getId()%> <%if( i.getNacionalidade.getId() == j.getId()){%> selected <%}%> > <%=j.getNome();%> </option>																
            <%
                }
            %>
            </select><br>
            <input type="submit" value="Atualizar">
        </form>
    </body>
</html>
