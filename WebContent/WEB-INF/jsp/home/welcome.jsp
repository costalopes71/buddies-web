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
	
	<div class="container">

		<!-- Page Heading/Breadcrumbs -->
		<%@include file="../templates/breadcrumb.jsp"%>
		<!-- Fim do page Heading/Breadcrumbs -->

		<!-- Intro Content -->
		<div class="row text-justify">
			<div class="col-lg-6">
				<img class="img-fluid rounded mb-4"	src="<c:url value="/resources/images/alzeimer.png" />" alt="Talking Buddies">
			</div>
			<div class="col-lg-6">
				<h2>Buddies</h2>
				<p>A Buddies é uma empresa criada por 5 (cinco) alunos do segundo ano do curso
				de análise e desenvolvimento de sistemas da faculdade FIAP (Faculdade de Informática e Administração Paulista) que
				foi pensada a partir da necessidade de produzir o trabalhado de conclusão de curso (TCC). O trabalho tem a parceria do
				hospital Sirio Libânes de São Paulo, que trouxe o desafio aos grupos de alunos de produzir um software inovador
				que tivesse como enfoque a saúde.
				Foi deste ponto de partida que a idéia do Buddies começou a tomar forma. 
				<p>O software Talking Buddies é um aplicativo mobile (no momento criado apenas para a plataforma Android) que foi
				pensado para pessoas mais velhas que se sentem sozinhas ou pessoas que sofram de algum tipo de doença neurodegenerativa
				como por exemplo a Doença de Alzheimer.</p>
			</div>
		</div>
		<div class="row text-justify">
			
			<div class="col-lg-6">
				<p>Claramente nossa intenção não é ser a solução final e definitiva para esses problemas elencados. A real intenção
				é demonstrar de forma clara como a tecnologia pode ser usada no cotidiano para auxiliar as pessoas e tentar
				aproximá-las de um convívio social mais sadio. Para tanto, tentamos utilizar técnicas que estão no
				ápice da modernidade, como Chatbots, dispositivos móveis (celular), tecnologias de conversão de texto para áudio e de
				áudio para texto, integração entre sistemas e outras mais.</p>
				<p>O Talking Buddies é um chatbot que pode ser usado através de um aplicativo mobile e que é personalizado exclusivamente
				para o seu usuário, e que tem a finalidade de manter o máximo possível a saúde mental deste usuário através de 
				estímulos como conversas com o chatbot personalizado, fotos familiares e músicas do gosto musical do seu usuário.
			</div>
			<div class="col-lg-6">
				<img class="img-fluid rounded mb-4" src="<c:url value="/resources/images/aries.png"/>" alt="Sistema Aries.">
			</div>
			<div class="col-lg-12">
				<p>Esperamos verdadeiramente que você goste da idéia, e mais ainda que ela a inspire a fazer algo melhor e mais amplo.
				Caso você tenha interesse, fique a vontade para usar nosso código, ele é código aberto (open source) e você pode usá-lo
				como bem entender para tentar fazer idéias cada vez melhores nascerem!</p>
			</div>
		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->

	<!-- INICIO RODAPE -->
	<%@include file="../templates/rodape.jsp"%>
	<!-- FIM RODAPE -->

	<!-- Bootstrap core JavaScript -->
	<%@include file="../templates/scripts.jsp"%>


</body>
</html>