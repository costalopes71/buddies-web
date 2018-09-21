/**
 * Script de validação para cadastrar e editar produtos. 
 */

// função que carrega a tabela
$(document).ready(function (){
	var table = $('#tabelaEmpresas').DataTable({
		"searching": false,
		"lengthChange": false,
		"scrollY": "350px",
		"scrollCollapse": true,
		"paging": false
	});
});

// função que checa todos os checkbox quando clicado o check all
$("#checkAll").click(function () {
	$(".check").prop('checked', $(this).prop('checked'));
});

// VALIDACAO

function validaFormulario() {
	var formularioValido = true;
	var mensagem = "ERRO ao cadastrar/editar. Erros:"
	if (!validaNome()) {
		mensagem += '\n\t - Nome do produto inválido. O tamanho mínimo do nome deve ser de 03 (três) caracteres.';
		formularioValido = false;
	}
	
	if (formularioValido) {
		return true;
	} else {
		return false;
	}
	
};

function validaNome() {
	var nomeProduto = $('#nome').val();
	if (nomeProduto.length >= 3) {
		$('#erroNome').text('');
		return true;
	} else {
		if (nomeProduto.length == 0) {
			$('#erroNome').text('Campo nome obrigatório.');
		} else {
			$('#erroNome').text('Nome do produto inválido. O tamanho mínimo do nome deve ser de 03 (três) caracteres.');
		}
		$('#nome').focus();
		return false;
	}
}