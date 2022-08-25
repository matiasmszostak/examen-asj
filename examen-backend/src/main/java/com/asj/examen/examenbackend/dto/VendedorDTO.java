package com.asj.examen.examenbackend.dto;


import com.asj.examen.examenbackend.models.Venta;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@AllArgsConstructor //Constructor con todos los argunmentos
@Data //Getters y Setters
@NoArgsConstructor //Constructor vacío
@JsonIgnoreProperties(ignoreUnknown = true)
public class VendedorDTO {

    private Long id; // codigo
    private String nombre;
    private Double sueldoBasico;
    private Double sueldoTotal;
    private Double comision;


    private List<Venta> listaVentas;



}
