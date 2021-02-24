/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sauces.ud05a05;

import java.util.Scanner;

/**
 *
 * @author daw1
 */
public class AppBanco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado=new Scanner(System.in);
        int accion;
        Banco banco;
        banco = new Banco("Banco Sauces");
        String codigo=null;
        String titular=null;
        float saldo=0; 
        int opcion;
        float cantidad;
        Cuenta cuenta;
        do{
            System.out.println("1- Abrir cuenta.");
            System.out.println("2- Operar con cuenta.");
            System.out.println("3- Cancelar cuenta.");
            System.out.println("4- Listar cuentas.");
            System.out.println("5- Consultar total depositos.");
            System.out.println("0- Cerrar Aplicacion");
            System.out.println("Escoja accion. ");
            accion = teclado.nextInt();
        }while(accion!=0);
        switch(accion){
            case 1: if(!banco.abrirCuenta(codigo , titular , saldo)){
                System.out.println("Cuenta abierta.");
            }else{
                System.out.println("No se ha podido abrir la cuenta.");
            }
                break;
            case 2:System.out.println("Operar con cuenta");
                    System.out.println("Introduzca codigo");
                    codigo=teclado.nextLine();
                   cuenta=banco.getCuenta(codigo);
                    if(cuenta!=null){
                        System.out.println("1- Ingresar dinero.");
                        System.out.println("2- Reintegrar dinero.");
                        System.out.println("5- Consultar Saldo.");
                        System.out.println("4- Realizar Transferencia.");
                        System.out.println("5- Consultar total depositos.");
                        System.out.println("0- Cerrar Aplicacion");
                        System.out.print("Escoja accion. ");
                        opcion = teclado.nextInt();
                        teclado.nextLine();
                        switch (opcion){
                            case 1:
                                System.out.print("Introduzca cantidad a ingresar.");
				cantidad=teclado.nextFloat();
				teclado.nextLine();
				cuenta.ingresar(cantidad);
				System.out.println("Cantidad ingresada "+cantidad+".");
                            break;
                            case 2:
                                System.out.println("Introduzca cantidad a reintegrar.");
                                cantidad=teclado.nextFloat();
                                teclado.nextLine();
                                cuenta.reintegrar(cantidad);
                                System.out.println("Cantidad reintegrada "+cantidad+".");
                            break;
                            case 3:
                                System.out.println("Su saldo es :"+cuenta.getSaldo()+".");
                            break;
                            case 4:
                                System.out.println("Introduzca cantidad a transferir.");
                                cantidad=teclado.nextFloat();
                                teclado.nextLine();
                                System.out.println("introduzca cuenta a la cual se transferira el dinero.");
                                 String destino=teclado.nextLine();
                                cuenta.realizarTransferencia(destino, cantidad);
                            break;
                            case 5:
                                cuenta.listarMovimientos();
                        }
                    }else{
                        System.out.println("No existe una cuenta con ese codigo.");
                    }
                    break;
            case 3:
                   
        }
    
        
        }
}

