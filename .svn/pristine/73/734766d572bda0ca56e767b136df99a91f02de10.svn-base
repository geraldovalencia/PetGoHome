<%@ include file="includes/header.jsp"%>
<%@ include file="includes/MascarasJS.jsp"%>
<%@ include file="../includeIndex/validarForm.jsp"%>
<%@ include file="../includeIndex/buscarCep.jsp"%>

<!-- MEnu Principal -->

<%@ include file="includes/menuPrincipal.jsp"%>

<!-- FIM do MEnu Principal -->


<div id="content">
	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-md-12">


				<div id="msgSenhaErrada" align="center"></div>
				<div align="center">
					<h3 class="laranja semiTitulo">Cadastro do Usuário</h3>
					<p>Preencha o formulário abaixo corretamente para criar a sua
						conta.</p>
					<div class="txt-1">O cadastro do usuário é seu primeiro passo
						no PetGoHome.</div>
					<p>Preencha o formulário abaixo corretamente para criar a sua
						conta.</p>
				</div>
			</div>
			

			<div class="col-xs-offset-2 col-xs-8 col-md-offset-2 col-md-8">
				<form id="contact-form" action="CadastroUsuario.pet" method="post"
					name="chavez" style="margin-top: 5%">


					<div class="form-group">
						<label for="nome">Nome</label> <input class="form-control"
							type="text" id="nome" value='${nome != null ? nome : ""}'
							placeholder="Nome:" maxlength="60" required="required"
							name="nome" autofocus>
					</div>
					<div class="form-group">
						<c:if test="${loginExiste != null }">
							<label for="login">Login</label>
							<input class="form-control"
								style="background-color: #FFF2A8; border-color: #EBC26A;"
								type="text" name="login" id="login" autocomplete="off"
								maxlength="30" required="required" class="marcar"
								placeholder="Login: Preencha de novo">

						</c:if>
						<c:if test="${loginExiste == null }">
							<label for="login">Login</label>
							<input type="text" class="form-control" name="login" id="login"
								autocomplete="off" required="required" class="marcar"
								placeholder="Login: " maxlength="30">
						</c:if>
					</div>



					<div class="form-group">
						<label for="senha">Senha</label> <input class="form-control"
							type="password" id="senha" name="senha" required="required"
							autocomplete="off" placeholder="Senha:" maxlength="50">
					</div>
					<div class="form-group">
						<label for="confirme">Confirme a senha</label> <input
							class="form-control" type="password" onBlur="validarSenha()"
							id="senha2" name="senha2" required="required" autocomplete="off"
							maxlength="50" placeholder="Confirmar senha:">
					</div>
					<div class="form-group">
						<label for="email">E-mail</label> <input type="email"
							class="form-control" id="email"
							value='${email != null ? email : ""}' placeholder="E-mail:"
							required="required" name="email">
					</div>
					<div class="form-group">
						<label for="telefone">Telefone</label> <input
							class="form-control fonemask" type="text" id="fone"
							value='${telefone != null ? telefone : ""}'
							placeholder="Telefone:" maxlength="20" name="telefone">
					</div>
					<div class="form-group">
						<label for="cpf">CPF</label><input type="text"
							class="cpf form-control" id="cpf"
							value='${cpf != null ? cpf : ""}' placeholder="CPF: "
							maxlength="15" required="required" mask="999.999.-99"
							required="required" name="cpf">
					</div>
					<div class="form-group">
						<label for="sexo">SEXO</label> <select class="form-control"
							name="sexo">
							<option>-- Selecione o sexo --</option>
							<option value="Masculino"
								${sexo == 'MASCULINO' ? 'selected="selected"' : ''}>Sexo:
								Masculino</option>
							<option value="Feminino"
								${sexo == 'FEMININO' ? 'selected="selected"' : ''}>Sexo:
								Feminino</option>
						</select>
					</div>

					<div class="form-group">
						<label for="cep">CEP</label><input type="text"
							class="form-control cepmask" value="${cep != null ? cep : ''}"
							size="10" maxlength="9" id="cep"
							onblur="pesquisacep(this.value);"
							placeholder=" CEP: Ex.: 59.000.000" name="cep">
					</div>


					<div class="form-group">
						<br>
						<button type="button" onclick="pesquisacep(cep.value);"
							class="btn btn-large btn-info" id="getEndereco"
							value="Pesquisar CEP">
							Buscar CEP <i class="icon-envelope icon-white"></i>
						</button>
						<br /> <br> <span id="loadingCep"></span>
					</div>


					<div class="form-group">
						<label for="endereco">Logradouro</label> <input type="text"
							class="form-control" id="rua" size="60" readonly="readonly"
							name="rua" placeholder="Rua, Avenida...">
					</div>
					<div class="form-group">
						<label for="numero">Número</label> <input type="text"
							class="form-control" value='${numero != null ? numero : ""}'
							placeholder="Número: 000" name="numero">
					</div>
					<div class="form-group">
						<label for="bairro">Bairro</label> <input type="text"
							class="form-control" id="bairro" size="40" placeholder="Bairro: "
							readonly="readonly" name="bairro">
					</div>


					<div class="form-group">
						<label for="cidade">Cidade</label> <input type="text"
							class="form-control" id="cidade" size="40" readonly="readonly"
							placeholder="Cidade: " name="cidade">
					</div>
					<div class="form-group">
						<label for="estado">Estado</label> <select name='uf' id="uf"
							class="form-control" required aria-required="true">
							<option value=>-- Selecione Estado --</option>
							<c:forEach items="${ufs}" var="ufs">
								<option>${ufs}</option>
							</c:forEach>
						</select>
					</div>


					<div class="buttons-wrapper">
						<button type="submit" class="btn btn-large btn-warning"
							id="Enviar">
							<i class="icon-edit icon-white"></i> Enviar
						</button>
					</div>
				</form>
			</div>
		</div>

	</div>
</div>


<%@ include file="includes/footer.jsp"%>
