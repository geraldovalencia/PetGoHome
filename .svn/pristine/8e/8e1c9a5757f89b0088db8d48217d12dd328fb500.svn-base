<%@ include file="../../includeAdm/topo.jsp"%>

<%@ include file="../../includeAdm/menuADM.jsp"%>
<%@ include file="../../includeAdm/Javascript.jsp"%>

<%@ include file="../../includeAdm/menuLateral.jsp"%>
<%@ include file="../../includeAdm/mensagens.jsp"%>


<!-- Content Header (Page header) -->
<section class="content-header">
	<h1>
		Remover ${dog.nome} ${gato.nome}<small>do seu perfil</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-home"></i> Home</a></li>
		<li class="active">Remover ${dog.nome} ${gato.nome}</li>
	</ol>
</section>

<!-- Main content -->
<section class="content">




	<c:if test="${gato != null || dog != null}">

		<div class="col-md-offset-1 col-lg-offset-2 col-md-8 col-lg-8">



			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">
						<i class="fa fa-exclamation-triangle"></i></i> REMOVER PET
					</h3>
				</div>
				<!-- /.box-header -->
				<div class="box-body">

					<table class="table">



						<!-- DOG -->
						<c:if test="${dog != null}">
							<tr>
								<td align="center">Deseja remover o Pet <strong><span
										class="laranja"> ${dog.nome}</span></strong> ?
								</td>

							</tr>
							<tr>
								<td><br>
									<form action="Remover-Cachorro.pets" method="Post">
										<input class="form-control" type="hidden" name="idDog"
											value="${dog.id}"> <input class="form-control"
											type="hidden" name="idPessoa" value="${dog.pessoa.id}">
										<div align="center">
											<button type="submit" id="removerModalConfirmaCao"
												class="btn btn-danger">
												<i class="fa fa-times"></i> Remover Pet
											</button>
											<a href="Pets-Cadastrados.pets" class="btn btn-default"
												type="button"> <i class="fa fa-times"></i> <strong>
													Cancelar</strong>
											</a>
										</div>
									</form></td>
							</tr>
						</c:if>

						<!-- GATO -->
						<c:if test="${gato != null}">
							<td>Deseja remover o Pet <strong><span class="azul">${gato.nome}</span></strong>
								?
							</td>
							<tr>
								<td><br>
									<form action="Remover-Gato.pets" method="Post">
										<input class="form-control" type="hidden" name="idGato"
											value="${gato.id}"> <input class="form-control"
											type="hidden" name="idPessoa" value="${gato.pessoa.id}">
										<div align="center">
											<button type="submit" id="removerModalConfirmaCao"
												class="btn btn-danger">
												<i class="fa fa-times"></i> Remover Pet
											</button>
											<a href="Pets-Cadastrados.pets" class="btn btn-default"
												type="button"> <i class="fa fa-times"></i> <strong>
													Cancelar</strong>
											</a>
										</div>
									</form></td>
							</tr>
						</c:if>
					</table>
				</div>
			</div>
		</div>
		
	</c:if>
</section>

</div>
<!-- /.content-wrapper -->
<%@ include file="../../includeAdm/rodapeAdm.jsp"%>
<%@ include file="../../includeAdm/fancybox.jsp"%>