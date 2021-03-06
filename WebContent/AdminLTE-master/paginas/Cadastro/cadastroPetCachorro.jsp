<%@ include file="../../includeAdm/topo.jsp"%>
<script type="text/javascript" src="antigo_js/jquery.js"></script>
<%@ include file="../../../includes/MascarasJS.jsp"%>
<%@ include file="../../../includeIndex/validarForm.jsp"%>
<%@ include file="../../../includeIndex/buscarCep.jsp"%>
<%@ include file="../../includeAdm/menuADM.jsp"%>
<%@ include file="../../../includeIndex/validaData.jsp"%>


<%@ include file="../../includeAdm/menuLateral.jsp"%>
<%@ include file="../../includeAdm/mensagens.jsp"%>


<!-- Content Header (Page header) -->
<section class="content-header">
	<h1>
		Cadastro de PET <small>Preencha os campos abaixo</small>
	</h1>
	<ol class="breadcrumb">
		<li><a href="IndexUser.pet"><i class="fa fa-home"></i> Home</a></li>
		<li>Cadastro de PET</li>
		<li class="active">Registar Cachorro</li>
	</ol>
</section>

<!-- Main content -->
<section class="content">


	<!-- ------------------------------------------- PETS de info ----------------------------------------------- -->

	<div class="row">
		<div class="col-xs-12 col-md-12" style="margin-bottom: 3%;">


			<div id="msgSenhaErrada" align="center"></div>
			<div align="center">
				<h3 class="laranja semiTitulo">Registar Cachorro</h3>
					<small>Preencha todos os dados. � importante enviar uma foto do seu PET.</small>
			</div>
		</div>
		<br>
	</div>
	<div class="row">
			
			
			
			
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

					<form id="contact-form" action="Cadastro-de-Animal.pets" class="formulario"
					method="post" enctype="multipart/form-data" name="chavez">
					
					<div id="msgSenhaErrada" align="center"></div>
					
						<div class="form-group">
							<label>Nome </label>
							<input class="form-control"
								type="text" placeholder="Nome do Pet:" required="required"
								name="nomeCachorro" autofocus> 
							
						</div>
						<div class="form-group">
							<label>Ra�a </label><select name='raca'
								class="form-control" required="required">
									<option value=''>-- Selecione a Ra�a --</option>
									<c:forEach var="raca" items="${racas}">
										<option value='${raca.id}'>${raca.nomeRacaCachorro}</option>

									</c:forEach>
							</select> 
							
						</div>
						<div class="form-group">
							<label >Cor </label><input type="text" class="form-control"
								placeholder="Cor predominante:" name="cor"> 
							
						</div>
						<div class="form-group">
							<label>Sexo</label> <select name="sexo"
								required="required" class="form-control">
									<option>--- Selecione o sexo ---</option>
									<option value="Masculino">Sexo: Masculino</option>
									<option value="Feminino">Sexo: Feminino</option>
							</select> 
						</div>

						<div class="form-group">
							<label class="data">Data de Nascimento</label> 
								
								<select name="birthday_day" class="form-control"
									id="day">
									<option>- DIA -</option>
										<option value="01">1</option>
										<option value="02">2</option>
										<option value="03">3</option>
										<option value="04">4</option>
										<option value="05">5</option>
										<option value="06">6</option>
										<option value="07">7</option>
										<option value="08">8</option>
										<option value="09">9</option>
										<option value="10">10</option>
										<option value="11">11</option>
										<option value="12">12</option>
										<option value="13">13</option>
										<option value="14">14</option>
										<option value="15">15</option>
										<option value="16">16</option>
										<option value="17">17</option>
										<option value="18">18</option>
										<option value="19">19</option>
										<option value="20">20</option>
										<option value="21">21</option>
										<option value="22">22</option>
										<option value="23">23</option>
										<option value="24">24</option>
										<option value="25">25</option>
										<option value="26">26</option>
										<option value="27">27</option>
										<option value="28">28</option>
										<option value="29">29</option>
										<option value="30">30</option>
										<option value="31">31</option></select>
							 
							
							  <select name="birthday_month" class="form-control"
									id="month" onClick="validarData()">
									<option>- M�S -</option>
										<option value="01">Janeiro</option>
										<option value="02">Fevereiro</option>
										<option value="03">Mar�o</option>
										<option value="04">Abril</option>
										<option value="05">Maio</option>
										<option value="06">Junho</option>
										<option value="07">Julho</option>
										<option value="08">Agosto</option>
										<option value="09">Setembro</option>
										<option value="10">Outubro</option>
										<option value="11">Novembro</option>
										<option value="12">Dezembro</option></select>

							<select name="birthday_year"
									id="year"  class="form-control"
									onChange="validarAno();">
									
									<option>- ANO -</option>
										<option value="2014"onClick="validarData();" >2014</option>
										<option value="2013"onClick="validarData();" >2013</option>
										<option value="2012"onClick="validarData();" >2012</option>
										<option value="2011"onClick="validarData();" >2011</option>
										<option value="2010"onClick="validarData();" >2010</option>
										<option value="2009"onClick="validarData();" >2009</option>
										<option value="2008"onClick="validarData();" >2008</option>
										<option value="2007"onClick="validarData();" >2007</option>
										<option value="2006"onClick="validarData();" >2006</option>
										<option value="2005"onClick="validarData();" >2005</option>
										<option value="2004"onClick="validarData();" >2004</option>
										<option value="2003"onClick="validarData();" >2003</option>
										<option value="2002"onClick="validarData();" >2002</option>
										<option value="2001"onClick="validarData();" >2001</option>
										<option value="2000"onClick="validarData();" >2000</option>
										<option value="1999">1999</option>
										<option value="1998">1998</option>
										<option value="1997">1997</option>
										<option value="1996">1996</option>
										<option value="1995">1995</option>
										<option value="1994">1994</option>
										<option value="1993">1993</option>
										<option value="1992">1992</option>
										<option value="1991">1991</option>
										<option value="1990">1990</option>
										</select>
						</div>
						
						<div class="form-group">
							<label>Foto do seu Pet: </label>
							<input class="form-control" type="file" name="fileFoto" onClick="validarAno();">
							
						</div><br>

						<div class="clear"></div>
						<div>
						<span><strong></strong></span>
							<label>Descri��o f�sica do seu Pet</label> <textarea name="descricao"   class="form-control"
									placeholder="Descri��o: breve do pet (tamanho, cor) e mais informa��es relevantes, como observa��es m�dicas: "></textarea>
								
							
						</div>
						<br /> <br />
						<div class="buttons-wrapper">
							<button type="submit" id="Enviar" disabled="disabled" class="btn btn-large btn-warning">
								<i class="icon-edit icon-white"></i> Enviar
							</button>
							<a href="Index.pet"  
							class="btn btn-large btn-danger">
							<i class="icon-remove icon-white"></i> Cancelar	
							</a>
						</div>
				</form>
				</div>

			
			
			
			
			</div>
		</section>
		<!-- /.Left col -->
	</div>
</section>
<!-- /.content -->
</div>

<!-- /.content-wrapper -->
<%@ include file="../../includeAdm/rodapeAdm.jsp"%>