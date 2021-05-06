/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author daw1
 */
public class CuentaCredito extends Cuenta {
    private float limiteCredito;

    public CuentaCredito(float limiteCredito, String codigo, String titular, float saldo) {
        super(codigo, titular, saldo);
        this.limiteCredito = limiteCredito;
    }

    public void setLimiteCredito(float limiteCredito) {
        this.limiteCredito = limiteCredito;
    }
    public void reintegrar(float cantidad){
        if (cantidad>0&& cantidad<=getSaldo()){
            setSaldo(getSaldo()-cantidad);
            getMovimientos().add(new Movimiento(LocalDate.now(),'R', -cantidad,getSaldo()));
        }
        
    }

    @Override
    public String toString() {
        return super.toString() + "limiteCredito=" + limiteCredito;
    }
}
