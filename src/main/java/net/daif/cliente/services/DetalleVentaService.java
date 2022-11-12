package net.daif.cliente.services;

import net.daif.cliente.models.DetalleVentaModel;
import net.daif.cliente.repositories.DetalleVentaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DetalleVentaService {
    @Autowired
    DetalleVentaRepository detalleVentasRepository;

    public DetalleVentaModel save(DetalleVentaModel detalleVenta){

        //Modificación de Stock


        return detalleVentasRepository.save(detalleVenta);
    }

    public ArrayList<DetalleVentaModel> getAll(){
        return (ArrayList<DetalleVentaModel>) detalleVentasRepository.findAll();
    }
}
