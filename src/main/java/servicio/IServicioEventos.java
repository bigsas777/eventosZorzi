package servicio;

import java.time.LocalDateTime;
import java.util.List;

import repositorio.EntidadNoEncontrada;
import repositorio.RepositorioException;
import utils.Categoria;

public interface IServicioEventos {
	
	String alta(String nombre, String descripcion, String organizador, Categoria categoria, LocalDateTime fechaInicio, LocalDateTime fechaFin, int plazas, String idEspacioFisico) throws RepositorioException, EntidadNoEncontrada;
	
	void modifica(String idEvento, String descripcion, LocalDateTime fechaInicio, LocalDateTime fechaFin, int plazas, String idEspacioFisico) throws RepositorioException, EntidadNoEncontrada;
	
	void cancelar(String idEvento) throws RepositorioException, EntidadNoEncontrada;
	
	List<EventoResumen> eventosDelMes(int mes, int año) throws RepositorioException;

}
