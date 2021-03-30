package com.robson.agenda.services;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.robson.agenda.dao.ContatoDao;
import com.robson.agenda.entidades.Contato;


public class ContatoServiceImpl implements ContatoService {

	@Inject
	private ContatoDao dao;
	
	@Transactional
	@Override
	public void salvar(Contato contato) {
		dao.save(contato);
	}

	@Transactional
	@Override
	public void editar(Contato contato) {
		dao.update(contato);
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override
	public Contato buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Contato> buscarTodos() {
		return dao.findAll();
	}

}
