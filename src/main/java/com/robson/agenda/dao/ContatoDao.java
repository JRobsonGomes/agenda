package com.robson.agenda.dao;

import java.util.List;

import javax.ejb.Stateless;

import com.robson.agenda.entidades.Contato;

@Stateless
public interface ContatoDao {
	void save(Contato contato);

    void update(Contato contato);

    void delete(Long id);

    Contato findById(Long id);

    List<Contato> findAll();
}
