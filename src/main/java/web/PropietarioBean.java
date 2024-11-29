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

    public PropietarioBean() throws RepositorioException {
    	
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

/*espacios = new ArrayList<>();

// Popolamento della lista (simulazione)
EspacioFisicoDTO e1 = new EspacioFisicoDTO("", "Sala A", 50, "Calle Uno", "Descr", "Pino Daniele", Estado.ACTIVO);
EspacioFisicoDTO e2 = new EspacioFisicoDTO("", "Sala B", 100, "Calle Dos", "Descr B", "Gigetto Fisichetto", Estado.CERRADO_TEMPORALMENTE);
EspacioFisicoDTO e3 = new EspacioFisicoDTO("", "Sala C", 75, "Calle Tres", "Descr C", "Maria Gonzalez", Estado.ACTIVO);
EspacioFisicoDTO e4 = new EspacioFisicoDTO("", "Auditorio Principal", 200, "Avenida Central 5", "Auditorio con equipamiento completo", "Luigi Rossini", Estado.ACTIVO);
EspacioFisicoDTO e5 = new EspacioFisicoDTO("", "Sala de Reuniones", 20, "Calle Cuatro", "Pequeña sala de reuniones", "Ana Rodríguez", Estado.CERRADO_TEMPORALMENTE);
EspacioFisicoDTO e6 = new EspacioFisicoDTO("", "Laboratorio de Informática", 30, "Campus Norte, Edificio A", "Sala equipada con ordenadores", "Carlos Pérez", Estado.ACTIVO);
EspacioFisicoDTO e7 = new EspacioFisicoDTO("", "Sala de Ensayos", 15, "Calle Cinco", "Espacio para ensayos teatrales", "Sofía Ramírez", Estado.CERRADO_TEMPORALMENTE);
EspacioFisicoDTO e8 = new EspacioFisicoDTO("", "Gimnasio", 100, "Centro Deportivo, Planta Baja", "Espacio deportivo multifuncional", "Diego Martínez", Estado.ACTIVO);
EspacioFisicoDTO e9 = new EspacioFisicoDTO("", "Biblioteca Central", 300, "Plaza del Conocimiento", "Espacio silencioso con libros y zonas de estudio", "Laura Fernández", Estado.ACTIVO);
EspacioFisicoDTO e10 = new EspacioFisicoDTO("", "Sala de Conferencias", 120, "Edificio B, Planta 3", "Sala equipada para presentaciones y conferencias", "José Ortega", Estado.CERRADO_TEMPORALMENTE);


espacios.add(e1);
espacios.add(e2);
espacios.add(e3);
espacios.add(e4);
espacios.add(e5);
espacios.add(e6);
espacios.add(e7);
espacios.add(e8);
espacios.add(e9);
espacios.add(e10);*/
