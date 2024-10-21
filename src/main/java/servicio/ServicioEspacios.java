package servicio;

import java.time.LocalDateTime;
import java.util.List;

import modelo.EspacioFisico;
import modelo.PuntoDeInteres;
import repositorio.FactoriaRepositorios;
import repositorio.Repositorio;
import utils.Estado;

public class ServicioEspacios implements IServicioEspacios {
	
	private Repositorio<EspacioFisico, String> repositorio = FactoriaRepositorios.getRepositorio(EspacioFisico.class);

	@Override
	public String alta(String nombre, String propietario, int capacidad, String direccion, float longitud,
			float latitud, String descripcion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addPuntosDeInteres(String id, List<PuntoDeInteres> puntosDeInteres) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String modifica(String id, String nombre, int capacidad, String descripcion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Estado darDeBaja(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Estado activar(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EspacioFisico> busqueda(LocalDateTime inicio, LocalDateTime fin, int capacidadMinima) {
		// TODO Auto-generated method stub
		return null;
	}

}
