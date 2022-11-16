package net.daif.cliente.services;

import net.daif.cliente.exceptions.ResourceAbsentException;
import net.daif.cliente.exceptions.ResourceDuplicityException;
import net.daif.cliente.repositories.ProductoRepository;
import net.daif.cliente.models.ProductoModel;

import net.daif.cliente.validators.ProductoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired private ProductoRepository productoRepository;

    @Autowired private ProductoValidator validator;

    public ProductoModel save(ProductoModel producto) throws ResourceDuplicityException {
        this.validator.validate(producto);

        Optional<ProductoModel> productInDB = this.productoRepository.findBySku(producto.getSku());

        if(productInDB.isPresent()){
            throw new ResourceDuplicityException("Ya existe un producto con este SKU");
        } else {
            producto.setFecha_alta(LocalDateTime.now());
            return this.productoRepository.save(producto);
        }
    }

    public ArrayList<ProductoModel> getAll(){
        return (ArrayList<ProductoModel>) this.productoRepository.findAll();
    }

    public Optional<ProductoModel> getById(Long id) {
        return this.productoRepository.findById(id);
    }

    public ProductoModel update(ProductoModel productoModel) throws ResourceAbsentException { //Los updates se hacen insertando la id del producto dentro del JSON
        Optional<ProductoModel> productInDB = this.productoRepository.findById(productoModel.getId());

        this.validator.validate(productoModel);

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
            throw new ResourceAbsentException("El producto que se ha intentado modificar no existe en la base de datos");
        }
    }

    public void delete(Long id){
        this.productoRepository.deleteById(id);
    }
}
