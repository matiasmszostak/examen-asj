package com.asj.examen.examenbackend.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity // Entidad
@Table(name= "ventas") // le cambio el nombre para que matchee con mi DB
@SequenceGenerator(name = "gn_venta", sequenceName = "gn_venta", allocationSize = 1) // secuencia para autogenerar el id
@Data // getters & setters
@NoArgsConstructor  // constructor sin args
@AllArgsConstructor // constructor con args
public class Venta {

    @Id
    @GeneratedValue(generator = "gn_venta", strategy = GenerationType.SEQUENCE) // autoincremental
    private Long id; // codigo
    private Double comision;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL) // setteo la forma en la que trae los datos de la entidad || Cascade ALL trae todos los datos relacionados a la entidad y actualiza
    @JoinTable(name = "venta_producto", joinColumns = @JoinColumn(name = "venta_id"), inverseJoinColumns = @JoinColumn(name = "producto_id")) // tabla de relación
    private List<Producto> productos;

    @ManyToOne(fetch = FetchType.LAZY)
//   @JoinColumn(name = "ventas_vendedor") // Armo una columna
    private Vendedor vendedor;





}

// Relaciones:
// Un vendedor tiene muchas ventas
// Una venta tiene muchos productos, un producto tiene muchas ventas