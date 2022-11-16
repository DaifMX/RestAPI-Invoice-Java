package net.daif.cliente.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "venta")
@AllArgsConstructor
@NoArgsConstructor

public class VentaModel {

    public VentaModel(Long id) {
        this.id = id;
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "fecha_alta")
    private LocalDateTime fecha_alta;

    @Column(name = "total")
    private double total;

    @ManyToOne()
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private ClienteModel cliente_id;

    @OneToMany(mappedBy = "venta_id", cascade = CascadeType.ALL)
    private List<DetalleVentaModel> detalle_venta;
}
