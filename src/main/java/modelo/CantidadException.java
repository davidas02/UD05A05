/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author daw1
 */
public class CantidadException extends Exception {

    /**
     * Creates a new instance of <code>CantidadException</code> without detail
     * message.
     */
    public CantidadException() {
    }

    /**
     * Constructs an instance of <code>CantidadException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CantidadException(String msg) {
        super(msg);
    }
}
