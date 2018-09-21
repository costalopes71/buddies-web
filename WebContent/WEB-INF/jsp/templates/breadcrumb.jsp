<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!-- <h1 class="mt-4 mb-3">${paginaAtiva}</h1> --> 
<div class="row navegacaoSuperior"> 
	<div class="col-md-8">
		<ol class="breadcrumb myBreadcrumb">
			<li class="breadcrumb-item"><a href="<c:url value="/login/welcome"/>">Home</a></li>
			<li class="breadcrumb-item active">
				<c:choose>
					<c:when test="${not empty proximaPaginaAtiva }">
						<a href="<c:url value="${urlPaginaAtiva}"/>">${paginaAtiva}</a>
					</c:when>
					<c:otherwise>
						${paginaAtiva}
					</c:otherwise>
				</c:choose>
			</li>
			<c:if test="${not empty proximaPaginaAtiva }">
				<li class="breadcrumb-item active">${proximaPaginaAtiva}</li>
			</c:if>
		</ol>
	</div>
	<!-- ESTA COMENTADO POIS AINDA NAO FOI IMPLEMENTADO O FAQ!!
	<div class="col-md-4 formPesquisa">
		<form class="form-inline float-right formularioBusca">
			<div class="input-group">
				<input type="text" class="form-control" placeholder="Digite sua dúvida aqui..." aria-label="Username" aria-describedby="basic-addon1"/>
				<div class="input-group-prepend">
		        	<button class="input-group-text" id="basic-addon1">Ok</button>
				</div>
			</div>
		</form>
	</div>
	 -->
</div>