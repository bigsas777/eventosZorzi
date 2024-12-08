package repositorio;

import java.util.List;

import modelo.Evento;

public interface RepositorioAdHocEvento extends RepositorioString<Evento> {
	
	public List<Evento> getEventosDelMes(int mes, int año) throws RepositorioException;
	
	public List<Evento> getByOrganizador(String organizador) throws RepositorioException;

}
