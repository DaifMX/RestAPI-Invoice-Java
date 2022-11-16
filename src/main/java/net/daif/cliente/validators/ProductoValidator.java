package net.daif.cliente.validators;

import net.daif.cliente.models.ProductoModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class ProductoValidator {

    public void validate(ProductoModel producto){

        //Revisión general
        if (producto == null){
            throw new IllegalArgumentException("El producto no fue ingresado o es nulo");
        }

        //Revisión por campos
        if (StringUtils.isBlank(producto.getSku())){
            throw new IllegalArgumentException("El SKU es nulo o fue ingresado de manera erronea");
        }

        if (StringUtils.isBlank(producto.getDescripcion())){
            throw new IllegalArgumentException("La descripción es nula o fue ingresada de manera erronea");
        }

        if (producto.getPrecioCompra() <= 0){
            throw new IllegalArgumentException("El precio de compra no puede ser menor o igual a cero");
        }

        if (producto.getPrecioVenta() <= 0){
            throw new IllegalArgumentException("El precio de venta no puede ser menor o igual a cero");
        }

        if (producto.getStock() <= 0){
            throw new IllegalArgumentException("El stock no puede ser menor o igual a cero");
        }
    }
}
