/**
 * Script de validação para cadastrar e editar usuarios. 
 */

$('a[data-toggle="tab"]').on('shown.bs.tab', function(e){
   $($.fn.dataTable.tables(true)).DataTable().columns.adjust();
});

// função que carrega a tabela
$(document).ready(function (){
	var table = $('#tabelaEmpresas').DataTable({
		"searching": false,
		"lengthChange": false,
		"paging": false,
		"scrollY": "350px",
		"scrollCollapse": true
	});
});

// função que checa todos os checkbox quando clicado o check all
$("#checkAll").click(function () {
	$(".check").prop('checked', $(this).prop('checked'));
});

//
// VALIDACAO
//

function validaFormulario() {
	var formularioValido = true;
	var mensagem = "ERRO ao tentar cadastrar ou editar. ERROS:";
	
	// verifica qual é o contexto que esta chamando, se for editar usuario, ele nao valida a senha, pois a senha pode permanecer a mesma que ja era antes.
	var ctx = window.location.pathname;
	if (ctx.search("perfil-usuario") != -1) {
		if (!this.validaNome() || !this.validaEmail()) {
			return false;
		} else {
			return true;
		}
	}
	
	if (!this.validaNome()) {
		mensagem += "\n\t - Nome do usuário inválido. O tamanho mínimo do nome deve ser de 03 (três) caracteres.";
		formularioValido = false;
	}
	if (!this.validaEmail()) {
		mensagem += "\n\t - E-mail inválido. (Exemplo de formato válido: usuario@dominico.com).";
		formularioValido = false;
	}
	
	// verifica qual é o contexto que esta chamando, se for editar usuario, ele nao valida a senha, pois a senha pode permanecer a mesma que ja era antes.
	if (ctx.search("editar-usuario") == -1) {
		if (!this.validaSenha()) {
			mensagem += "\n\t - Senha inválida. A senha deve conter pelo menos 5 caracteres.";
			formularioValido = false;
		}
	}
	
	if (formularioValido) {
		return true;
	} else {
		$('#dados-tab').click();
		return false;
	}
	
}

function validaNome(){
	var nomeUsuario = $('#nome').val();
	if (nomeUsuario.length >= 3) {
		$('#erroNome').text('');
		return true;
	} else {
		if (nomeUsuario.length == 0) {
			$('#erroNome').text('Campo nome obrigatório.');
		} else {
			$('#erroNome').text('Nome inválido. Tamanho mínimo de 03 (três) caracteres.');
		}
		$('#nome').focus();
		return false;
	}
}

function validaEmail() {
	var email = $("#email").val();
	if (this.isEmail(email) == true) {
		$('#erroEmail').text('');
		return true;
	} else {
		if ($("#email").val() == '') {
			$('#erroEmail').text('Campo e-mail obrigatório.');
		} else {
			$('#erroEmail').text('Email inválido (ex: usuario@dominio.com).');
		}
		$('#email').focus();
		return false;
	}
}

function validaSenha() {
	var senhaUsuario = $('#password').val();
	if (senhaUsuario.length >= 5) {
		$('#erroPassword').text('');
		return true;
	} else {
		if (senhaUsuario.length == 0) {
			$('#erroPassword').text('Campo senha obrigatório.');
		} else {
			$('#erroPassword').text('Senha inválida. Tamanho mínimo de 05 (cinco) caracteres.');
		}
		$('#password').focus();
		return false;
	}
}

function isEmail(email){
  var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
  return re.test(email);
}