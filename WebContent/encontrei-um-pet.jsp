<%@ include file="includes/header.jsp"%>

<!-- MEnu Principal -->

<%@ include file="includes/menuPrincipal.jsp"%>

<!-- FIM do MEnu Principal -->

<div class="container">
	<div class="row" >


		<div class="col-md-8 col-lg-8 semiTitulo">
			<h2 class="laranja">ENCONTREI UM PET</h2>
			<br>
			<p>Caso você encontre qualquer animal que possua a tag do
				PetGoHome, basta digitar o código que está no pingente, no campo
				abaixo, ou fazer a leitura do QRCode, com qualquer dispositivo que
				possua um leitor de tags, obter os dados do proprietário, e entrar
				em contato diretamente.</p>

			<form method="post" action="Busca-Tag.pet">
				<p class="semiTitulo">Por favor digite no campo abaixo o número
					da TAG do Pet.</p>
					<br>
					<div class="input-group">
						<input type="text" class="form-control"
							id="appendedInputButton" name="numeroTag"
						autofocus type="text" placeholder="Digite sua TAG - Ex.: A1B0001"
						required="required"> <span
							class="input-group-btn">
							<button class="btn btn-default" type="button">Enviar Tag!</button>
						</span>
					</div>
					<!-- /input-group -->

			</form>
		</div>

		<div class="col-md-4 col-lg-4 semiTitulo" align="center">
			<a id="example1" href="img/TAG.png"><img style="width: 50%"
				alt="Clique para ampliar" src="img/TAG.png"><br> <span
				class="label label-info">Exemplo da TAG</span></a>
		</div>

	</div>

</div>
<br>
<%@ include file="includes/footer.jsp"%>