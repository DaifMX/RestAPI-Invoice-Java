package net.daif.cliente.services;

import net.daif.cliente.repositories.ClienteRepository;
import net.daif.cliente.models.ClienteModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteModel save(ClienteModel cliente){
        return this.clienteRepository.save(cliente);
    }

    public List<ClienteModel> getAll(){
        return this.clienteRepository.findAll();
    }

    public Optional<ClienteModel> getById(Long id) {
        return this.clienteRepository.findById(id);
    }

    public ClienteModel update(ClienteModel clienteModel){
        Optional<ClienteModel> clienteInDB = this.clienteRepository.findById(clienteModel.getId());

        if(clienteInDB.isPresent()){
            ClienteModel c = clienteInDB.get();
            c.setDni(clienteModel.getDni());
            c.setNombre(clienteModel.getNombre());
            c.setApellido(clienteModel.getApellido());
            c.setFecha_nacimiento(clienteModel.getFecha_nacimiento());
            return this.clienteRepository.save(c);
        } else {
            return null;
        }
    }

    public void delete(Long id){
        this.clienteRepository.deleteById(id);
    }
}