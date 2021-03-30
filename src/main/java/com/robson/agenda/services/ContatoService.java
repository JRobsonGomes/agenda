package com.robson.agenda.services;

import java.util.List;

import javax.ejb.Stateless;

import com.robson.agenda.entidades.Contato;

@Stateless
public interface ContatoService {

void salvar(Contato contato);
	
	void editar(Contato contato);
	
	void excluir(Long id);
	
	Contato buscarPorId(Long id);
	
	List<Contato> buscarTodos();
}
