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
			    	<a class="nav-link active" id="dados-tab" role="tab" data-toggle="tab" href="#dados" aria-controls="dados" aria-selected="true">Dados do Idoso</a>
			  	</li>
			  	<li class="nav-item">
			    	<a class="nav-link" id="dados2-tab" role="tab" data-toggle="tab" href="#dados2" aria-controls="dados2" aria-selected="false">Preferências do Idoso</a>
			  	</li>
			  	<li class="nav-item">
			    	<a class="nav-link" id="dadosendereco-tab" role="tab" data-toggle="tab" href="#dadosendereco" aria-controls="dados2" aria-selected="false">Endereço do Idoso</a>
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
				<c:url value="/idoso/editar-idoso" var="action"/>
				<form:form action="${action}" method="post" modelAttribute="idoso">
					<!--  INICIO DO CONTEUDO DE TABS -->
					<div class="tab-content">
						<!--  INICIO DA TAB 1 (dados basicos do idoso) -->
						<div id="dados" class="tab-pane fade show active" role="tabpanel" aria-labelledby="dados-tab">
							
							<form:hidden path="id"/>
							
							<div class="row">
								<div class="form-group col-md-8">
									<form:label path="nome" for="nome">Nome</form:label>
									<form:input path="nome" cssClass="form-control" id="nome" onkeyup="validaNome()" placeholder="Nome do idoso"/>
									<span class="text-danger" id="erroNome"></span>
								</div>
								
								<div class="form-group col-md-4">
									<form:label path="apelido" for="nome">Apelido</form:label>
									<form:input path="apelido" cssClass="form-control" id="nome" onkeyup="validaApelido()" placeholder="Apelido do idoso"/>
									<span class="text-danger" id="erroApelido"></span>
								</div>
								
							</div>
							
							<div class="row">
								<div class="form-group col-md-8">
									<form:label path="email" for="email">E-mail</form:label>
									<form:input path="email" cssClass="form-control" id="email" onkeyup="validaEmail()" placeholder="E-mail"/>
									<span class="text-danger" id="erroEmail"></span>
								</div>
									
								<div class="form-group col-md-2">
									<form:label path="senha" for="senha">Senha</form:label>
									<form:password path="senha" cssClass="form-control" id="password" placeholder="Senha"/>
									<span class="text-danger" id="erroPassword"></span>
								</div>
								
								<div class="form-group col-md-2">
									<form:label path="dataNascimento" for="dataNascimento">Data Nascimento</form:label>
									<form:input path="dataNascimento" cssClass="form-control" id="datanascimento" onkeyup="validaDataNascimento()" placeholder="DD/MM/YYYY"/>
									<span class="text-danger" id="erroDataNascimento"></span>
								</div>
								
							</div>
							
							<div class="row">
								<div class="form-group col-md-8">
									<form:label path="descricao" for="descricao">Descrição</form:label>
									<form:input path="descricao" cssClass="form-control" id="descricao" onkeyup="validaDescricao()" placeholder="Breve descrição do idoso"/>
									<span class="text-danger" id="erroDescricao"></span>
								</div>
									
								<div class="form-group col-md-2">
									<form:label path="cpf" for="cpf">CPF</form:label>
									<form:input path="cpf" cssClass="form-control" id="cpf" onkeyup="validaCPF()" placeholder="Nº CPF"/>
									<span class="text-danger" id="erroCPF"></span>
								</div>	
								
								<div class="form-group col-md-2">
									<form:hidden path="profissao.id"/>
									<form:label path="profissao.nome" for="profissao">Profissão</form:label>
									<form:input path="profissao.nome" cssClass="form-control" id="profissao" onkeyup="validaProfissao()" placeholder="Digite a profissão"/>
									<span class="text-danger" id="erroProfissao"></span>
								</div>
								
							</div>
							
							<div class="row float-right btnNextPrevious">
								<a class="btn btn-primary" href="#" onclick="abreAbaDados2()">Próximo</a>
							</div>
							
						</div>
						<!--  FIM DA TAB 1 (dados basicos do usuário)-->
						
						<!--  INICIO DA TAB 2 (preferencias do idoso)-->
						<div id="dados2" class="tab-pane fade" role="tabpanel" aria-labelledby="dados2-tab">
						
							<div class="row">
								<div class="form-group col-md-8">
									<form:label path="conjuge" for="conjuge">Conjuge</form:label>
									<form:input path="conjuge" cssClass="form-control" id="conjuge" onkeyup="validaConjuge()" placeholder="Nome do conjuge"/>
									<span class="text-danger" id="erroEmail"></span>
								</div>
								
								<div class="form-group col-md-4">
									<form:hidden path="responsavel.id" />
									<form:label path="responsavel" for="responsavel">Responsável</form:label>
									<form:input path="responsavel.nome" cssClass="form-control" disabled="true" onchange="validaResponsavel()" id="responsavel"/>
									<span class="text-danger" id="erroResponsavel"></span>
								</div>
							</div>
						
							<div class="row">
								<div class="form-group col-md-8">
									<form:hidden path="filme.id"/>
									<form:label path="filme.nome" for="filme">Filme Predileto</form:label>
									<form:input path="filme.nome" cssClass="form-control" id="filme" onkeyup="validaFilme()" placeholder="Filme predileto"/>
									<span class="text-danger" id="erroFilme"></span>
								</div>
								
								<div class="form-group col-md-2">
									<form:label path="time" for="time">Time</form:label>
									<form:input path="time" cssClass="form-control" id="time" onkeyup="validaTime()" placeholder="Time do coração"/>
									<span class="text-danger" id="erroTime"></span>
								</div>
								
								<div class="form-group col-md-2">
									<form:hidden path="cantor.id"/>
									<form:label path="cantor.nome" for="cantor">Cantor Predileto</form:label>
									<form:input path="cantor.nome" cssClass="form-control" id="cantor" onkeyup="validaCantor()" placeholder="Cantor predileto"/>
									<span class="text-danger" id="erroCantor"></span>
								</div>
							</div>
							
							<div class="row float-left btnNextPrevious">
								<a class="btn btn-primary" href="#" onclick="abreAbaDados()">Anterior</a>
							</div>
							
							<div class="row float-right btnNextPrevious">
								<a class="btn btn-primary" href="#" onclick="abreAbaEndereco()">Próximo</a>
							</div>
							
						</div>
						<!--  FIM DA TAB 2 (preferencias do idoso) -->
						
						<!--  INICIO DA TAB 3 (dados de endereco do idoso) -->
						<div id="dadosendereco" class="tab-pane fade" role="tabpanel" aria-labelledby="dadosendereco-tab">
							
							<div class="row">
								<form:hidden path="logradouro.id"/>
								<div class="form-group col-md-8">
									<form:label path="logradouro.nome" for="logradouro">Logradouro</form:label>
									<form:input path="logradouro.nome" cssClass="form-control" id="logradouro" onkeyup="validaLogradouro()" placeholder="Nome do logradouro"/>
									<span class="text-danger" id="erroLogradouro"></span>
								</div>
								
								<div class="form-group col-md-2">
									<form:label path="logradouro.numero" for="numero">Número</form:label>
									<form:input path="logradouro.numero" cssClass="form-control" id="numero" onkeyup="validaNumero()" placeholder="Número do endereço"/>
									<span class="text-danger" id="erroNumero"></span>
								</div>
								
								<div class="form-group col-md-2">
									<form:label path="logradouro.cep" for="cep">CEP</form:label>
									<form:input path="logradouro.cep" cssClass="form-control" id="cep" onkeyup="validaCep()" placeholder="Cep do endereço"/>
									<span class="text-danger" id="erroCep"></span>
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-8">
									<form:label path="logradouro.cidade" for="cidade">Cidade</form:label>
									<form:input path="logradouro.cidade" cssClass="form-control" id="cidade" onkeyup="validaCidade()" placeholder="Nome da cidade"/>
									<span class="text-danger" id="erroCidade"></span>
								</div>
								
								<div class="form-group col-md-2">
									<form:label path="logradouro.bairro" for="bairro">Bairro</form:label>
									<form:input path="logradouro.bairro" cssClass="form-control" id="bairro" onkeyup="validaBairro()" placeholder="Nome do bairro"/>
									<span class="text-danger" id="erroBairro"></span>
								</div>
								
								<div class="form-group col-md-2">
									<form:label path="logradouro.estado" for="estado">Estado</form:label>
									<form:select path="logradouro.estado" cssClass="custom-select form-control" onchange="validaEstado()" id="estado">
										<form:option label="${idoso.logradouro.estado}" value="${idoso.logradouro.estado}"/>
										<form:options items="${estados}"/>
									</form:select>
									<span class="text-danger" id="erroEstado"></span>
								</div>
								
							</div>
							
							<div class="row float-left btnNextPrevious">
								<a class="btn btn-primary" href="#" onclick="abreAbaDados2()">Anterior</a>
							</div>
							
							<div class="row float-right btnNextPrevious">
								<a class="btn btn-primary" href="#" onclick="abreAbaConfirmacao()">Próximo</a>
							</div>
							
							
						</div>
						<!--  FIM DA TAB 3 (dados de endereco do usuário)-->
						
						<!--  INICIO DA TAB 4 (confirmacao)-->
						<div id="confirmacao" class="tab-pane fade" role="tabpanel" aria-labelledby="confirmacao-tab">
							
							<div class="row text-center" style="padding: 30px 15px; justify-content: center;">
								<a class="btn btn-lg btn-danger" href="javascript:history.go(-1)" style="margin-right: 0.5%;">Cancelar</a>
								<button type="submit" class="btn btn-lg btn-primary" onclick="return validaFormulario()">Editar</button>
							</div>
							
						</div>
						<!--  FIM DA TAB 4 (confirmacao) -->
						
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
	<script src="<c:url value="/resources/js/validacao/validacao_idosos.js" />"></script>
	<!-- FIM DOS SCRIPTS PROPRIOS DA PAGINA DE PRODUTO -->
	
</body>
</html>