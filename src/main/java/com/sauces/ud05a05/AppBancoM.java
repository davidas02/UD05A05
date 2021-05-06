/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.ud05a05;

import controlador.Controlador;
import modelo.Banco;
import vista.Ventana;

/**
 *
 * @author daw1
 */
public class AppBancoM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Banco banco=new Banco("Banco Sauces");
        Ventana vista=new Ventana();
        Controlador controlador=new Controlador(banco,vista);
        vista.setControlador(controlador);
        controlador.iniciar();
    }
    
}
