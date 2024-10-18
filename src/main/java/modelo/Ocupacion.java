package modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Transient;


@Entity
public class Ocupacion {
	
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;
	private EspacioFisico espacioFisico;
	@Transient // Porque es un atributo calculado
	private boolean activa;
	
	
	// 
	
	
	// Auto-generated constructor, getters and setters
	public Ocupacion() {
		
	}
	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public LocalDateTime getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(LocalDateTime fechaFin) {
		this.fechaFin = fechaFin;
	}
	public EspacioFisico getEspacioFisico() {
		return espacioFisico;
	}
	public void setEspacioFisico(EspacioFisico espacioFisico) {
		this.espacioFisico = espacioFisico;
	}
	public boolean isActiva() {
		return activa;
	}
	public void setActiva(boolean activa) {
		this.activa = activa;
	}
	
}
