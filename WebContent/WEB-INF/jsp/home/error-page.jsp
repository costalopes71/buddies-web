<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="pt-br">

<!-- INICIO HEAD -->
	<%@include file="../templates/header.jsp"%>
<!-- FIM HEAD -->

<body>

	<!-- INICIO Menu Superior -->
	<%@include file="../templates/menu_superior.jsp"%>
	<!-- FIM Menu Superiro -->
	
	<div class="container conteudoDinamico">

		<!-- Page Heading/Breadcrumbs -->
		<%@include file="../templates/breadcrumb.jsp"%>
		<!-- Fim do page Heading/Breadcrumbs -->
		
		<!-- Intro Content -->
		<div class="row subTitulo">
			<div class="col-md-12">
				<h2 class="page-header">Ops algum erro aconteceu!</h2>
			</div>
		</div>
		<hr/>
		
		<div class="row">
			<!-- INICIO DO PAINEL DE ERRO -->
			<div class="col-md-6 offset-md-3" style="padding: 0px;">
				<div class="alert alert-danger" role="alert">
  					<strong>Ahhh não! =(</strong> ${msgErro}
				</div>
				<div>
					<a class="btn btn-danger float-right" href="javascript:history.go(-1)">Voltar</a>
				</div>
			</div>
			<!-- FIM DO PAINEL DE ERRO -->
		</div>
				
	</div>
	<!-- /.container -->

	<!-- INICIO RODAPE -->
	<%@include file="../templates/rodape.jsp"%>
	<!-- FIM RODAPE -->

	<!-- Bootstrap core JavaScript -->
	<%@include file="../templates/scripts.jsp"%>

</body>
</html>