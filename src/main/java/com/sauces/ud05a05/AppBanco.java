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
            teclado.nextLine();
        switch(accion){ 
            case 1: System.out.println("Abrir cuenta");
                System.out.println("Introduzca el codigo. ");
                codigo=teclado.nextLine();              
                System.out.println("Introduzca su nombre. ");
                titular=teclado.nextLine();
                System.out.println("Introduce saldo.");
                saldo=teclado.nextFloat();
                
                if(banco.abrirCuenta(codigo , titular , saldo)){
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
                        System.out.println("3- Consultar Saldo.");
                        System.out.println("4- Realizar Transferencia.");
                        System.out.println("5- Consultar total depositos.");
                        System.out.println("0- Cerrar Aplicacion");
                        System.out.print("Escoja accion. ");
                        opcion = teclado.nextInt();
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
                                cuenta.reintegrar(cantidad);
                                System.out.println("Cantidad reintegrada "+cantidad+".");
                            break;
                            case 3:
                                System.out.println("Su saldo es :"+cuenta.getSaldo()+".");
                            break;
                            case 4:
                                System.out.println("Introduzca cantidad a transferir.");
                                cantidad=teclado.nextFloat();
                                System.out.println("introduzca cuenta a la cual se transferira el dinero.");
                                Cuenta destino=teclado.nextLine();
                                cuenta.realizarTransferencia(destino, cantidad);
                                System.out.println("Transferencia realizada");
                            break;
                            case 5:
                                cuenta.listarMovimientos();
                            break;
                            case 0:
                                System.out.println("Adios");
                        }
                    }else{
                        System.out.println("No existe una cuenta con ese codigo.");
                    }
                    break;
            case 3:
                System.out.println("Cancelar cuenta");
                codigo=teclado.nextLine();
                banco.cancelarCuenta(codigo);
                if(banco.cancelarCuenta(codigo)){
                    System.out.println("Su cuenta ha sido cancelada.");
                }else{System.out.println("Su cuenta no se ha podido cancelar");}
            break;
            case 4:
                System.out.println("4- Listar cuentas.");
                
                
                
                for(Cuenta c: banco.getCuentas()){
                    System.out.println(c.toString());
                }
            break;
            case 5:System.out.println("Su total de depositos es: "+banco.getTotalDepositos());
            break;
            case 0:System.out.println("Adios, Vuelva pronto.");
            break;
        }
        }while(accion!=0);         
    }      
}

