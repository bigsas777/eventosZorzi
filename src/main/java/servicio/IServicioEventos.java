package servicio;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import utils.Categoria;

public interface IServicioEventos {
	
	String alta(String nombre, String descripcion, Categoria categoria, LocalDateTime fechaInicio, LocalDateTime fechaFin, int plazas, String idEspacioFisico);
	
	String modifica(String idEvento, String description, LocalDateTime fechaInicio, LocalDateTime fechaFin, int plazas, String idEspacioFisico);
	
	void cancelar(String idEvento);
	
	List<EventoResumen> eventosDelMes(Month mes, int año);

}
