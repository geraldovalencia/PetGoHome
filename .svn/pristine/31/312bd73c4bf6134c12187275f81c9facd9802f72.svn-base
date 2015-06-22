<script type="text/javascript" >
    function validarCPF(){
    	cpf = document.chavez.cpf.value;
     

    		if(cpf == ""){
    			$('#msgSenhaErrada').html("<div style='width:50%' align='center' class='alert alert-warning'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Digite o seu CPF.</h5></div>").prop('disabled', false);
    			$('#cpf').css("background-color", "#FFF2A8");
    			$('#cpf').css("border-color", "#EBC26A");
    			$('#vazio').css("display", "block");
    			$('#vazio').addClass("animated rubberBand");
    			$('#errinho').css("display", "none");
    			setTimeout(function() {
    				jQuery('#msgSenhaErrada').show();
    			});
    			//alert("SENHAS DIFERENTES");
    			setTimeout(function() {
    					jQuery('#msgSenhaErrada').hide("slow"); }, 5000);
    			}else{
    				//  document.chavez.submit();
    				$('#cpf').css("background-color", "#b4eeb4");
    				$('#cpf').css("border-color", "#00c060");
    				$('#Enviar').html('Enviar').prop('disabled', false); 
    				}
    		
    }


    </script>