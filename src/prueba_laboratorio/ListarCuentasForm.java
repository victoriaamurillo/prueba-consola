/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba_laboratorio;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
/**
 *
 * @author Administrator
 */

public class ListarCuentasForm extends JFrame {
    private Banco banco;

    public ListarCuentasForm(Banco banco) {
        this.banco = banco;

        setTitle("Listar Cuentas");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        add(panel);

        JLabel montoLabel = new JLabel("Monto mínimo:");
        JTextField montoText = new JTextField(10);
        JButton listarButton = new JButton("Listar");
        
        JPanel inputPanel = new JPanel();
        inputPanel.add(montoLabel);
        inputPanel.add(montoText);
        inputPanel.add(listarButton);
        panel.add(inputPanel, BorderLayout.NORTH);

        JTable table = new JTable(new DefaultTableModel(new Object[]{"Código", "Nombre", "Saldo"}, 0));
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        listarButton.addActionListener(e -> {
            double monto = Double.parseDouble(montoText.getText());
            CuentaBancaria[] cuentas = banco.listar(monto);
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // Limpiar la tabla

            for (CuentaBancaria cuenta : cuentas) {
                model.addRow(cuenta.toObjectArray());
            }
        });

        setVisible(true);
    }
}