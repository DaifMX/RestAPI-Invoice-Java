package net.daif.cliente.exceptions;

import lombok.Data;

@Data
public class Error {

    public Error(String msg, String status){
        this.msg = msg;
        this.status = status;
    }

    private String msg;
    private String status;

    public Error() {

    }
}
