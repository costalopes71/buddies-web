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
		
		<!-- INICIO DO CORPO (conteudo dinamico) -->
		 
		<div class="row menuNavegacao">
			<ul class="nav nav-tabs col-md-12" id="#myTab" role="tablist">
				<li class="nav-item">
			    	<a class="nav-link active" id="dados-tab" role="tab" data-toggle="tab" href="#dados" aria-controls="dados" aria-selected="true">Dados do Usuário</a>
			  	</li>
			  	<li class="nav-item">
			    	<a class="nav-link" id="confirmarcao-tab" role="tab" data-toggle="tab" href="#confirmacao" aria-controls="confirmacao" aria-selected="false">Confirmação</a>
			  	</li>
			</ul>
		</div>
		
		<!--  INICIO DO CONTEUDO DINAMICO -->
		<div class="row">
			<div class="col-md-12">
				<!-- INICIO DO FORM DE CADASTRO -->
				<c:url value="/usuario/cadastrar-usuario" var="action"/>
				<form:form action="${action}" method="post" modelAttribute="usuario">
					<!--  INICIO DO CONTEUDO DE TABS -->
					<div class="tab-content">
						<!--  INICIO DA TAB 1 (dados basicos do responsavel) -->
						<div id="dados" class="tab-pane fade show active" role="tabpanel" aria-labelledby="dados-tab">
						
							<div class="row">
								<div class="form-group col-md-8">
									<form:label path="nome" for="nome">Nome</form:label>
									<form:input path="nome" cssClass="form-control" id="nome" onkeyup="validaNome()" placeholder="Nome do usuário"/>
									<span class="text-danger" id="erroNome"></span>
								</div>
								
							</div>
							
							<div class="row">
								<div class="form-group col-md-8">
									<form:label path="email" for="email">E-mail</form:label>
									<form:input path="email" cssClass="form-control" id="email" onkeyup="validaEmail()" placeholder="E-mail"/>
									<span class="text-danger" id="erroEmail"></span>
								</div>
									
								<div class="form-group col-md-2">
									<form:label path="password" for="password">Senha</form:label>
									<form:password path="password" cssClass="form-control" id="password" onkeyup="validaSenha()" placeholder="Senha"/>
									<span class="text-danger" id="erroPassword"></span>
								</div>
								
								<div class="form-group col-md-2">
									<form:label path="administrador" for="administrador">Administrador</form:label>
									<form:select path="administrador" cssClass="custom-select form-control" id="administrador">
										<form:option label="Não" value="false"/>
										<form:option label="Sim" value="true"/>
									</form:select>
									<span class="text-danger" id="erroPerfil"></span>
								</div>
							</div>
							
							<div class="row float-right btnNextPrevious">
								<a class="btn btn-primary" href="#" onclick="abreAbaEmpresas()">Próximo</a>
							</div>
							
						</div>
						<!--  FIM DA TAB 1 (dados basicos do usuário)-->
						
						<!--  INICIO DA TAB 2 (confirmacao)-->
						<div id="confirmacao" class="tab-pane fade" role="tabpanel" aria-labelledby="confirmacao-tab">
							
							<div class="row text-center" style="padding: 30px 15px; justify-content: center;">
								<a class="btn btn-lg btn-danger" href="javascript:history.go(-1)" style="margin-right: 0.5%;">Cancelar</a>
								<button type="submit" class="btn btn-lg btn-primary" onclick="return validaFormulario()">Cadastrar</button>
							</div>
							
						</div>
						<!--  FIM DA TAB 2 (confirmacao) -->
						
					<!--  FIM DO CONTEUDO DE TABS -->
					</div>
				</form:form>
				<!-- FIM DO FORM DE CADASTRO -->
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
	
</body>
</html>