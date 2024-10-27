package servicio;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import modelo.EspacioFisico;
import modelo.Evento;
import modelo.Ocupacion;
import modelo.PuntoDeInteres;
import repositorio.EntidadNoEncontrada;
import repositorio.FactoriaRepositorios;
import repositorio.Repositorio;
import repositorio.RepositorioEventoJPA;
import repositorio.RepositorioException;
import utils.Categoria;

public class ServicioEventos implements IServicioEventos {
	
	private Repositorio<Evento, String> repositorioEventos = FactoriaRepositorios.getRepositorio(Evento.class);
	private Repositorio<EspacioFisico, String> repositorioEspacios = FactoriaRepositorios.getRepositorio(EspacioFisico.class);

	@Override
	public String alta(String nombre, String descripcion, String organizador, Categoria categoria, LocalDateTime fechaInicio,
			LocalDateTime fechaFin, int plazas, String idEspacioFisico) throws RepositorioException, EntidadNoEncontrada {
		if (nombre == null || nombre.isEmpty())
			throw new IllegalArgumentException("nombre: no debe ser nulo ni vacio");
		if (descripcion == null || descripcion.isEmpty())
			throw new IllegalArgumentException("descripcion: no debe ser nula ni vacia");
		if (categoria == null)
			throw new IllegalArgumentException("categoria: no debe ser nula");
		if (fechaInicio == null)
			throw new IllegalArgumentException("fechaInicio: no debe ser nula");
		if (fechaFin == null)
			throw new IllegalArgumentException("fechaFin: no debe ser nula");
		if (plazas == 0)
			throw new IllegalArgumentException("plazas: no debe ser cero");
		if (idEspacioFisico == null || idEspacioFisico.isEmpty())
			throw new IllegalArgumentException("idEspacioFisico: no debe ser nulo ni vacio");
		
		EspacioFisico ef = repositorioEspacios.getById(idEspacioFisico);
		Ocupacion o = new Ocupacion(fechaInicio, fechaFin, ef);
		Evento e = new Evento(nombre, descripcion, organizador, plazas, categoria, o);
		
		return repositorioEventos.add(e);
	}

	@Override
	public void modifica(String idEvento, String descripcion, LocalDateTime fechaInicio, LocalDateTime fechaFin,
			int plazas, String idEspacioFisico) throws RepositorioException, EntidadNoEncontrada {
		
		if (descripcion == null || descripcion.isEmpty())
			throw new IllegalArgumentException("descripcion: no debe ser nula ni vacia");
		if (fechaInicio == null)
			throw new IllegalArgumentException("fechaInicio: no debe ser nula");
		if (fechaFin == null)
			throw new IllegalArgumentException("fechaFin: no debe ser nula");
		if (plazas == 0)
			throw new IllegalArgumentException("plazas: no debe ser cero");
		if (idEspacioFisico == null || idEspacioFisico.isEmpty())
			throw new IllegalArgumentException("idEspacioFisico: no debe ser nulo ni vacio");
		
		Evento e = repositorioEventos.getById(idEvento);
		Ocupacion o = e.getOcupacion();
		
		e.setDescripcion(descripcion);
		o.setFechaInicio(fechaInicio);
		o.setFechaFin(fechaFin);
		o.setEspacioFisico(repositorioEspacios.getById(idEspacioFisico));
		e.setOcupacion(o);
		e.setPlazas(plazas);
		
		repositorioEventos.update(e);
		
	}

	@Override
	public void cancelar(String idEvento) throws RepositorioException, EntidadNoEncontrada {
		
		Evento e = repositorioEventos.getById(idEvento);
		
		Ocupacion o = e.getOcupacion();
		o.setActiva(false);
		e.setOcupacion(o);
		
		repositorioEventos.update(e);
		repositorioEventos.delete(e);
		
	}

	@Override
	public List<EventoResumen> eventosDelMes(int mes, int año) throws RepositorioException {
		LinkedList<EventoResumen> resultado = new LinkedList<>();
		
		for (Evento e : ((RepositorioEventoJPA) repositorioEventos).getEventosDelMes(mes, año))
		{
			EventoResumen er = new EventoResumen();
			er.setNombre(e.getNombre());
			er.setDescripcion(e.getDescripcion());
			Ocupacion o = e.getOcupacion();
			er.setFechaInicio(o.getFechaInicio());
			er.setCategoria(e.getCategoria());
			EspacioFisico ef = o.getEspacioFisico();
			er.setNombreEspacio(ef.getNombre());
			er.setDireccion(ef.getDireccion());
			er.setPuntosDeInteres(ef.getPuntosDeInteres().stream()
					.sorted(Comparator.comparing(PuntoDeInteres::getDistancia))
                    .map(PuntoDeInteres::getNombre)
                    .collect(Collectors.toList()));
			
			resultado.add(er);
		}
		
		return resultado;
	}
	
	

}
