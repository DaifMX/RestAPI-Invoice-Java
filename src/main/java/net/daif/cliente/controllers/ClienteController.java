package net.daif.cliente.controllers;

import net.daif.cliente.models.ClienteModel;
import net.daif.cliente.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @PostMapping("/save")
    public ResponseEntity<ClienteModel> save(@RequestBody ClienteModel cliente){
        return new ResponseEntity<ClienteModel>(clienteService.save(cliente), HttpStatus.OK);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<ClienteModel>> getAll(){
        return new ResponseEntity<>(this.clienteService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<ClienteModel>> getById(@PathVariable("id") Long id){
        return new ResponseEntity<>(this.clienteService.getById(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ClienteModel> update(@RequestBody ClienteModel cliente){
        return new ResponseEntity<ClienteModel>(clienteService.update(cliente), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        clienteService.delete(id);
        return new ResponseEntity<>("Succesfully deleated", HttpStatus.OK);
    }
}
