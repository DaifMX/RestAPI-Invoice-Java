package net.daif.cliente.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "detalle_venta")
@AllArgsConstructor
@NoArgsConstructor

public class DetalleVentaModel {

    public DetalleVentaModel(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "venta_id", referencedColumnName = "id")
    private VentaModel venta_id;

    @ManyToOne()
    @JoinColumn(name = "producto_id", referencedColumnName = "id")
    private ProductoModel producto_id;

    @Column(name = "precioDelProducto")
    private double precioDelProducto;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "subtotal")
    private double subtotal;

}
