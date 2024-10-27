package modelo;

import javax.persistence.Entity;


@Entity
public class PuntoDeInteres {

	private String nombre;
	private String descripcion;
	private float distancia;
	private String urlWikipedia;
	
	
	//
	
	
	// Auto-generated constructor, getters and setters
	public PuntoDeInteres() {
		
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
	public float getDistancia() {
		return distancia;
	}
	public void setDistancia(float distancia) {
		this.distancia = distancia;
	}
	public String getUrlWikipedia() {
		return urlWikipedia;
	}
	public void setUrlWikipedia(String urlWikipedia) {
		this.urlWikipedia = urlWikipedia;
	}
	
}
