package net.daif.cliente.services;

import net.daif.cliente.models.DetalleVentaModel;
import net.daif.cliente.models.VentaModel;
import net.daif.cliente.repositories.DetalleVentaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class DetalleVentaService {
    @Autowired
    DetalleVentaRepository detalleVentaRepository;

    public ArrayList<DetalleVentaModel> getAll(){
        return (ArrayList<DetalleVentaModel>) detalleVentaRepository.findAll();
    }

    public Optional<DetalleVentaModel> getById(Long id) {
        return this.detalleVentaRepository.findById(id);
    }
}
