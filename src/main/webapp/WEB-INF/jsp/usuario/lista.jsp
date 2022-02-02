<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usuários</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container mt-3">
	  <h2>Cadastramento de Usuários</h2>
	  
	   <hr>
	   
	  <c:if test="${not empty mensagem}">
		<div class="alert alert-success">
		  <strong>Confirmação!</strong> ${mensagem}
		</div>	  
	  </c:if>

	<c:if test="${not empty lista}">		
				  
		<table class="table table-striped">
		    <thead>
		      <tr>
		        <th>ID</th>
		        <th>Nome</th>
		        <th>E-mail</th>
		        <th>Endereço</th>
		        <th>Clientes</th>
		        <th>Cargas</th>
		        <th>Agendamentos</th>
		        <c:if test="${user.admin}">
		        	<th></th>
		        </c:if>
		      </tr>
		    </thead>
		    <tbody>
		      <c:forEach var="u" items="${lista}">
			      <tr>
			        <td>${u.id}</td>
			        <td>${u.nome}</td>
			        <td>${u.email}</td>
			        <td>${u.endereco.cep}</td>
			        <td>${u.clientes.size()}</td>
			        <td>${u.cargas.size()}</td>
			        <td>${u.agendamentos.size()}</td>
			        	<td><c:if test="${user.admin && user.id != u.id}" ><a href="/usuario/${u.id}/excluir">excluir</a> </c:if></td>			       
			      </tr>
		      </c:forEach>		      
		    </tbody>
	  	</table>
	  	<h4>Total de Usuários: ${lista.size()}</h4>
    </c:if>	  	  

	<c:if test="${empty lista}">		
	  <h2>Não existem usuários cadastrados!!!</h2>
	</c:if>

	</div>
</body>
</html>