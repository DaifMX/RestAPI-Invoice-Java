package net.daif.cliente.models;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name="producto")

public class ProductoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name = "sku")
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

    @OneToMany(mappedBy = "productoModel", cascade = CascadeType.ALL)
    private List<DetalleVentaModel> detalleVenta;
}
