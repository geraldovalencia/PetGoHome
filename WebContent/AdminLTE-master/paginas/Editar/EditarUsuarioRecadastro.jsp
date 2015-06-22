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
					<li class="pull-left header" style="color: #00a65a;!important"><i class="fa fa-user"></i>
						<strong>Faça as suas alterações!</strong></li>
				</ul>
				<div class="tab-content no-padding">

					<form id="contact-form" action="Editar-Usuario.pets" method="post"
						name="chavez"
						style="margin-top: 2%; margin-left: 2%; margin-right: 2%">

						<input type='hidden' name='idUserEditado'
							value='${pessoaLogado != null ? pessoaLogado.id : ""}' />

						<div class="form-group">
							<label for="nome">Nome</label> <input class="form-control"
								type="text" id="nome"
								value='${pessoaLogado != null ? pessoaLogado.nome : ""}'
								name="nome" autofocus>

						</div>
						<div class="form-group">
							<label for="login">Login</label> <input class="form-control"
								type="text" name="" id="login" class="marcar" readonly="readonly"
								value='${pessoaLogado != null ? pessoaLogado.login : ""}'>

						</div>



						<div class="form-group">
							<label for="senha">Senha</label> <input class="form-control"
								type="password" id="senha" readonly="readonly" autocomplete="off"
								value='********'><br>
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
								name="email">
						</div>
						<div class="form-group">
							<label for="telefone">Telefone</label> <input
								class="form-control fonemask" type="text" id="fone"
								value='${pessoaLogado != null ? pessoaLogado.telefone : ""}'
								name="telefone">
						</div>
						<div class="form-group">
							<label for="cpf">CPF</label><input type="text" required="required"
								class="cpf form-control" id="cpf" placeholder='${cpfIncompleto}'
								maxlength="15" name="cpf">
								<div id="spanValida"></div>
						</div>
						<div class="form-group">
							<label for="sexo">SEXO</label> <select name="sexo"
								class="form-control">
								<option value="Masculino"
									${pessoaLogado.sexo == 'MASCULINO' ? 'selected="selected"' : ''}>Sexo:
									Masculino</option>
								<option value="Feminino"
									${pessoaLogado.sexo == 'FEMININO' ? 'selected="selected"' : ''}>Sexo:
									Feminino</option>
							</select>
						</div>

						<div class="form-group">
							<label for="cep">CEP</label><input type="text"
								class="form-control cepmask" id="cep"
								onblur="pesquisacep(this.value);"
								value='${pessoaLogado != null ? pessoaLogado.endereco.cep : ""}'
								name="cep">
						</div>

						<div class="form-group">
							<br>
							<button type="button" onclick="pesquisacep(cep.value);"
								class="btn btn-large btn-info" id="getEndereco"
								value="Pesquisar CEP">
								Buscar CEP <i class="icon-envelope icon-white"></i>
							</button>
							<br /> <br> <span id="loadingCep"></span>
						</div>

						<div class="form-group">
							<label for="endereco">Logradouro</label> <input type="text"
								class="form-control" id="rua" size="60" name="rua"
								value='${pessoaLogado != null ? pessoaLogado.endereco.rua : ""}'>
						</div>
						<div class="form-group">
							<label for="numero">Número</label> <input type="text"
								class="form-control"
								value='${pessoaLogado != null ? pessoaLogado.endereco.numero : ""}'
								name="numero">
						</div>
						<div class="form-group">
							<label for="bairro">Bairro</label> <input type="text"
								class="form-control" id="bairro"
								value='${pessoaLogado != null ? pessoaLogado.endereco.bairro : ""}'
								name="bairro">
						</div>


						<div class="form-group">
							<label for="cidade">Cidade</label> <input type="text"
								class="form-control" id="cidade" size="40"
								value='${pessoaLogado != null ? pessoaLogado.endereco.cidade : ""}'
								name="cidade">
						</div>
						<div class="form-group">
							<label for="estado">Estado</label> <input name='uf' id="uf"
								class="form-control"
								value='${pessoaLogado != null ? pessoaLogado.uf : ""}'>
						</div>


						<div class="buttons-wrapper">
							<button type="submit" class="btn btn-large btn-success"
								id="Editar" onclick="validarCPF();">
								<i class="fa fa-check"></i> Concluir
							</button>
							<div id="info" style="display: none;">
								<i class="fa fa-arrow-up" style="margin-left: 3%;"></i><span
									class="help-block laranja"><strong> Clique no
										botão editar.</strong></span>
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

