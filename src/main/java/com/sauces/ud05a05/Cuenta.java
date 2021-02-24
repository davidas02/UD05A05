/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.ud05a05;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author david Aparicio Sir "APA"
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
        movimientos=new ArrayList<>();
        movimientos.add(new Movimiento(LocalDate.now(),'I',saldo,this.saldo));
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
    List<Movimiento> listado=new ArrayList<>();
        for(Movimiento m: movimientos){
            if(m.getFecha().isAfter(desde)&&m.getFecha().isBefore(hasta)){
                listado.add(m);
            }
        }
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
            movimientos.add(new Movimiento(LocalDate.now(),'I', cantidad, saldo));
        }
        
   }
    public void reintegrar(float cantidad){
        if(cantidad<=saldo&&cantidad>0){
            saldo-=cantidad;
            movimientos.add(new Movimiento(LocalDate.now(),'R', -cantidad, saldo));
	}   
    }
    public void realizarTransferencia(Cuenta destino,float cantidad){
        if(cantidad<=saldo&&cantidad>0){
            this.saldo-=cantidad;
            destino.saldo+=cantidad;
            this.movimientos.add(new Movimiento(LocalDate.now(),'T', -cantidad, saldo));
            destino.movimientos.add(new Movimiento(LocalDate.now(),'T', cantidad, saldo));
        }
    }
    public String listarMovimientos(){
        StringBuilder salida=new StringBuilder();
        for(Movimiento m: movimientos){
        salida.append(m.toString());
        salida.append("\n");
        }
        return salida.toString();
    }
    @Override
    public String toString() {
        return "codigo, " + codigo + " titular, " + titular + " saldo, " + saldo ;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cuenta other = (Cuenta) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    void realizarTransferencia(String codigo, float cantidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}