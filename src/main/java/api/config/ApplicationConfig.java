package api.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import api.Cargos;
import api.Cotacoes;
import api.Produtos;

@ApplicationPath("/api")
public class ApplicationConfig extends Application {
	@SuppressWarnings("unchecked")
	@Override
	public Set<Class<?>> getClasses() {
		return new HashSet<Class<?>>(Arrays.asList(Cargos.class, Produtos.class, Cotacoes.class));
	}
}