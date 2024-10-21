package servicio;

import java.util.List;

import modelo.PuntoDeInteres;

public interface IPuntosDeInteres {
	
	List<PuntoDeInteres> getPuntosDeInteres(float longitud, float latitud);

}
