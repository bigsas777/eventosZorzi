package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class PuntoDeInteres {

	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
	private String id;
	@Column(nullable = false)
	private String nombre;
	@Column(nullable = false, length = 1000)
	private String descripcion;
	@Column(nullable = false)
	private float distancia;
	@Column(nullable = false, length = 500)
	private String urlWikipedia;
	
	
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
	@Override
	public String toString() {
		return "PuntoDeInteres [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", distancia="
				+ distancia + ", urlWikipedia=" + urlWikipedia + "]";
	}
	
}
