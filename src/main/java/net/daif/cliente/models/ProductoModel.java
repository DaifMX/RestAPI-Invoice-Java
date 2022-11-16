package net.daif.cliente.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="producto")
@AllArgsConstructor
@NoArgsConstructor

public class ProductoModel {

    public ProductoModel(Long id) {
        this.id = id;
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "sku", unique = true)
    private String sku;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precioCompra")
    private double precioCompra;

    @Column(name = "precioVenta")
    private double precioVenta;

    @Column(name = "stock")
    private int stock;

    @Column(name = "fecha_alta")
    private LocalDateTime fecha_alta;
}
