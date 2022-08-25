package com.asj.examen.examenbackend.dto;


import com.asj.examen.examenbackend.models.Venta;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@AllArgsConstructor //Constructor con todos los argunmentos
// @Data //Getters y Setters
@NoArgsConstructor //Constructor vacío
@JsonIgnoreProperties(ignoreUnknown = true)
public class VendedorDTO {

    private Long id; // codigo
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
