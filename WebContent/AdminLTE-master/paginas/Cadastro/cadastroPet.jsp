<%@ include file="../../includeAdm/topo.jsp"%>
<script type="text/javascript" src="antigo_js/jquery.js"></script>
<%@ include file="../../../includes/MascarasJS.jsp"%>
<%@ include file="../../../includeIndex/validarForm.jsp"%>
<%@ include file="../../../includeIndex/buscarCep.jsp"%>
<%@ include file="../../includeAdm/menuADM.jsp"%>


<%@ include file="../../includeAdm/menuLateral.jsp"%>
<%@ include file="../../includeAdm/mensagens.jsp"%>




<!-- Content Header (Page header) -->
<section class="content-header">
	<h1>
		Cadastro de PET <small>Preencha os campos abaixo</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="IndexUser.pet"><i class="fa fa-home"></i> Home</a></li>
		<li class="active">Cadastro de PET</li>
		
	</ol>
</section>

<!-- Main content -->
<section class="content">


	<!-- ------------------------------------------- PETS de info ----------------------------------------------- -->

	<div class="row">
		<div class="col-xs-12 col-md-12" style="margin-bottom: 3%;">


			<div id="msgSenhaErrada" align="center"></div>
			<div align="center">
				<h3 class="laranja semiTitulo">Escolha o tipo de PET que deseja
					cadastrar.</h3>
					<small>Após a escolha será redirecionado para o preenchimento dos dados do Pet.</small>
			</div>
		</div>
		<br>
	</div>
	<div class="row">
		<section
			class="col-lg-offset-1 col-xs-offset-1 col-xs-10 col-md-10 connectedSortable">

			<div class="row">
				<div class="col-sm-6 col-md-4">
					<div class="thumbnail">
						<img src="img/cao.jpg" alt="Cadastrar um cachorro"
							data-holder-rendered="true"
							style="height: 200px; width: 160px; display: block; margin-top: 2%;">
						<div class="caption">
							<h3 id="thumbnail-label">
								Cadastrar Cachorro<a class="anchorjs-link" href="#thumbnail-label"><span
									class="anchorjs-icon"></span></a>
							</h3><hr style="margin-top: -2%;">
							<p>Se o seu amiguinho for um cachorro começe por essa opção.</p>
							<form id="contact-form" action="Cadastro-do-seu.pet"
									method="post">
							<hr><p>
							
							<input type="hidden" value="cao" name="cao">
								<button type="submit"  class="btn btn-warning" role="button">Registrar</button> <a
									href="#" class="btn btn-default" role="button">Button</a>
							</p>
							</form>
						</div>
					</div>
				</div>
				<div class="col-sm-6 col-md-4">
					<div class="thumbnail">
						<img src="img/gato.jpg"
							style="height: 200px; width: 160px; display: block; margin-top: 2%;">
						<div class="caption">
							<h3 id="thumbnail-label">
								Cadastrar Gato<a class="anchorjs-link" href="#thumbnail-label"><span
									class="anchorjs-icon"></span></a>
							</h3><hr style="margin-top: -2%;">
							<p>Se o seu amiguinho for um gato começe clicando aqui nessa opção..</p>
							<hr>
							<form id="contact-form" action="Cadastro-do-seu.pet"
									method="post">
									<p>
							<input type="hidden" value="gato" name="gato">
								<button type="submit" class="btn btn-primary" role="button">Registrar</button> <a
									href="#" class="btn btn-default" role="button">Button</a>
							</p>
							</form>
						</div>
					</div>
				</div>
			</div>






		</section>
		<!-- /.Left col -->


	</div>
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->
<%@ include file="../../includeAdm/rodapeAdm.jsp"%>

