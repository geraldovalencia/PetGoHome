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
							<label for="nome">Nome</label><input class="form-control" style="background: #EDEDED; " type="text"
								value='Nome Completo: ${pessoaLogado != null ? pessoaLogado.nome : ""}'
								disabled="disabled" name="nome" autofocus> 
						</div>
						<div class="form-group">
							<label class="login">Login</label> <input class="form-control" style="background: #EDEDED; " type="text" name="login"
								value='Login: ${pessoaLogado != null ? pessoaLogado.login : ""}'
								 disabled="disabled"> 
								
								
						</div>
						<div class="form-group">
							<label class="senha">Senha</label> <input class="form-control" style="background: #EDEDED; "type="text" name="senha"
								disabled="disabled" value='Senha: ********'><br>
								<div align="right">
								<a href="Alterar-sua-Senha.pets">
								<button type="button" class="btn btn-danger">
								<i class="fa fa-pencil-square-o"></i> Mudar Senha</button></a>
								</div>   
						</div>
					<div class="form-group">
							<label class="email">E-mail</label> <input class="form-control" style="background: #EDEDED; "type="text"
								value='Email: ${pessoaLogado != null ? pessoaLogado.email : ""}'
								name="email" disabled="disabled"> 
								
						</div>
						<div class="form-group">
							<label class="">USUARIO: </label>  <input class="form-control" style="background: #EDEDED; "type="text"
								value='Tipo: ${pessoaLogado != null ? pessoaLogado.tipoUsuario : ""}'
								name="tipo" disabled="disabled"> 
								
						</div>
						<div class="form-group">
							<label class="phone">Última alteração</label> <input class="form-control" style="background: #EDEDED; "type="text"
							value="Alterado: <fmt:formatDate
											value="${pessoaLogado != null ? pessoaLogado.dataUltimaAlteracao : ''}" type="both"
											pattern="dd/MM/yyyy" />"
								name="telefone" disabled="disabled">
								
						</div>

						<div class="form-group">
							<button type="submit" class="btn btn-large btn-warning"
								data-type="submit">
								<i class="icon-edit icon-white"></i> Editar Perfil
							</button>
							<a href="Index.pet"  
										class="btn btn-large btn-danger">
									<i class="icon-remove icon-white"></i> Cancelar	
									</a>
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