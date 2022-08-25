package com.asj.examen.examenbackend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity // Entidad
@Table(name= "ventas") // le cambio el nombre para que matchee con mi DB
@SequenceGenerator(name = "gn_venta", sequenceName = "gn_venta", allocationSize = 1) // secuencia para autogenerar el id
@NoArgsConstructor  // constructor sin args
@AllArgsConstructor // constructor con args
@JsonIgnoreProperties(ignoreUnknown = true)
public class Venta {

    @Id
    @GeneratedValue(generator = "gn_venta", strategy = GenerationType.SEQUENCE) // autoincremental
    @Column(name = "codigo", unique = true)
    private Long id;


    @ManyToOne
    @JoinColumn(name="id_vendedor")
    private Vendedor vendedor;

    @ManyToOne
    @JoinColumn(name="id_producto")
    private Producto producto;

    private Double total;

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
