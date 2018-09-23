<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<!-- inicio do head -->
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<title>Login | Buddies</title>
	
	<!-- CSS includes -->
	<link rel="shortcut icon" type="image/png" href="<c:url value="/resources/images/buddies_favicon.ico" />"/>
	<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap_3.css"/>">
	<link rel="stylesheet" href="<c:url value="/resources/fonts/font-awesome.min.css"/>">
	<link rel="stylesheet" href="<c:url value="/resources/css/login_style.css"/>">
</head>
<!-- fim do head -->

<body id="login-init">
	<div class="row col-md-12">
		<div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
			<div class="login-panel panel panel-default">
				<div class="panel-heading text-center">
					<img class="img-responsive img-center" alt="bem vindo ao Buddies" src="<c:url value="/resources/images/logo_login.png"/>"
						style="width: 320px; height: 40px;"/>
				</div>
				<div class="text-center">
					<h4>Buddies - Sirio Libânes</h4>
				</div>
				<div style="margin-bottom: 50px;" class="panel-body">
					<c:url value="/login/logar" var="action"/>
					<form:form id="loginForm" action="${action}" method="post" modelAttribute="login">
						
						<fieldset>
							
							<div class="form-group">
								<form:input path="username" name="" id="username" class="form-control" placeholder="E-mail"/>
							</div>
							
							<div class="form-group">
								<form:password path="password" name="password" id="password" class="form-control" placeholder="Senha"/>
							</div>
							
							<form:button id="login-init" name="login" class="btn btn-primary btn-block" style="height: 40px;">Login</form:button>
						</fieldset>
						
					</form:form>
					<div style="width: 100%; margin: 0 auto;">
						<h5 style="text-align: center; color: red; padding-bottom: 25px;">${message}</h5>
					</div>
				</div>
			</div>
		</div>
		<!-- /.col-->
	</div>
	<!-- /.row -->
	
	<%@include file="../templates/scripts.jsp"%>
			
</body>
</html>
