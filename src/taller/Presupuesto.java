package taller;

import java.sql.Date;
import java.sql.Time;

public class Presupuesto {

	private int id;
	private Date fecha;
	private Time tiempoReparacion;
	private int costoReparacion;
	private boolean aceptado;
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

	public Time getTiempoReparacion() {
		return tiempoReparacion;
	}

	public void setTiempoReparacion(Time tiempoReparacion) {
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

}
