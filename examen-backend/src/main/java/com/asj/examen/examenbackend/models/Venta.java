package com.asj.examen.examenbackend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity // Entidad
@Table(name= "ventas") // le cambio el nombre para que matchee con mi DB
@SequenceGenerator(name = "gn_venta", sequenceName = "gn_venta", allocationSize = 1) // secuencia para autogenerar el id
// @Data // getters & setters | mala práctica
@NoArgsConstructor  // constructor sin args
@AllArgsConstructor // constructor con args
@JsonIgnoreProperties(ignoreUnknown = true)
public class Venta {

    @Id
    @GeneratedValue(generator = "gn_venta", strategy = GenerationType.SEQUENCE) // autoincremental
    private Long id; // codigo

/*
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL) // setteo la forma en la que trae los datos de la entidad || Cascade ALL trae todos los datos relacionados a la entidad y actualiza
    @JoinTable(name = "venta_producto", joinColumns = @JoinColumn(name = "venta_id"), inverseJoinColumns = @JoinColumn(name = "producto_id")) // tabla de relación
    private List<Producto> productos;
*/ // le saco el many to many porque me estaba generando errores en el DER

    //Se pueden hacer muchas ventas del mismo producto
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto") //FK // tabla de relación
    private Producto producto;

    private Double total;

    // Muchas ventas puede hacer un vendedor
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_vendedor") //FK
//   @JoinColumn(name = "ventas_vendedor") // Armo una columna
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

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}

// Relaciones:
// Un vendedor tiene muchas ventas
// Una venta tiene muchos productos, un producto tiene muchas ventas


