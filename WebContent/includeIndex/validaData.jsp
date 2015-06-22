<script>

function moveWindow (){window.location.hash="#msgSenhaErrada";} // Move a pagina para a Ancora do Alerta.
function mudarCor(){
	$('#day').css("background-color", "rgb(180, 238, 180)");
	$('#day').css("border-color", "rgb(0, 192, 96)");
	$('#day').addClass("animated rubberBand");
	$('#month').css("background-color", "rgb(180, 238, 180)");
	$('#month').css("border-color", "rgb(0, 192, 96)");
	$('#month').addClass("animated rubberBand");
	$('#Enviar').html('Enviar').prop('disabled', false); 
	}

function validarData(){

	day = document.chavez.day.value;
	month = document.chavez.month.value;

 
	if (day == 01 && month == 01 || day == 02 && month == 01 || day == 03 && month == 01 || day == 04 && month == 01 || day == 05 && month == 01 || day == 06 && month == 01 || day == 07 && month == 01 || day == 08 && month == 01 || day == 09 && month == 01 || day == 10 && month == 01 || day == 11 && month == 01 || day == 12 && month == 01 || day == 13 && month == 01 || day == 14 && month == 01 || day == 15 && month == 01 || day == 16 && month == 01 || day == 17 && month == 01 || day == 18 && month == 01 || day == 19 && month == 01 || day == 20 && month == 01 || day == 21 && month == 01 || day == 22 && month == 01 || day == 23 && month == 01 || day == 24 && month == 01 || day == 25 && month == 01 || day == 26 && month == 01 || day == 27 && month == 01 || day == 28 && month == 01 || day == 29 && month == 01 || day == 30 && month == 01 || day == 31 && month == 01){
		mudarCor();
	}
	if (day == 01 && month == 02 || day == 02 && month == 02 || day == 03 && month == 02 || day == 04 && month == 02 || day == 05 && month == 02 || day == 06 && month == 02 || day == 07 && month == 02 || day == 08 && month == 02 || day == 09 && month == 02 || day == 10 && month == 02 || day == 11 && month == 02 || day == 12 && month == 02 || day == 13 && month == 02 || day == 14 && month == 02 || day == 15 && month == 02 || day == 16 && month == 02 || day == 17 && month == 02 || day == 18 && month == 02 || day == 19 && month == 02 || day == 20 && month == 02 || day == 21 && month == 02 || day == 22 && month == 02 || day == 23 && month == 02 || day == 24 && month == 02 || day == 25 && month == 02 || day == 26 && month == 02 || day == 27 && month == 02 || day == 28 && month == 02){
		mudarCor(); 
	}
	if (day == 01 && month == 03 || day == 02 && month == 03 || day == 03 && month == 03 || day == 04 && month == 03 || day == 05 && month == 03 || day == 06 && month == 03 || day == 07 && month == 03 || day == 08 && month == 03 || day == 09 && month == 03 || day == 10 && month == 03 || day == 11 && month == 03 || day == 12 && month == 03 || day == 13 && month == 03 || day == 14 && month == 03 || day == 15 && month == 03 || day == 16 && month == 03 || day == 17 && month == 03 || day == 18 && month == 03 || day == 19 && month == 03 || day == 20 && month == 03 || day == 21 && month == 03 || day == 22 && month == 03 || day == 23 && month == 03 || day == 24 && month == 03 || day == 25 && month == 03 || day == 26 && month == 03 || day == 27 && month == 03 || day == 28 && month == 03 || day == 29 && month == 03 || day == 30 && month == 03 || day == 31 && month == 03){
		mudarCor();
	}
	if (day == 01 && month == 04 || day == 02 && month == 04 || day == 03 && month == 04 || day == 04 && month == 04 || day == 05 && month == 04 || day == 06 && month == 04 || day == 07 && month == 04 || day == 08 && month == 04 || day == 09 && month == 04 || day == 10 && month == 04 || day == 11 && month == 04 || day == 12 && month == 04 || day == 13 && month == 04 || day == 14 && month == 04 || day == 15 && month == 04 || day == 16 && month == 04 || day == 17 && month == 04 || day == 18 && month == 04 || day == 19 && month == 04 || day == 20 && month == 04 || day == 21 && month == 04 || day == 22 && month == 04 || day == 23 && month == 04 || day == 24 && month == 04 || day == 25 && month == 04 || day == 26 && month == 04 || day == 27 && month == 04 || day == 28 && month == 04 || day == 29 && month == 04 || day == 30 && month == 04){
		mudarCor();
	}
	if (day == 01 && month == 05 || day == 02 && month == 05 || day == 03 && month == 05 || day == 04 && month == 05 || day == 05 && month == 05 || day == 06 && month == 05 || day == 07 && month == 05 || day == 08 && month == 05 || day == 09 && month == 05 || day == 10 && month == 05 || day == 11 && month == 05 || day == 12 && month == 05 || day == 13 && month == 05 || day == 14 && month == 05 || day == 15 && month == 05 || day == 16 && month == 05 || day == 17 && month == 05 || day == 18 && month == 05 || day == 19 && month == 05 || day == 20 && month == 05 || day == 21 && month == 05 || day == 22 && month == 05 || day == 23 && month == 05 || day == 24 && month == 05 || day == 25 && month == 05 || day == 26 && month == 05 || day == 27 && month == 05 || day == 28 && month == 05 || day == 29 && month == 05 || day == 30 && month == 05 || day == 31 && month == 05){
		mudarCor();
	}
	if (day == 01 && month == 06 || day == 02 && month == 06 || day == 03 && month == 06 || day == 04 && month == 06 || day == 05 && month == 06 || day == 06 && month == 06 || day == 07 && month == 06 || day == 08 && month == 06 || day == 09 && month == 06 || day == 10 && month == 06 || day == 11 && month == 06 || day == 12 && month == 06 || day == 13 && month == 06 || day == 14 && month == 06 || day == 15 && month == 06 || day == 16 && month == 06 || day == 17 && month == 06 || day == 18 && month == 06 || day == 19 && month == 06 || day == 20 && month == 06 || day == 21 && month == 06 || day == 22 && month == 06 || day == 23 && month == 06 || day == 24 && month == 06 || day == 25 && month == 06 || day == 26 && month == 06 || day == 27 && month == 06 || day == 28 && month == 06 || day == 29 && month == 06 || day == 30 && month == 06){
		mudarCor();
	}
	if (day == 01 && month == 07 || day == 02 && month == 07 || day == 03 && month == 07 || day == 04 && month == 07 || day == 05 && month == 07 || day == 06 && month == 07 || day == 07 && month == 07 || day == 08 && month == 07 || day == 09 && month == 07 || day == 10 && month == 07 || day == 11 && month == 07 || day == 12 && month == 07 || day == 13 && month == 07 || day == 14 && month == 07 || day == 15 && month == 07 || day == 16 && month == 07 || day == 17 && month == 07 || day == 18 && month == 07 || day == 19 && month == 07 || day == 20 && month == 07 || day == 21 && month == 07 || day == 22 && month == 07 || day == 23 && month == 07 || day == 24 && month == 07 || day == 25 && month == 07 || day == 26 && month == 07 || day == 27 && month == 07 || day == 28 && month == 07 || day == 29 && month == 07 || day == 30 && month == 07 || day == 31 && month == 07){
		mudarCor(); 
	}
	if (day == 01 && month == 08 || day == 02 && month == 08 || day == 03 && month == 08 || day == 04 && month == 08 || day == 05 && month == 08 || day == 06 && month == 08 || day == 07 && month == 08 || day == 08 && month == 08 || day == 09 && month == 08 || day == 10 && month == 08 || day == 11 && month == 08 || day == 12 && month == 08 || day == 13 && month == 08 || day == 14 && month == 08 || day == 15 && month == 08 || day == 16 && month == 08 || day == 17 && month == 08 || day == 18 && month == 08 || day == 19 && month == 08 || day == 20 && month == 08 || day == 21 && month == 08 || day == 22 && month == 08 || day == 23 && month == 08 || day == 24 && month == 08 || day == 25 && month == 08 || day == 26 && month == 08 || day == 27 && month == 08 || day == 28 && month == 08 || day == 29 && month == 08 || day == 30 && month == 08 || day == 31 && month == 08){
		mudarCor(); 
	}
	if (day == 01 && month == 09 || day == 02 && month == 09 || day == 03 && month == 09 || day == 04 && month == 09 || day == 05 && month == 09 || day == 06 && month == 09 || day == 07 && month == 09 || day == 08 && month == 09 || day == 09 && month == 09 || day == 10 && month == 09 || day == 11 && month == 09 || day == 12 && month == 09 || day == 13 && month == 09 || day == 14 && month == 09 || day == 15 && month == 09 || day == 16 && month == 09 || day == 17 && month == 09 || day == 18 && month == 09 || day == 19 && month == 09 || day == 20 && month == 09 || day == 21 && month == 09 || day == 22 && month == 09 || day == 23 && month == 09 || day == 24 && month == 09 || day == 25 && month == 09 || day == 26 && month == 09 || day == 27 && month == 09 || day == 28 && month == 09 || day == 29 && month == 09 || day == 30 && month == 09){
		mudarCor(); 
	}
	if (day == 01 && month == 10 || day == 02 && month == 10 || day == 03 && month == 10 || day == 04 && month == 10 || day == 05 && month == 10 || day == 06 && month == 10 || day == 07 && month == 10 || day == 08 && month == 10 || day == 09 && month == 10 || day == 10 && month == 10 || day == 11 && month == 10 || day == 12 && month == 10 || day == 13 && month == 10 || day == 14 && month == 10 || day == 15 && month == 10 || day == 16 && month == 10 || day == 17 && month == 10 || day == 18 && month == 10 || day == 19 && month == 10 || day == 20 && month == 10 || day == 21 && month == 10 || day == 22 && month == 10 || day == 23 && month == 10 || day == 24 && month == 10 || day == 25 && month == 10 || day == 26 && month == 10 || day == 27 && month == 10 || day == 28 && month == 10 || day == 29 && month == 10 || day == 30 && month == 10 || day == 31 && month == 10){
		mudarCor();
	}
	if (day == 01 && month == 11 || day == 02 && month == 11 || day == 03 && month == 11 || day == 04 && month == 11 || day == 05 && month == 11 || day == 06 && month == 11 || day == 07 && month == 11 || day == 08 && month == 11 || day == 09 && month == 11 || day == 10 && month == 11 || day == 11 && month == 11 || day == 12 && month == 11 || day == 13 && month == 11 || day == 14 && month == 11 || day == 15 && month == 11 || day == 16 && month == 11 || day == 17 && month == 11 || day == 18 && month == 11 || day == 19 && month == 11 || day == 20 && month == 11 || day == 21 && month == 11 || day == 22 && month == 11 || day == 23 && month == 11 || day == 24 && month == 11 || day == 25 && month == 11 || day == 26 && month == 11 || day == 27 && month == 11 || day == 28 && month == 11 || day == 29 && month == 11 || day == 30 && month == 11){
		mudarCor();
	}
	if (day == 01 && month == 12 || day == 02 && month == 12 || day == 03 && month == 12 || day == 04 && month == 12 || day == 05 && month == 12 || day == 06 && month == 12 || day == 07 && month == 12 || day == 08 && month == 12 || day == 09 && month == 12 || day == 10 && month == 12 || day == 11 && month == 12 || day == 12 && month == 12 || day == 13 && month == 12 || day == 14 && month == 12 || day == 15 && month == 12 || day == 16 && month == 12 || day == 17 && month == 12 || day == 18 && month == 12 || day == 19 && month == 12 || day == 20 && month == 12 || day == 21 && month == 12 || day == 22 && month == 12 || day == 23 && month == 12 || day == 24 && month == 12 || day == 25 && month == 12 || day == 26 && month == 12 || day == 27 && month == 12 || day == 28 && month == 12 || day == 29 && month == 12 || day == 30 && month == 12 || day == 31 && month == 12){
		mudarCor();
	}


	//Em caso de data inexistente, abre aqui
	if (day == 30 && month == 02 || day == 31 && month == 02 || day == 31 && month == 04 || day == 31 && month == 06 || day == 31 && month == 08 || day == 31 && month == 10 || day == 31 && month == 11){
		$('#msgSenhaErrada').html("<div style='width:50%' align='center' class='alert alert-warning'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Data inválida.</h5></div>").prop('disabled', false);
		
		setTimeout(function() {
			jQuery('#msgSenhaErrada').show()
			moveWindow(); // Move a pagina para a Ancora do Alerta.
		});
		setTimeout(function() {
			jQuery('#msgSenhaErrada').hide("slow"); }, 5000);
		$('#day').css("background-color", "#FFF2A8");
		$('#day').css("border-color", "#EBC26A");
		$('#day').addClass("animated rubberBand");
		$('#month').css("background-color", "#FFF2A8");
		$('#month').css("border-color", "#EBC26A");
		$('#month').addClass("animated rubberBand");
		$('#Enviar').html('Enviar').prop('disabled', true);
		
	}
	
}

function validarAno(){

	year = document.chavez.year.value;

	if (year != null && day != 30 && month != 02 || day != 31 && month != 02 || day != 31 && month != 04 || day != 31 && month != 06 || day != 31 && month != 08 || day != 31 && month != 10 || day != 31 && month != 11){
			$('#year').css("background-color", "rgb(180, 238, 180)");
			$('#year').css("border-color", "rgb(0, 192, 96)");
			$('#year').addClass("animated rubberBand");
			$('#Enviar').html('Enviar').prop('disabled', false);
			
	}
	validarData();

	
}

</script>