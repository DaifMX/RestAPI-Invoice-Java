package net.daif.cliente.services;

import net.daif.cliente.models.VentaModel;
import net.daif.cliente.repositories.VentaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VentaService {
    @Autowired
    VentaRepository ventaRepository;

    public VentaModel guardarVenta(VentaModel venta){
        venta.setFecha_alta(LocalDateTime.now());
        return ventaRepository.save(venta);
    }

    public List<VentaModel> getAll(){
        return this.ventaRepository.findAll();
    }
}
