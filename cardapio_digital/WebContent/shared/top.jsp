<!-- Static navbar -->
<div class="navbar navbar-default navbar-static-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Cardápio Digital</a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="/cardapio_digital/">Início</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">Cadastrar <span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="/cardapio_digital/novo_item">Item</a></li>
						<li><a href="/cardapio_digital/nova_categoria">Catgoria</a></li>
						<li><a href="/cardapio_digital/nova_mesa">Mesa</a></li>
					</ul>
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<form class="navbar-form navbar-right" role="form">
					<a href="/cardapio_digital/gerar_token" class="btn btn-success">Gerar token</a>
				</form>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
</div>
