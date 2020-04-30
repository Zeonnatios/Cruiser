/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.exception;

import java.sql.SQLException;

/**
 *
 * @author mathe
 */
public class ClienteException extends SQLException {

    public ClienteException(String msg, Throwable e) {
        super(msg, e);
    }
}
