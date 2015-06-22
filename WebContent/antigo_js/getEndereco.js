function getEndereco(cep) {
    if($.trim(cep) != ""){
        $("#loadingCep").html("<span id='loadingCep'  style='display: block;' class='label label-info'>  Pesquisando ...</span>");
        $.getScript("http://cep.republicavirtual.com.br/web_cep.php?formato=javascript&cep="+cep, function(){            
            if (resultadoCEP["resultado"] != 0) {
                $("#cidade").val(unescape(resultadoCEP["cidade"]));
                $("#estado").val(unescape(resultadoCEP["uf"]));
                $("#bairro").val(unescape(resultadoCEP["bairro"]));
                $("#rua").val(unescape(resultadoCEP["tipo_logradouro"] + " " + resultadoCEP["logradouro"]));
                $('#loadingCep').html("<span id='loadingCep'  style='display: block;' class='label label-info'>  CEP Encontrado.</span>");
                
            }else{
                $("#loadingCep").html(unescape(resultadoCEP["resultado_txt"]));                
            }            
        });
    }
    else{
        $("#loadingCep").html('Informe o CEP');
    }
}