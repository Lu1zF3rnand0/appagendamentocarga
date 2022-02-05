<%@page import="br.edu.infnet.appagendamentocarga.model.domain.Aluno"%>
<%@page import="java.util.List"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>Agendamentos</title>
<!--   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet"> -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container mt-3">
	  <h2> Cadastramento de Agendamentos</h2>
	 	  
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
		      	<th>Número</th>
		        <th>Data</th>
		        <th>Tipo</th>
		        <th>Transportador</th>
		        <th>Cliente</th>
		        <th>Qtd. Cargas</th>
		        <th></th>
		      </tr>
		    </thead>
		    <tbody>
		      <c:forEach var="a" items="${lista}">
		      <tr>
		      	<td>${a.id}</td>
		        <td>${a.data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))}</td>
		        <td>${a.tipo}</td>
		        <td>${a.transportador}</td>
		        <td>${a.cliente.nome}</td>
		        <td>${a.cargas.size()}</td>
		        <td><a href="/agendamento/${a.id}/excluir">excluir</a></td>
		      </tr>
		      </c:forEach>
		    </tbody>
		  </table>	
		  <h4>Total de agendamentos: ${lista.size()}</h4>
		  
	  </c:if>  
	  
	  <c:if test="${empty lista}">
	  	<h4>Não existem agendamentos cadastrados!!!</h4>
	  </c:if>
	   
	</div>
	
	<div class="container mt-3" align = "right">
		<form action="/agendamento" method="get" >
			<button type="submit" class="btn btn-primary">Novo</button>
		</form>
	</div>

</body>
</html>