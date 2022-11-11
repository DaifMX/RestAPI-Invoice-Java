package net.daif.cliente.services;

import net.daif.cliente.models.VentaModel;
import net.daif.cliente.repositories.VentaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class VentaService {
    @Autowired
    VentaRepository ventaRepository;

    public ArrayList<VentaModel> obtenerVenta(){
        return (ArrayList<VentaModel>) ventaRepository.findAll();
    }

    public VentaModel guardarVenta(VentaModel venta){
        return ventaRepository.save(venta);
    }
}
