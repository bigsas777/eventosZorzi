package modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import repositorio.Identificable;
import utils.Estado;


@Entity
public class EspacioFisico implements Identificable {

	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
	private String id;
	@Column(nullable = false)
	private String nombre;
	@Column(nullable = false)
	private String proprietario;
	@Column(nullable = false)
	private int capacidad;
	@Column(nullable = false)
	private String direccion;
	@Column(nullable = false)
	private float longitud;
	@Column(nullable = false)
	private float latitud;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "espacio_fisico_id")
	private List<PuntoDeInteres> puntosDeInteres;
	@Column(nullable = false)
	@Lob
	private String descripcion;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Estado estado;
	
	
	// Auto-generated constructors, getters and setters
	public EspacioFisico() {
		
	}
	public EspacioFisico(String nombre, String proprietario, int capacidad, String direccion, float longitud,
			float latitud, String descripcion) {
		super();
		this.nombre = nombre;
		this.proprietario = proprietario;
		this.capacidad = capacidad;
		this.direccion = direccion;
		this.longitud = longitud;
		this.latitud = latitud;
		this.descripcion = descripcion;
		this.estado = Estado.ACTIVO;
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
	public String getProprietario() {
		return proprietario;
	}
	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public float getLongitud() {
		return longitud;
	}
	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}
	public float getLatitud() {
		return latitud;
	}
	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}
	public List<PuntoDeInteres> getPuntosDeInteres() {
		return puntosDeInteres;
	}
	public void setPuntosDeInteres(List<PuntoDeInteres> puntosDeInteres) {
		this.puntosDeInteres = puntosDeInteres;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "EspacioFisico [id=" + id + ", nombre=" + nombre + ", proprietario=" + proprietario + ", capacidad="
				+ capacidad + ", direccion=" + direccion + ", longitud=" + longitud + ", latitud=" + latitud
				+ ", puntosDeInteres=" + puntosDeInteres + ", descripcion=" + descripcion + ", estado=" + estado + "]";
	}
	
}
