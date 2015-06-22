 <!-- Left side column. contains the logo and sidebar -->
      <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
          <!-- Sidebar user panel -->
          <div class="user-panel">
            <div class="pull-left image">
              <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image" />
            </div>
            <div class="pull-left info">
            
              <p>${usuarioOnline}</p>

              <a href="Profile.pets"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
          </div>
          <!-- search form -->
          <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
              <input type="text" name="q" class="form-control" placeholder="Search..."/>
              <span class="input-group-btn">
                <button type='submit' name='search' id='search-btn' class="btn btn-flat"><i class="fa fa-search"></i></button>
              </span>
            </div>
          </form>
          <!-- /.search form -->
          <!-- sidebar menu: : style can be found in sidebar.less -->
          <ul class="sidebar-menu">
            <li class="header">MENU DE NAVEGAÇÃO</li>
            
            
           
           
           <c:choose>
		<c:when test="${pessoaLogado != null}">
				<c:choose>
					<c:when
						test="${home != null || meusPetsOn != null || profile != null  }">
						<c:if test="${home != null }">
							<li class="active"><a href="IndexUser.pet"><i
									style=""></i> <i class="fa fa-home"></i>Home</a></li>
							<li><a href="Pets-Cadastrados.pets"> <i class="fa fa-github-alt"></i>Meus Pet's</a></li>
							<li><a href="Profile.pets"><i class="fa fa-user"></i>Perfil</a></li>
							<c:if test="${menuAdm != null}">
								<li><a href="Listar-Usuarios.adm"><i class="fa fa-users"></i>Listar Usuarios</a></li>
								<li><a href="Listar-Pet.adm"><i class="fa fa-github"></i>Listar Pet's</a></li>
								<li><a href="Listar-PetShop.adm"><i class="fa fa-gift"></i>Listar PetShop's</a></li>
								<li><a href="Listar-Tags.adm"><i class="fa fa-tags"></i>Listar Tag's</a></li>
							</c:if>
							<li><a href="Logout.pet" 
								 style="cursor: pointer"><i class="fa fa-reply"></i>Sair</a></li>
						</c:if>
						<c:if test="${meusPetsOn != null }">
							<li><a href="IndexUser.pet"><i class="icon-home"></i> <i class="fa fa-home"></i>Home</a></li>
							<li class="active"><a href="Pets-Cadastrados.pets"> <i class="fa fa-github-alt"></i>${meusPetsOn}</a></li>
							<li><a href="Profile.pets"><i class="fa fa-user"></i>Perfil</a></li>
							<c:if test="${menuAdm != null}">
								<li><a href="Listar-Usuarios.adm"><i class="fa fa-users"></i>Listar Usuarios</a></li>
								<li><a href="Listar-Pet.adm"><i class="fa fa-github"></i>Listar Pet's</a></li>
								<li><a href="Listar-PetShop.adm"><i class="fa fa-gift"></i>Listar PetShop's</a></li>
								<li><a href="Listar-Tags.adm"><i class="fa fa-tags"></i>Listar Tag's</a></li>								
							</c:if>
							<li><a href="Logout.pet" 
								 style="cursor: pointer"><i class="fa fa-reply"></i>Sair</a></li>
						</c:if>
						<c:if test="${profile != null }">
							<li><a href="IndexUser.pet"><i class="icon-home"></i> <i class="fa fa-home"></i>Home</a></li>
							<li><a href="Pets-Cadastrados.pets"> <i class="fa fa-github-alt"></i>Meus Pet's</a></li>
							<li class="active"><a href="Profile.pets"><i class="fa fa-user"></i>Perfil</a></li>
							<c:if test="${menuAdm != null}">
								<li><a href="Listar-Usuarios.adm"><i class="fa fa-users"></i>Listar Usuarios</a></li>
								<li><a href="Listar-Pet.adm"><i class="fa fa-github"></i>Listar Pet's</a></li>
								<li><a href="Listar-PetShop.adm"><i class="fa fa-gift"></i>Listar PetShop's</a></li>
								<li><a href="Listar-Tags.adm"><i class="fa fa-tags"></i>Listar Tag's</a></li>
							</c:if>
							<li><a href="Logout.pet" 
								 style="cursor: pointer"><i class="fa fa-reply"></i>Sair</a></li>
						</c:if>
					</c:when>
					<c:otherwise>
						<c:if test="${listagemUsuario != null}">
							<li><a href="IndexUser.pet"><i class="icon-home"></i> <i class="fa fa-home"></i>Home</a></li>
							<li><a href="Pets-Cadastrados.pets"> <i class="fa fa-github-alt"></i>Meus Pet's</a></li>
							<li><a href="Profile.pets"><i class="fa fa-user"></i>Perfil</a></li>
							<c:if test="${menuAdm != null}">
								<li class="active"><a href="Listar-Usuarios.adm"><i class="fa fa-users"></i>Listar
										Usuarios</a></li>
								<li><a href="Listar-Pet.adm"><i class="fa fa-github"></i>Listar Pet's</a></li>
								<li><a href="Listar-PetShop.adm"><i class="fa fa-gift"></i>Listar PetShop's</a></li>
								<li><a href="Listar-Tags.adm"><i class="fa fa-tags"></i>Listar Tag's</a></li>
							</c:if>
							<li><a href="Logout.pet" 
								 style="cursor: pointer"><i class="fa fa-reply"></i>Sair</a></li>
						</c:if>
						<c:if test="${listagemPet != null}">
							<li><a href="IndexUser.pet"><i class="icon-home"></i> <i class="fa fa-home"></i>Home</a></li>
							<li><a href="Pets-Cadastrados.pets"> <i class="fa fa-github-alt"></i>Meus Pet's</a></li>
							<li><a href="Profile.pets"><i class="fa fa-user"></i>Perfil</a></li>
							<c:if test="${menuAdm != null}">
								<li><a href="Listar-Usuarios.adm"><i class="fa fa-users"></i>Listar Usuarios</a></li>
								<li class="active"><a href="Listar-Pet.adm"><i class="fa fa-github"></i>Listar
										Pet's</a></li>
								<li><a href="Listar-PetShop.adm"><i class="fa fa-gift"></i>Listar PetShop's</a></li>
								<li><a href="Listar-Tags.adm"><i class="fa fa-tags"></i>Listar Tag's</a></li>
							</c:if>
							<li><a href="Logout.pet" 
								 style="cursor: pointer"><i class="fa fa-reply"></i>Sair</a></li>
						</c:if>
						<c:if test="${listagemPetshop != null}">
							<li><a href="IndexUser.pet"><i class="icon-home"></i> <i class="fa fa-home"></i>Home</a></li>
							<li><a href="Pets-Cadastrados.pets"> <i class="fa fa-github-alt"></i>Meus Pet's</a></li>
							<li><a href="Profile.pets"><i class="fa fa-user"></i>Perfil</a></li>
							<c:if test="${menuAdm != null}">
								<li><a href="Listar-Usuarios.adm"><i class="fa fa-users"></i>Listar Usuarios</a></li>
								<li ><a href="Listar-Pet.adm"><i class="fa fa-github"></i>Listar
										Pet's</a></li>
								<li class="active"><a href="Listar-PetShop.adm"><i class="fa fa-gift"></i>Listar PetShop's</a></li>
								<li><a href="Listar-Tags.adm"><i class="fa fa-tags"></i>Listar Tag's</a></li>
							</c:if>
							<li><a href="Logout.pet" 
								 style="cursor: pointer"><i class="fa fa-reply"></i>Sair</a></li>
						</c:if>
						<c:if test="${listagemTags != null}">
							<li><a href="IndexUser.pet"><i class="icon-home"></i> <i class="fa fa-home"></i>Home</a></li>
							<li><a href="Pets-Cadastrados.pets"> <i class="fa fa-github-alt"></i>Meus Pet's</a></li>
							<li><a href="Profile.pets"><i class="fa fa-user"></i>Perfil</a></li>
							<c:if test="${menuAdm != null}">
								<li><a href="Listar-Usuarios.adm"><i class="fa fa-users"></i>Listar Usuarios</a></li>
								<li ><a href="Listar-Pet.adm"><i class="fa fa-github"></i>Listar
										Pet's</a></li>
								<li ><a href="Listar-PetShop.adm"><i class="fa fa-gift"></i>Listar PetShop's</a></li>
								<li class="active"><a href="Listar-Tags.adm"><i class="fa fa-tags"></i>Listar Tag's</a></li>
							</c:if>
							<li><a href="Logout.pet" 
								 style="cursor: pointer"><i class="fa fa-reply"></i>Sair</a></li>
						</c:if>
						<c:if test="${listagemPet == null && listagemUsuario == null && listagemPetshop == null && listagemTags == null}">
							<li><a href="IndexUser.pet"><i class="icon-home"></i> <i class="fa fa-home"></i>Home</a></li>
							<li><a href="Pets-Cadastrados.pets"> <i class="fa fa-github-alt"></i>Meus Pet's</a></li>
							<li><a href="Profile.pets"><i class="fa fa-user"></i>Perfil</a></li>
							<c:if test="${menuAdm != null}">
								<li><a href="Listar-Usuarios.adm"><i class="fa fa-users"></i>Listar Usuarios</a></li>
								<li><a href="Listar-Pet.adm"><i class="fa fa-github"></i>Listar	Pet's</a></li>
								<li><a href="Listar-PetShop.adm"><i class="fa fa-gift"></i>Listar PetShop's</a></li>
								<li><a href="Listar-Tags.adm"><i class="fa fa-tags"></i>Listar Tag's</a></li>
							</c:if>
							<li><a href="Logout.pet" style="cursor: pointer"><i class="fa fa-reply"></i>Sair</a></li>
						</c:if>
					</c:otherwise>
				</c:choose>
		</c:when>
		<c:otherwise></c:otherwise>
	</c:choose>
           
           
        </section>
        <!-- /.sidebar -->
      </aside>