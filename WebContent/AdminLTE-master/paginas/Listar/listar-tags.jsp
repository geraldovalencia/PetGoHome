<%@ include file="../../includeAdm/topo.jsp"%>
<%@ include file="../../includeAdm/menuADM.jsp"%>
<%@ include file="../../includeAdm/Javascript.jsp"%>
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
	<h1>Listagens dos TAG's</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-home"></i> Home</a></li>
		<li class="active">Listagem de TAG's</li>
	</ol>
</section>


<!-- Main content -->
<section class="content">
	<!-- Small boxes (Stat box) -->
	<div class="row">
		<!-- small box -->

		<%-- 			<%@ include file="../../includeAdm/BoxesInfo.jsp"%>    --%>

	</div>
	<!-- /.row -->
	<!-- ------------------------------------------- TABS de info ----------------------------------------------- -->


	<!-- ------------------------------------------- PETS de info ----------------------------------------------- -->

	<div class="row" id="ListaPET">


		<div class="col-md-offset-1 col-lg-offset-1 col-md-10 col-lg-10">



			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">
						<i class="fa fa-tags"></i> Tags registradas no sistema: <small><span
							class="txt-azul">${qtLista} cadastradas</span></small>
					</h3>
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<table class="table table-hover table-condensed" id="tabelaTAG">


						<c:if test="${qtLista != 0}">

							<tbody align="center" id="corpo">
								<tr>
									<th style="width: 10px">ID</th>
									<th>Código da TAG</th>
									<th><strong>DATA/CRIAÇÃO</strong></th>
									<th><strong>DATA/ATIVAÇÃO</strong></th>
									<th><strong>USUÁRIO</strong></th>
									<th style="width: 100px">STATUS</th>
								</tr>
								<tr class="cinza">
									<td>#</td>
									<td>



										<form method="get" action="PesquisarTAG.adm" id="formTAG">
											<input type="hidden" id="idvalorTag" name="idvalorTag" ${readOnlyUser} ${readOnlyStatus}
												class="form-control" /> <input
												value="${filtro != null ? filtro : ''}"
												class="form-control ui-autocomplete-input" type="text"
												id="valorTag" placeholder="Digite o valor">
											<button type="submit" id="pesquisaTag"
												style="margin-top: 3%; display: none;" type="button"
												class="btn btn-info btn-xs">
												<strong> Pesquisar <i class="fa fa-search"></i></strong>
											</button>
										</form>

									</td>
									<td><form method="get" action="#">
											<input class="form-control" readonly="readonly" type="text"
												name="valorTag" placeholder="">
										</form></td>
									<td><form method="get" action="#">
											<input class="form-control" readonly="readonly" type="text"
												name="valorTag" placeholder="">
										</form></td>
									<td><form method="get" action="PesquisarPessoa.adm">
											<input type="hidden" id="idPessoa" name="idPessoa"
												class="form-control" /> <input class="form-control"
												type="text" value="${filtroUser != null ? filtroUser : ''}"
												name="nomePessoa" ${readOnly} id="nomePessoa" ${readOnlyStatus}
												placeholder="Digite o Usuário">
												<button type="submit" id="pesquisaNome"
												style="margin-top: 3%; display: none;" type="button"
												class="btn btn-info btn-xs">
												<strong> Pesquisar <i class="fa fa-search"></i></strong>
											</button>
										</form></td>
									<td><form method="get" action="StatusDaTag.adm"  id="status">
										<input type="hidden" id="item" name="item">
											<select id="selectBox" name="statusTag" ${readOnly} ${readOnlyUser} class="form-control"  onchange="changeFunc(value);">
												<option>---</option>
												<option value="livre" id="livre">Livre</option>
												<option value="usada" id="usada" >Usada</option>
											</select>
											<button type="submit" id="pesquisa"
												style="margin-top: 3%; display: none;" type="button"
												class="btn btn-info btn-xs">
												<strong> Pesquisar <i class="fa fa-search"></i></strong>
											</button>
										</form></td>
								</tr>
								<c:forEach var="tag" items="${tags}">

									<c:if test="${tag.id  % 2 != 0}">
										<tr class='opcao'>
											<td>${tag.id}</td>
											<c:if test="${tag.pet.id != null}">
												<td class="laranja"><strong>${tag.valorTag}</strong></td>
											</c:if>
											<c:if test="${tag.pet.id == null}">
												<td class="txt-verde"><strong>${tag.valorTag}</strong></td>
											</c:if>
											<td><fmt:formatDate value="${tag.dataCriacao}"
													type="both" pattern="dd/MM/yyyy" /></td>
											<td><fmt:formatDate value="${tag.dataAtivacao}"
													type="both" pattern="dd/MM/yyyy" /></td>

											<td>${tag.pet.pessoa.nome}</td>


											<c:if test="${tag.pet.id != null}">
												<td><span class="badge bg-red">${tag.pet.id}</span></td>
											</c:if>
											<c:if test="${tag.pet.id == null}">
												<td><span class="badge bg-green">(livre)</span></td>
											</c:if>
										</tr>
									</c:if>
									<c:if test="${tag.id  % 2 == 0}">
										<tr class="warning opcao">
											<td>${tag.id}</td>
											<c:if test="${tag.pet.id != null}">
												<td class="laranja"><strong>${tag.valorTag}</strong></td>
											</c:if>
											<c:if test="${tag.pet.id == null}">
												<td class="txt-verde"><strong>${tag.valorTag}</strong></td>
											</c:if>
											<td><fmt:formatDate value="${tag.dataCriacao}"
													type="both" pattern="dd/MM/yyyy" /></td>
											<td><fmt:formatDate value="${tag.dataAtivacao}"
													type="both" pattern="dd/MM/yyyy" /></td>

											<td>${tag.pet.pessoa.nome}</td>


											<c:if test="${tag.pet.id != null}">
												<td><span class="badge bg-red">${tag.pet.id}</span></td>
											</c:if>
											<c:if test="${tag.pet.id == null}">
												<td><span class="badge bg-green">(livre)</span></td>
											</c:if>
										</tr>
									</c:if>



								</c:forEach>
								${retorno}
							</tbody>



						</c:if>
						<c:if test="${qtLista == 0}">

							<tbody>
								<tr>
									<td colspan="1"></td>
									<td colspan="1"></td>
									<td colspan="1"></td>
									<td colspan="4"><h5>Nenhum resultado encontrado.</h5></td>
								</tr>
							</tbody>
						</c:if>
					</table>
				</div>
				<!-- /.box-body -->
				<div class="box-footer clearfix">
					${botao}
					<div align='right'>
						<ul class="pagination pagination-sm no-margin pull-right">
							<li><a href="#">«</a></li>
							<li><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">»</a></li>
						</ul>
					</div>
				</div>
			</div>






			<c:if test="${not empty qtdePages}">
				<div id="pagination" align="center">
					<ul class="pagination">
						<c:if test="${not empty param.pag}">
							<li><a href="Listar-Tags.adm?pag=0">Início</a></li>
						</c:if>


						<%-- 							<c:forEach var="teste" begin="0" end="${qtdePages}" step="1"> --%>
						<%-- 								<li><a href="Listar-Tags.adm?pag=${teste*8}">${teste+1}</a></li> --%>
						<%-- 							</c:forEach> --%>

						<c:forEach var="teste" begin="0" end="${qtdePages}" step="1">
							<li><a href="Listar-Tags.adm?pag=${teste*8}">${teste+1}</a></li>
						</c:forEach>

						<c:if test="${param.pag lt qtdePages}">
							<c:if test="${not empty param.pag}">
								<li><a
									href="Listar-Tags.adm?pag=${param.pag == null ? qtdePages-2 : param.pag + 8}">Próximo</a></li>
							</c:if>
						</c:if>
					</ul>
				</div>
			</c:if>


		</div>

	</div>
	<!-- /.row (main row) -->
	</div>
