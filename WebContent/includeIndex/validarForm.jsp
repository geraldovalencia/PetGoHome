<script>

function validarCPF(){
	cpf = document.chavez.cpf.value;
	
	if(cpf == null || cpf == ""){
		$('#cpf').css("background-color", "#ffb7c5");
		$('#cpf').css("border-color", "#ff7373");
		$('#spanValida').html("<span class='laranja'><strong>* O CPF deve ser preenchido. </strong></span>").prop('disabled', false);
		setTimeout(function() {
			jQuery('#spanValida').hide("slow"); }, 8000);
	}
}

function validarSenha(){
	senha = document.chavez.senha.value;
	senha2 = document.chavez.senha2.value;
	nome = document.chavez.nome.value;

	
 
	if (senha == senha2){

		if(senha == "" && senha2 == ""){
			$('#msgSenhaErrada').html("<div style='width:50%' align='center' class='alert alert-warning'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>É obrigatório preencher as senhas.</h5></div>").prop('disabled', false);
			$('#senha').css("background-color", "#FFF2A8");
			$('#senha2').css("background-color", "#FFF2A8");
			$('#senha').css("border-color", "#EBC26A");
			$('#senha2').css("border-color", "#EBC26A");
			setTimeout(function() {
				jQuery('#msgSenhaErrada').show();
			});
			//alert("SENHAS DIFERENTES");
			setTimeout(function() {
					jQuery('#msgSenhaErrada').hide("slow"); }, 5000);
			}else{
				//alert("SENHAS IGUAIS");
				/*Faz o submit do form*/
				//  document.chavez.submit();
				$('#senha').css("background-color", "#b4eeb4");
				$('#senha2').css("background-color", "#b4eeb4");
				$('#senha').css("border-color", "#00c060");
				$('#senha2').css("border-color", "#00c060");
				$('#Enviar').html('Enviar').prop('disabled', false); 
				}
		
	}else{
		/*desabilita o Botão do form*/
		$('#senha2').css("background-color", "#ffb7c5");
		$('#senha2').css("border-color", "#ff7373");
		$('#Enviar').html('Redigite as senhas').prop('disabled', true);
		$('#msgSenhaErrada').html("<div style='width:50%' align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Senhas com valores diferentes. Redigite, Por favor.</h5></div>").prop('disabled', false);
		setTimeout(function() {
			jQuery('#msgSenhaErrada').show();
		});
		//alert("SENHAS DIFERENTES");
		setTimeout(function() {
				jQuery('#msgSenhaErrada').hide("slow"); }, 5000);
		}
}

</script>