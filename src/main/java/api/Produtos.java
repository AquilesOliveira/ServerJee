package api;

import javax.ejb.EJB;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import jee.api.GenericRest;
import jee.dao.GenericModel;
import models.ProdutoDao;
import models.dto.Produto;

@Path("/produtos")
@Produces(MediaType.APPLICATION_JSON)
public class Produtos extends GenericRest<Produto> {

	@EJB
	ProdutoDao dao;

	@Override
	public GenericModel getModel() {
		return this.dao;
	}

	@Override
	public Produto getDtoToSave(final MultivaluedMap<String, String> form) {
		final Produto c = new Produto();
		c.setNome(form.getFirst("produto.nome"));
		c.setDescricao(form.getFirst("produto.descricao"));
		System.out.println("Produtos.getDtoToSave() " + form.getFirst("produto.quantidade"));
		c.setQuantidade(Integer.parseInt(form.getFirst("produto.quantidade")));
		c.setValor(Double.parseDouble(form.getFirst("produto.valor")));

		System.out.println("Produtos.getDtoToSave() " + c);
		return c;
	}

	@Override
	public void setDtoToSave(final Produto dto, final MultivaluedMap<String, String> form) {
		for (final String iterable_element : form.keySet()) {
			System.out.println("Chave:" + iterable_element + " valor:" + form.getFirst(iterable_element));
		}

		dto.setNome(form.getFirst("produto.nome"));
		dto.setDescricao(form.getFirst("produto.descricao"));
		System.out.println("Produtos.setDtoToSave() " + form.getFirst("produto.quantidade"));
		dto.setQuantidade(Integer.parseInt(form.getFirst("produto.quantidade")));
		dto.setValor(Double.parseDouble(form.getFirst("produto.valor")));

		System.out.println("Produtos.setDtoToSave() " + dto);
	}
}