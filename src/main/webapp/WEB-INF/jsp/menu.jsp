<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href='<c:url value="/app"/>'>AppAgendamentoCarga</a>
    </div>
    <ul class="nav navbar-nav">
    
      <li class=active><a href='<c:url value="/home"/>'>Home</a></li>
      
      <c:if test="${not empty user}">
	      <li><a href='<c:url value="/usuarios"/>'>Usuário</a></li>
	      <li><a href='<c:url value="/clientes"/>'>Cliente</a></li>
	      <li><a href='<c:url value="/cargas"/>'>Carga</a></li>
	      <li><a href='<c:url value="/conteineres"/>'>Conteiner</a></li>
	      <li><a href='<c:url value="/veiculos"/>'>Veiculo</a></li>
	      <li><a href='<c:url value="/cargasSolta"/>'>Carga Solta</a></li>
	      <li><a href='<c:url value="/agendamentos"/>'>Agendamento</a></li>
      </c:if>
    </ul>
    <ul class="nav navbar-nav navbar-right">
     
      <c:if test="${not empty user}">
      	<li><a href='<c:url value="/logout"/>'><span class="glyphicon glyphicon-log-out"></span> Logout, ${user.nome}</a></li>
      </c:if>
      
      <c:if test="${empty user}">
      	<li><a href='<c:url value="/usuario"/>'><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      	<li><a href='<c:url value="/login"/>'><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </c:if>
    </ul>
  </div>
</nav>

