package dto;

import utils.Estado;

public class EspacioFisicoDTO {
	
	private String id;
	private String nombre;
	private int capacidad;
	private String direccion;
	private String descripcion;
	private String propietario;
	private Estado estado;
	
	
	public EspacioFisicoDTO(String id, String nombre, int capacidad, String direccion, String descripcion,
			String propietario, Estado estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.direccion = direccion;
		this.descripcion = descripcion;
		this.propietario = propietario;
		this.estado = estado;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
}
