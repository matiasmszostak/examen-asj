package com.asj.examen.examenbackend.dto;


import com.asj.examen.examenbackend.models.Producto;
import com.asj.examen.examenbackend.models.Vendedor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor //Constructor con todos los argunmentos
@Data //Getters y Setters
@NoArgsConstructor //Constructor vacío
@JsonIgnoreProperties(ignoreUnknown = true)
public class VentaDTO {

    private Long id; // codigo

    private Producto producto;

    private Double total;

    private Vendedor vendedor;

}
