package net.daif.cliente.controllers;

import net.daif.cliente.models.VentaModel;
import net.daif.cliente.services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/venta")
public class VentaController {
    @Autowired
    VentaService ventaService;

    @GetMapping()
    public ArrayList<VentaModel> obtenerVenta(){
        return ventaService.obtenerVenta();
    }

    @PostMapping("/save")
    public ResponseEntity<VentaModel> guardarVenta(@RequestBody VentaModel venta){
        return new ResponseEntity<VentaModel>(ventaService.guardarVenta(venta), HttpStatus.OK);
    }
}
