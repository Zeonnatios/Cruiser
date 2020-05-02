package br.senac.tads.pi3.exception;

import java.sql.SQLException;

/**
 *
 * @author Cruiser
 */
public class ClienteException extends SQLException {

    public ClienteException(String msg, Throwable e) {
        super(msg, e);
    }
}
