<%@page import="java.util.ArrayList"%>
<%@page import="org.eng2.model.Token"%>
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

    <%@include file="shared/top.jsp"%>
    <% ArrayList<Token> tokens = (ArrayList<Token>) request.getAttribute("lista_tokens");  %>
    <div class="container">
    
        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <form action="/cardapio_digital/deletar_token" method="get">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h1 class="panel-title">Remove Token</h1>
                        </div>
                        <div class="panel-body">
                            <div class="form-group">
                                <label for="description">Escolha o token</label>
                                <br/>
                                <select class="form-control" name="cod">
                                <% for(Token token:tokens) { %>
                                    <option value="<%= token.getCod() %>"><%= token.getCod() + " " + token.getMesaId() %></option>
                                <% } %>
                                </select>
                            </div>
                            <input type="submit" value="Remover" name="button"
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