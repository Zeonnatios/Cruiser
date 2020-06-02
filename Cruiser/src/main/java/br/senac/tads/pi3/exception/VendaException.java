package br.senac.tads.pi3.exception;

import java.sql.SQLException;

/**
 *
 * @author CRUISER
 */
public class VendaException extends SQLException {

    public VendaException(String msg, Throwable e) {
        super(msg, e);
    }

}
