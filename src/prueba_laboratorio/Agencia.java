/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba_laboratorio;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Administrator
 */

public class Agencia {
    private static Banco banco;

    public static void main(String[] args) {
        banco = new Banco(10);  // Por ejemplo, un banco con capacidad para 10 cuentas

        JFrame frame = new JFrame("Agencia Bancaria");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JButton agregarButton = new JButton("Agregar Cuenta");
        agregarButton.setBounds(10, 20, 150, 25);
        panel.add(agregarButton);

        agregarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AgregarCuentaForm(banco);
            }
        });

        JButton listarButton = new JButton("Listar Cuentas");
        listarButton.setBounds(10, 60, 150, 25);
        panel.add(listarButton);

        listarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ListarCuentasForm(banco);
            }
        });

        JButton interesesButton = new JButton("Aplicar Intereses");
        interesesButton.setBounds(10, 100, 150, 25);
        panel.add(interesesButton);

        interesesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                banco.intereses();
                JOptionPane.showMessageDialog(null, "Intereses aplicados.");
            }
        });

        JButton transferirButton = new JButton("Transferir");
        transferirButton.setBounds(10, 140, 150, 25);
        panel.add(transferirButton);

        transferirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TransferirForm(banco);
            }
        });
    }
}