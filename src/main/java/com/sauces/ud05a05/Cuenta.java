/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.ud05a05;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author daw1
 */
public class Cuenta {
   private String codigo;
   private String titular;
   private float saldo;
   private List<Movimiento> movimientos;

    public Cuenta(String codigo, String titular, float saldo) {
        this.codigo = codigo;
        this.titular = titular;
        this.saldo = saldo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitular() {
        return titular;
    }

    public float getSaldo() {
        return saldo;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public List<Movimiento>getMovimientos(LocalDate desde,LocalDate hasta){
    return movimientos;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
   public void ingresar (float cantidad){
        if(cantidad>0){
            saldo+=cantidad;
        }
   }
    public void reintegrar(float cantidad){
        if(cantidad<=saldo&&cantidad>0){
            saldo-=cantidad;
	}   
    }
    public void realizarTransferencia(Cuenta destino,float cantidad){
    
    }
    public String listarMovimientos(){
    return List<movimiento>;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "codigo=" + codigo + ", titular=" + titular + ", saldo=" + saldo + ", movimientos=" + movimientos + '}';
    }
    public boolean equals(Object o){
    return o;
    }
    
}
