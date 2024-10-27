package modelo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;


@Entity
public class Ocupacion {
	
	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
	private String id;
	@Column(nullable = false)
	private LocalDateTime fechaInicio;
	@Column(nullable = false)
	private LocalDateTime fechaFin;
	@ManyToOne
    @JoinColumn(name = "espacio_fisico_id", nullable = false)
	private EspacioFisico espacioFisico;
	@Transient // Porque es un atributo calculado
	private boolean activa;
	
	
	private boolean calculaActiva()
	{
		return this.fechaFin.isAfter(LocalDateTime.now()) ? true : false;
	}
	
	
	// Auto-generated constructor, getters and setters
	public Ocupacion() {
		
	}
	public Ocupacion(LocalDateTime fechaInicio, LocalDateTime fechaFin, EspacioFisico espacioFisico) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.espacioFisico = espacioFisico;
		this.activa = calculaActiva();
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
