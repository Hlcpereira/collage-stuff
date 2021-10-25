$(function() {

    function exibir_pessoas() {
        $.ajax({
            url: 'http://localhost:5000/listar/Pessoa',
            method: 'GET',
            dataType: 'json',
            success: listar,
            error: function() {
                alert("erro ao ler dados, verifique o backend");
            }
        });
        function listar (pessoas) {
            $('#corpoTabelaPessoas').empty();
            mostrar_conteudo("tabelaPessoas");
            for (var i in pessoas) {
                lin = '<tr>' +
                '<td>' + pessoas[i].nome + '</td>' + 
                '<td>' + pessoas[i].email + '</td>' + 
                '<td>' + pessoas[i].telefone + '</td>' + 
                '</tr>';
                $('#corpoTabelaPessoas').append(lin);
            }
        }
    }

    function mostrar_conteudo(identificador) {
        $("#tabelaPessoas").addClass('invisible');
        $("#conteudoInicial").addClass('invisible');
        $("#"+identificador).removeClass('invisible');      
    }

    $(document).on("click", "#linkListarPessoas", function() {
        exibir_pessoas();
    });

    $(document).on("click", "#linkInicio", function() {
        mostrar_conteudo("conteudoInicial");
    });

    $(document).on("click", "#btIncluirPessoa", function() {
        nome = $("#campoNome").val();
        email = $("#campoEmail").val();
        tel = $("#campoTelefone").val();
        var dados = JSON.stringify({ nome: nome, email: email, telefone: tel });
        $.ajax({
            url: 'http://localhost:5000/incluir/Pessoa',
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json',
            data: dados,
            success: pessoaIncluida,
            error: erroAoIncluir
        });
        function pessoaIncluida (retorno) {
            if (retorno.resultado == "ok") {
                alert("Pessoa incluída com sucesso!");
                $("#campoNome").val("");
                $("#campoEmail").val("");
                $("#campoTelefone").val("");
            } else {
                alert(retorno.resultado + ":" + retorno.detalhes);
            }            
        }
        function erroAoIncluir (retorno) {
            alert("ERRO: "+retorno.resultado + ":" + retorno.detalhes);
        }
    });

    $('#modalIncluirPessoa').on('hide.bs.modal', function (e) {
        if (! $("#tabelaPessoas").hasClass('invisible')) {
            exibir_pessoas();
        }
    });

    mostrar_conteudo("conteudoInicial");
});
