package taller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "modelos")
public class Modelo {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	private String modelo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "marca")
	private Marca marca;

	public Modelo() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	@Override
	public String toString() {
		return "Modelo [modelo=" + modelo + ", marca=" + marca +  "]";
	}

}
