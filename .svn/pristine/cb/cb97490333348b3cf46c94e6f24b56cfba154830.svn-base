<%@ include file="../../includeAdm/topo.jsp"%>
<%@ include file="../../includeAdm/menuADM.jsp"%>
<%@ include file="../../../includeIndex/validaData.jsp"%>
<%@ include file="../../includeAdm/Javascript.jsp"%>
<style>
#ListaPET li {
	list-style: none;
	margin-top: 1%;
	margin-bottom: 1%;
	font-size: 15px;
}
#ListaPET ul li a img{
	
	float: left;
	margin-left: 1%;
	
}
</style>
<%@ include file="../../includeAdm/menuLateral.jsp"%>
<%@ include file="../../includeAdm/mensagens.jsp"%>




<!-- Content Header (Page header) -->
<section class="content-header">
	<h1>
		Alterar Foto <small>de Gato</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-home"></i> Home</a></li>
		<li><a href="Pets-Cadastrados.pets">Alterar Gato</a></li>
		<li class="active">Alterar Foto</li>
	</ol>
</section>

<!-- Main content -->
<section class="content">


	<!-- ------------------------------------------- PETS de info ----------------------------------------------- -->

	<div class="row">
		<div class="col-xs-12 col-md-12" style="margin-bottom: 3%;">


			<div id="msgSenhaErrada" align="center"></div>
		</div>
		<br>

		<section class="col-lg-12 col-md-12 connectedSortable ui-sortable">

		
			<form id="contact-form" action="Alterar-Foto-do-seu-Gato.pets"
				method="post" enctype="multipart/form-data">

					<input type='hidden' name='idGatoEditado' class="form-control"
						value='${gato != null ? gato.id : ""}' />


					<div class="col-xs-12 col-md-10 col-lg-10">
						<h4>Foto do seu Pet:</h4>
						<input type="file" name="fileFoto" class="form-control" required="required"><br>
						<div align="right">
						<button type="submit" class="btn btn-large btn-warning">
							<i class="icon-edit icon-white"></i> Enviar
						</button>
						</div>
					</div>

						
			</form>
			<div class="col-xs-12 col-md-12 col-lg-12" id="ListaPET">

			<c:if test="${hps != null}">
				<h3>Fotos anteriores do seu Pet</h3>

				<ul class="img-responsive">
					<c:forEach items="${hps}" var="hpsLista">
						<li><a id="example1"
							href="images/${hpsLista.nomeFoto}"><img style="width: 30%; height: 50%"
												class="img-rounded form-control"
								src="images/resize_${hpsLista.nomeFoto}"></a></li>
					</c:forEach>
				</ul>
			</c:if>
			<c:if test="${hps == null}">
			</c:if>
			</div>

		</section>











	</div>
	<!-- /.row (main row) -->

</section>
<!-- /.content -->



</div>
<!-- /.content-wrapper -->
<%@ include file="../../includeAdm/rodapeAdm.jsp"%>

<%@ include file="../../includeAdm/fancybox.jsp"%>