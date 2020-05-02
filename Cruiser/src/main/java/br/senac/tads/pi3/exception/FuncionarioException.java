package br.senac.tads.pi3.exception;

import java.sql.SQLException;

/**
 *
 * @author Cruiser
 */
public class FuncionarioException extends SQLException {

    public FuncionarioException(String msg, Throwable e) {
        super(msg, e);
    }
}
