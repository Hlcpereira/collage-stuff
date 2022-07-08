<%-- 
    Document   : form_create_pessoa
    Created on : 3 de jun de 2022, 18:48:29
    Author     : henrique
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"
        import="java.util.*"
        import="ifc.edu.br.mv9hib2.model.Tecnico"
        %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar tecnico</title>
    </head>
    <body>
        <h1>Cadastrar tecnico</h1>

        <form action="PessoaController?op=post" method="post">
            Nome: <input type="text" name="nome"> <br>
            CPF: <input type="text" name="cpf"> <br>
            Email: <input type="text" name="email"> <br>
            Telefone: <input type="text" name="telefone"> <br>
            </select><br>
            <input type="submit" value="Cadastrar">
        </form>
    </body>
</html>
