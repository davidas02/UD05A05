/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.ud05a05;

import java.time.LocalDate;

/**
 *
 * @author David Aparicio Sir
 */
public class Movimiento {
    private LocalDate fecha;
    private char tipo;
    private float cantidad;
    private float saldo;

    public Movimiento(LocalDate fecha, char tipo, float cantidad, float saldo) {
        this.fecha = fecha;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.saldo = saldo;
    }
    /*Obtiene la fecha del movimiento*/
    public LocalDate getFecha() {
        return fecha;
    }
    /*obtiene el tipo del movimiento*/
    public char getTipo() {
        return tipo;
    }
    /*Obtiene la cantidad del movimiento*/
   public float getCantidad() {
        return cantidad;
    }
   /*Devuelve el saldo de la cuenta */
    public float getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "fecha," + fecha + " tipo," + tipo + " cantidad," + cantidad + " saldo," + saldo + '}';
    }
    
}
