<%@ include file="fancybox.jsp"%>

<div class="container">
	<div class="navbar navbar_ clearfix">
		<ul class="list-soc">

			<!--         <li><a href="#"><img alt="" src="img/soc-icon2.png"></a></li> -->
			<!--         <li><a href="#"><img alt="" src="img/soc-icon3.png"></a></li> -->
		</ul>
		<div class="nav-collapse nav-collapse_  collapse">
			<ul class="nav sf-menu" style="cursor: pointer">
				<c:choose>
					<c:when test="${pessoaLogado != null}">
						<c:choose>
							<c:when
								test="${home != null || comoFuncionaActive != null || encontreiPet != null || contato != null}">

								<c:if test="${home != null}">
									<li><a href="Index.pet" style="width: 120px; margin-top: -11%;"><img src="img/online.png" alt="Online" style="width: 100%"></a></li>
									<li><a href="Como-funciona.pet">Como Funciona</a></li>
									<li><a href="#">Cadastre Agora!</a>
										<ul>
											<li><a href="Cadastro-do-seu.pet">Cadastrar pet</a></li>
										</ul></li>
									<li id="Encontrei"><a href="Encontrei.pet">Encontrei
											um PET</a></li>
									<li id="contato"><a href="Contato.pet">Contato</a></li>
								</c:if>
								<c:if test="${comoFuncionaActive != null}">
									<li><a href="Index.pet" style="width: 120px; margin-top: -11%;"><img src="img/online.png" alt="Online" style="width: 100%"></a></li>
									<li class="active"><a href="Como-funciona.pet">Como
											Funciona</a></li>
									<li><a href="#">Cadastre Agora!</a>
										<ul>
											<li><a href="Cadastro-do-seu.pet">Cadastrar pet</a></li>
										</ul></li>
									<li id="Encontrei.pet"><a href="Encontrei.pet">Encontrei
											um PET</a></li>
									<li id="contato"><a href="Contato.pet">Contato</a></li>
								</c:if>
								<c:if test="${encontreiPet != null}">
									<li><a href="Index.pet" style="width: 120px; margin-top: -11%;"><img src="img/online.png" alt="Online" style="width: 100%"></a></li>
									<li><a href="Como-funciona.pet">Como Funciona</a></li>
									<li><a href="#">Cadastre Agora!</a>
										<ul>
											<li><a href="Cadastro-do-seu.pet">Cadastrar pet</a></li>
										</ul></li>
									<li class="active" id="Encontrei.pet"><a
										href="Encontrei.pet">Encontrei um PET</a></li>
									<li id="contato"><a href="Contato.pet">Contato</a></li>
								</c:if>
								<c:if test="${contato != null}">
									<li><a href="Index.pet" style="width: 120px; margin-top: -11%;"><img src="img/online.png" alt="Online" style="width: 100%"></a></li>
									<li><a href="Como-funciona.pet">Como Funciona</a></li>
									<li><a href="#">Cadastre Agora!</a>
										<ul>
											<li><a href="Cadastro-do-seu.pet">Cadastrar pet</a></li>
										</ul></li>
									<li id="Encontrei"><a
										href="Encontrei.pet">Encontrei um PET</a></li>
									<li class="active" id="contato"><a href="Contato.pet">Contato</a></li>
								</c:if>
							</c:when>
							<c:otherwise>
								<li><a href="Index.pet" style="width: 120px; margin-top: -11%;"><img src="img/online.png" alt="Online" style="width: 100%"></a></li>
								<li><a href="Como-funciona.pet">Como Funciona</a></li>
								<li><a href="#">Cadastre Agora!</a>
									<ul>
										<li><a href="Cadastro-do-seu.pet">Cadastrar pet</a></li>
									</ul></li>
								<li id="Encontrei.pet"><a href="Encontrei.pet">Encontrei
										um PET</a></li>
								<li id="contato"><a href="Contato.pet">Contato</a></li>
							</c:otherwise>
						</c:choose>
					</c:when>
					<c:otherwise>
						<!-- PESSOA NAO LOGADA -->
						<c:if
							test="${home != null || comoFuncionaActive != null || encontreiPet != null || contato != null}">

							<c:if test="${home != null}">
								<li class="active"><a href="Index.pet">Home</a></li>
								<li><a href="" data-toggle="modal" data-target="#myModal">Login</a></li>
								<li><a href="Como-funciona.pet">Como Funciona</a></li>
								<li><a href="#">Cadastre Agora!</a>
									<ul>
										<li><a href="Cadastro-de-Usuario.pet">Cadastro do
												usuário</a></li>
										<li><a href="Cadastro-do-seu.pet">Cadastrar pet</a></li>
									</ul></li>
								<li id="Encontrei.pet"><a href="Encontrei.pet">Encontrei
										um PET</a></li>
								<li id="contato"><a href="Contato.pet">Contato</a></li>
							</c:if>
							<c:if test="${comoFuncionaActive != null}">
								<li><a href="Index.pet">Home</a></li>
								<li><a href="" data-toggle="modal" data-target="#myModal">Login</a></li>
								<li class="active"><a href="Como-funciona.pet">Como
										Funciona</a></li>
								<li><a href="#">Cadastre Agora!</a>
									<ul>
										<li><a href="Cadastro-de-Usuario.pet">Cadastro do
												usuário</a></li>
										<li><a href="Cadastro-do-seu.pet">Cadastrar pet</a></li>
									</ul></li>
								<li id="Encontrei.pet"><a href="Encontrei.pet">Encontrei
										um PET</a></li>
								<li id="contato"><a href="Contato.pet">Contato</a></li>
							</c:if>
							<c:if test="${encontreiPet != null}">
								<li><a href="Index.pet">Home</a></li>
								<li><a href="" data-toggle="modal" data-target="#myModal">Login</a></li>
								<li><a href="Como-funciona.pet">Como Funciona</a></li>
								<li><a href="#">Cadastre Agora!</a>
									<ul>
										<li><a href="Cadastro-de-Usuario.pet">Cadastro do
												usuário</a></li>
										<li><a href="Cadastro-do-seu.pet">Cadastrar pet</a></li>
									</ul></li>
								<li class="active" id="Encontrei.pet"><a
									href="Encontrei.pet">Encontrei um PET</a></li>
								<li id="contato"><a href="Contato.pet">Contato</a></li>
							</c:if>
							<c:if test="${contato != null}">
								<li><a href="Index.pet">Home</a></li>
								<li><a href="" data-toggle="modal" data-target="#myModal">Login</a></li>
								<li><a href="Como-funciona.pet">Como Funciona</a></li>
								<li><a href="#">Cadastre Agora!</a>
									<ul>
										<li><a href="Cadastro-de-Usuario.pet">Cadastro do
												usuário</a></li>
										<li><a href="Cadastro-do-seu.pet">Cadastrar pet</a></li>
									</ul></li>
								<li id="Encontrei.pet"><a href="Encontrei.pet">Encontrei
										um PET</a></li>
								<li class="active" id="contato"><a href="Contato.pet">Contato</a></li>
							</c:if>
						</c:if>
						<c:if
							test="${home == null && comoFuncionaActive == null && encontreiPet == null && contato == null}">
							<li><a href="Index.pet">Home</a></li>
							<li><a href="" data-toggle="modal" data-target="#myModal">Login</a></li>
							<li><a href="Como-funciona.pet">Como Funciona</a></li>
							<li><a href="#">Cadastre Agora!</a>
								<ul>
									<li><a href="Cadastro-de-Usuario.pet">Cadastro do
											usuário</a></li>
									<li><a href="Cadastro-do-seu.pet">Cadastrar pet</a></li>
								</ul></li>
							<li id="Encontrei.pet"><a href="Encontrei.pet">Encontrei
									um PET</a></li>
							<li id="contato"><a href="Contato.pet">Contato</a></li>
						</c:if>
					</c:otherwise>
				</c:choose>

			</ul>
		</div>

	</div>

	<c:choose>
		<c:when test="${pessoaLogado != null}">
			<ul class="nav nav-tabs">
				<c:choose>
					<c:when
						test="${home != null || meusPetsOn != null || profile != null  }">
						<c:if test="${home != null }">
							<li class="active"><a href="Index.pet"><i
									class="icon-home" style=""></i> Home</a></li>
							<li><a href="Pets-Cadastrados.pets">Meus Pet's</a></li>
							<li><a href="Profile.pets">Perfil</a></li>
							<c:if test="${menuAdm != null}">
								<li><a href="Listar-Usuarios.adm">Listar Usuarios</a></li>
								<li><a href="Listar-Pet.adm">Listar Pet's</a></li>
								<li><a href="Listar-PetShop.adm">Listar PetShop's</a></li>
								<li><a href="Listar-Tags.adm">Listar Tag's</a></li>
							</c:if>
							<li><a href="" data-toggle="modal"
								data-target="#myModalSair" style="cursor: pointer">Sair</a></li>
						</c:if>
						<c:if test="${meusPetsOn != null }">
							<li><a href="Index.pet"><i class="icon-home"></i> Home</a></li>
							<li class="active"><a href="Pets-Cadastrados.pets">${meusPetsOn}</a></li>
							<li><a href="Profile.pets">Perfil</a></li>
							<c:if test="${menuAdm != null}">
								<li><a href="Listar-Usuarios.adm">Listar Usuarios</a></li>
								<li><a href="Listar-Pet.adm">Listar Pet's</a></li>
								<li><a href="Listar-PetShop.adm">Listar PetShop's</a></li>
								<li><a href="Listar-Tags.adm">Listar Tag's</a></li>								
							</c:if>
							<li><a href="" data-toggle="modal"
								data-target="#myModalSair" style="cursor: pointer">Sair</a></li>
						</c:if>
						<c:if test="${profile != null }">
							<li><a href="Index.pet"><i class="icon-home"></i> Home</a></li>
							<li><a href="Pets-Cadastrados.pets">Meus Pet's</a></li>
							<li class="active"><a href="Profile.pets">Perfil</a></li>
							<c:if test="${menuAdm != null}">
								<li><a href="Listar-Usuarios.adm">Listar Usuarios</a></li>
								<li><a href="Listar-Pet.adm">Listar Pet's</a></li>
								<li><a href="Listar-PetShop.adm">Listar PetShop's</a></li>
								<li><a href="Listar-Tags.adm">Listar Tag's</a></li>
							</c:if>
							<li><a href="" data-toggle="modal"
								data-target="#myModalSair" style="cursor: pointer">Sair</a></li>
						</c:if>
					</c:when>
					<c:otherwise>
						<c:if test="${listagemUsuario != null}">
							<li><a href="Index.pet"><i class="icon-home"></i> Home</a></li>
							<li><a href="Pets-Cadastrados.pets">Meus Pet's</a></li>
							<li><a href="Profile.pets">Perfil</a></li>
							<c:if test="${menuAdm != null}">
								<li class="active"><a href="Listar-Usuarios.adm">Listar
										Usuarios</a></li>
								<li><a href="Listar-Pet.adm">Listar Pet's</a></li>
								<li><a href="Listar-PetShop.adm">Listar PetShop's</a></li>
								<li><a href="Listar-Tags.adm">Listar Tag's</a></li>
							</c:if>
							<li><a href="" data-toggle="modal"
								data-target="#myModalSair" style="cursor: pointer">Sair</a></li>
						</c:if>
						<c:if test="${listagemPet != null}">
							<li><a href="Index.pet"><i class="icon-home"></i> Home</a></li>
							<li><a href="Pets-Cadastrados.pets">Meus Pet's</a></li>
							<li><a href="Profile.pets">Perfil</a></li>
							<c:if test="${menuAdm != null}">
								<li><a href="Listar-Usuarios.adm">Listar Usuarios</a></li>
								<li class="active"><a href="Listar-Pet.adm">Listar
										Pet's</a></li>
								<li><a href="Listar-PetShop.adm">Listar PetShop's</a></li>
								<li><a href="Listar-Tags.adm">Listar Tag's</a></li>
							</c:if>
							<li><a href="" data-toggle="modal"
								data-target="#myModalSair" style="cursor: pointer">Sair</a></li>
						</c:if>
						<c:if test="${listagemPetshop != null}">
							<li><a href="Index.pet"><i class="icon-home"></i> Home</a></li>
							<li><a href="Pets-Cadastrados.pets">Meus Pet's</a></li>
							<li><a href="Profile.pets">Perfil</a></li>
							<c:if test="${menuAdm != null}">
								<li><a href="Listar-Usuarios.adm">Listar Usuarios</a></li>
								<li ><a href="Listar-Pet.adm">Listar
										Pet's</a></li>
								<li class="active"><a href="Listar-PetShop.adm">Listar PetShop's</a></li>
								<li><a href="Listar-Tags.adm">Listar Tag's</a></li>
							</c:if>
							<li><a href="" data-toggle="modal"
								data-target="#myModalSair" style="cursor: pointer">Sair</a></li>
						</c:if>
						<c:if test="${listagemTags != null}">
							<li><a href="Index.pet"><i class="icon-home"></i> Home</a></li>
							<li><a href="Pets-Cadastrados.pets">Meus Pet's</a></li>
							<li><a href="Profile.pets">Perfil</a></li>
							<c:if test="${menuAdm != null}">
								<li><a href="Listar-Usuarios.adm">Listar Usuarios</a></li>
								<li ><a href="Listar-Pet.adm">Listar
										Pet's</a></li>
								<li ><a href="Listar-PetShop.adm">Listar PetShop's</a></li>
								<li class="active"><a href="Listar-Tags.adm">Listar Tag's</a></li>
							</c:if>
							<li><a href="" data-toggle="modal"
								data-target="#myModalSair" style="cursor: pointer">Sair</a></li>
						</c:if>
						<c:if test="${listagemPet == null && listagemUsuario == null && listagemPetshop == null && listagemTags == null}">
							<li><a href="Index.pet"><i class="icon-home"></i> Home</a></li>
							<li><a href="Pets-Cadastrados.pets">Meus Pet's</a></li>
							<li><a href="Profile.pets">Perfil</a></li>
							<c:if test="${menuAdm != null}">
								<li><a href="Listar-Usuarios.adm">Listar Usuarios</a></li>
								<li><a href="Listar-Pet.adm">Listar
										Pet's</a></li>
								<li><a href="Listar-PetShop.adm">Listar PetShop's</a></li>
								<li><a href="Listar-Tags.adm">Listar Tag's</a></li>
							</c:if>
							<li><a href="" data-toggle="modal"
								data-target="#myModalSair" style="cursor: pointer">Sair</a></li>
						</c:if>
					</c:otherwise>
				</c:choose>
			</ul>
		</c:when>
		<c:otherwise></c:otherwise>
	</c:choose>

	<div align='center'>

		<strong>${message} ${messageErro}</strong>
		<c:remove var="message" scope="session" />
		<c:remove var="messageErro" scope="session" />
	</div>