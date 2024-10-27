package modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import repositorio.Identificable;
import utils.Categoria;

@Entity
public class Evento implements Identificable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
	private String id;
	@Column(nullable = false)
	private String nombre;
	@Column(nullable = false, length = 1000)
	private String descripcion;
	@Column(nullable = false)
	private String organizador;
	@Column(nullable = false)
	private int plazas;
	@Column(nullable = false)
	private boolean cancelado;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Categoria categoria;
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "ocupacion_id")
	private Ocupacion ocupacion;
	
	
	// Auto-generated constructors, getters and setters
	public Evento() {
		
	}
	public Evento(String nombre, String descripcion, String organizador, int plazas, Categoria categoria,
			Ocupacion ocupacion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.organizador = organizador;
		this.plazas = plazas;
		this.cancelado = false;
		this.categoria = categoria;
		this.ocupacion = ocupacion;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getOrganizador() {
		return organizador;
	}
	public void setOrganizador(String organizador) {
		this.organizador = organizador;
	}
	public int getPlazas() {
		return plazas;
	}
	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}
	public boolean isCancelado() {
		return cancelado;
	}
	public void setCancelado(boolean cancelado) {
		this.cancelado = cancelado;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Ocupacion getOcupacion() {
		return ocupacion;
	}
	public void setOcupacion(Ocupacion ocupacion) {
		this.ocupacion = ocupacion;
	}
	@Override
	public String toString() {
		return "Evento [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", organizador="
				+ organizador + ", plazas=" + plazas + ", cancelado=" + cancelado + ", categoria=" + categoria
				+ ", ocupacion=" + ocupacion + "]";
	}
	
}
