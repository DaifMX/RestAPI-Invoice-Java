package net.daif.cliente.services;

import net.daif.cliente.exceptions.ResourceAbsentException;
import net.daif.cliente.exceptions.ResourceDuplicityException;
import net.daif.cliente.repositories.ClienteRepository;
import net.daif.cliente.models.ClienteModel;
import net.daif.cliente.validators.ClienteValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteValidator validator;

    public ClienteModel save(ClienteModel clienteModel) throws ResourceDuplicityException {
        this.validator.validate(clienteModel); //Verifiaciones por campo

        //Verificar duplicidad
        Optional<ClienteModel> clienteInDB = this.clienteRepository.findByDni(clienteModel.getDni());
        if(clienteInDB.isPresent()){
            throw new ResourceDuplicityException("El cliente que se ha intenado ingresar ya existe en la base de datos");
        } else {
            return this.clienteRepository.save(clienteModel);
        }
    }

    public List<ClienteModel> getAll() {
        return this.clienteRepository.findAll();
    }

    public Optional<ClienteModel> getById(Long id) {
        return this.clienteRepository.findById(id);
    }

    public ClienteModel update(ClienteModel clienteModel) throws ResourceAbsentException { //Los updates se hacen insertando la id del cliente dentro del JSON
        Optional<ClienteModel> clienteInDB = this.clienteRepository.findById(clienteModel.getId());

        this.validator.validate(clienteModel);

        if(clienteInDB.isPresent()){
            ClienteModel c = clienteInDB.get();
            c.setDni(clienteModel.getDni());
            c.setNombre(clienteModel.getNombre());
            c.setApellido(clienteModel.getApellido());
            c.setFecha_nacimiento(clienteModel.getFecha_nacimiento());
            return this.clienteRepository.save(c);
        } else {
            throw new ResourceAbsentException("El cliente que se ha intentado modificar no existe");
        }
    }

    public void delete(Long id){
        this.clienteRepository.deleteById(id);
    }
}