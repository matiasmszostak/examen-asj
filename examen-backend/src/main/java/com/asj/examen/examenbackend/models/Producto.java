package com.asj.examen.examenbackend.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.DecimalFormat;
import java.util.List;

@Entity // Entidad
@Table(name= "productos") // le cambio el nombre para que matchee con mi DB
@SequenceGenerator(name = "gn_producto", sequenceName = "gn_producto", allocationSize = 1) // secuencia para autogenerar el id
// @Data // getters & setters | mala práctica
@NoArgsConstructor  // constructor sin args
@AllArgsConstructor // constructor con args
public class Producto {

//    código, nombre, precio, categoría

    @Id
    @GeneratedValue(generator = "gn_producto", strategy = GenerationType.SEQUENCE) // autoincremental
    private Long id; // codigo
    private String nombre;
    private Double precio;
    private String categoria;

    //mappedBY => el dueño de la relación es Venta, mappedBy al atributo de productos
    @ManyToMany(mappedBy = "productos", fetch = FetchType.LAZY) // relación de entidades many to many, armo lista de ventas || con fetch LAZY setteo que traiga los datos de la entidad bajo demanda
    private List<Venta> ventas;


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

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }
}
