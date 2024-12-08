package repositorio;

import java.time.LocalDateTime;
import java.util.List;

import modelo.EspacioFisico;

public interface RepositorioAdHocEspacioFisico extends RepositorioString<EspacioFisico> {
	
	public List<EspacioFisico> buscarEspaciosLibres(LocalDateTime inicio, LocalDateTime fin, int capacidadMinima) throws RepositorioException;

	public boolean tieneOcupacionActiva(String idEspacio) throws RepositorioException;
	
	public List<EspacioFisico> getByPropietario(String propietario) throws RepositorioException;

}
