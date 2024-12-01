package web;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import dto.EspacioFisicoDTO;
import repositorio.RepositorioException;
import servicio.FactoriaServicios;
import servicio.IServicioEspacios;
import servicio.IServicioEventos;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class OrganizadorBean implements Serializable {
	
	private IServicioEspacios servicioEspacios;
	private IServicioEventos servicioEventos;
	
	private int capacidadMinima;
	private List<LocalDate> rangoFechas;
	private List<EspacioFisicoDTO> espaciosDisponibles;
	private Date dateTest;
	
	
	public Date getDateTest() {
		return dateTest;
	}

	public void setDateTest(Date dateTest) {
		this.dateTest = dateTest;
	}

	public OrganizadorBean() {
		servicioEspacios = FactoriaServicios.getServicio(IServicioEspacios.class);
		servicioEventos = FactoriaServicios.getServicio(IServicioEventos.class);
	}

	public void addEvento() {
		
	}
	
	public void busquedaEspacios() throws RepositorioException {
		
		System.out.println("Fecha test: " + dateTest.toString());
		
		if (rangoFechas == null || rangoFechas.size() < 2) {
	        System.out.println("Errore: rangoFechas non valido o incompleto");
	        return;
	    }
		
		espaciosDisponibles = servicioEspacios.busqueda(rangoFechas.get(0).atStartOfDay(), rangoFechas.get(1).atStartOfDay(), capacidadMinima);
	}
	
	public void onDateSelect() {
	    System.out.println("Date range selected: " + rangoFechas);
	}

	
	public int getCapacidadMinima() {
		return capacidadMinima;
	}

	public void setCapacidadMinima(int capacidadMinima) {
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

}
