package servicio;

import java.time.LocalDateTime;
import java.util.List;

import modelo.EspacioFisico;
import modelo.PuntoDeInteres;
import utils.Estado;

public interface IServicioEspacios {
	
	String alta(String nombre, String propietario, int capacidad, String direccion, float longitud, float latitud, String descripcion);
	
	void addPuntosDeInteres(String id, List<PuntoDeInteres> puntosDeInteres);
	
	String modifica(String id, String nombre, int capacidad, String descripcion);
	
	Estado darDeBaja(String id);
	
	Estado activar(String id);
	
	List<EspacioFisico> busqueda(LocalDateTime inicio, LocalDateTime fin, int capacidadMinima);

}
