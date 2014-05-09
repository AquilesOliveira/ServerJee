/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import models.ProdutoDao;
import models.dto.Produto;

/**
 *
 * @author itakenami
 */
@Stateless
@WebService(portName = "ProdutoPort", serviceName = "ProdutoService", targetNamespace = "http://localhost/wsdl")
public class ProdutoWS {

	@EJB
	ProdutoDao dao;

	public Produto save(final Produto obj) {
		try {
			this.dao.save(obj);
			return obj;
		} catch (final Exception ex) {
			return null;
		}
	}

	public Produto update(final Long id, final Produto obj) {
		try {
			this.dao.update(obj);
			return obj;
		} catch (final Exception ex) {
			return null;
		}
	}

	public boolean delete(final Long id) {
		final Produto c = this.dao.findById(id);
		try {
			this.dao.delete(c);
			return true;
		} catch (final Exception ex) {
			return false;
		}

	}

	public List<Produto> findAll() {
		return this.dao.findAll();
	}

	public Produto findById(final Long id) {
		return this.dao.findById(id);
	}

}
