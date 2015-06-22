<%@ include file="header.jsp"%>
<style>
/* BS3 using input group icons from Font-Awesome 3.2.1 */

/* no need for any margin/padding for headings when using WELL */
.well h3 {
    padding-top: 0;
    margin-top: 0;
    margin-bottom: 20px;
}
#signupForm .input-group {
    margin-bottom: 20px;
}

/* get font-awesome to work with BS3 */
.input-group-addon .icon-2x {
    width: 28px;
    min-width: 28px;
    display: inline-block;
}

.inline-block > li {
    position: relative;
    display: inline-block;
    margin: 0 10px 10px 0;
}

/* Why doesn't OR work? Tested with Chrome 29, FF 24 or IE 11
@media (max-width: 480px), (min-width: 1199px) { 
    #social-sign-in .icon-5x {
        font-size: 7em;
    }
}
*/
@media (max-width: 768px) {
    #social-sign-in .icon-5x {
        font-size: 7em;
    }
}
@media (max-width: 480px) {
    #social-sign-in .icon-5x {
        font-size: 4.5em;
    }
}
@media (min-width: 1199px) {
    #social-sign-in .icon-5x {
        font-size: 7em;
    }
}

</style>
<script type="text/javascript">
$(document).ready(function () {
    $('form input').tooltip({
      placement: 'top',
      trigger: 'focus',
      title: function (){
        return $(this).attr('placeholder');
      }
    });
});
</script>

<!-- MEnu Principal -->

<%@ include file="menuPrincipal.jsp"%>


<div id="contentContainer" class="container">
  
    <div class="row" style="margin-top: 4%;">
        <div id="realContent" class="col-xs-12">
            <div class="row">
                <section class="col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1 col-xs-12 col-sm-offset-0">
                    <div class="well well-lg">
                        <div class="row">
                            <div class="col-sm-6 col-xs-12">
                                <div class="row">
                                    <div class="col-xs-12"><h3 style="color: #f36510;">LOGIN DE USUÁRIO</h3></div>
                                </div>
                                <div class="row">
                                    <div class="col-xs-12">
                                        <form id="signupForm" method="POST" action="Login.pet" accept-charset="UTF-8">
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="fa fa-child"></i></span>
                                                <input id="login" class="form-control input-lg" placeholder="Login" required="required" maxlength="100" type="text" name="login" value="">
                                            </div>
                                            <div class="input-group">
                                                <span class="input-group-addon"><i class="fa fa-asterisk"></i></span>
                                                <input id="password" class="form-control input-lg" placeholder="Senha" required="required" maxlength="60" type="password" name="senha">
                                            </div>
                                                <div class="form-group">
                                                <button type="submit" id="btn-signup" class="btn btn-block btn-warning btn-lg"><i class="fa fa-user"></i> Logar</button>
                                            </div>
                                        </form>
                                        <div class="form-group">
                                        
                                            <div ><p>Ainda não é cadastrado? <a href="Cadastro-de-Usuario.pet"><strong>Clique aqui</strong></a></p></div>
                                            <div ><p>Esqueci minha senha! <a href="Esqueci-a-Minha-Senha.pet"><strong>Clique aqui</strong></a></p></div>
                                        </div>
                                        <div class="form-group">
                                            <p>Clique aqui para saber ler os nossos  <a href="#terms-of-service" target="_blank">Termos de serviço</a> e a nossa política de privacidade <a href="#privacy" target="_blank">Privacy Policy</a>.</p>
                                        </div>
                                    </div><!-- end of column -->
                                </div><!-- end of row -->
                            </div><!-- end of column 2 -->
                            
                            
                            <div class="col-sm-6 col-xs-12">
                                <div class="row">
                                    <div class="col-xs-12"><h3 style="color: #f36510;">Ainda não possui cadastro?</h3></div>
                                </div>
                                <div class="row">
                                    <div class="col-xs-12">
                                    <div>  <h3>   <i class="fa fa-asterisk"></i> Clique aqui e faça o seu cadastro.  </h3></div>
                                    <div>  <h3>   <i class="fa fa-asterisk"></i> É gratuito.  </h3></div>  
                                     <div class="form-group">
                                            <p>Veja como funciona o <a href="#terms-of-service" target="_blank">PetGoHome</a> e aprenda como você pode deixar o seu melhor amigo seguro. <a href="#privacy" target="_blank">Saiba como</a>.</p>
                                        </div>
                                                <div class="form-group">
                                              <a href="Cadastro-de-Usuario.pet">
                                                <button type="submit" id="btn-signup" class="btn btn-block btn-warning btn-lg"><i class="fa fa-pencil-square-o"></i> Cadastrar</button>
                                              </a>  
                                            </div>
                                    </div><!-- end of column -->
                                </div><!-- end of row -->
                            </div><!-- end of column 2 -->
                            
                        </div><!-- end of well row -->
                    </div><!-- end of well -->
                </section>
            </div><!-- end of row -->
        </div>
    </div>  
</div>

