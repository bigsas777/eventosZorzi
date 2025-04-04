package servicio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dto.EspacioFisicoDTO;
import modelo.EspacioFisico;
import modelo.PuntoDeInteres;
import repositorio.EntidadNoEncontrada;
import repositorio.FactoriaRepositorios;
import repositorio.RepositorioAdHocEspacioFisico;
import repositorio.RepositorioException;
import utils.Estado;

public class ServicioEspacios implements IServicioEspacios {
	
	private RepositorioAdHocEspacioFisico repositorio = FactoriaRepositorios.getRepositorio(EspacioFisico.class);

	@Override
	public String alta(String nombre, String propietario, int capacidad, String direccion, float latitud, float longitud, 
			String descripcion) throws RepositorioException {
		
		if (nombre == null || nombre.isEmpty())
			throw new IllegalArgumentException("nombre: no debe ser nulo ni vacio");
		if (propietario == null || propietario.isEmpty())
			throw new IllegalArgumentException("propietario: no debe ser nulo ni vacio");
		if (capacidad == 0)
			throw new IllegalArgumentException("capacidad: no debe ser nula");
		if (direccion == null || direccion.isEmpty())
			throw new IllegalArgumentException("direccion: no debe ser nula ni vacia");
		if (descripcion == null || descripcion.isEmpty())
			throw new IllegalArgumentException("descripcion: no debe ser nula ni vacia");
		
		EspacioFisico espacioFisico = new EspacioFisico(nombre, propietario, capacidad, direccion, longitud, latitud, descripcion);
		
		String id = repositorio.add(espacioFisico);
		
		return id;
	}

	@Override
	public void addPuntosDeInteres(String id, List<PuntoDeInteres> puntosDeInteres) throws RepositorioException, EntidadNoEncontrada {
		if (id == null || id.isEmpty())
			throw new IllegalArgumentException("id: no debe ser nulo ni vacio");
		
		EspacioFisico espacioFisico = repositorio.getById(id);
		
		espacioFisico.setPuntosDeInteres(puntosDeInteres);
		
		repositorio.update(espacioFisico);
	}

	@Override
	public void modifica(String id, String nombre, int capacidad, String descripcion) throws RepositorioException, EntidadNoEncontrada {
		if (id == null || id.isEmpty())
			throw new IllegalArgumentException("id: no debe ser nulo ni vacio");
		if (nombre == null || nombre.isEmpty())
			throw new IllegalArgumentException("nombre: no debe ser nulo ni vacio");
		if (capacidad == 0)
			throw new IllegalArgumentException("capacidad: no debe ser nula");
		if (descripcion == null || descripcion.isEmpty())
			throw new IllegalArgumentException("descripcion: no debe ser nula ni vacia");
		
		EspacioFisico espacioFisico = repositorio.getById(id);
		
		espacioFisico.setNombre(nombre);
		espacioFisico.setCapacidad(capacidad);
		espacioFisico.setDescripcion(descripcion);
		
		repositorio.update(espacioFisico);
	}

	@Override
	public void darDeBaja(String id) throws RepositorioException, EntidadNoEncontrada {
		if (id == null || id.isEmpty())
			throw new IllegalArgumentException("id: no debe ser nulo ni vacio");
		
		EspacioFisico espacioFisico = repositorio.getById(id);
		
		boolean tieneOcupacionActiva = repositorio.tieneOcupacionActiva(id);
		
		if (!tieneOcupacionActiva)
		{
			espacioFisico.setEstado(Estado.CERRADO_TEMPORALMENTE);
			repositorio.update(espacioFisico);
		}
		
	}

	@Override
	public void activar(String id) throws RepositorioException, EntidadNoEncontrada {
		if (id == null || id.isEmpty())
			throw new IllegalArgumentException("id: no debe ser nulo ni vacio");
		
		EspacioFisico espacioFisico = repositorio.getById(id);
		
		if (espacioFisico.getEstado() == Estado.CERRADO_TEMPORALMENTE)
		{
			espacioFisico.setEstado(Estado.ACTIVO);
			repositorio.update(espacioFisico);
		}
	}

	@Override
	public List<EspacioFisicoDTO> busqueda(LocalDateTime inicio, LocalDateTime fin, int capacidadMinima) throws RepositorioException {
		
		List<EspacioFisico> espaciosDisponibles = repositorio.buscarEspaciosLibres(inicio, fin, capacidadMinima);
		
		List<EspacioFisicoDTO> espaciosDisponiblesDTO = new ArrayList<EspacioFisicoDTO>();
		
		for (EspacioFisico ef : espaciosDisponibles)
		{
			espaciosDisponiblesDTO.add(transformToDTO(ef));
		}
		
		return espaciosDisponiblesDTO;
	}
	
	@Override
	public List<EspacioFisicoDTO> getByOwner(String propietario) throws RepositorioException {
		
		List<EspacioFisico> all = repositorio.getByPropietario(propietario);
		
		List<EspacioFisicoDTO> allDto = new ArrayList<EspacioFisicoDTO>();
		
		for (EspacioFisico ef : all)
		{
			allDto.add(transformToDTO(ef));
		}
		
		return allDto;
		
	}
	
	private EspacioFisicoDTO transformToDTO(EspacioFisico ef)
	{
		EspacioFisicoDTO espacioFisicoDTO = new EspacioFisicoDTO(ef.getId(), ef.getNombre(), ef.getCapacidad(), 
				ef.getDireccion(), ef.getDescripcion(), ef.getPropietario(), ef.getEstado());
		
		return espacioFisicoDTO;
	}

}
