<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

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

   <%@include file="shared/top.jsp"%>

   <div class="container">
    
      <div class="row">
         <div class="col-md-8 col-md-offset-2">
            <form action="/cardapio_digital/atualiza_item" method="post">
               <div class="panel panel-default">
                  <div class="panel-heading">
                     <h1 class="panel-title">Editar item</h1>
                  </div>                 
                  <div class="panel-body">

                     <input type="hidden" class="form-control"  name="id" id="id" value="${item.id}">
                     <div class="form-group">
                        <label for="description">Título:</label>
                        <input class="form-control" name="titulo" id="titulo" placeholder="${item.titulo}">
                     </div>
                     <div class="form-group">
                        <label for="description">Descrição:</label>
                        <input class="form-control" name="descricao" id="descricao" placeholder="${item.descricao}">
                     </div>
                     <div class="form-group">
                        <label for="description">Preço:</label>
                        <input class="form-control" name="preco" id="preco" placeholder="R$ ${item.preco}">
                     </div>
                     <div class="form-group">
                        <label for="description">Imagem:</label>
                        <input class="form-control" name="imagem" id="imagem" placeholder="${item.imagem}">
                     </div>
                     <div class="form-group">
                        <label for="description">Selecione a categoria:</label>
                        <select class="form-control" id="categoria" name="categoria">
                           <option selected="selected" value="${cat_selecionada.descricao}
                            - ${cat_selecionada.id}">
                            ${cat_selecionada.descricao} - ${cat_selecionada.id}</option>
                           <c:forEach var="categoria" items="${categorias}" >
                               <option value="${categoria.descricao} - ${categoria.id}">
                                  ${categoria.descricao} - ${categoria.id}
                               </option>
                           </c:forEach>
                        </select>
                     </div>
                     <input type="submit" value="Atualizar" name="button" class="btn btn-default" />
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