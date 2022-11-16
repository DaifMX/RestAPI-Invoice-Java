package net.daif.cliente.services;

import net.daif.cliente.exceptions.ResourceAbsentException;
import net.daif.cliente.models.ClienteModel;
import net.daif.cliente.models.DetalleVentaModel;
import net.daif.cliente.models.ProductoModel;
import net.daif.cliente.models.VentaModel;
import net.daif.cliente.repositories.ClienteRepository;
import net.daif.cliente.repositories.DetalleVentaRepository;
import net.daif.cliente.repositories.ProductoRepository;
import net.daif.cliente.repositories.VentaRepository;
import net.daif.cliente.validators.VentaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class VentaService {

    @Autowired private VentaRepository ventaRepository;
    @Autowired private DetalleVentaRepository detalleVentaRepository;
    @Autowired private ProductoRepository productoRepository;
    @Autowired private VentaValidator validator;
    @Autowired private ClienteRepository clienteRepository;

    public VentaModel save(VentaModel venta) throws ResourceAbsentException {
        this.validator.validate(venta);

        Optional<ClienteModel> clienteInDB = this.clienteRepository.findById(venta.getCliente_id().getId());
        if (clienteInDB.isEmpty()){ //Revisa si el cliente ingresado para solicitar la venta existe
            throw new ResourceAbsentException("El cliente solicitado para concretar la venta no existe");

        } else {
            venta.setFecha_alta(LocalDateTime.now());
            VentaModel savedVenta = ventaRepository.save(venta); //Se guarda la venta una vez para despues poder acceder a su id.
            double precioFinal = 0;

            //Guardado de detalle venta desde el guardado de la venta.
            for (int i = 0; i < savedVenta.getDetalle_venta().toArray().length; i++) {
                DetalleVentaModel item = savedVenta.getDetalle_venta().get(i);
                item.setVenta_id(new VentaModel(savedVenta.getId()));

                //Excepciones de los "DetalleVenta"
                Optional<ProductoModel> productInDB = this.productoRepository.findById(item.getProducto_id().getId());

                if (item.getCantidad() <= 0) {
                    ventaRepository.delete(venta);
                    throw new IllegalArgumentException("La cantidad de producto no puede ser menor o igual a cero");
                }

                if (productInDB.isEmpty()){
                    throw new ResourceAbsentException("El producto ingresado no existe");

                } else {
                    this.detalleVentaRepository.save(item);

                    //Actualización de stock y obtención de los precios
                    ProductoModel c = productInDB.get();
                    c.setStock(c.getStock() - item.getCantidad()); //Modificación del stock del producto.
                    item.setSubtotal(c.getPrecioVenta() * item.getCantidad()); //Creación del subtotal en base al precio de venta del producto multiplicado por la cantidad de productos de este tipo que se compro.
                    item.setPrecioDelProducto(item.getSubtotal() / item.getCantidad()); //PrecioDelProducto sirve para al cambiar el precio de producto, el precio antiguo persista.
                    precioFinal += item.getSubtotal(); //Suma de todos los subtotales de los detalles venta y lo pasa al total.
                    venta.setTotal(precioFinal);

                    this.productoRepository.save(c);
                }
            }
        }
        return this.ventaRepository.save(venta);
    }

    public List<VentaModel> getAll() {
        return this.ventaRepository.findAll();
    }

    public Optional<VentaModel> getById(Long id) {
        return this.ventaRepository.findById(id);
    }
}
