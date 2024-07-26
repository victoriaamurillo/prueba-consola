/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba_laboratorio;

/**
 *
 * @author Administrator
 */
public class CuentaBancaria {
    private int codigo;
    private String nombreCliente;
    private double saldo;

    public CuentaBancaria(int codigo, String nombreCliente) {
        this.codigo = codigo;
        this.nombreCliente = nombreCliente;
        this.saldo = 500.0;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
        }
    }

    public boolean retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            return true;
        }
        return false;
    }

    public Object[] toObjectArray() {
        return new Object[] { codigo, nombreCliente, saldo };
    }
}