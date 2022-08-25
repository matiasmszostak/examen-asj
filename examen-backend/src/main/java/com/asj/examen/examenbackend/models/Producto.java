package com.asj.examen.examenbackend.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity // Entidad
@Table(name= "productos") // le cambio el nombre para que matchee con mi DB
@SequenceGenerator(name = "gn_producto", sequenceName = "gn_producto", allocationSize = 1)
@NoArgsConstructor  // constructor sin args
@AllArgsConstructor // constructor con args
@JsonIgnoreProperties(ignoreUnknown = true)
public class Producto {


    @Id
    @GeneratedValue(generator = "gn_producto", strategy = GenerationType.SEQUENCE) // autoincremental
    @Column(name = "codigo", unique = true)
    private Long id;
    private String nombre;
    private Double precio;
    private String categoria;


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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

}
