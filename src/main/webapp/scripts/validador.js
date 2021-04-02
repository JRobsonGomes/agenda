/**
 * Validação de formulário
 * @author Robson Gomes
*/

function validar() {
	let nome = formContato.nome.value;
	let telefone = formContato.telefone.value;
	let feedbackNome = document.getElementById('feedbackNome');
	let feedbackTelefone = document.getElementById('feedbackTelefone');
	
	if (nome === "") {
		formContato.nome.classList.add('is-invalid');
		formContato.nome.focus();
		return false;
	}else if (nome.length < 3) {
		formContato.nome.classList.add('is-invalid');
		feedbackNome.innerText = 'Não pode ser menor que 3 caracteres!'
		formContato.nome.focus();
		return false;
	}else {
		formContato.nome.classList.remove('is-invalid');
		formContato.nome.classList.add('is-valid');
		feedbackNome.innerText = 'Preencha o nome';
	}
	
	if (telefone === "") {
		formContato.telefone.classList.add('is-invalid');
		formContato.telefone.focus();
		return false;
	}else {
		formContato.telefone.classList.remove('is-invalid');
		formContato.telefone.classList.add('is-valid');
	}
}

/*
 *Função para formatar telefone
 *Importar jquery e jquery.mask.min nas paginas que usarão a formatação
*/

$("#txttelefone").mask("(00) 0000-0000");

