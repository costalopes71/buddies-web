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

	<!-- INICIO MENU SUPERIOR -->
	<%@include file="../templates/menu_superior.jsp"%>
	<!-- FIM MENU SUPERIOR -->
	
	<div class="container conteudoDinamico">

		<!-- INICIO DO BREADCRUMBS -->
		<%@include file="../templates/breadcrumb.jsp"%>
		<!-- FIM DO BREADCRUMBS -->
		
		<c:if test="${sucesso == true }">
			<div id="divSucesso" class="row alert alert-success msgSucesso" onload="someAlerta()">${operacao} com sucesso!</div>
		</c:if>
		
		<!--  INICIO DO CONTEUDO DINAMICO -->
		<div class="row" style="margin-top: 4%;">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-4 text-right" id="dadosCadastrais">Dados Cadastrais</div>
					
					<div class="col-md-6">
						<c:url value="/usuario/editar-perfil" var="action"/>
						<form:form action="${action}" method="post" modelAttribute="usuario">
							<div class="row">
								<form:hidden path="id"/>
								<div class="form-group col-md-12">
									<form:label path="nome" for="nome">Nome</form:label>
									<form:input path="nome" cssClass="form-control" id="nome" onkeyup="validaNome()" placeholder="Nome do usuário"/>
									<span class="text-danger" id="erroNome"></span>
								</div>
							</div>
							<div class="row">
								<div class="form-group col-md-12">
									<form:label path="email" for="email">E-mail</form:label>
									<form:input path="email" cssClass="form-control" id="email" onkeyup="validaEmail()" placeholder="E-mail"/>
									<span class="text-danger" id="erroEmail"></span>
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-12">
									<label for="password">Senha</label>
									<input type="password" class="form-control" id="password" placeholder="Senha" disabled="disabled" value="1234567891011"/>
									<span class="text-danger" id="erroPassword"></span>
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-6">
									<button type="submit" class="btn btn-primary btnsPerfil col-md-12" onclick="return validaFormulario()">SALVAR ALTERAÇÕES</button>
								</div>
								<div class="form-group col-md-6">
									<a class="btn btn-secondary btnsPerfil col-md-12" href="<c:url value="/usuario/alterar-senha"/>">ALTERAR SENHA</a>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
		<!-- FIM DO CONTEUDO DINAMICO -->
	</div>

	<!-- INICIO RODAPE -->
	<%@include file="../templates/rodape.jsp"%>
	<!-- FIM RODAPE -->

	<!-- INICIO IMPORT DOS SCRIPTS (js)-->
	<%@include file="../templates/scripts.jsp"%>
	<!-- FIM IMPORT DOS SCRIPTS (js)-->
	
	<!-- INICIO DOS SCRIPTS PROPRIOS DA PAGINA DE PRODUTO  -->
	<script src="<c:url value="/resources/js/validacao/validacao_usuarios.js" />"></script>
	<!-- FIM DOS SCRIPTS PROPRIOS DA PAGINA DE PRODUTO -->
	
	<script type="text/javascript">
		$(function() {
			$('#divSucesso').delay(5000).fadeOut('slow');
		});
	</script>
	
</body>
</html>