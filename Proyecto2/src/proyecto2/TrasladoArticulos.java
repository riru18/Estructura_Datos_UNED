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

public class TrasladoArticulos extends JFrame {

    private Departamento[] pila;
    private int tope;

    private JTable tablaDeptos;
    private DefaultTableModel modeloDeptos;

    private JTextArea resultadoArea;

    public TrasladoArticulos(Departamento[] pilaExistente, int topeExistente) {
        this.pila = pilaExistente;
        this.tope = topeExistente;

        setTitle("Traslado de Artículos");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        modeloDeptos = new DefaultTableModel(new Object[]{"ID", "Nombre"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tablaDeptos = new JTable(modeloDeptos);
        tablaDeptos.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane scroll = new JScrollPane(tablaDeptos);
        add(scroll, BorderLayout.CENTER);

        resultadoArea = new JTextArea(5, 50);
        resultadoArea.setEditable(false);
        add(new JScrollPane(resultadoArea), BorderLayout.SOUTH);

        JButton btnTrasladar = new JButton("Trasladar Artículos");
        btnTrasladar.addActionListener(e -> realizarTraslado());
        add(btnTrasladar, BorderLayout.NORTH);

        llenarTabla();        
    }

    private void llenarTabla() {
        modeloDeptos.setRowCount(0);
        for (int i = tope; i >= 0; i--) {
            modeloDeptos.addRow(new Object[]{
                pila[i].getId(), pila[i].getNombre()
            });
        }
    }

    private void realizarTraslado() {
        resultadoArea.setText("");

        int[] seleccion = tablaDeptos.getSelectedRows();

        if (tope < 1) {
            mostrar("Debe haber al menos dos departamentos registrados.");
            return;
        }

        if (seleccion.length != 2) {
            mostrar("Seleccione únicamente dos departamentos: origen y destino.");
            return;
        }

        Departamento origen = pila[tope - seleccion[0]];
        Departamento destino = pila[tope - seleccion[1]];

        if (origen == destino) {
            mostrar("El departamento origen y destino no pueden ser el mismo.");
            return;
        }

        Articulo[] articulosOrigen = origen.getArticulos();

        if (articulosOrigen.length == 0) {
            mostrar("El departamento origen no tiene artículos para trasladar.");
            return;
        }

        int trasladados = 0;

        for (Articulo art : articulosOrigen) {
            if (destino.agregarArticulo(art)) {
                origen.eliminarArticulo();
                trasladados++;
            } else {
                mostrar("Cola del departamento destino llena. Se detuvo el traslado.");
                break;
            }
        }

        mostrar("Se trasladaron " + trasladados + " artículo(s) de '" + origen.getNombre()
                + "' a '" + destino.getNombre() + "'.");

    }

    private void mostrar(String mensaje) {
        resultadoArea.append(mensaje + "\n");
    }
}
