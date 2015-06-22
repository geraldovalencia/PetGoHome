<%@ include file="../../includeAdm/topo.jsp"%>
<script type="text/javascript" src="antigo_js/jquery.js"></script>
<%@ include file="../../../includes/MascarasJS.jsp"%>
<%-- <%@ include file="../../../includeIndex/validarForm.jsp"%> --%>
<script>
function validarSenha(){
	senha = document.chavez.senha.value;
	senha2 = document.chavez.senha2.value;
 
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




<%@ include file="../../../includeIndex/buscarCep.jsp"%>
<%@ include file="../../includeAdm/menuADM.jsp"%>

<%@ include file="../../includeAdm/menuLateral.jsp"%>
<%@ include file="../../includeAdm/mensagens.jsp"%>




<!-- Content Header (Page header) -->
<section class="content-header">
	<h1>
		Alterar Senha <small>de Usuário</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-home"></i> Home</a></li>
		<li class="active">Alterar Senha</li>
	</ol>
</section>

<!-- Main content -->
<section class="content">


	<!-- ------------------------------------------- PETS de info ----------------------------------------------- -->

	<div class="row">
		<div class="col-xs-12 col-md-12" style="margin-bottom: 3%;">


			<div id="msgSenhaErrada" align="center"></div>
			<div align="center">
				<h3 class="laranja semiTitulo">Mudar sua senha de acesso</h3>
				<small>Caso deseje alterar algum campo, siga as instruções
					abaixo<a href="#Editar" onclick="ExibirTag('info')"> clique
						aqui</a>.
				</small>
			</div>
		</div>
		<br>

		<section
			class="col-lg-offset-1 col-xs-offset-1 col-xs-10 col-md-10 connectedSortable">
			<!-- Custom tabs (Charts with tabs)-->
			<div class="nav-tabs-custom">
				<!-- Tabs within a box -->
				<ul class="nav nav-tabs pull-right">
					<li class="pull-left header" style="color: #00a65a;!important"><i
						class="fa fa-user"></i> <strong>Faça as suas alterações!</strong></li>
				</ul>
				<div class="tab-content no-padding">

					<form id="contact-form" action="Alterar-sua-Senha.pets"
						method="post" name="chavez" class="formulario">
						<fieldset>

							<div id="msgSenhaErrada" align="center"></div>
							<div class="form-group">
								<label>Senha</label> <input type="password" id="senha"
									name="senha" required="required" autocomplete="off"
									class="form-control" placeholder="Senha:">

							</div>
							<div class="form-group">
								<label>Confirme a senha</label> <input type="password"
									id="senha2" name="senha2" required="required"
									autocomplete="off" onBlur="validarSenha()" class="form-control"
									placeholder="Confirmar senha:">

							</div>
							<div class="form-group">
								<label>Confirme digitando seu CPF</label> <input type="text" class="form-control cpf"
									id="cpf" placeholder="CPF: " maxlength="15" required="required"
									required="required" name="cpf" placeholder="Confirmar senha:">
								
							</div>


							<div class="form-group">
								<button type="submit" class="btn btn-large btn-warning"
									id="Enviar">
									<i class="fa fa-thumbs-up"></i> Alterar
								</button>
							</div>
						</fieldset>
					</form>

				</div>

			</div>
			<!-- /.nav-tabs-custom -->


			<!-- TO DO List -->


		</section>
		<!-- /.Left col -->


	</div>
	<!-- /.row (main row) -->

</section>
<!-- /.content -->



</div>
<!-- /.content-wrapper -->
<%@ include file="../../includeAdm/rodapeAdm.jsp"%>

