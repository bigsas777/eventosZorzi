package web;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import dto.EspacioFisicoDTO;
import repositorio.EntidadNoEncontrada;
import repositorio.RepositorioException;
import servicio.FactoriaServicios;
import servicio.IServicioEspacios;
import utils.Estado;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class PropietarioBean implements Serializable {
	
	private IServicioEspacios servicioEspacios;

    public PropietarioBean() {
    	
    	servicioEspacios = FactoriaServicios.getServicio(IServicioEspacios.class);

    }

    public List<EspacioFisicoDTO> getEspacios(String propietario) throws RepositorioException {
        return servicioEspacios.getByOwner(propietario);
    }
    
    public void updateEstado(EspacioFisicoDTO espacio) throws RepositorioException, EntidadNoEncontrada {
    	
        if (espacio != null) {
        	
            if (espacio.getEstado() == Estado.ACTIVO) {
                servicioEspacios.darDeBaja(espacio.getId());
            } else {
                servicioEspacios.activar(espacio.getId());
            }
        }
    }

}
