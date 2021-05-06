/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;

/**
 *
 * @author daw1
 */
public interface CuentaDao {
    int guardar(List<Cuenta> listado) throws DaoException;
    List<Cuenta> listar() throws DaoException;
}
