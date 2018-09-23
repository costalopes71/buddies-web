<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar fixed-top navbar-expand-lg navbar-light bg-light fixed-top">
	<div class="container">
		<a class="navbar-brand" href="<c:url value="/login/welcome"/>"><img	src="<c:url value="/resources/images/logo.png"/>" alt="" width="200" height="41"></a>
		<button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" href="<c:url value="/login/welcome"/>">Home</a></li>
				<c:if test="${usuarioLogado.administrador == true}">
					<li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#" id="navbarDropdownPortfolio" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> Administração </a>
						<div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownPortfolio">
							<a class="dropdown-item" href="<c:url value="/usuario/cadastrar-usuario"/>">Cadastrar Responsável</a>
							<a class="dropdown-item" href="<c:url value="/usuario/usuarios-home"/>">Listar Reponsáveis</a> 
						</div>
					</li>
				</c:if>
				<li class="nav-item"><a class="nav-link" href="<c:url value="#"/>">Idosos</a></li>
				<li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenu" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"><i class="fa fa-user-circle-o fa-lg" aria-hidden="true"></i></a>
					<div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenu">
						<a class="dropdown-item" href="<c:url value="/usuario/perfil-usuario"/>"><i class="fa fa-address-book" aria-hidden="true"></i> Minha Conta</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="<c:url value="/login/logout"/>"><i class="fa fa-sign-out" aria-hidden="true"></i> Sair</a>
					</div>
				</li>
			</ul>
		</div>
	</div>
</nav>