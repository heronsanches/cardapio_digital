<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
<%@include file="resources/css/bootstrap.min.css" %>
</style>
<title>Cardápio Digital</title>
</head>
<body>
    
    <%@include file="shared/top.jsp" %>
    
    <div class="container">

      <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron">
        <h5>Mensagem do sistema</h5>
        <p><% out.print(request.getAttribute("mensagem")); %></p>
        <p>
          <a class="btn btn-lg btn-primary" href="/cardapio_digital" role="button">Voltar para Inicio</a>
        </p>
      </div>

    </div> <!-- /container -->
    
    <script type="text/javascript">
    <%@include file="resources/js/jquery.js" %>
    <%@include file="resources/js/bootstrap.min.js" %>
    </script>
</body>
</html>