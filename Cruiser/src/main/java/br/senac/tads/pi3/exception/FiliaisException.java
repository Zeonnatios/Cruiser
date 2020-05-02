package br.senac.tads.pi3.exception;

import java.sql.SQLException;

/**
 *
 * @author Cruiser
 */
public class FiliaisException extends SQLException {

    public FiliaisException(String msg, Throwable e) {
        super(msg, e);
    }
}
