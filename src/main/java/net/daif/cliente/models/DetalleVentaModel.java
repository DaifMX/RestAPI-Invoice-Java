package net.daif.cliente.models;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "detalle_venta")
public class DetalleVentaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @ManyToOne @JoinColumn(name = "venta_id")
    private VentaModel ventaModel;

    @ManyToOne @JoinColumn(name = "producto_id")
    private ProductoModel productoModel;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "subtotal")
    private double subtotal;

}
