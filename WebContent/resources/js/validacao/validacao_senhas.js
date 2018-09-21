/**
 * Script para a pagina editar-senha.jsp, valida as senhas digitas no front-end.
 * @author Joao Lopes
 * @since 18/07/2018
 */

function validaSenhaAtual() {
	var senhaAtual = $('#senhaAtual').val();
	if (senhaAtual.length > 0) {
		$('#erroSenhaAtual').text('');
		return true;
	} else {
		$('#erroSenhaAtual').text('Preenchimento obrigatório.');
		$('#senhaAtual').focus();
		return false;
	}
}

function validaSenhaNova() {
	var novaSenha = $('#senhaNova').val();
	if (novaSenha.length == 0) {
		$('#erroSenhaNova').text('Preenchimento obrigatório.');
		$('#senhaNova').focus();
		return false;
	} else if (novaSenha.length < 5) {
		$('#erroSenhaNova').text('Sua senha deve ter de 5 a 20 caracteres.');
		$('#senhaNova').focus();
		return false;
	} else {
		$('#erroSenhaNova').text('');
		return true;
	}
}

function validaRepeticao() {
	var novaSenha = $('#senhaNova').val();
	var repeticao = $('#senhaNovaRepeticao').val();
	if (novaSenha === repeticao) {
		$('#erroSenhaNovaRepeticao').text('');
		return true;
	} else {
		$('#erroSenhaNovaRepeticao').text('As senhas não coincidem.');
		$('#senhaNovaRepeticao').focus();
		return false;
	}
}

function validaFormulario() {
	var formularioValido = true;
	if (!validaSenhaAtual()) {
		formularioValido = false;
	}
	if (!validaSenhaNova()) {
		formularioValido = false;
	}
	if (!validaRepeticao()) {
		formularioValido = false;
	}
	return formularioValido;
}
