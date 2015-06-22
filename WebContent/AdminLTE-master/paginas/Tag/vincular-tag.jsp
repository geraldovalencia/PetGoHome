<%@ include file="../../includeAdm/topo.jsp"%>
<script type="text/javascript" src="antigo_js/jquery.js"></script>
<%@ include file="../../../includes/MascarasJS.jsp"%>
<%-- <%@ include file="../../../includeIndex/validarForm.jsp"%> --%>


<%@ include file="../../../includeIndex/buscarCep.jsp"%>
<%@ include file="../../includeAdm/menuADM.jsp"%>

<%@ include file="../../includeAdm/menuLateral.jsp"%>
<%@ include file="../../includeAdm/mensagens.jsp"%>


<!-- Content Header (Page header) -->
<section class="content-header">
	<h1>
		Vincular TAG <small>no seu PET</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-home"></i> Home</a></li>
		<li class="active">Vincular TAG</li>
 	</ol>
</section>

<!-- Main content -->
<section class="content">



	<div class="col-md-offset-1 col-lg-offset-1 col-md-10 col-lg-10">



		<div class="box">
			<div class="box-header with-border">
				<h3 class="box-title">
					<i class="fa fa-tags"></i> Vincular TAG ao seu PET: <small><span
						class="txt-azul">${dog != null ? dog.nome : ""}${gato != null ? gato.nome : ""}</span></small>
				</h3>
			</div>
			<!-- /.box-header -->
			<div class="box-body">

				<table class="table">
					<tr>
						<c:if test="${gato != null || dog != null}">

							<!-- DOG -->
							<c:if test="${dog != null}">

								<td style="width: 60%;">
									<p>Digite o valor num�rico da TAG aqui.</p>

									<form id="contact-form" action="Vincular-Tag-dos.pets"
										method="post" name="chavez">

										<input type='hidden' name='idDogVinculado'
											value='${dog != null ? dog.id : ""}' /> <input type='hidden'
											name='idPessoa' value='${pessoa != null ? pessoa.id : ""}' />
										<label class="name">C�digo da TAG</label> <input type="text"
											id="valorTag" placeholder="N�mero da TAG:"
											required="required" class="form-control" name="valorTag"
											maxlength="7" autofocus>

										<div class="buttons-wrapper" style="margin-top: 3%;">
											<button type="submit" class="btn btn-large btn-success"
												id="Enviar">
												<i class="fa fa-check-square-o"></i> Vincular
											</button>
											<a href="Pets-Cadastrados.pets" class="btn btn-large btn-danger">
												<i class="fa fa-ban"></i> Cancelar
											</a>
										</div>
									</form>

								</td>
								<td style="width: 15px;"></td>
								<td>

									<h4>
										Nome do pet: <span style="color: #eb6f25;">${dog.nome}</span>
									</h4> <c:if test="${dog.nomeImagem != null}">
										<a id="example1" href="images/${dog.nomeImagem}"><img
											style="width: 70%;" class="img-rounded"
											alt="Clique para ampliar" src="images/${dog.nomeImagem}"></a>
									</c:if> <c:if
										test="${dog.nomeImagem == null || dog.nomeImagem == '' }">
										<a id="example1" href="img/pets.jpg"><img
											class="img-rounded" style="width: 70%;"
											alt="Clique para ampliar" src="img/pets.jpg"></a>
									</c:if>
								<td>
							</c:if>




							<!-- GATO -->

							<c:if test="${gato != null}">

								<td style="width: 60%;">

									<p>Digite o valor num�rico da TAG aqui.</p>

									<form id="contact-form" action="Vincular-Tag-dos.pets"
										method="post" name="chavez">

										<input type='hidden' name='idGatoVinculado'
											value='${gato != null ? gato.id : ""}' /> <input
											type='hidden' name='idPessoa'
											value='${pessoa != null ? pessoa.id : ""}' /> 
											<label class="name">C�digo da TAG</label>
											 <input type="text" id="valorTag"
											placeholder="N�mero da TAG:" class="form-control"
											required="required" name="valorTag" maxlength="7" autofocus>

										
										<div class="buttons-wrapper" style="margin-top: 3%;">
											<button type="submit" class="btn btn-large btn-success"
												id="Enviar">
												<i class="fa fa-check-square-o"></i> Vincular
											</button>
											<a href="Pets-Cadastrados.pets" class="btn btn-large btn-danger">
											<i class="fa fa-ban"></i> Cancelar
											</a>
										</div>
									</form>
								</td>
								<td style="width: 15px;"></td>
								<td>
									<h4>
										Nome do pet: <span style="color: #eb6f25;">${gato.nome}</span>
									</h4> <c:if test="${gato.nomeImagem != null}">
										<a id="example1" href="images/${gato.nomeImagem}"><img
											style="width: 70%;" class="img-rounded"
											alt="Clique para ampliar" src="images/${gato.nomeImagem}"></a>
									</c:if> <c:if
										test="${gato.nomeImagem == null || gato.nomeImagem == '' }">
										<a id="example1" href="img/pets.jpg"><img
											class="img-rounded" style="width: 70%;"
											alt="Clique para ampliar" src="img/pets.jpg"></a>
									</c:if>
								</td>


							</c:if>


						</c:if>

					</tr>
					<tr></tr>
					<tr></tr>

				</table>
			</div>
		</div>
	</div>
</section>
<!-- /.content -->


</div>
<!-- /.content-wrapper -->
<%@ include file="../../includeAdm/rodapeAdm.jsp"%>