</section>
<!-- /.content -->




</div>
<!-- /.content-wrapper -->
<%@ include file="../../includeAdm/rodapeAdm.jsp"%>

<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
<script src="AdminLTE-master/dist/js/jquery.form.js"
	type="text/javascript"></script>
<script type="text/javascript">
	path = "${pageContext.request.contextPath}";
	$(function() {
		$("#valorTag")
				.autocomplete(
						{
							source : function(request, response) {
								$
										.ajax({
											url : "/PetGoHome/ComplertarNomeDaTag.petjson?valorTag="
													+ request.term,
											type : "GET",
											dataType : "json",
											success : function(data) {

												response($.map(data, function(
														i, v) {
													return {
														label : i,
														value : v
													};
												}));
											}
										});
							},
							select : function(event, ui) {

								$("#idvalorTag").val(ui.item.value);
								ui.item.value = ui.item.label;
								$("#valorTag").val(ui.item.value);

								setTimeout(function() {
									jQuery('.opcao').hide("slow");
								}, 6000);

								$("#pesquisaTag").show();

								// 								$.get("PesquisarTAG.petjson?idvalorTag=" + ui.item.value, 

								// 										function(dadosDeResposta) {
								// 									$('#corpo').html("<p>Acabou<p>");
								// 							      });
								// 								alert(ui.item.value); //Funcionou

								// 								$("#formTAG").ajaxForm({
								// 									target : '#corpo',
								// 									dataType: 'text',
								// 									success : function(retorno) {
								// 										$('#corpo').html(retorno);
								// 										$('#corpo').show();
								// 										$("#formTAG").resetForm();
								// 									}

								// 								});
								//	setTimeout(function() {
								//		jQuery('#ListaPET').hide("slow"); }, 2000);
								//	$("#botaoAdd").prop("disabled", false);
							}
						});

		$("#nomePessoa")
				.autocomplete(
						{
							source : function(request, response) {
								$
										.ajax({
											url : "/PetGoHome/CompletarNomePessoa.petjson?nomePessoa="
													+ request.term,
											type : "GET",
											dataType : "json",
											success : function(data) {

												response($.map(data, function(
														i, v) {
													return {
														label : i,
														value : v
													};
												}));
											}
										});
							},
							select : function(event, ui) {

								$("#idPessoa").val(ui.item.value);
								ui.item.value = ui.item.label;
								$("#nomePessoa").val(ui.item.value);

								setTimeout(function() {
									jQuery('.opcao').hide("slow");
								}, 6000);

								$("#pesquisaNome").show();

							}
						});
		
	});
</script>
<script type="text/javascript">

   function changeFunc(valor) {
	   alert(valor);
	   if(valor == "livre"){
		   $("#item").val("livre");
		   }else{
			   $("#item").val("usado");
			   }
	  $("#item").val(valor);
	   alert("ITEM: " + item);
	 //  $("#pesquisa").show();
	 //  $( "#selectBox" ).val();
	   $( "#status" ).submit();
   }

  </script>
<%@ include file="../../../includes/MascarasJS.jsp"%>
