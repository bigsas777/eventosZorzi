package servicio;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import modelo.Evento;
import repositorio.FactoriaRepositorios;
import repositorio.Repositorio;
import utils.Categoria;

public class ServicioEventos implements IServicioEventos {
	
	private Repositorio<Evento, String> repositorio = FactoriaRepositorios.getRepositorio(Evento.class);

	@Override
	public String alta(String nombre, String descripcion, Categoria categoria, LocalDateTime fechaInicio,
			LocalDateTime fechaFin, int plazas, String idEspacioFisico) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String modifica(String idEvento, String description, LocalDateTime fechaInicio, LocalDateTime fechaFin,
			int plazas, String idEspacioFisico) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cancelar(String idEvento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EventoResumen> eventosDelMes(Month mes, int año) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
