package br.com.fiap.buddies.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.fiap.buddies.dao.UsuarioDAO;
import br.com.fiap.buddies.entities.Usuario;

@Repository
public class UsuarioDAOImpl extends GenericDAOImpl<Usuario, Integer> implements UsuarioDAO {

}
