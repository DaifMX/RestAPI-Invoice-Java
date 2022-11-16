package net.daif.cliente.repositories;

import net.daif.cliente.models.ProductoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoModel, Long> {
    Optional<ProductoModel> findBySku(String sku);
}
