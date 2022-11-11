package net.daif.cliente.controllers;

import net.daif.cliente.models.DetalleVentaModel;
import net.daif.cliente.services.DetalleVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/detalle_venta")
public class DetalleVentaController {
    @Autowired
     DetalleVentaService detalleVentaService;

    @GetMapping()
    public ArrayList<DetalleVentaModel> obtenerDetalleVenta(){
        return detalleVentaService.obtenerDetalleVenta();
    }

    @PostMapping("/save")
    public ResponseEntity<DetalleVentaModel> guardarDetalleVenta(@RequestBody DetalleVentaModel detalleVenta){
        return new ResponseEntity<DetalleVentaModel>(detalleVentaService.guardarDetalleVenta(detalleVenta), HttpStatus.OK);
    }
}
