package net.daif.cliente.controllers;

import net.daif.cliente.exceptions.ResourceAbsentException;
import net.daif.cliente.models.VentaModel;
import net.daif.cliente.services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/venta")
public class VentaController {

    @Autowired private VentaService ventaService;

    @PostMapping("/save")
    public ResponseEntity<VentaModel> save(@RequestBody VentaModel venta) throws ResourceAbsentException {
        return new ResponseEntity<>(ventaService.save(venta), HttpStatus.OK);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<VentaModel>> getAll(){
        return new ResponseEntity<>(this.ventaService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<VentaModel>> getById(@PathVariable("id") Long id){
        return new ResponseEntity<>(this.ventaService.getById(id), HttpStatus.FOUND);
    }
}
