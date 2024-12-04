package web;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dto.EspacioFisicoDTO;
import repositorio.EntidadNoEncontrada;
import repositorio.RepositorioException;
import servicio.FactoriaServicios;
import servicio.IServicioEspacios;
import servicio.IServicioEventos;
import utils.Categoria;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class OrganizadorBean implements Serializable {
	
	private IServicioEspacios servicioEspacios;
	private IServicioEventos servicioEventos;
	
	@Inject
	private UserSessionBean userSessionBean;
	
	private Double capacidadMinima;
	private List<LocalDate> rangoFechas;
	private List<EspacioFisicoDTO> espaciosDisponibles;
	private String tmpNombreEvento;
	private String tmpDescripcion;
	private Double tmpPlazas;
	private Categoria tmpCategoria;
	private List<Categoria> categorias;
	private LocalTime primerDiaTime;
	private LocalTime ultimoDiaTime;
	private String tmpIdEsapcio;

	public OrganizadorBean() {
		servicioEspacios = FactoriaServicios.getServicio(IServicioEspacios.class);
		servicioEventos = FactoriaServicios.getServicio(IServicioEventos.class);
		
		capacidadMinima = 1.;
		categorias = Arrays.asList(Categoria.values());
	}

	public void addEvento() throws RepositorioException, EntidadNoEncontrada {
		LocalDateTime fechaInicio = rangoFechas.get(0).atTime(primerDiaTime);
		LocalDateTime fechFin = rangoFechas.get(1).atTime(ultimoDiaTime);
		
		servicioEventos.alta(tmpNombreEvento, tmpDescripcion, userSessionBean.getNombre(), tmpCategoria,
							fechaInicio, fechFin, tmpPlazas.intValue(), tmpIdEsapcio);
		
	}
	
	public void busquedaEspacios() throws RepositorioException {
		
		if (capacidadMinima == null) {
	        capacidadMinima = 1.;
	    }
		
		if (rangoFechas == null || rangoFechas.size() < 2) {
	        System.out.println("Errore: rangoFechas non valido o incompleto");
	        System.out.println(rangoFechas);
	        return;
	    }
	    
	    espaciosDisponibles = servicioEspacios.busqueda(rangoFechas.get(0).atStartOfDay(), rangoFechas.get(1).atStartOfDay(), capacidadMinima.intValue());
	    /*
	     * Lo spazio si occupa per tutto il giorno in modo tale da permettere agli organizzatori di praparare e poi smantellare l'evento
	     */
	}
	
	public void onDateSelect() {
	    System.out.println("Date range selected: " + rangoFechas);
	}

	
	public Double getCapacidadMinima() {
		return capacidadMinima;
	}

	public void setCapacidadMinima(Double capacidadMinima) {
		this.capacidadMinima = capacidadMinima;
	}
	
	public List<LocalDate> getRangoFechas() {
        return rangoFechas;
    }

    public void setRangoFechas(List<LocalDate> rangoFechas) {
        this.rangoFechas = rangoFechas;
    }

	public List<EspacioFisicoDTO> getEspaciosDisponibles() {
		return espaciosDisponibles;
	}

	public void setEspaciosDisponibles(List<EspacioFisicoDTO> espaciosDisponibles) {
		this.espaciosDisponibles = espaciosDisponibles;
	}

	public String getTmpNombreEvento() {
		return tmpNombreEvento;
	}

	public void setTmpNombreEvento(String tmpNombreEvento) {
		this.tmpNombreEvento = tmpNombreEvento;
	}

	public String getTmpDescripcion() {
		return tmpDescripcion;
	}

	public void setTmpDescripcion(String tmpDescripcion) {
		this.tmpDescripcion = tmpDescripcion;
	}

	public Double getTmpPlazas() {
		return tmpPlazas;
	}

	public void setTmpPlazas(Double tmpPlazas) {
		this.tmpPlazas = tmpPlazas;
	}

	public Categoria getTmpCategoria() {
		return tmpCategoria;
	}

	public void setTmpCategoria(Categoria tmpCategoria) {
		this.tmpCategoria = tmpCategoria;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public LocalTime getPrimerDiaTime() {
		return primerDiaTime;
	}

	public void setPrimerDiaTime(LocalTime primerDiaTime) {
		this.primerDiaTime = primerDiaTime;
	}

	public LocalTime getUltimoDiaTime() {
		return ultimoDiaTime;
	}

	public void setUltimoDiaTime(LocalTime ultimoDiaTime) {
		this.ultimoDiaTime = ultimoDiaTime;
	}

	public String getTmpIdEsapcio() {
		return tmpIdEsapcio;
	}

	public void setTmpIdEsapcio(String tmpIdEsapcio) {
		this.tmpIdEsapcio = tmpIdEsapcio;
	}

}
