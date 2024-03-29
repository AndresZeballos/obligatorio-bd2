package taller;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	private String nombre;
	private String apellido;
	private String direccion;
	private int telefono;
	private Date baja;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "auto")
	private List<Auto> autos;

	public Cliente() {

	}

	public Cliente(String nombre, String apellido, String direccion,
			int telefono, List<Auto> autos) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.telefono = telefono;
		this.autos = autos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public List<Auto> getAutos() {
		return autos;
	}

	public void setAutos(List<Auto> autos) {
		this.autos = autos;
	}

	public Date getBaja() {
		return baja;
	}

	public void setBaja(Date baja) {
		this.baja = baja;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido="
				+ apellido + ", direccion=" + direccion + ", telefono="
				+ telefono + ", baja=" + baja + "]";
	}

}
