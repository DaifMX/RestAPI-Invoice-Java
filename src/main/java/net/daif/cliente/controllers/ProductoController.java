package net.daif.cliente.controllers;

import net.daif.cliente.models.ProductoModel;
import net.daif.cliente.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    ProductoService productoService;

    @PostMapping("/save")
    public ResponseEntity<ProductoModel> save(@RequestBody ProductoModel producto){
        return new ResponseEntity<ProductoModel>(productoService.save(producto), HttpStatus.OK);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<ProductoModel>> getAll(){
        return new ResponseEntity<>(this.productoService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<ProductoModel>> getById(@PathVariable("id") Long id){
        return new ResponseEntity<>(this.productoService.getById(id), HttpStatus.OK);
    }

    @PutMapping("/update/")
    public ResponseEntity<ProductoModel> update(@RequestBody ProductoModel producto){
        return new ResponseEntity<ProductoModel>(productoService.update(producto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        productoService.delete(id);
        return new ResponseEntity<>("Succesfully deleated", HttpStatus.OK);
    }
}
