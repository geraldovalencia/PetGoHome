<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand img-responsive" href="Index.pet"> <img
						class="img-responsive" alt="" src="imagens/TAG-PetGoHome.jpg">
					</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">

					<ul class="nav navbar-nav navbar-right">
					
					
					
					<c:choose>
					<c:when test="${loginBoolean == true || comoFuncionaActive == true || cadastroUser == true
					|| contato == true || encontreiPet == true}">

						<c:if test="${loginBoolean == true }">
						
							<%@ include file="menus/menuLoginActive.jsp"%>
						
						</c:if>
						<c:if test="${comoFuncionaActive == true }">
						
							<%@ include file="menus/menuComoFunciona.jsp"%>
						
						</c:if>
						<c:if test="${cadastroUser == true }">
						
							<%@ include file="menus/menuCadastroUser.jsp"%>
						
						</c:if>
						<c:if test="${encontreiPet == true }">
						
							<%@ include file="menus/menuEncontreiPet.jsp"%>
						
						</c:if>
						<c:if test="${contato == true }">
						
							<%@ include file="menus/menuContato.jsp"%>
						
						</c:if>
					</c:when>
					<c:otherwise>
					
						<li><a class="active" href="Index.pet">Home</a></li>
						<li><a href="Login-de-usuario.pet">Login</a></li>
						<li><a href="Como-funciona.pet">Como Funciona</a>
						<li><a href="Cadastro-de-Usuario.pet">Cadastre-se</a>
						<li><a href="Encontrei.pet">Encontrei um PET</a>
						<li><a href="Contato.pet">Contato</a></li>
						
					</c:otherwise>	
				</c:choose>


					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
			<!--/.container-fluid --> </nav>
		</header>
		
		
		<div align='center'>

		<strong>${message} ${messageErro}</strong>
			<c:remove var="message" scope="session" />
			<c:remove var="messageErro" scope="session" />
		</div>