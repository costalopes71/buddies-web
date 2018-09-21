package br.com.fiap.buddies.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import br.com.fiap.buddies.dao.GenericDAO;
import br.com.fiap.buddies.exceptions.DBException;

public class GenericDAOImpl<T, K> implements GenericDAO<T, K> {

	@PersistenceContext
	protected EntityManager em;
	
	private Class<T> classe;
	
	@SuppressWarnings("unchecked")
	public GenericDAOImpl() {
		classe = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	public List<T> listar() throws DBException {
		return em.createQuery("FROM " + classe.getName(), classe).getResultList();
	}

	@Override
	@Transactional
	public void cadastrar(T entity) throws DBException {
		em.persist(entity);
	}

	@Override
	@Transactional
	public void alterar(T entity) throws DBException {
		em.merge(entity);
	}

	@Override
	public T pesquisar(K codigo) throws DBException {
		return em.find(classe, codigo);
	}

	@Override
	@Transactional
	public void remover(K codigo) throws DBException {
		T entity = this.pesquisar(codigo);
		
		if (entity == null){
			throw new DBException("Entidade com o c�digo [" + codigo + "] n�o encontrada.");
		}
		
		em.remove(entity);
	}

}
