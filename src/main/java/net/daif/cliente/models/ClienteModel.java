package net.daif.cliente.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "cliente")
@AllArgsConstructor
@NoArgsConstructor

public class ClienteModel {

    public ClienteModel(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "dni")
    private String dni;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "fecha_nacimiento")
    private LocalDate fecha_nacimiento;

    /*
    @OneToMany(mappedBy = "cliente_id", cascade = CascadeType.ALL)
    private List<VentaModel> venta;
     */
}

