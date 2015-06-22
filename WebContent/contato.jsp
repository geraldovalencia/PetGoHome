<%@ include file="includes/header.jsp"%>

<!-- MEnu Principal -->
<%@ include file="includes/MascarasJS.jsp"%>
<%@ include file="includes/menuPrincipal.jsp"%>

<!-- FIM do MEnu Principal -->





<script src="http://maps.googleapis.com/maps/api/js?sensor=false"
	type="text/javascript"></script>

<!-- Start Map -->
<div id="map" data-position-latitude="-7.1166258"
	data-position-longitude="-34.8881649"></div>
<script>
	(function($) {
		$.fn.CustomMap = function(options) {

			var posLatitude = $('#map').data('position-latitude'), posLongitude = $(
					'#map').data('position-longitude');

			var settings = $
					.extend(
							{
								home : {
									latitude : posLatitude,
									longitude : posLongitude
								},
								text : '<div class="map-popup"><h4>CIPA</h4><p>A web development blog for all your HTML5 and WordPress needs.</p></div>',
								icon_url : $('#map').data('marker-img'),
								zoom : 15
							}, options);

			var coords = new google.maps.LatLng(settings.home.latitude,
					settings.home.longitude);

			return this.each(function() {
				var element = $(this);

				var options = {
					zoom : settings.zoom,
					center : coords,
					mapTypeId : google.maps.MapTypeId.ROADMAP,
					mapTypeControl : false,
					scaleControl : false,
					streetViewControl : false,
					panControl : true,
					disableDefaultUI : true,
					zoomControlOptions : {
						style : google.maps.ZoomControlStyle.DEFAULT
					},
					overviewMapControl : true,
				};

				var map = new google.maps.Map(element[0], options);

				var icon = {
					url : settings.icon_url,
					origin : new google.maps.Point(0, 0)
				};

				var marker = new google.maps.Marker({
					position : coords,
					map : map,
					icon : icon,
					draggable : false
				});

				var info = new google.maps.InfoWindow({
					content : settings.text
				});

				google.maps.event.addListener(marker, 'click', function() {
					info.open(map, marker);
				});

				var styles = [ {
					"featureType" : "landscape",
					"stylers" : [ {
						"saturation" : -100
					}, {
						"lightness" : 65
					}, {
						"visibility" : "on"
					} ]
				}, {
					"featureType" : "poi",
					"stylers" : [ {
						"saturation" : -100
					}, {
						"lightness" : 51
					}, {
						"visibility" : "simplified"
					} ]
				}, {
					"featureType" : "road.highway",
					"stylers" : [ {
						"saturation" : -100
					}, {
						"visibility" : "simplified"
					} ]
				}, {
					"featureType" : "road.arterial",
					"stylers" : [ {
						"saturation" : -100
					}, {
						"lightness" : 30
					}, {
						"visibility" : "on"
					} ]
				}, {
					"featureType" : "road.local",
					"stylers" : [ {
						"saturation" : -100
					}, {
						"lightness" : 40
					}, {
						"visibility" : "on"
					} ]
				}, {
					"featureType" : "transit",
					"stylers" : [ {
						"saturation" : -100
					}, {
						"visibility" : "simplified"
					} ]
				}, {
					"featureType" : "administrative.province",
					"stylers" : [ {
						"visibility" : "on"
					} ]
				}, {
					"featureType" : "water",
					"elementType" : "labels",
					"stylers" : [ {
						"visibility" : "on"
					}, {
						"lightness" : -25
					}, {
						"saturation" : -100
					} ]
				}, {
					"featureType" : "water",
					"elementType" : "geometry",
					"stylers" : [ {
						"hue" : "#ffff00"
					}, {
						"lightness" : -25
					}, {
						"saturation" : -97
					} ]
				} ];

				map.setOptions({
					styles : styles
				});
			});

		};
	}(jQuery));

	jQuery(document).ready(function() {
		jQuery('#map').CustomMap();
	});
</script>
<!-- End Map -->




<!-- Start Content -->
<div id="content">
	<div class="container">

		<div class="row">

			<div class="col-md-8">

				<!-- Classic Heading -->
				<h4 class="classic-title">
					<span>Fale Conosco</span>
				</h4>

				<!-- Start Contact Form -->
				<div id="contact-form" class="contatct-form">
					<div class="loader"></div>
					<form id="contact-form" action="Contato.pet" class="contactForm"
						name="cform" method="post">
						<div class="row">
							<div class="col-md-4">
								<label for="name">Nome<span class="required">*</span></label> <span
									class="name-missing">Digite seu nome</span> <input type="text"
									id="name" placeholder="Nome:" class="form-control" name="nome"
									size="30" required="required" autofocus>
							</div>
							<div class="col-md-4">
								<label for="e-mail">Email<span class="required">*</span></label>
								<span class="email-missing">Digite um e-mail válido</span> <input
									id="e-mail" type="email" placeholder="E-mail:" name="email"
									class="form-control" size="30" required="required">
							</div>
							<div class="col-md-4">
								<label for="e-mail">Telefone<span class="required">*</span></label>
								<span class="email-missing">Digite seu fone</span> <input
									id="fone" type="text" placeholder="Telefone" name="telefone"
									class="form-control fonemask" required="required">
							</div>
						</div>
						<br>
						<div class="row">
							<div class="col-md-12">
								<label for="message">Escreve seu comentário</label> <span
									class="message-missing">Fale algo!</span>
								<textarea name="mensagem" class="form-control"
									required="required" rows="10" id="message"
									placeholder="Digite aqui sua mensagem. Críticas, sugestões, dúvidas, reclamações ..."></textarea>
								<br>
								<button type="submit" class="btn btn-large btn-warning"
									id="Enviar">
									 <i class="fa fa-envelope-o"></i> Enviar
								</button>
							</div>
						</div>
					</form>
				</div>
				<!-- End Contact Form -->

			</div>

			<div class="col-md-4">

				<!-- Classic Heading -->
				<h4 class="classic-title">
					<span>Informações</span>
				</h4>

				<!-- Some Info -->
				<p>PetGoHome - Seu melhor amigo Sempre Seguro</p>

				<!-- Divider -->
				<div class="hr1" style="margin-bottom: 10px;"></div>

				<!-- Info - Icons List -->
				<ul class="icons-list">
					<li><i class="fa fa-globe"> </i> <strong>Dúvidas:</strong> Em
						caso de alguma dúvida pode escrever para nós que responderemos o
						mais breve possível.</li><br>
					<li><i class="fa fa-tags"></i><strong>Achei um PET:</strong>
						Se por acaso encontrou um PET e tem alguma dúvida, escreva-nos com
						o número da TApara que possamos ajudá-lo a entrar em contato com o
						dono do PET.</li>
				</ul>

				<!-- Divider -->
				<div class="hr1" style="margin-bottom: 15px;"></div>

				<!-- Classic Heading -->
				<h4 class="classic-title">
					<span>Horário de Funcionamento</span>
				</h4>

				<!-- Info - List -->
				<ul class="list-unstyled">
					<li><strong>Segunda - Sexta</strong> - 8:00 até 18:00</li>
				</ul>

			</div>

		</div>

	</div>
</div>
<!-- End content -->




<%@ include file="includes/footer.jsp"%>