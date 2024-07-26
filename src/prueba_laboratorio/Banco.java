/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba_laboratorio;
import java.util.Arrays;

/**
 *
 * @author Administrator
 */
public class Banco {
    private CuentaBancaria[] cuentas;
    private static final double tasaInteres = 0.02;

    public Banco(int tamano) {
        cuentas = new CuentaBancaria[tamano];
    }

    public CuentaBancaria buscar(int codigo) {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta != null && cuenta.getCodigo() == codigo) {
                return cuenta;
            }
        }
        return null;
    }

    public boolean agregar(int codigo, String nombreCliente) {
        if (buscar(codigo) != null) {
            return false;
        }
        for (int i = 0; i < cuentas.length; i++) {
            if (cuentas[i] == null) {
                cuentas[i] = new CuentaBancaria(codigo, nombreCliente);
                return true;
            }
        }
        return false;
    }

    public boolean transferir(int codigoOrigen, int codigoDestino, double monto) {
        CuentaBancaria origen = buscar(codigoOrigen);
        CuentaBancaria destino = buscar(codigoDestino);

        if (origen != null && destino != null) {
            if (origen.retirar(monto)) {
                destino.depositar(monto);
                return true;
            }
        }
        return false;
    }

    public void intereses() {
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta != null) {
                cuenta.depositar(cuenta.getSaldo() * tasaInteres);
            }
        }
    }

    public CuentaBancaria[] listar(double monto) {
        return Arrays.stream(cuentas)
                .filter(cuenta -> cuenta != null && cuenta.getSaldo() >= monto)
                .toArray(CuentaBancaria[]::new);
    }
}