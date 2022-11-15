package net.daif.cliente.controllers;

import net.daif.cliente.models.DetalleVentaModel;
import net.daif.cliente.services.DetalleVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/detalle_venta")
public class DetalleVentaController {
    @Autowired
     DetalleVentaService detalleVentaService;

    @GetMapping("/get/all")
    public ResponseEntity<List<DetalleVentaModel>> obtenerDetalleVenta(){
        return new ResponseEntity<>(this.detalleVentaService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<DetalleVentaModel>> getById(@PathVariable("id") Long id){
        return new ResponseEntity<>(this.detalleVentaService.getById(id), HttpStatus.FOUND);
    }
}
