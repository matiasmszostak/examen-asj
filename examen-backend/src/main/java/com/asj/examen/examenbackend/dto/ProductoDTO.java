package com.asj.examen.examenbackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor //Constructor con todos los argunmentos
@Data //Getters y Setters
@NoArgsConstructor //Constructor vacío
@JsonIgnoreProperties
public class ProductoDTO {


    private Long id; // codigo
    private String nombre;
    private Double precio;
    private String categoria;


}
