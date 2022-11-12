package net.daif.cliente.controllers;

import net.daif.cliente.models.DetalleVentaModel;
import net.daif.cliente.services.DetalleVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalle_venta")
public class DetalleVentaController {
    @Autowired
     DetalleVentaService detalleVentaService;

    @PostMapping("/save")
    public ResponseEntity<DetalleVentaModel> save(@RequestBody DetalleVentaModel detalleVenta){
        return new ResponseEntity<DetalleVentaModel>(detalleVentaService.save(detalleVenta), HttpStatus.OK);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<DetalleVentaModel>> obtenerDetalleVenta(){
        return new ResponseEntity<>(this.detalleVentaService.getAll(), HttpStatus.OK);
    }


}
