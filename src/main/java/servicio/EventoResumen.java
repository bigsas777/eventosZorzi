package servicio;

import java.time.LocalDateTime;
import java.util.List;

import utils.Categoria;

public class EventoResumen {
	
	private String nombre;
	private String descripcion;
	private LocalDateTime fechaInicio;
	private Categoria categoria;
	private String nombreEspacio;
	private String direccion;
	private List<String> puntosDeInteres;
	
	
	public EventoResumen() {
		super();
	}
	@Override
	public String toString() {
		return "EventoResumen [nombre=" + nombre + ", descripcion=" + descripcion + ", fechaInicio=" + fechaInicio
				+ ", categoria=" + categoria + ", nombreEspacio=" + nombreEspacio + ", direccion=" + direccion
				+ ", puntosDeInteres=" + puntosDeInteres + "]";
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String getNombreEspacio() {
		return nombreEspacio;
	}
	public void setNombreEspacio(String nombreEspacio) {
		this.nombreEspacio = nombreEspacio;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public List<String> getPuntosDeInteres() {
		return puntosDeInteres;
	}
	public void setPuntosDeInteres(List<String> puntosDeInteres) {
		this.puntosDeInteres = puntosDeInteres;
	}

}
