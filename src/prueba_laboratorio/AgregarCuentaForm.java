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

public class AgregarCuentaForm extends JFrame {
    private Banco banco;

    public AgregarCuentaForm(Banco banco) {
        this.banco = banco;

        setTitle("Agregar Cuenta");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        placeComponents(panel);
        add(panel);

        setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Código");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        JTextField codigoText = new JTextField(20);
        codigoText.setBounds(100, 20, 165, 25);
        panel.add(codigoText);

        JLabel nameLabel = new JLabel("Nombre");
        nameLabel.setBounds(10, 50, 80, 25);
        panel.add(nameLabel);

        JTextField nombreText = new JTextField(20);
        nombreText.setBounds(100, 50, 165, 25);
        panel.add(nombreText);

        JButton agregarButton = new JButton("Agregar");
        agregarButton.setBounds(10, 80, 150, 25);
        panel.add(agregarButton);

        agregarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int codigo = Integer.parseInt(codigoText.getText());
                String nombre = nombreText.getText();
                if (banco.agregar(codigo, nombre)) {
                    JOptionPane.showMessageDialog(null, "Cuenta agregada exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al agregar cuenta.");
                }
            }
        });
    }
}