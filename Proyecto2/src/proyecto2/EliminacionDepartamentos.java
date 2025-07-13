/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 *
 * @author Ricardo
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class EliminacionDepartamentos extends JFrame {

    private Departamento[] pila;
    private int tope;

    private JTable tablaDepartamentos;
    private DefaultTableModel modelo;

    public EliminacionDepartamentos(Departamento[] pilaExistente, int topeExistente) {
        this.pila = pilaExistente;
        this.tope = topeExistente;

        setTitle("Eliminación de Departamentos");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        modelo = new DefaultTableModel(new Object[]{"ID", "Nombre"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tablaDepartamentos = new JTable(modelo);
        tablaDepartamentos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(tablaDepartamentos), BorderLayout.CENTER);

        JButton btnEliminar = new JButton("Eliminar Último Departamento");
        btnEliminar.addActionListener(e -> eliminarUltimoDepartamento());
        add(btnEliminar, BorderLayout.SOUTH);

        actualizarTabla();
        setVisible(true);
    }

    private void actualizarTabla() {
        modelo.setRowCount(0);
        for (int i = tope; i >= 0; i--) {
            modelo.addRow(new Object[]{
                pila[i].getId(),
                pila[i].getNombre()
            });
        }
    }

    private void eliminarUltimoDepartamento() {
        if (tope == -1) {
            JOptionPane.showMessageDialog(this, "No hay departamentos para eliminar.");
            return;
        }

        Departamento ultimo = pila[tope];

        if (ultimo.getArticulos().length > 0) {
            JOptionPane.showMessageDialog(this,
                "No se puede eliminar. El departamento aún contiene artículos.");
            return;
        }

        pila[tope] = null;
        tope--;
        Proyecto2.setTope(tope); // actualizar estado global        
        actualizarTabla();
    }
}
