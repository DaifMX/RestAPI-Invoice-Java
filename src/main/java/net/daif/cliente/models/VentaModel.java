package net.daif.cliente.models;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "venta")

public class VentaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name = "fecha_alta")
    private LocalDateTime fecha_alta;

    @Column(name = "total")
    private double total;

    @ManyToOne @JoinColumn(name = "cliente_id")
    private ClienteModel clienteModel;

    @OneToMany(mappedBy = "ventaModel", cascade = CascadeType.ALL)
    private List<DetalleVentaModel> detalleVenta;
}
