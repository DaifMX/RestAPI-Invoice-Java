package net.daif.cliente.services;

import net.daif.cliente.repositories.ProductoRepository;
import net.daif.cliente.models.ProductoModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public ProductoModel save(ProductoModel producto){
        producto.setFecha_alta(LocalDateTime.now());
        return this.productoRepository.save(producto);
    }

    public ArrayList<ProductoModel> getAll(){
        return (ArrayList<ProductoModel>) productoRepository.findAll();
    }

    public Optional<ProductoModel> getById(Long id) {
        return this.productoRepository.findById(id);
    }

    public ProductoModel update(ProductoModel productoModel){
        Optional<ProductoModel> productInDB = this.productoRepository.findById(productoModel.getId());

        if(productInDB.isPresent()){
            ProductoModel c = productInDB.get();
            c.setSku(productoModel.getSku());
            c.setDescripcion(productoModel.getDescripcion());
            c.setPrecioCompra(productoModel.getPrecioCompra());
            c.setPrecioVenta(productoModel.getPrecioVenta());
            c.setStock(productoModel.getStock());
            c.setFecha_alta(productoModel.getFecha_alta());
            return this.productoRepository.save(c);
        } else {
            return null;
        }
    }

    public ProductoModel stockUpdate(ProductoModel productoModel){
        Optional<ProductoModel> productoInDb = this.productoRepository.findById(productoModel.getId());

        if(productoInDb.isPresent()){
            ProductoModel c = productoInDb.get();
            c.setStock(productoModel.getStock());
            return this.productoRepository.save(c);
        } else {
            return null;
        }
    }

    public void delete(Long id){
        this.productoRepository.deleteById(id);
    }
}
