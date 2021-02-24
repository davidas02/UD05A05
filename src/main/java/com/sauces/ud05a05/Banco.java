/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.ud05a05;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David Aparicio Sir
 */
public class Banco {
    private String nombre;
    private List <Cuenta> cuentas;
public Banco(String nombre){
    this.nombre=nombre;
    cuentas=new ArrayList<>();
}

    public String getNombre() {
        return nombre;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public boolean abrirCuenta(String codigo,String titular,float saldo){
    boolean correcto=false;
        if (this.buscarCuenta(codigo)==-1) {
          cuentas.add(new Cuenta(codigo,titular,saldo)); 
          correcto=true;
        }
   
    return correcto;
    } 
    public boolean cancelarCuenta(String codigo){
        boolean correcto=false;
         int posicion = this.buscarCuenta(codigo);
            if(posicion !=-1){
                cuentas.remove(posicion);
                correcto=true;
            }
        
        return correcto;
    }
    public float getTotalDepositos(){
        float total=0;
         for(Cuenta c:cuentas){
             total+=c.getSaldo();
         }
        return total;
    }
    public Cuenta getCuenta(String codigo){
    Cuenta c=null;
    int posicion;
    posicion=this.buscarCuenta(codigo);
    if(posicion!=-1){
         c=cuentas.get(posicion);
         }
    return c;
    }
    @Override
    public String toString() {
        return nombre;
    }

   private int buscarCuenta(String codigo){
   int posicion=-1;
   for(int i=0;i<cuentas.size()&&posicion==-1;i++){
       if(codigo.equals(cuentas.get(i).getCodigo())){
         posicion=i;
       }
   }
   return posicion;
   } 
}

