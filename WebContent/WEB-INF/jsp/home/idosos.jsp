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
		<!-- FIM DO BREADCRUMBS  -->
		
		<!-- INICIO DO CORPO (conteudo dinamico) -->
		<div class="row subTitulo">
			
			<div class="col-md-12">
				<a class="btn btn-primary float-right btnCadastrar" href="<c:url value="/idoso/cadastrar-idoso" />">&nbsp;&nbsp;&nbsp;Cadastrar Idoso&nbsp;&nbsp;&nbsp;&nbsp;</a>
			</div>
		</div>
		<hr/>
		
		<c:if test="${sucesso == true }">
			<div id="divSucesso" class="row alert alert-success msgSucesso" onload="someAlerta()">Idoso ${operacao} com sucesso!</div>
		</c:if>
		
		<div class="row">
		
			<!-- INICIO DA TABELA -->
			<div class="col-md-12" style="padding: 0px;">
				<table id="tabelaUsuarios" class="table table-striped table-bordered table-hover" style="width: 100%;">
					<thead class="headerTabela">
						<tr>
							<th style="width: 7%;">ID</th>
							<th>NOME</th>
							<th>E-MAIL</th>
							<th>RESPONSÁVEL</th>
							<th style="width: 10%;">EDITAR</th>
							<th style="width: 10%;">EXCLUIR</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${idosos}" var="idoso">
							<tr class="text-center">
								<td>${idoso.id}</td>
								<td>${idoso.nome}</td>
								<td>${idoso.email}</td>
								<td>${idoso.resposavel.nome}</td>
								<td class="btnsAcoes">
									<c:url var="link" value="/idoso/editar-idoso/${idoso.id}"/>
									<a href="${link}" class="fa fa-pencil-square-o fa-lg btnsAcoes"></a>
								</td>
								<td class="btnsAcoes text-center">
									<a class="fa fa-trash fa-lg" href="#" onclick="idExcluir.value = ${idoso.id}" data-toggle="modal" data-target="#exampleModal"></a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<!-- FIM DA TABELA -->
		
		</div>
				
	</div>
	<!-- FIM DO CORPO (conteudo dinamico) -->

	<!-- INICIO DO MODAL DE EXCLUSAO-->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Confirmação</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">Deseja realmente excluir o idoso?</div>
				<div class="modal-footer">
					<c:url value="/usuario/excluir" var="action"/>
					<form action="${action}" method="post">
						<input type="hidden" name="usuarioId" id="idExcluir"/>
					    <button type="button" class="btn btn-primary" data-dismiss="modal">Não</button>
						<button type="submit" class="btn btn-danger">Sim</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- FIM DO MODAL DE EXCLUSAO -->		

	<!-- INICIO RODAPE -->
	<%@include file="../templates/rodape.jsp"%>
	<!-- FIM RODAPE -->

	<!-- INICIO IMPORT DOS SCRIPTS (js)-->
	<%@include file="../templates/scripts.jsp"%>
	<!-- FIM IMPORT DOS SCRIPTS (js)-->
	
	<!-- INICIO SCRIPT QUE GERA AS FUNCIONALIDADES DA TABELA  -->
	<script type="text/javascript">
		$(document).ready(function() {
		    $('#tabelaUsuarios').DataTable();
		} );
		
		$(function() {
			$('#divSucesso').delay(5000).fadeOut('slow');
		});
		
		
	</script>
	<!-- FIM SCRIPT QUE GERA AS FUNCIONALIDADES DA TABELA  -->

	<!-- INICIO DOS SCRIPTS PROPRIOS DA PAGINA DE PRODUTO  -->
	<!-- FIM DOS SCRIPTS PROPRIOS DA PAGINA DE PRODUTO -->

</body>
</html>