package com.asj.examen.examenbackend.dto;

import com.asj.examen.examenbackend.models.Venta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@AllArgsConstructor //Constructor con todos los argunmentos
@Data //Getters y Setters
@NoArgsConstructor //Constructor vacío
public class ProductoDTO {


    private Long id; // codigo
    private String nombre;
    private Double precio;
    private String categoria;
    private List<Venta> ventas;

}
