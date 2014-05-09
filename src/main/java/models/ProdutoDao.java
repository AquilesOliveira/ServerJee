/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import jee.dao.GenericModel;
import models.dto.Produto;

/**
 *
 * @author itakenami
 */
@Stateless
public class ProdutoDao extends GenericModel<Produto> {

	@PersistenceContext
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}

	@Override
	protected Class<Produto> getEntityClass() {
		return Produto.class;
	}

}
