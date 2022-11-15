package net.daif.cliente.services;

import net.daif.cliente.models.DetalleVentaModel;
import net.daif.cliente.models.ProductoModel;
import net.daif.cliente.models.VentaModel;
import net.daif.cliente.repositories.DetalleVentaRepository;
import net.daif.cliente.repositories.ProductoRepository;
import net.daif.cliente.repositories.VentaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class VentaService {
    @Autowired VentaRepository ventaRepository;

    @Autowired DetalleVentaRepository detalleVentaRepository;


    @Autowired ProductoRepository productoRepository;

    public VentaModel save(VentaModel venta){
        venta.setFecha_alta(LocalDateTime.now());
        VentaModel savedVenta = ventaRepository.save(venta); //Se guarda la venta una vez para despues poder acceder a su id.
        double precioFinal = 0;

        //Guardado de detalle venta desde el guardado de la venta.
        for (int i = 0; i < savedVenta.getDetalle_venta().toArray().length; i++) {
            DetalleVentaModel item = savedVenta.getDetalle_venta().get(i);
            item.setVenta_id(new VentaModel(savedVenta.getId()));
            detalleVentaRepository.save(item);

            //Modificación del stock del producto.
            Optional<ProductoModel> productInDB = this.productoRepository.findById(item.getProducto_id().getId());
            if (productInDB.isPresent()) {
                ProductoModel c = productInDB.get();
                c.setStock(c.getStock() - item.getCantidad());
                item.setSubtotal(c.getPrecioVenta() * item.getCantidad());
                item.setPrecioDelProducto(item.getSubtotal() / item.getCantidad());
                precioFinal += item.getSubtotal();
                venta.setTotal(precioFinal);

                this.productoRepository.save(c);
            }
        }
        return ventaRepository.save(venta);
    }

    public List<VentaModel> getAll(){
        return this.ventaRepository.findAll();
    }

    public Optional<VentaModel> getById(Long id) {
        return this.ventaRepository.findById(id);
    }
}
