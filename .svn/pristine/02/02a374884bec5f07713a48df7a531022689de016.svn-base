<%@ include file="../../includeAdm/topo.jsp"%>
<%@ include file="../../includeAdm/menuADM.jsp"%>
<style>
#ListaPET li {
	list-style: none;
	margin-top: 1%;
	margin-bottom: 1%;
	font-size: 15px;
}
</style>


<%@ include file="../../includeAdm/menuLateral.jsp"%>
<%@ include file="../../includeAdm/mensagens.jsp"%>




<!-- Content Header (Page header) -->
<section class="content-header">
	<h1>
		Alterar Perfil <small>de Usuário</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-home"></i> Home</a></li>
		<li class="active">Alterar Perfil</li>
	</ol>
</section>

<!-- Main content -->
<section class="content">


	<!-- ------------------------------------------- PETS de info ----------------------------------------------- -->

	<div class="row">
		<div class="col-xs-12 col-md-12" style="margin-bottom: 3%;">


			<div id="msgSenhaErrada" align="center"></div>
			<div align="center">
				<h3 class="laranja semiTitulo">Alterar dados do Usuário</h3>
				<small>Caso deseje alterar algum campo,<a href="#Editar"
					onclick="ExibirTag('info')"> clique aqui</a>.
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
					<li class="pull-left header"><i class="fa fa-user"></i>
						Confira seus dados abaixo!</li>
				</ul>
				<div class="tab-content no-padding">

					<form id="contact-form" action="Editar-Usuario.pets" method="get"
						name="chavez"	class="formulario"	>


						<div class="form-group">
							<label for="nome">Nome</label> <input class="form-control"
								type="text" id="nome"
								value='${pessoaLogado != null ? pessoaLogado.nome : ""}'
								readonly="readonly" name="nome">

						</div>
						<div class="form-group">
							<label for="login">Login</label> <input class="form-control"
								style="background-color: #FFF2A8; border-color: #EBC26A;"
								type="text" name="login" id="login" class="marcar"
								readonly="readonly"
								value='${pessoaLogado != null ? pessoaLogado.login : ""}'>

						</div>



						<div class="form-group">
							<label for="senha">Senha</label> <input class="form-control"
								type="password" id="senha" name="senha" readonly="readonly"
								autocomplete="off" value='********'><br>
								<div align="right">
								<a href="Alterar-sua-Senha.pets">
								<button type="button" class="btn btn-danger">
								<i class="fa fa-pencil-square-o"></i> Mudar Senha</button></a>
								</div>
						</div>
						<div class="form-group">
							<label for="email">E-mail</label> <input type="email"
								class="form-control" id="email"
								value='${pessoaLogado != null ? pessoaLogado.email : ""}'
								name="email" readonly="readonly">
						</div>
						<div class="form-group">
							<label for="telefone">Telefone</label> <input
								class="form-control fonemask" type="text" id="fone"
								value='${pessoaLogado != null ? pessoaLogado.telefone : ""}'
								name="telefone" readonly="readonly">
						</div>
						<div class="form-group">
							<label for="cpf">CPF</label><input type="text"
								class="cpf form-control" id="cpf" value='${cpfIncompleto}'
								maxlength="15" " mask="999.999.-99" name="cpf"
								readonly="readonly">
						</div>
						<div class="form-group">
							<label for="sexo">SEXO</label> <input type="text"
								class="cpf form-control" id="cpf"
								value='${pessoaLogado != null ? pessoaLogado.sexo : ""}'
								name="sexo" readonly="readonly">
						</div>

						<div class="form-group">
							<label for="cep">CEP</label><input type="text"
								class="form-control cepmask" id="cep" readonly="readonly"
								value='${pessoaLogado != null ? pessoaLogado.endereco.cep : ""}'
								name="cep">
						</div>



						<div class="form-group">
							<label for="endereco">Logradouro</label> <input type="text"
								class="form-control" id="rua" size="60" readonly="readonly"
								name="rua"
								value='${pessoaLogado != null ? pessoaLogado.endereco.rua : ""}'>
						</div>
						<div class="form-group">
							<label for="numero">Número</label> <input type="text"
								readonly="readonly" class="form-control"
								value='${pessoaLogado != null ? pessoaLogado.endereco.numero : ""}'
								name="numero">
						</div>
						<div class="form-group">
							<label for="bairro">Bairro</label> <input type="text"
								class="form-control" id="bairro"
								value='${pessoaLogado != null ? pessoaLogado.endereco.bairro : ""}'
								readonly="readonly" name="bairro">
						</div>


						<div class="form-group">
							<label for="cidade">Cidade</label> <input type="text"
								class="form-control" id="cidade" size="40" readonly="readonly"
								value='${pessoaLogado != null ? pessoaLogado.endereco.cidade : ""}'
								name="cidade">
						</div>
						<div class="form-group">
							<label for="estado">Estado</label> <input name='uf' id="uf"
								class="form-control"
								value='${pessoaLogado != null ? pessoaLogado.uf : ""}'
								readonly="readonly">
						</div>


						<div class="buttons-wrapper">
							<button type="submit" class="btn btn-large btn-warning"
								id="Editar">
								<i class="fa fa-pencil-square-o"></i> Editar
							</button>
							<div id="info" style="display: none;">
								<i class="fa fa-arrow-up" style="margin-left: 3%;"></i><span class="help-block laranja"><strong> Clique no botão
										editar.</strong></span>
							</div>
						</div>
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
<%@ include file="../../../includes/MascarasJS.jsp"%>
<script type='text/javascript'>
	function ExibirTag(el) {
		var display = document.getElementById(el).style.display;
		if (display == "none")
			document.getElementById(el).style.display = 'block';
		else
			document.getElementById(el).style.display = 'none';
	}
</script>