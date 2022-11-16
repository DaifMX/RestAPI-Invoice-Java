package net.daif.cliente.validators;

import net.daif.cliente.models.ClienteModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class ClienteValidator {

    public void validate(ClienteModel cliente){
        //Revisión general
        if (cliente == null){
            throw new IllegalArgumentException("El cliente es nulo o fue ingresado de manera erronea");
        }

        //Revisión por campos
        if (StringUtils.isBlank(cliente.getDni())) {
            throw new IllegalArgumentException("El DNI es nulo o fue ingresado de manera erronea");
        }

        if (StringUtils.isBlank(cliente.getNombre())){
            throw new IllegalArgumentException("El nombre es nulo o fue ingresado de manera erronea");
        }

        if (StringUtils.isBlank(cliente.getApellido())){
            throw new IllegalArgumentException("El apellido es nulo o fue ingresado de manera erronea");
        }

        /*if (cliente.getFecha_nacimiento() == null){
            throw new IllegalArgumentException("Fecha de nacimiento no ingresada o ingresada de manera erronea");
        }
         */
    }
}
