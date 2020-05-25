package br.senac.tads.pi3.exception;

import java.sql.SQLException;

/**
 *
 * @author mathe
 */
public class HomeException extends SQLException {

    public HomeException(String msg, Throwable e) {
        super(msg, e);
    }
}
