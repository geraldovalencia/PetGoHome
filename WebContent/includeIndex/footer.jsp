<div class="container">
	<footer>
		<div class="row">
			<article>
				<img src="img/logo-footer.gif" alt="" class="logo-footer" />
				<div class="privacy">
					&copy;
					<?php echo date('Y'); ?>
					| Copyright
				</div>
			</article>
		</div>
	</footer>
</div>
<script type="text/javascript" src="js/bootstrap.js"></script>


<c:choose>
	<c:when test="${pessoaLogado != null}">
		<div id="myModalSair" class="modal hide fade" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">X</button>
				<h5 id="myModalLabel">Logout PetGoHome</h5>
			</div>
			<div class="modal-body" align="center">
				<h4>
					<strong>Deseja realmente sair do sistema?</strong>
				</h4>
				<br>
				<form method='get' action='Logout.pet' class="form-inline">

					<div class="modal-footer" align="center">

						<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
						<button type='submit' class="btn btn-warning">Sair</button>
					</div>
				</form>
			</div>
		</div>
	</c:when>
	<c:otherwise>


		<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">

			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">X</button>
				<h5 id="myModalLabel">LOGIN PetGoHome</h5>
			</div>

			<div class="modal-body" align="center">
				<h4>
					<strong>Preencha os campos abaixo para Logar.</strong>
				</h4>
				<br>
				<form method='post' action='Login.pet' class="form-inline">

					<input id="login" placeholder="Login" class="input-small"
						type="text" name="login" class="form-control" required="required"
						autofocus> <input class="input-small" placeholder="Senha"
						required="required" type="password" name="senha"
						class="form-control"> <label class="checkbox"> <input
						type="checkbox"> Lembrar
					</label><br>
					<div>

						<table  cellpadding="15">
							<tbody>
								<tr>
									<td align='center'>
										<h5>
											Não é cadastrado? <a href="Cadastro-de-Usuario.pet"><strong>Clique
													Aqui</strong></a>
										</h5>
									</td>
									<td align='center'>
										<h5>
											Esqueci minha senha! <a href="Esqueci-a-Minha-Senha.pet"><strong>Clique
													Aqui</strong></a>
										</h5>
									</td>
								</tr>
							</tbody>
						</table>

					</div>
					<div class="modal-footer" align="center">

						<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
						<button type='submit' class="btn btn-warning">Logar</button>
					</div>
				</form>
			</div>

		</div>
	</c:otherwise>
</c:choose>

<c:if test="${gatos != null}">

	<script type="text/javascript">
		$(document).on(
				'click',
				'.open-RemoverModal',
				function() {
					var propValue = $(this).data('id');
					var propMsg = $(this).data('msg');
					var propIdpessoa = $(this).data('idpessoa');
					$('#removerModalPropValue').val(propValue);
					$('#removerModalPropIdpessoa').val(propIdpessoa);
					$('#removerModalMessage').text(
							'Deseja realmente remover o Gato \"' + propMsg
									+ '\"?');
				});

		$(document).on('click', '#removerModalConfirma', function() {
			$("#removerForm").submit();
		});
	</script>

	<div class="modal fade" id="RemoverModalGato" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">X</button>
			<h4 class="modal-title" id="myModalLabel">REMOVER PET</h4>
		</div>

		<form id="removerForm" method="Post" action="Remover-Gato.pets">
			<input type="hidden" name="idGato" id="removerModalPropValue"
				value=""> <input type="hidden" name="idPessoa"
				id="removerModalPropIdpessoa" value="">
			<div class="modal-body" align="center">
				<p style="font-size: 16px; color: #071117;" id="removerModalMessage"></p>
				<p>
					Se este Pet estiver vinculado a uma TAG, ao eliminá-lo, sua Tag
					será <strong>desvinculada</strong>. Realmente deseja continuar?
				</p>
			</div>
			<div class="modal-footer">
				<button type="submit" id="removerModalConfirma"
					class="btn btn-danger" data-dismiss="modal">Sim</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
			</div>
		</form>
	</div>
</c:if>

<c:if test="${dogs != null}">

	<script type="text/javascript">
		$(document).on(
				'click',
				'.open-RemoverModal',
				function() {
					var propValue = $(this).data('idcao');
					var propMsg = $(this).data('msgcao');
					var propIdpessoa = $(this).data('idpessoacao');
					$('#removerModalIdcao').val(propValue);
					$('#removerModalIdpessoaCao').val(propIdpessoa);
					$('#removerModalMessageCao').text(
							'Deseja realmente remover o Cachorro \"' + propMsg
									+ '\"?');
				});

		$(document).on('click', '#removerModalConfirmaCao', function() {
			$("#removerFormCao").submit();
		});
	</script>

	<div class="modal fade" id="RemoverModalCachorro" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">X</button>
			<h4 class="modal-title" id="myModalLabel">REMOVER PET</h4>
		</div>

		<form id="removerFormCao" method="Post" action="Remover-Cachorro.pets">
			<input type="hidden" name="idDog" id="removerModalIdcao" value="">
			<input type="hidden" name="idPessoa" id="removerModalIdpessoaCao"
				value="">
			<div class="modal-body" align="center">
				<p style="font-size: 16px; color: #071117;"
					id="removerModalMessageCao"></p>
				<p>
					Se este Pet estiver vinculado a uma TAG, ao eliminá-lo, sua Tag
					será <strong>desvinculada</strong>. Realmente deseja continuar?
				</p>
			</div>
			<div class="modal-footer">
				<button type="submit" id="removerModalConfirmaCao"
					class="btn btn-danger" data-dismiss="modal">Sim</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
			</div>
		</form>
	</div>
</c:if>


