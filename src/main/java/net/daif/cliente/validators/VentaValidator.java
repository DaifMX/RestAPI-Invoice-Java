package net.daif.cliente.validators;

import net.daif.cliente.models.VentaModel;
import org.springframework.stereotype.Component;


@Component
public class VentaValidator {

    public void validate(VentaModel venta){

        //Revisión general
        if (venta == null){
            throw new IllegalArgumentException("La venta fue ingresada de manera vacia o nula");
        }

        if (venta.getDetalle_venta() == null){
            throw new IllegalArgumentException("Detalle de venta no ingresadoo o ingresado de manera erronea");
        }


        //La fecha de alta es generada de manera automatica.

        //El total es calculado de manera automatica sumando los subtotales de los detalles de venta.

        //Al ser los detalles de venta generados dentro de la misma venta, estos serán verificados dentro de "services/VentaService.java".
    }
}
