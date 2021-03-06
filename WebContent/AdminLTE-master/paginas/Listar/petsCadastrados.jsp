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
.form-control {
    display: block;
    width: 88%;
    }
</style>

<%@ include file="../../includeAdm/menuLateral.jsp"%>
<%@ include file="../../includeAdm/mensagens.jsp"%>




<!-- Content Header (Page header) -->
<section class="content-header">
	<h1>
		Meus PET's <small>Control panel</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-home"></i> Home</a></li>
		<li class="active">Meus Pet's</li>
	</ol>
</section>

<c:if test="${dogs != null || gatos != null }">

	<!-- Main content -->
	<section class="content">
		<!-- Small boxes (Stat box) -->
		<div class="row">
			<!-- small box -->

			<%@ include file="../../includeAdm/BoxesInfo.jsp"%>

		</div>
		<!-- /.row -->
		<!-- ------------------------------------------- TABS de info ----------------------------------------------- -->


		<!-- ------------------------------------------- PETS de info ----------------------------------------------- -->

		<div class="row" id="ListaPET">


			<c:if test="${dogs != null}">


				<c:forEach items="${dogs}" var="dog">

					<section class="col-lg-4 connectedSortable petsCadastrados">
						<!-- Custom tabs (Charts with tabs)-->
						<div class="nav-tabs-custom">


							<!-- Tabs within a box -->
							<ul class="nav nav-tabs pull-right">
								<li class="pull-left header"><i
									class="ion ion-social-octocat"></i><strong> Nome:</strong>
									${dog.nome}</li>
								<li><a
									href="Alterar-Foto-do-seu.pets?idDog=${dog.id}&idPessoa=${dog.pessoa.id}">
										<img alt="Alterar Foto" title="Mudar Foto"
										src="img/cam-peq.png" class="linkCamera"
										onmouseover="this.src='img/cam-peq-hover.png'"
										onmouseout="this.src='img/cam-peq.png'">
								</a></li>
							</ul>

							<div class="tab-content no-padding">


								<!-- TAG TABELA -->
								<ul >
									<li>
										<h3 style="color: #eb6f25;"></h3>
									</li>
									<li><c:if test="${dog.nomeImagem != null}">
											<a id="example1" href="images/${dog.nomeImagem}"><img
												class="img-rounded imgExede" alt="Clique para ampliar"
												src="images/resize_${dog.nomeImagem}"></a>
										</c:if> <c:if
											test="${dog.nomeImagem == null || dog.nomeImagem == '' }">
											<a id="example1" href="img/pets.jpg"><img
												class="img-rounded imgExede" alt="Clique para ampliar"
												src="img/pets.jpg"></a>
										</c:if></li>
									<li></li><li><br><strong>Tipo de Animal:<span
											style="color: #eb6f25;"> ${dog.tipoAnimal} </span></strong></li>
									<li><strong>Ra�a:</strong>
										${dog.racaCachorro.nomeRacaCachorro}</li>
									<li><strong>Sexo:</strong> ${dog.sexo}</li>
									<li><strong>Cor:</strong> ${dog.cor}</li>

									<c:if test="${dog.possuiTag == 'true'}">
										<li><strong>TAG: <span class="txt-verde">
													${dog.tagNumero }</span></strong></li>
									</c:if>
									<c:if test="${dog.possuiTag == 'false'}">
										<li><strong>TAG:</strong> <span class="txt-red">N�o
												possui</span></li>
									</c:if>


									<li><strong>Data Nascimento:</strong> <fmt:formatDate
											value="${dog.dataNascimentoPet}" type="both"
											pattern="dd/MM/yyyy" /></li>
									<li><strong>Descri��o:</strong></li>
									<c:if test="${dog.descricao != ''}">
										<li><textarea readonly="readonly" id="rules" class="form-control"
												style="cursor: pointer;">${dog.descricao}</textarea></li>
									</c:if>
									<c:if test="${dog.descricao == ''}">
										<li><textarea id="rules" class="form-control" style="cursor: pointer;">Nenhuma descri��o.</textarea></li>
									</c:if>


								</ul>


								<br>
								<div align="center">
									<a title="Edite os dados do seu Pet"
										href="Editar-Cachorro.pets?idDog=${dog.id}&idPessoa=${dog.pessoa.id}">
										<button type='button' class="btn btn-large btn-warning">
											<i class="fa fa-pencil-square-o"></i>  Alterar dados
										</button>
									</a>
								</div>
								<br>
								<div align="center">
									<c:if test="${dog.possuiTag == 'false'}">
										<a
											href="Vincular-Tag-dos.pets?idDog=${dog.id}&idPessoa=${dog.pessoa.id}"
											title="vincule a tag"><button type='button'
												class="btn btn-large btn-success">
												<i class="fa fa-lock"></i> Vincular TAG
											</button></a>
										<!-- 									<li><a href="relatorios.php" title="Report Missing">&raquo; -->
										<!-- 											Relat�rio Desaparecidas</a></li> -->
									</c:if>
									<c:if test="${dog.possuiTag == 'true'}">
										<a href="#" title="Este Pet possui uma tag"><button
												type='button' disabled="disabled"
												class="btn btn-large btn-default">
												<i class="fa fa-check-square-o"></i> Pet Vinculado
											</button></a>
										<!-- 									<li><a href="relatorios.php" title="Report Missing">&raquo; -->
										<!-- 											Relat�rio Desaparecidas</a></li> -->
									</c:if>
								</div>
								<br>
								<div align="center">
								<form id="removerFormCao" method="Post"
											action="RemoverPet.pets">
									<input type="hidden" name="idDog" 
												value="${dog.id}"> 
									<input type="hidden" name="tipoDog" 
												value="tipoDog"> 
									<input type="hidden" name="idPessoa"
												value="${dog.pessoa.id}">		
									<button type="submit" id="removerModalConfirmaCao"
										class="btn btn-danger"><i class="fa fa-times"></i>
										 Remover Pet</button>
								</form>


									
								</div>

							</div>
						</div>
						<!-- /.nav-tabs-custom -->


					</section>
					<!-- /.Left col -->
				</c:forEach>
			</c:if>



			<c:if test="${gatos != null}">

				<!-- Para GATOS -->
				<c:forEach items="${gatos}" var="gato">


					<section class="col-lg-4 connectedSortable petsCadastrados">
						<!-- Custom tabs (Charts with tabs)-->
						<div class="nav-tabs-custom">


							<!-- Tabs within a box -->
							<ul class="nav nav-tabs pull-right">

								<li class="pull-left header"><i
									class="ion ion-social-octocat"></i><strong> Nome:</strong>
									${gato.nome}</li>
								<li><a
									href="Alterar-Foto-do-seu-Gato.pets?idGato=${gato.id}&idPessoa=${gato.pessoa.id}">
										<img alt="Alterar Foto" title="Mudar Foto"
										src="img/cam-peq.png" class="linkCamera"
										onmouseover="this.src='img/cam-peq-hover.png'"
										onmouseout="this.src='img/cam-peq.png'">
								</a></li>
							</ul>
							<div class="tab-content no-padding">

								<!-- TAG TABELA -->
								<ul>
									<li>
										<h3 class="txt-azul"></h3>
									</li>
									<li><c:if test="${gato.nomeImagem != null}">
											<a id="example1" href="images/${gato.nomeImagem}"> <img
												class="img-rounded imgExede" alt="Clique para ampliar"
												src="images/resize_${gato.nomeImagem}"></a>
										</c:if> <c:if
											test="${gato.nomeImagem == null || gato.nomeImagem == '' }">
											<a id="example1" href="img/pets.jpg"><img
												class="img-rounded imgExede" alt="Clique para ampliar"
												src="img/pets.jpg"></a>
										</c:if></li>
									<li></li><li><br><strong>Tipo de Animal:<span class="txt-azul"> ${gato.tipoAnimal}
										</span></strong></li>
									<li><strong>Ra�a:</strong> ${gato.racaGato.nomeRacaGato}</li>
									<li><strong>Sexo:</strong> ${gato.sexo}</li>
									<li><strong>Cor:</strong> ${gato.cor}</li>

									<c:if test="${gato.possuiTag == 'true'}">
										<li><strong>TAG:<span class="txt-verde">
													${gato.tagNumero }</span></strong></li>
									</c:if>
									<c:if test="${gato.possuiTag == 'false'}">
										<li><strong>TAG:</strong> <span class="txt-red">N�o
												possui</span></li>
									</c:if>

									<li><strong>Data Nascimento:</strong> <fmt:formatDate
											value="${gato.dataNascimentoPet}" type="both"
											pattern="dd/MM/yyyy" /></li>
									<li><strong>Descri��o:</strong></li>
									<c:if test="${gato.descricao != ''}">
										<li><textarea readonly="readonly" id="rules" class="form-control"
												style="cursor: pointer;">${gato.descricao}</textarea></li>
									</c:if>
									<c:if test="${gato.descricao == ''}">
										<li><textarea id="rules" class="form-control" style="cursor: pointer;">Nenhuma descri��o.</textarea></li>
									</c:if>
								</ul>
								<br>
								<div align="center">
									<a title="Edite os dados do seu Pet"
										href="Editar-Gato.pets?idGato=${gato.id}&idPessoa=${gato.pessoa.id}">
										<button type='button' class="btn btn-large btn-info">
											<i class="icon-pencil icon-white"></i> Alterar dados
										</button>
									</a>
								</div>
								<br>
								<div align="center">
									<c:if test="${gato.possuiTag == 'false'}">
										<a
											href="Vincular-Tag-dos.pets?idGato=${gato.id}&idPessoa=${gato.pessoa.id}"
											title="vincule a tag"><button type='button'
												class="btn btn-large btn-success">
												<i class="fa fa-lock"></i> Vincular TAG
											</button></a>
									</c:if>
									<c:if test="${gato.possuiTag == 'true'}">
										<a href="#" title="Este Pet possui uma tag"><button
												type='button' disabled="disabled"
												class="btn btn-large btn-default">
												<i class="fa fa-check-square-o"></i> Pet Vinculado
											</button></a>
									</c:if>
								</div>
								<br>
								<div align="center">
								<form id="removerFormGato" method="Post"
											action="RemoverPet.pets">
									<input type="hidden" name="idGato" 
												value="${gato.id}"> 
									<input type="hidden" name="tipoGato" 
												value="tipoGato"> 
									<input type="hidden" name="idPessoa"
												value="${gato.pessoa.id}">		
									<button type="submit" id="removerModalConfirmaCao"
										class="btn btn-danger"><i class="fa fa-times"></i>
										 Remover Pet</button>
								</form>
								
								
								</div>

							</div>
						</div>
						<!-- /.nav-tabs-custom -->

					</section>
					<!-- /.Left col -->

				</c:forEach>
			</c:if>


		</div>
		<!-- /.row (main row) -->

	</section>
	<!-- /.content -->

</c:if>

<c:if test="${gatos == null && dogs == null}">
	<!-- CASO DE GATOS E CACHORROS FOREM NULOS -->
	<div class="hero-unit"
		style="background-color: #EDE6DD; margin-top: 8%;">
		<div class="txt-1" align="center">
			<img alt="Nenhum pet Cadastrado" class="img-responsive"
				src="img/sem-pet.png" style="margin-top: -5%;">
			<h3>Cadastre Agora!</h3>
			<br>
			<p>� muito f�cil cadastrar um Pet. Clique no bot�o abaixo.</p>
			<p>� gratuito e r�pido. Proteja seu melhor amigo.</p>
			<br>
			<p>
				<a type="button" href="Cadastro-do-seu.pet"
					class="btn btn-warning btn-large"> <i
					class="icon-align-justify icon-white"></i> <strong>Cadastrar</strong></a>
			</p>
			<br>
		</div>
	</div>
</c:if>



</div>
<!-- /.content-wrapper -->
<%@ include file="../../includeAdm/rodapeAdm.jsp"%>
<%@ include file="../../../includes/MascarasJS.jsp"%>
<%@ include file="../../includeAdm/fancybox.jsp"%>