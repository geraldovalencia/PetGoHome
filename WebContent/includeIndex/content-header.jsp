<header style="padding: 0px 0px 50px 0px;">

	<%@ include file="menu.jsp"%>

<script type="text/javascript">
$(function() {
    $('a.page-scroll').bind('click', function(event) {
        var $anchor = $(this);
        $('html, body').stop().animate({
            scrollTop: $($anchor.attr('href')).offset().top
        }, 1500, 'easeInOutExpo');
        event.preventDefault();
    });
});
</script>

	<div class="row pad-bot sidebar">
		<article class="span3index">
			<h1 class="brand">
				<a id="example1" href="img/logo.gif"><img alt="PetGoHome"
					src="img/logo.gif"></a>
			</h1>
		</article>

		<article class="span3index">
			<div class="block-address maxheight">
				<div class="address">
					<strong>Encontrou um Pet perdido?</strong> <span>Informe o
						código abaixo:</span>
					<form method="post" action="Busca-Tag.pet">
						<input type="text" name="numeroTag" placeholder="Ex.: A1B0001"
							required="required"> <button style="margin-top: 4%;"
							type="submit" class="btn btn-danger animated rubberBand">OK</button>
					</form>

					<span>ou envie um email para<a href="#"> <br />info@petgohome.com.br
					</a></span> <span>ou ligue para <a href="tel:*0800 123 1234">0800
							123 1234</a></span>
				</div>
				<span><strong>Saiba Mais</strong></span> <a href="Encontrei.pet"><strong>Clique
						Aqui</strong></a>
			</div>
		</article>
	</div>

	<div class="row banner">
		<article class="content-banner">
			<%@ include file="banner.jsp"%>
		</article>
	</div>
</header>