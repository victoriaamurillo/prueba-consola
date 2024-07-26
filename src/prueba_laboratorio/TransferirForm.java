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
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransferirForm extends JFrame {
    private Banco banco;

    public TransferirForm(Banco banco) {
        this.banco = banco;

        setTitle("Transferir");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        placeComponents(panel);
        add(panel);

        setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel codigoOrigenLabel = new JLabel("Código Origen");
        codigoOrigenLabel.setBounds(10, 20, 100, 25);
        panel.add(codigoOrigenLabel);

        JTextField codigoOrigenText = new JTextField(20);
        codigoOrigenText.setBounds(120, 20, 150, 25);
        panel.add(codigoOrigenText);

        JLabel codigoDestinoLabel = new JLabel("Código Destino");
        codigoDestinoLabel.setBounds(10, 60, 100, 25);
        panel.add(codigoDestinoLabel);

        JTextField codigoDestinoText = new JTextField(20);
        codigoDestinoText.setBounds(120, 60, 150, 25);
        panel.add(codigoDestinoText);

        JLabel montoLabel = new JLabel("Monto");
        montoLabel.setBounds(10, 100, 100, 25);
        panel.add(montoLabel);

        JTextField montoText = new JTextField(20);
        montoText.setBounds(120, 100, 150, 25);
        panel.add(montoText);

        JButton transferirButton = new JButton("Transferir");
        transferirButton.setBounds(10, 140, 150, 25);
        panel.add(transferirButton);

        transferirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int codigoOrigen = Integer.parseInt(codigoOrigenText.getText());
                int codigoDestino = Integer.parseInt(codigoDestinoText.getText());
                double monto = Double.parseDouble(montoText.getText());
                if (banco.transferir(codigoOrigen, codigoDestino, monto)) {
                    JOptionPane.showMessageDialog(null, "Transferencia exitosa.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error en la transferencia.");
                }
            }
        });
    }
}
