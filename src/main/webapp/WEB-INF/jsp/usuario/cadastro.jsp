<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Usu?rio</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link rel="icon" href="img/icon.ico">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container mt-3">
	  <h2>Cadastramento de Usu?rios</h2>
	  
	  <c:if test="${not empty mensagem}">
		<div class="alert alert-success">
		  <strong>Confirma??o!</strong> ${mensagem}
		</div>	  
	  </c:if>
	  
	  <form action='<c:url value="/cep"/>' class="form-inline" method="post">
	  	<div class="mb-3 mt-3">
	  		<label>Busca por CEP:</label>
	  		<input type="text" class="form-control" placeholder="Entre com o seu cep" name="cep" value="25930000">
	  	</div>
	  	
	  	<button type="submit" class="btn btn-primary">Buscar</button>
	 </form>
	    

	  <form action='<c:url value="/usuario/incluir"/>' method="post">
	    <div class="mb-3 mt-3">
	      <label>Nome:</label>
	      <input type="text" class="form-control" placeholder="Entre com o seu nome" name="nome" value="Luiz">
	    </div>

	    <div class="mb-3 mt-3">
	      <label>E-mail:</label>
	      <input type="email" class="form-control" placeholder="Entre com o seu e-mail" name="email" value="Luiz@luiz.com">
	    </div>

	    <div class="mb-3 mt-3">
	      <label>Senha:</label>
	      <input type="password" class="form-control" placeholder="Entre com o sua senha" name="senha" value="123">
	    </div>
	    
	    <c:import url="/WEB-INF/jsp/endereco.jsp"/>

	    <button type="submit" class="btn btn-primary">Cadastrar</button>
	  </form>
	</div>
	

</body>
</html>