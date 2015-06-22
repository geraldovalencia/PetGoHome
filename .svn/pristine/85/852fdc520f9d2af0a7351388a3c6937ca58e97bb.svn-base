<%@ include file="../../includeAdm/topo.jsp"%>
<%@ include file="../../includeAdm/menuADM.jsp"%>
<%@ include file="../../../includeIndex/validaData.jsp"%>

<%@ include file="../../includeAdm/menuLateral.jsp"%>
<%@ include file="../../includeAdm/mensagens.jsp"%>




<!-- Content Header (Page header) -->
<section class="content-header">
	<h1>
		Alterar Perfil <small>de Cachorro</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-home"></i> Home</a></li>
		<li class="active">Alterar Cachorro</li>
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

		<section class="col-lg-7 connectedSortable ui-sortable">


			<!-- TO DO List -->

			<!-- Alterar Dados de DOG ------------------------------------------------ -->
			<div class="box box-info">
				<div class="box-header ui-sortable-handle" style="cursor: move;">
					<i class="fa fa-pencil-square-o"></i>
					<h3 class="box-title">Alterar a dados de ${dog != null ? dog.nome : 'seu Pet.'}!</h3>
					<!-- tools box -->
					<div class="pull-right box-tools">
						<button class="btn btn-info btn-sm" data-widget="remove"
							data-toggle="tooltip" title="" data-original-title="Remove">
							<i class="fa fa-times"></i>
						</button>
					</div>
					<!-- /. tools -->
				</div>
				<div class="box-body">
					<form action="#" method="post" name="chavez">
						<input type='hidden' name='idDogEditado'
							value='${dog != null ? dog.id : ""}' />

						<div class="form-group">
							<label>Nome</label> <input value="${dog != null ? dog.nome : ''}"
								class="form-control" type="text" placeholder="Nome do Pet:"
								name="nomeGato">
						</div>
						<div class="form-group">
							<label>Raça</label> <select name='raca' required="required"
								class="form-control">
								<option value=''>-- Selecione a Raça --</option>
								<c:forEach var="raca" items="${racas}">
									<option value="${raca.id}"
										${raca.id == dog.racaCachorro.id ? 'selected="selected"' : ''}>${raca.nomeRacaCachorro}</option>

								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label>Cor</label> <input class="form-control"
								value="${dog != null ? dog.cor : ''}" type="text"
								placeholder="Cor predominante:" name="cor">
						</div>
						<div class="form-group">
							<label>Sexo</label> <select class="form-control" name="sexo"
								required="required">
								<option>--- Selecione o sexo ---</option>
								<option value="Masculino"
									${dog.sexo == 'MASCULINO' ? 'selected="selected"' : ''}>Sexo:
									Masculino</option>
								<option value="Feminino"
									${dog.sexo == 'FEMININO' ? 'selected="selected"' : ''}>Sexo:
									Feminino</option>
							</select>
						</div>

						<div class="form-group">
							<label>Data de Nascimento</label> <select name="birthday_day"
								id="day" class="form-control">
								<option value='' ${dia == '00' ? 'selected="selected"' : ''}>-
									DIA -</option>
								<option value='01' ${dia == '01' ? 'selected="selected"' : ''}>01</option>
								<option value='02' ${dia == '02' ? 'selected="selected"' : ''}>02</option>
								<option value='03' ${dia == '03' ? 'selected="selected"' : ''}>03</option>
								<option value='04' ${dia == '04' ? 'selected="selected"' : ''}>04</option>
								<option value='05' ${dia == '05' ? 'selected="selected"' : ''}>05</option>
								<option value='06' ${dia == '06' ? 'selected="selected"' : ''}>06</option>
								<option value='07' ${dia == '07' ? 'selected="selected"' : ''}>07</option>
								<option value='08' ${dia == '08' ? 'selected="selected"' : ''}>08</option>
								<option value='09' ${dia == '09' ? 'selected="selected"' : ''}>09</option>
								<option value='10' ${dia == '10' ? 'selected="selected"' : ''}>10</option>
								<option value='11' ${dia == '11' ? 'selected="selected"' : ''}>11</option>
								<option value='12' ${dia == '12' ? 'selected="selected"' : ''}>12</option>
								<option value='13' ${dia == '13' ? 'selected="selected"' : ''}>13</option>
								<option value='14' ${dia == '14' ? 'selected="selected"' : ''}>14</option>
								<option value='15' ${dia == '15' ? 'selected="selected"' : ''}>15</option>
								<option value='16' ${dia == '16' ? 'selected="selected"' : ''}>16</option>
								<option value='17' ${dia == '17' ? 'selected="selected"' : ''}>17</option>
								<option value='18' ${dia == '18' ? 'selected="selected"' : ''}>18</option>
								<option value='19' ${dia == '19' ? 'selected="selected"' : ''}>19</option>
								<option value='20' ${dia == '20' ? 'selected="selected"' : ''}>20</option>
								<option value='21' ${dia == '21' ? 'selected="selected"' : ''}>21</option>
								<option value='22' ${dia == '22' ? 'selected="selected"' : ''}>22</option>
								<option value='23' ${dia == '23' ? 'selected="selected"' : ''}>23</option>
								<option value='24' ${dia == '24' ? 'selected="selected"' : ''}>24</option>
								<option value='25' ${dia == '25' ? 'selected="selected"' : ''}>25</option>
								<option value='26' ${dia == '26' ? 'selected="selected"' : ''}>26</option>
								<option value='27' ${dia == '27' ? 'selected="selected"' : ''}>27</option>
								<option value='28' ${dia == '28' ? 'selected="selected"' : ''}>28</option>
								<option value='29' ${dia == '29' ? 'selected="selected"' : ''}>29</option>
								<option value='30' ${dia == '30' ? 'selected="selected"' : ''}>30</option>
								<option value='31' ${dia == '31' ? 'selected="selected"' : ''}>31</option>

							</select> <select name="birthday_month" class="form-control" id="month"
								onClick="validarData()">
								<option value="" ${mes == '00' ? 'selected="selected"' : ''}>-
									MÊS -</option>
								<option value="01" ${mes == '01' ? 'selected="selected"' : ''}>Janeiro</option>
								<option value="02" ${mes == '02' ? 'selected="selected"' : ''}>Fevereiro</option>
								<option value="03" ${mes == '03' ? 'selected="selected"' : ''}>Março</option>
								<option value="04" ${mes == '04' ? 'selected="selected"' : ''}>Abril</option>
								<option value="05" ${mes == '05' ? 'selected="selected"' : ''}>Maio</option>
								<option value="06" ${mes == '06' ? 'selected="selected"' : ''}>Junho</option>
								<option value="07" ${mes == '07' ? 'selected="selected"' : ''}>Julho</option>
								<option value="08" ${mes == '08' ? 'selected="selected"' : ''}>Agosto</option>
								<option value="09" ${mes == '09' ? 'selected="selected"' : ''}>Setembro</option>
								<option value="10" ${mes == '10' ? 'selected="selected"' : ''}>Outubro</option>
								<option value="11" ${mes == '11' ? 'selected="selected"' : ''}>Novembro</option>
								<option value="12" ${mes == '12' ? 'selected="selected"' : ''}>Dezembro</option>
							</select> <select name="birthday_year" id="year" class="form-control"
								onChange="validarAno();">

								<option value='' ${ano == 'xxxx' ? 'selected="selected"' : ''}>-
									ANO -</option>
								<option value='2014'
									${ano == '2014' ? 'selected="selected"' : ''}>2014</option>
								<option value='2013'
									${ano == '2013' ? 'selected="selected"' : ''}>2013</option>
								<option value='2012'
									${ano == '2012' ? 'selected="selected"' : ''}>2012</option>
								<option value='2011'
									${ano == '2011' ? 'selected="selected"' : ''}>2011</option>
								<option value='2010'
									${ano == '2010' ? 'selected="selected"' : ''}>2010</option>
								<option value='2009'
									${ano == '2009' ? 'selected="selected"' : ''}>2009</option>
								<option value='2008'
									${ano == '2008' ? 'selected="selected"' : ''}>2008</option>
								<option value='2007'
									${ano == '2007' ? 'selected="selected"' : ''}>2007</option>
								<option value='2006'
									${ano == '2006' ? 'selected="selected"' : ''}>2006</option>
								<option value='2005'
									${ano == '2005' ? 'selected="selected"' : ''}>2005</option>
								<option value='2004'
									${ano == '2004' ? 'selected="selected"' : ''}>2004</option>
								<option value='2003'
									${ano == '2003' ? 'selected="selected"' : ''}>2003</option>
								<option value='2002'
									${ano == '2002' ? 'selected="selected"' : ''}>2002</option>
								<option value='2001'
									${ano == '2001' ? 'selected="selected"' : ''}>2001</option>
								<option value='2000'
									${ano == '2000' ? 'selected="selected"' : ''}>2000</option>
								<option value='1999'
									${ano == '1999' ? 'selected="selected"' : ''}>1999</option>
								<option value='1998'
									${ano == '1998' ? 'selected="selected"' : ''}>1998</option>
								<option value='1997'
									${ano == '1997' ? 'selected="selected"' : ''}>1997</option>
								<option value='1996'
									${ano == '1996' ? 'selected="selected"' : ''}>1996</option>
								<option value='1995'
									${ano == '1995' ? 'selected="selected"' : ''}>1995</option>
								<option value='1994'
									${ano == '1994' ? 'selected="selected"' : ''}>1994</option>
								<option value='1993'
									${ano == '1993' ? 'selected="selected"' : ''}>1993</option>
								<option value='1992'
									${ano == '1992' ? 'selected="selected"' : ''}>1992</option>
								<option value='1991'
									${ano == '1991' ? 'selected="selected"' : ''}>1991</option>

							</select>
						</div>
						<br>


						<div>
							<label>Descrição física do seu Pet</label>
							<textarea class="form-control" name="descricao"
								placeholder="Descrição: breve do pet (tamanho, cor) e mais informações relevantes, como observações médicas: ">${dog != null ? dog.descricao : ''}</textarea>

						</div>
						<br>
						<div class="box-footer clearfix" align="right">
							<button id="Enviar" type="submit"
								class="btn btn-large btn-warning">
								<i class="icon-edit icon-white"></i><strong> Alterar</strong>
							</button>
							<a href="Index.pet" class="btn btn-large btn-danger"> <i
								class="icon-remove icon-white"></i> Cancelar
							</a>
						</div>
					</form>
				</div>
			</div>
		</section>
		<section class="col-lg-5 connectedSortable ui-sortable">

			<div class="box box-info">
				<div class="box-header ui-sortable-handle" style="cursor: move;">
					<i class="fa fa-picture-o"></i>
					<h3 class="box-title">Foto</h3>
					<div class="box-tools pull-right">
						<button class="btn bg-teal btn-sm" data-widget="collapse">
							<i class="fa fa-minus"></i>
						</button>
						<button class="btn bg-teal btn-sm" data-widget="remove">
							<i class="fa fa-times"></i>
						</button>
					</div>
				</div>
				<div class="box-body border-radius-none">
					<div>

						<div align="center">
							<c:choose>
								<c:when test="${pessoaLogado != null}">
									<div class="form-group">
										<p>Clique no botão abaixo para fazer a alteração.</p>
										<c:if test="${dog.nomeImagem != null}">
											<a id="example1" href="images/${dog.nomeImagem}"><img
												style="width: 80%; height: 100%"
												class="img-rounded form-control animated fadeIn"
												alt="Clique para ampliar" src="images/${dog.nomeImagem}"></a>
										</c:if>
										<c:if
											test="${dog.nomeImagem == null || dog.nomeImagem == '' }">
											<a id="example1" href="img/pets.jpg"><img
												class="img-rounded animated fadeIn" style="width: 70%;"
												alt="Clique para ampliar" src="img/pets.jpg"></a>
										</c:if>
										<br> <a
											href="Alterar-Foto-do-seu.pets?idDog=${dog.id}&idPessoa=${dog.pessoa.id}">
											<button type="submit" class="btn btn-large btn-danger">
												<i class="icon-camera icon-white"></i> <strong>Alterar
													Foto</strong>
											</button>
										</a>

										<c:if test="${dog.tagNumero != null}">
											<h3>Seu Pet está protegindo!</h3>
											<a id="example1" href="img/icones/tag-vinculado.png"><img
												style="width: 70%;" class="img-rounded animated fadeIn"
												alt="Clique para ampliar" src="img/icones/tag-vinculado.png"></a>
											<h3 style="margin-left: 10%;">
												Sua Tag é: <span class="txt-verde">${dog.tagNumero }</span>
											</h3>
										</c:if>
										<c:if test="${dog.tagNumero == null}">
											<h3>Seu Pet não está protegindo</h3>
											<a id="example1" href="img/icones/tag-nao-vinculado.png"
												title="vincule a tag"><img style="width: 70%;"
												class="img-rounded animated fadeIn"
												alt="Clique para ampliar"
												src="img/icones/tag-nao-vinculado.png"></a>
											<h3>
												Cadastre uma tag: <a
													href="Vincular-Tag-dos.pets?idDog=${dog.id}&idPessoa=${dog.pessoa.id}"
													title="vincule a tag">Clique aqui</a>
											</h3>
										</c:if>
									</div>
									<div>


										<form id="contact-form" action="Editar-Cachorro.pets"
											method="post"></form>
									</div>
								</c:when>
								<c:otherwise>
								</c:otherwise>
							</c:choose>
						</div>











					</div>
				</div>

				<!-- /.box-footer -->
			</div>




		</section>
















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
<%@ include file="../../includeAdm/fancybox.jsp"%>