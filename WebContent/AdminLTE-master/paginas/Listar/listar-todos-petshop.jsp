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
		Listagens dos PETSHOP's <small><span class="txt-azul">${qtLista} cadastrados</span></small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-home"></i> Home</a></li>
		<li class="active">Listagem de PETSHOP</li>
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
							<th>#IDº</th>
							<th>NOME</th>
							<th>CNPJ</th>
							<th>E-MAIL</th>
							<th>CIDADE</th>
							<th>ESTADO</th>
							<th>RECEBEU TAG</th>
							<th>EDITAR</th>
<!-- 							<th>VER PERFIL</th> -->
						</tr>
					</thead>
					
					<c:if test="${qtLista != 0}">
					<tbody>
						<c:forEach var="petshops" items="${petshops}">
							<tr>
								<td align='center' class="t-status t-active">${petshops.id}</td>
								<td align='center'><strong>${petshops.nomePetShop}</strong></td>
								<td align='center'>${petshops.cnpj}</td>
								<td align='center'>${petshops.emailPetShop}</td>
								<td align='center'>${petshops.endereco.cidade}</td>
								<td align='center'>${petshops.uf}</td>
								
								<c:if test="${petshops.recebeuTag == false}">
									<td align='center'>Não</td>
								</c:if>
								<c:if test="${petshops.recebeuTag == true}">
									<td align='center' class="t-status t-draft"><strong>Sim</strong></td>
								</c:if>
								
								
<%-- 								<td align='center'><fmt:formatDate --%>
<%-- 										value="${petshops.dataCriacao}" type="both" --%>
<%-- 										pattern="dd/MM/yyyy" /></td> --%>
<%-- 								<td align='center'><fmt:formatDate --%>
<%-- 										value="${petshops.dataUltimaAlteracao}" type="both" --%>
<%-- 										pattern="dd/MM/yyyy" /></td> --%>
								<td align='center'><a
									href="Editar-PetShop.adm?idPetShop=${petshops.id}&idPessoa=${p.id}">
										<button type="submit" class="btn btn-defaul">
											<i class="icon-edit"></i>
										</button>
								</a></td>
<!-- 								<td align='center'><a -->
<%-- 									href="Ver-PetShop.adm?idPetShop=${petshops.id}&idPessoa=${p.id}"> --%>
<!-- 										<button type="submit" class="btn btn-success"> -->
<!-- 											<i class="icon-th-list icon-white"></i> -->
<!-- 										</button> -->
<!-- 								</a></td> -->
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
								<li><a href="Listar-PetShop.adm?pag=0">Início</a></li>
							</c:if>

							<c:forEach var="teste" begin="0" end="${qtdePages}" step="1">
								<li><a href="Listar-PetShop.adm?pag=${teste*8}">${teste+1}</a></li>
							</c:forEach>

							<c:if test="${param.pag lt qtdePages}">
								<c:if test="${not empty param.pag}">
									<li><a
										href="Listar-PetShop.adm?pag=${param.pag == null ? qtdePages-2 : param.pag + 1}">Próximo</a></li>
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
