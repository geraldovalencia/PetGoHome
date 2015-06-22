
<script type="text/javascript" src="js/jquery.maskedinput.min.js"></script>
<script type="text/javascript">
	jQuery(function($) {
		$(".cpf").mask("999.999.999-99");
		$(".cnpj").mask("99.999.999/9999-99");
		$(".fonemask").mask("(99) 9999-9999");
		$(".cepmask").mask("99999-999");
		$(".pesomask").mask("99.99");
	});

	// 	$(document).ready(function() {
	// 		$("#cep").change(function() {
	// 			getEndereco($("#cep").val());

	// 			setTimeout(function() {
	// 				jQuery('#loadingCep').hide("slow"); }, 3000);
	// 		});
	// 	});
	
	setTimeout(function() {
				jQuery('#msgAlerta').hide("slow"); }, 5000);
</script>