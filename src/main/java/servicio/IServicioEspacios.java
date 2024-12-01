package servicio;

import java.time.LocalDateTime;
import java.util.List;

import dto.EspacioFisicoDTO;
import modelo.EspacioFisico;
import modelo.PuntoDeInteres;
import repositorio.EntidadNoEncontrada;
import repositorio.RepositorioException;

public interface IServicioEspacios {
	
	String alta(String nombre, String propietario, int capacidad, String direccion, float latitud, float longitud, String descripcion) throws RepositorioException;
	
	void addPuntosDeInteres(String id, List<PuntoDeInteres> puntosDeInteres) throws RepositorioException, EntidadNoEncontrada;
	
	void modifica(String id, String nombre, int capacidad, String descripcion) throws RepositorioException, EntidadNoEncontrada;
	
	void darDeBaja(String id) throws RepositorioException, EntidadNoEncontrada;
	
	void activar(String id) throws RepositorioException, EntidadNoEncontrada;
	
	List<EspacioFisicoDTO> busqueda(LocalDateTime inicio, LocalDateTime fin, int capacidadMinima) throws RepositorioException;
	
	public List<EspacioFisicoDTO> getAll() throws RepositorioException;
	
	public List<EspacioFisicoDTO> getByOwner(String propietario) throws RepositorioException;

}
