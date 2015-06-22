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
		Listagens dos PETS <small><span class="txt-azul">${qtLista} cadastrados</span></small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-home"></i> Home</a></li>
		<li class="active">Listagem de PETS</li>
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
								<th><strong>SEXO</strong></th>
								<th><strong>TIPO</strong></th>
								<th><strong>DONO</strong></th>
								<th><strong>TAG?</strong></th>
								<th><strong>DATA/NASCIMENTO</strong></th>
							</tr>
						</thead>
						
						<c:if test="${qtLista != 0}">
						
						<tbody>
							<c:forEach var="pet" items="${petsLimitados}">
								<tr>
									<td  class="t-status t-active">${pet.id}</td>
									<td ><strong>${pet.nome}</strong></td>
									<td >${pet.sexo}</td>
									
									<c:if test="${pet.tipoAnimal == 'CACHORRO'}">
										<td  class="t-status t-inactive">${pet.tipoAnimal}</td>
									</c:if>
									<c:if test="${pet.tipoAnimal == 'GATO'}">
										<td  class="t-status t-scheduled">${pet.tipoAnimal}</td>
									</c:if>
								<td >${pet.pessoa.nome}</td>
								<c:if test="${pet.possuiTag == false}">
									<td >Não</td>
								</c:if>
								<c:if test="${pet.possuiTag == true}">
									<td  class="t-status t-draft"><strong>Sim</strong></td>
								</c:if>
								<td ><fmt:formatDate
											value="${pet.dataNascimentoPet}" type="both"
											pattern="dd/MM/yyyy" /></td>
								</tr>
							</c:forEach>
						</tbody>
						</c:if>
						<c:if test="${qtLista == 0}">
						
						<tbody>
							<tr >
								<td colspan="1"></td>
								<td colspan="1"></td>
								<td colspan="1"></td>
								<td colspan="4"><h5>Nenhum resultado encontrado.</h5></td>
							</tr>	
						</tbody>
						</c:if>
						
					</table>
					
					<c:if test="${not empty qtdePages}">
			<div align="center">
				<ul class="pagination" >
					<c:if test="${not empty param.pag}">				
						<li><a href="Listar-Pet.adm?pag=0">Início</a></li>
					</c:if>
					
					<c:forEach var="teste" begin="0" end="${qtdePages}" step="1">
						<li ><a href="Listar-Pet.adm?pag=${teste*8}">${teste+1}</a></li>
					</c:forEach>
					
					<c:if test="${param.pag lt qtdePages}">
						<c:if test="${not empty param.pag}">
							<li><a href="Listar-Pet.adm?pag=${param.pag == null ? qtdePages-2 : param.pag + 1}">Próximo</a></li>
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
<%-- <%@ include file="../../includeAdm/fancybox.jsp"%> --%>