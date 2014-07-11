<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
<%@include file = "resources/css/bootstrap.min.css" %>
</style>
<title>Cardápio Digital</title>
</head>
<body>

	<%@include file="shared/top.jsp"%>
	<div class="container">

		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<form action="/cardapio_digital/atualiza_categoria" method="post">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h1 class="panel-title">Atualizar categoria</h1>
						</div>
						<div class="panel-body">
							<div class="form-group">
								<label for="descricao">Nome da categoria</label> <input
									class="form-control" name="descricao" id="descricao"
									placeholder="Informe o nome da categoria" value="${categoria.descricao}"/>
							</div>
							<input type="hidden" name="id" value="${categoria.id}" />
							<input type="submit" value="Salvar" name="button"
								class="btn btn-default" />
						</div>

					</div>
				</form>
			</div>
		</div>

	</div>
	<!-- /container -->

	<script type="text/javascript">
    <%@include file="resources/js/jquery.js" %>
    <%@include file="resources/js/bootstrap.min.js" %>
    </script>
</body>
</html>