package taller;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "presupuestos")
public class Presupuesto {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	private Date fecha;
	private int tiempoReparacion;
	private int costoReparacion;
	private boolean aceptado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "auto")
	private Auto auto;

	public Presupuesto() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getTiempoReparacion() {
		return tiempoReparacion;
	}

	public void setTiempoReparacion(int tiempoReparacion) {
		this.tiempoReparacion = tiempoReparacion;
	}

	public int getCostoReparacion() {
		return costoReparacion;
	}

	public void setCostoReparacion(int costoReparacion) {
		this.costoReparacion = costoReparacion;
	}

	public boolean isAceptado() {
		return aceptado;
	}

	public void setAceptado(boolean aceptado) {
		this.aceptado = aceptado;
	}

	public Auto getAuto() {
		return auto;
	}

	public void setAuto(Auto auto) {
		this.auto = auto;
	}

	@Override
	public String toString() {
		return "Presupuesto [fecha=" + fecha + ", tiempoReparacion="
				+ tiempoReparacion + ", costoReparacion=" + costoReparacion
				+ ", aceptado=" + aceptado + "]";
	}

}
