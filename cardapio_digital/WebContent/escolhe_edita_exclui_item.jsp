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
            <form action="/cardapio_digital/edita_exclui_item" method="post">
               <div class="panel panel-default">
                  <div class="panel-heading">
                     <h1 class="panel-title">Edição ou Exclusão > Item</h1>
                  </div>
                  <div class="panel-body">
                     <div class="form-group">
                        <label for="description">Selecione o item para edição:</label>
                        <select class="form-control" id="item" name="item">
                           <c:forEach var="item" items="${items}" >
                               <option value="${item.titulo} - ${item.id}">
                                  ${item.titulo} - ${item.id}
                               </option>
                           </c:forEach>
                        </select>
                     </div>
                     <input type="submit" value="Editar" name="button" class="btn btn-default" />
                     <input type="submit" value="Excluir" name="button" class="btn btn-default" />
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