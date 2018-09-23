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
			<div id="divSucesso" class="row alert alert-success msgSucesso" onload="someAlerta()">${operacao}</div>
		</c:if>
		
		<c:if test="${insucesso == true }">
			<div id="divSucesso" class="row alert alert-danger msgSucesso" onload="someAlerta()">${operacao}</div>
		</c:if>
		
		<!--  INICIO DO CONTEUDO DINAMICO -->
		<div class="row" style="margin-top: 4%;">
			<div class="col-md-12">
				<div class="row">
					
					<div class="col-md-12 text-center" id="dadosCadastrais" style="margin-bottom: 3%;">ALTERAÇÃO DE SENHA</div>
					
					<div class="col-md-12">
						<c:url value="/usuario/alterar-senha" var="action"/>
						<form action="${action}" method="post">
							
							<div class="form-group col-md-4 offset-md-4">
								<label for="senhaAtual">Senha Atual</label>
								<input type="password" name="senhaAtual" class="form-control" id="senhaAtual" onkeyup="validaSenhaAtual()" 
									placeholder="Digite sua senha atual"/>
								<span class="text-danger" id="erroSenhaAtual">${msgSenhaAtual}</span>
							</div>
							<div class="form-group col-md-4 offset-md-4">
								<label for="nome">Nova Senha</label>
								<input type="password" name="senhaNova" class="form-control" id="senhaNova" onkeyup="validaSenhaNova()" 
									placeholder="Digite a sua nova senha" maxlength="20"/>
								<span class="text-danger" id="erroSenhaNova"></span>
							</div>
							<div class="form-group col-md-4 offset-md-4">
								<label for="nome">Confirmação de nova senha</label>
								<input type="password" name="repeticaoSenhaNova" class="form-control" id="senhaNovaRepeticao" onkeyup="validaRepeticao()" 
									placeholder="Repita sua nova senha" maxlength="20"/>
								<span class="text-danger" id="erroSenhaNovaRepeticao">${msgCoincidencia}</span>
							</div>
							<div class="form-group col-md-4 offset-md-4">
								<button type="submit" class="btn btn-primary btnsPerfil col-md-12" onclick="return validaFormulario()">SALVAR NOVA SENHA</button>
							</div>

						</form>
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
	<script src="<c:url value="/resources/js/validacao/validacao_senhas.js" />"></script>
	<!-- FIM DOS SCRIPTS PROPRIOS DA PAGINA DE PRODUTO -->
	
	<script type="text/javascript">
		$(function() {
			$('#divSucesso').delay(5000).fadeOut('slow');
		});
	</script>
	
</body>
</html>