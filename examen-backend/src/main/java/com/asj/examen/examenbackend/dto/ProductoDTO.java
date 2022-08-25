package com.asj.examen.examenbackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor //Constructor con todos los argunmentos
@Data //Getters y Setters
@NoArgsConstructor //Constructor vacío
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductoDTO {


    private Long id; // codigo
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
