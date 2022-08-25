package com.asj.examen.examenbackend.dto;


import com.asj.examen.examenbackend.models.Producto;
import com.asj.examen.examenbackend.models.Vendedor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;



@AllArgsConstructor //Constructor con todos los argunmentos
// @Data //Getters y Setters
@NoArgsConstructor //Constructor vacío
@JsonIgnoreProperties(ignoreUnknown = true)
public class VentaDTO {

    private Long id; // codigo

    private Producto producto;

    private Double total;

    private Vendedor vendedor;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
}
