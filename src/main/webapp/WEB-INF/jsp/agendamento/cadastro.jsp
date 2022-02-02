<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8">
<title>Cadastro de Agendamentos</title>
<!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet"> -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>
	
	<div class="container mt-3">
	  <h2>Cadastramento de Agendamentos</h2>
	  
	<form action="/agendamento/incluir" method="post">
	  
		<div class="form-group">
	  		<label>Clientes:</label>
	  		<select class="form-control" name="cliente.id">
	  			<c:forEach var="c" items="${clientes}">
	  				<option value="${c.id}">${c.nome}</option>
	  			</c:forEach>
	  		</select>
	  	</div>
	  	  
	    <div class="mb-3 mt-3">
	    	<label>Tipo:</label>
	      	<input type="text" class="form-control" placeholder="Entre com o tipo de agendamento" name="tipo" value="I">
	    </div>
	    
	    <div class="mb-3 mt-3">
	      	<label>Transportador:</label>
	    	<input type="text" class="form-control" placeholder="Entre com o transportador" name="transportador" value="MSC Transportes"> 
	    </div>
	    
  	    <div class="mb-3 mt-3" style="margin-top:25px">
	    	<label>Cargas:</label>
	    		<c:forEach var="c" items="${cargas}">
		    		<div class="checkbox">
		    			<label><input type="checkbox" name="cargasId" value="${c.id}">${c.documento}</label>
		    		</div>
		    	</c:forEach>	
	   	</div>  
    
	    <button type="submit" class="btn btn-primary">Cadastrar</button>
	  </form>
	</div>


</body>
</html>