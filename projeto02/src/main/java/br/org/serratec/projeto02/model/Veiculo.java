package br.org.serratec.projeto02.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Veiculo {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name="id_veiculo")
	private Long id;
	private String placa;
	private String marca;
	private String modelo;
	@Embedded
	private CaracteristicaVeiculo caracteristicaVeiculo;
	
	
	public Veiculo(Long id, String placa, String marca, String modelo, CaracteristicaVeiculo caracteristicaVeiculo) {
		super();
		this.id = id;
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.caracteristicaVeiculo = caracteristicaVeiculo;
	}
	
	public Veiculo() {
		// TODO Auto-generated constructor stub
	}
	
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Long getId() {
		return id;
	}
	public String getMarca() {
		return marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	
	public CaracteristicaVeiculo getCaracteristicaVeiculo() {
		return caracteristicaVeiculo;
	}
	public void setCaracteristicaVeiculo(CaracteristicaVeiculo caracteristicaVeiculo) {
		this.caracteristicaVeiculo = caracteristicaVeiculo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
