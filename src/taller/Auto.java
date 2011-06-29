package taller;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "autos")
public class Auto {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	private String matricula;

	@Column(name = "anio")
	private int a�o;
		
	private String color;
	
	private String chasis;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "marca")
	private Marca marca;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "modelo")
	private Modelo modelo;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente")
	private Cliente cliente;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "presupuesto")
	private List<Presupuesto> presupuestos;

	public Auto() {

	}

	public Auto(String matricula, int a�o, String color, String chasis, Marca marca, 
						Modelo modelo, Cliente cliente){
		this.matricula = matricula;
		this.a�o = a�o;
		this.color = color;
		this.chasis = chasis;
		this.marca = marca;
		this.modelo = modelo;
		this.cliente = cliente;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getA�o() {
		return a�o;
	}

	public void setA�o(int a�o) {
		this.a�o = a�o;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getChasis() {
		return chasis;
	}

	public void setChasis(String chasis) {
		this.chasis = chasis;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Presupuesto> getPresupuestos() {
		return presupuestos;
	}

	public void setPresupuestos(List<Presupuesto> presupuestos) {
		this.presupuestos = presupuestos;
	}

	@Override
	public String toString() {
		return "Auto [matricula=" + matricula + ", a�o="
				+ a�o + ", color=" + color
				+ ", chasis=" + chasis + ", marca=" + marca 
				+ ", modelo=" + modelo + ", cliente=" + cliente + "]";
	}
	
}
