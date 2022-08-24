package com.asj.examen.examenbackend.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity // Entidad
@Table(name= "vendedores") // le cambio el nombre para que matchee con mi DB
@SequenceGenerator(name = "gn_vendedor", sequenceName = "gn_vendedor", allocationSize = 1) // secuencia para autogenerar el id
// @Data // getters & setters | mala práctica
@NoArgsConstructor  // constructor sin args
@AllArgsConstructor // constructor con args
public class Vendedor {

	//código, nombre, sueldo
	@Id
	@GeneratedValue(generator = "gn_vendedor", strategy = GenerationType.SEQUENCE) // autoincremental
	private Long id; // codigo
	private String nombre;
	private Double sueldo;

	@OneToMany(mappedBy = "vendedor", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Venta> listaVentas;

	//orphanRemoval => si borro al vendedor, borro sus ventas


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

	public Double getSueldo() {
		return sueldo;
	}

	public void setSueldo(Double sueldo) {
		this.sueldo = sueldo;
	}

	public List<Venta> getListaVentas() {
		return listaVentas;
	}

	public void setListaVentas(List<Venta> listaVentas) {
		this.listaVentas = listaVentas;
	}
}
