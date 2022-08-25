package com.asj.examen.examenbackend.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Entity // Entidad
@Table(name= "vendedores") // le cambio el nombre para que matchee con mi DB
@SequenceGenerator(name = "gn_vendedor", sequenceName = "gn_vendedor", allocationSize = 1) // secuencia para autogenerar el id
@NoArgsConstructor  // constructor sin args
@AllArgsConstructor // constructor con args
@JsonIgnoreProperties
public class Vendedor {


	@Id
	@GeneratedValue(generator = "gn_vendedor", strategy = GenerationType.SEQUENCE) // autoincremental
	@Column(name = "codigo", unique = true)
	private Long id;
	private String nombre;
	private Double sueldoBasico;
	private Double sueldoTotal;
	private Double comision;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Double getSueldoBasico() {
		return sueldoBasico;
	}

	public void setSueldoBasico(Double sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}

	public Double getSueldoTotal() {
		return sueldoTotal;
	}

	public void setSueldoTotal(Double sueldoTotal) {
		this.sueldoTotal = sueldoTotal;
	}

	public Double getComision() {
		return comision;
	}

	public void setComision(Double comision) {
		this.comision = comision;
	}
}
