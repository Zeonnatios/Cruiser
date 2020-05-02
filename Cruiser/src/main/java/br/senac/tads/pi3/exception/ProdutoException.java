package br.senac.tads.pi3.exception;

import java.sql.SQLException;

/**
 *
 * @author Cruiser
 */
public class ProdutoException extends SQLException {

    public ProdutoException(String msg, Throwable e) {
        super(msg, e);
    }

}
