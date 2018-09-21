/**
 * Script de validação para cadastrar e editar downloads. 
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
		"scrollCollapse": true,
		"ordering": false
	});
});


// função que checa todos os checkbox quando clicado o check all
$("#checkAll").click(function () {
	$(".check").prop('checked', $(this).prop('checked'));
});

//
//VALIDACAO
//

function validaFormulario() {
	var formularioValido = true;
	var mensagem = "ERRO ao tentar cadastrar/editar. Erros:";
	
	if (!validaProduto()) {
		mensagem += "\n\t - Produto inválido. Por favor escolha um produto.";
		formularioValido = false;
	}
	if (!validaVersao()) {
		mensagem += "\n\t - Versão inválida. O campo versão é obrigatório.";
		formularioValido = false;
	}
	/*
	 * Comentado pq agora o campo é opcional
	if (!validaDescricao()) {
		mensagem += "\n\t - Descrição inválida. Tamanho mínimo da descrição deve ser de 3 (três) caracteres.";
		formularioValido = false;
	}
	*/
	if (!validaArquivo()) {
		mensagem += "\n\t - Arquivo inválido. Por favor escolha um arquivo para o download.";
		formularioValido = false;
	}

	if (formularioValido) {
		return true;
	} else {
		$('#dados-tab').click();
		return false;
	}
	
}

function validaProduto() {
	if ($('#produto').val() == -1) {
		$('#erroProduto').text('Escolha um produto.');
		$('#produto').focus();
		return false;
	} else {
		$('#erroProduto').text('');
		return true;
	}
}

function validaVersao() {
	var versaoDownload = $('#versao').val();
	if (versaoDownload.length > 0) {
		$('#erroVersao').text('');
		return true;
	} else {
		$('#erroVersao').text('Campo versão é obrigatório.');
		$('#versao').focus();
		return false;
	}
}

function validaDescricao() {
	var descricaoDownload = $('#descricao').val();
	
	if (descricaoDownload.length >= 3) {
		$('#erroDescricao').text('');
		return true;
	} else {
		if (descricaoDownload.length == 0) {
			$('#erroDescricao').text('Campo descrição é obrigatório.');
		} else {
			$('#erroDescricao').text('Descrição inválida. Tamanho mínimo de 03 (três) caracteres.');
		}
		$('#descricao').focus();
		return false;
	}
}

function validaArquivo() {
	if ($('#arquivo').val() == '') {
		$('#erroArquivo').text('Escolha um arquivo.');
		$('#arquivo').focus();
		return false;
	} else {
		$('#erroArquivo').text('');
		return true;
	}
	
}

