package net.daif.cliente.repositories;

import net.daif.cliente.models.VentaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository<VentaModel, Long> {
}
