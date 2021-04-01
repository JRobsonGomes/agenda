/**
 * Confimação de formulário
 * @author Robson Gomes
 */

function confirmar(id, nome){
	let resposta = confirm("Deseja realmente excluir: " + nome);
	if(resposta === true){
		window.location.href = `deletar?id=${id}`;
	}
}