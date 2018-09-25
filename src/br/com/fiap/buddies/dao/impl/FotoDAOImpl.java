package br.com.fiap.buddies.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.fiap.buddies.dao.FotoDAO;
import br.com.fiap.buddies.entities.Foto;

@Repository
public class FotoDAOImpl extends GenericDAOImpl<Foto, Integer> implements FotoDAO {

}
