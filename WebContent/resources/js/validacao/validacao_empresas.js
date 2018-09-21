/**
 * Script de validação para cadastrar e editar empresas. 
 */

// funcao que ajusta o tamanho da tabela (necessario por ela estar em outra TAB)
$('a[data-toggle="tab"]').on('shown.bs.tab', function(e){
   $($.fn.dataTable.tables(true)).DataTable().columns.adjust();
});

// função que carrega a tabela
$(document).ready(function (){
	var table = $('#tabelaProdutos').DataTable({
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
//VALIDACAO
//

function validaFormulario() {
	var formularioValido = true;
	var mensagem = "ERRO ao tentar cadastrar/editar. Erros:";
	if (!this.validaNome()) {
		mensagem += "\n\t - Nome da empresa inválido. O tamanho mínimo do nome deve ser de 03 (três) caracteres.";
		formularioValido = false;
	}
	if (!validaLogradouro()) {
		mensagem += "\n\t - Logradouro da empresa inválido. O tamanho mínimo do logradouro deve ser de 03 (três) caracteres.";
		formularioValido = false;
	}
	if (!validaNumeroLogradouro()) {
		mensagem += "\n\t - Número do logradouro da empresa inválido. O tamanho mínimo do número deve ser de 01 (um) caracter.";
		formularioValido = false;
	}
	if (!validaBairro()) {
		mensagem += "\n\t - Bairro da empresa inválido. O tamanho mínimo do nome do bairro deve ser de 03 (três) caracteres.";
		formularioValido = false;
	}
	if (!validaCidade()) {
		mensagem += "\n\t - Cidade da empresa inválida. O tamanho mínimo do nome da cidade deve ser de 03 (três) caracteres.";
		formularioValido = false;
	}
	if (!validaEstado()) {
		mensagem += "\n\t - UF da empresa inválido. Por favor escolha uma UF.";
		formularioValido = false;
	}
	if (!validaCep()) {
		mensagem += "\n\t - CEP da empresa inválido. Utilize o padrão 00000-000";
		formularioValido = false;
	}
	
	if (formularioValido == false) {
		$('#dados-tab').click();
		return false;
	} else {
		return true;
	}
	
};

function validaNome() {
	var nomeEmpresa = $('#nome').val();
	if (nomeEmpresa.length >= 3) {
		$('#erroNome').text('');
		return true;
	} else {
		if (nomeEmpresa.length == 0) {
			$('#erroNome').text('Campo nome obrigatório.');
		} else {
			$('#erroNome').text('Nome inválido. Tamanho mínimo de 03 (três) caracteres.');
		}
		$('#nome').focus();
		return false;
	}
}

function validaLogradouro() {
	var logradouroEmpresa = $('#logradouro').val();
	if (logradouroEmpresa.length >= 3) {
		$('#erroLogradouro').text('');
		return true;
	} else {
		if (logradouroEmpresa.length == 0) {
			$('#erroLogradouro').text('Campo logradouro obrigatório.');
		} else {
			$('#erroLogradouro').text('Logradouro inválido. Tamanho mínimo de 03 (três) caracteres.');
		}
		$('#logradouro').focus();
		return false;
	}
}

function validaNumeroLogradouro() {
	var numeroLogradouro = $('#numeroEndereco').val();
	if (numeroLogradouro.length > 0) {
		$('#erroNumero').text('');
		return true;
	} else {
		$('#erroNumero').text('Campo obrigatório.');
		$('#numeroEndereco').focus();
		return false;
	}	
}

function validaBairro() {
	var bairroEmpresa = $('#bairro').val();
	if (bairroEmpresa.length >= 3) {
		$('#erroBairro').text('');
		return true;
	} else {
		if (bairroEmpresa.length == 0) {
			$('#erroBairro').text('Campo bairro obrigatório.');
		} else {
			$('#erroBairro').text('Bairro inválido. Mínimo de 03 (três) caracteres.');
		}
		$('#bairro').focus();
		return false;
	}
}

function validaCidade() {
	var cidadeEmpresa = $('#cidade').val();
	if (cidadeEmpresa.length >= 3) {
		$('#erroCidade').text('');
		return true;
	} else {
		if (cidadeEmpresa.length == 0) {
			$('#erroCidade').text('Campo cidade obrigatório.');
		} else {
			$('#erroCidade').text('Cidade inválida. Mínimo de 03 (três) caracteres.');
		}
		$('#cidade').focus();
		return false;
	}
}

function validaEstado() {
	if($('#estado').val() == -1){
		$('#erroEstado').text('Escolha uma UF.');
		$('#estado').focus();
		return false;
	} else {
		$('#erroEstado').text('');
		return true;
	}
}

function validaCep() {
	var cepRE = /^[0-9]{5}-[0-9]{3}$/;
	var e = (cepRE.test($("#cep").val()));
	if (e == true) {
		$('#erroCep').text('');
		return true;
	} else {
		$('#erroCep').text('CEP inválido (ex: 00000-000).');
		$('#cep').focus();
		return false;
	}
}
