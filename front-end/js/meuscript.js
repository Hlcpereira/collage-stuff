$(function() {

    function exibir_tecnicos() {
        $.ajax({
            url: 'http://localhost:5000/listar/Tecnico',
            method: 'GET',
            dataType: 'json',
            success: listar,
            error: function() {
                alert("erro ao ler dados, verifique o backend");
            }
        });
        function listar (tecnicos) {
            $('#corpoTabelaTecnicos').empty();
            mostrar_conteudo("tabelaTecnicos");
            for (var i in tecnicos) {
                lin = '<tr>' +
                '<td>' + tecnicos[i].nome + '</td>' + 
                '<td>' + tecnicos[i].email + '</td>' + 
                '<td>' + tecnicos[i].telefone + '</td>' + 
                '</tr>';
                $('#corpoTabelaTecnicos').append(lin);
            }
        }
    }

    function mostrar_conteudo(identificador) {
        $("#tabelaTecnicos").addClass('invisible');
        $("#conteudoInicial").addClass('invisible');
        $("#"+identificador).removeClass('invisible');      
    }

    $(document).on("click", "#linkListarTecnicos", function() {
        exibir_tecnicos();
    });

    $(document).on("click", "#linkInicio", function() {
        mostrar_conteudo("conteudoInicial");
    });

    $(document).on("click", "#btIncluirTecnico", function() {
        nome = $("#campoNome").val();
        email = $("#campoEmail").val();
        tel = $("#campoTelefone").val();
        var dados = JSON.stringify({ nome: nome, email: email, telefone: tel });
        $.ajax({
            url: 'http://localhost:5000/incluir/Tecnico',
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json',
            data: dados,
            success: tecnicoIncluido,
            error: erroAoIncluir
        });
        function tecnicoIncluido (retorno) {
            if (retorno.resultado == "ok") {
                alert("Tecnico incluída com sucesso!");
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

    $('#modalIncluirTecnico').on('hide.bs.modal', function (e) {
        if (! $("#tabelaTecnicos").hasClass('invisible')) {
            exibir_tecnicos();
        }
    });

    function exibir_manutencoes() {
        $.ajax({
            url: 'http://127.0.0.1:5000/listar/Manutencao',
            method: 'GET',
            dataType: 'json',
            success: listar,
            error: function() {
                alert("erro ao ler dados, verifique o backend");
            }
        });
        function listar (manutencoes) {
            $('#corpoTabelaManutencoes').empty();
            mostrar_conteudo("tabelaManutencoes");
            console.log(manutencoes)
            for (var i in manutencoes) {
                lin = '<tr>' +
                '<td>' + manutencoes[i].op_sys.type + '</td>' + 
                '<td>' + manutencoes[i].op_sys.versao + '</td>' + 
                '<td>' + manutencoes[i].op_sys.fornecedora + '</td>' +
                '<td>' + manutencoes[i].eletronico.marca + '</td>' + 
                '<td>' + manutencoes[i].eletronico.voltagen + '</td>' + 
                '<td>' + manutencoes[i].tecnico.nome + '</td>' + 
                '<td>' + manutencoes[i].tecnico.telefone + '</td>' + 
                '<td>' + manutencoes[i].tecnico.email + '</td>' + 
                '</tr>';
                $('#corpoTabelaManutencoes').append(lin);
            }
        }
    }

    $(document).on("click", "#linkListarManutencoes", function() {
        exibir_manutencoes();
    });

    $(document).on("click", "#linkInicio", function() {
        mostrar_conteudo("conteudoInicial");
    });

    $(document).on("click", "#btIncluirManutencao", function() {
        op_sys_id = $("#campoIdOpSys").val();
        eletronico_id = $("#campoIdEletronico").val();
        tecnico_id = $("#campoIdTecnico").val();
        var dados = JSON.stringify({ op_sys_id: op_sys_id, eletronico_id: eletronico_id, tecnico_id: tecnico_id });
        $.ajax({
            url: 'http://127.0.0.1:5000/incluir/Manutencao',
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json',
            data: dados,
            success: manutencaoIncluida,
            error: erroAoIncluir
        });
        function manutencaoIncluida (retorno) {
            if (retorno.resultado == "ok") {
                alert("Manutencao incluída com sucesso!");
                $("#campoIdOpSys").val("");
                $("#campoIdEletronico").val("");
                $("#campoIdTecnico").val("");
            } else {
                alert(retorno.resultado + ":" + retorno.detalhes);
            }            
        }
        function erroAoIncluir (retorno) {
            alert("ERRO: "+retorno.resultado + ":" + retorno.detalhes);
        }
    });

    $('#modalIncluirTecnico').on('hide.bs.modal', function (e) {
        if (! $("#tabelaTecnicos").hasClass('invisible')) {
            exibir_tecnicos();
        }
    });

    mostrar_conteudo("conteudoInicial");
});
