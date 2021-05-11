/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Banco;
import modelo.CantidadException;
import modelo.Cuenta;
import vista.Ventana;

/**
 *
 * @author daw1
 */
public class Controlador {
    private Banco modelo;
    private Ventana vista;

    public Controlador(Banco modelo, Ventana vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
    public void abrirCuenta(){
        String codigo,titular;
                float saldo;
                codigo=vista.getCodigo();
                titular=vista.getTitular();
                saldo=vista.getSaldo();
                if(modelo.abrirCuenta(codigo, titular, saldo)){
                vista.mostrarMensaje("Cuenta Abierta");
                vista.mostrarCuentas(modelo.getCuentas());
                }else{vista.mostrarMensaje("No se ha podido abrir la cuenta");}
    }
    public void operarConCuenta() throws CantidadException{
        int operacion;
        String codigo;
        float cantidad;
        Cuenta c;
        codigo=vista.getCodigo();
        c=modelo.getCuenta(codigo);
        if (c!=null){
            operacion=vista.getOperacion();
            cantidad=vista.getCantidad();
            if(operacion!=-1){
                cantidad=vista.getCantidad();
                switch(operacion){
                    case Ventana.INGRESAR:
                        c.ingresar(cantidad);
                        break;
                    case Ventana.REINTEGRAR:
                        c.reintegrar(cantidad);
                        break;
                }
            }
            vista.mostrarCuentas(modelo.getCuentas());
            vista.mostrarMensaje("Operacion realizada");
        }
    }  
    public void cancelarCuenta(){
        String codigo=vista.getCodigo();
        if(modelo.cancelarCuenta(codigo)){
            vista.mostrarMensaje("Cuenta Cancelada");
        }else{
        vista.mostrarMensaje("No se ha podido cancelar la cuenta");
        }
    }
    public void listarCuentas(){
    
    }
    public void guardarCuentas(){
    
    }
    public void cargarCuentas(){
    
    }
    public void iniciar(){
        vista.setVisible(true);
    
    }
}
