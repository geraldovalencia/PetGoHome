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
		Listagens dos Usuarios <small><span class="txt-azul">${qtLista} cadastrados</span></small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-home"></i> Home</a></li>
		<li class="active">Listagem de usuarios</li>
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

					<table class="table table-striped">
						<thead>
							<tr>
							
								<th><strong>#IDº</strong></th>
								<th><strong>NOME</strong></th>
								<th><strong>E-MAIL</strong></th>
								<th><strong>LOGIN</strong></th>
								<th><strong>TIPO</strong></th>
								<th><strong>DATA / CRIAÇÃO</strong></th>
								<th><strong>ÚLTIMA ALTERAÇÃO</strong></th>
								
							</tr>
						</thead>
						<tbody>
							<c:forEach var="pessoa" items="${pessoas}">
								<tr>
									<td  class="t-status t-active">${pessoa.id}</td>
									<td ><strong>${pessoa.nome}</strong></td>
									<td >${pessoa.email}</td>
									<td >${pessoa.login}</td>
									<c:if test="${pessoa.tipoUsuario == 'ADMINISTRADOR'}">
										<td  class="t-status t-inactive">${pessoa.tipoUsuario}</td>
									</c:if>
									<c:if test="${pessoa.tipoUsuario == 'USUARIO'}">
										<td  class="t-status t-scheduled">${pessoa.tipoUsuario}</td>
									</c:if>
									<td ><fmt:formatDate
											value="${pessoa.dataCriacao}" type="both"
											pattern="dd/MM/yyyy" /></td>
									<td ><fmt:formatDate
											value="${pessoa.dataUltimaAlteracao}" type="both"
											pattern="dd/MM/yyyy" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					
					<c:if test="${not empty qtdePages}">
			<div align="center">
				<ul class="pagination">
					<c:if test="${not empty param.pag}">				
						<li><a href="Listar-Usuarios.adm?pag=0">Início</a></li>
					</c:if>
					
					<c:forEach var="teste" begin="0" end="${qtdePages}" step="1">
						<li ><a href="Listar-Usuarios.adm?pag=${teste*8}">${teste+1}</a></li>
					</c:forEach>
					
					<c:if test="${param.pag lt qtdePages}">
						<c:if test="${not empty param.pag}">
							<li><a href="Listar-Usuarios.adm?pag=${param.pag == null ? qtdePages-2 : param.pag + 1}">Próximo</a></li>
						</c:if>
					</c:if>
				</ul>
			</div>
		</c:if>

	</div>	
		
		</div>
	<!-- /.row (main row) -->

</section>
<!-- /.content -->
		






</div>
<!-- /.content-wrapper -->
<%@ include file="../../includeAdm/rodapeAdm.jsp"%>
<%@ include file="../../../includes/MascarasJS.jsp"%>
