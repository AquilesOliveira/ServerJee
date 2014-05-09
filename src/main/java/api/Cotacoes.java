/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import java.text.ParseException;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.ejb.EJB;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import jee.api.GenericRest;
import jee.dao.GenericModel;
import models.CotacaoDao;
import models.dto.Cotacao;
import models.dto.Produto;

/**
 *
 * @author itakenami
 */
@Path("/cotacoes")
@Produces(MediaType.APPLICATION_JSON)
public class Cotacoes extends GenericRest<Cotacao> {

	@EJB
	CotacaoDao dao;

	@Override
	public GenericModel getModel() {
		return this.dao;
	}

	@Override
	public Cotacao getDtoToSave(final MultivaluedMap<String, String> form) {

		final Cotacao cotacao = new Cotacao();
		cotacao.setCpf(form.getFirst("cotacao.cpf"));
		cotacao.setSolicitante(form.getFirst("cotacao.solicitante"));

		final java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");

		try {
			cotacao.setData_solicitacao(sdf.parse(form.getFirst("cotacao.data_solicitacao")));
		} catch (final ParseException ex) {

		}

		final Set<Produto> produtos = new LinkedHashSet<Produto>();
		final Set<String> lista = form.keySet();
		for (final String param : lista) {
			if (param.indexOf("[") > -1) {
				final String val_id = form.getFirst(param);
				final Produto p = new Produto();
				p.setId(new Long(val_id));
				produtos.add(p);
			}
		}

		cotacao.setProdutos(produtos);

		return cotacao;

	}

	@Override
	public void setDtoToSave(final Cotacao dto, final MultivaluedMap<String, String> form) {

		dto.setCpf(form.getFirst("cotacao.cpf"));
		dto.setSolicitante(form.getFirst("cotacao.solicitante"));

		final java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");

		try {
			dto.setData_solicitacao(sdf.parse(form.getFirst("cotacao.data_solicitacao")));
		} catch (final ParseException ex) {

		}

		final Set<Produto> produtos = new LinkedHashSet<Produto>();
		final Set<String> lista = form.keySet();

		for (final String param : lista) {
			if (param.indexOf("[") > -1) {
				final String val_id = form.getFirst(param);
				final Produto p = new Produto();
				p.setId(new Long(val_id));
				produtos.add(p);
			}
		}

		dto.setProdutos(produtos);
	}

}