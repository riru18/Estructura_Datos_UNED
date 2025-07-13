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

    private JTable tablaOrigen;
    private JTable tablaDestino;
    private DefaultTableModel modeloOrigen;
    private DefaultTableModel modeloDestino;

    private JTextArea resultadoArea;

    public TrasladoArticulos(Departamento[] pilaExistente, int topeExistente) {
        this.pila = pilaExistente;
        this.tope = topeExistente;

        setTitle("Traslado de Artículos");
        setSize(1000, 550);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        
        JPanel panelTablas = new JPanel(new GridLayout(1, 2));

        // Origen
        modeloOrigen = new DefaultTableModel(new Object[]{"ID", "Nombre"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaOrigen = new JTable(modeloOrigen);
        tablaOrigen.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JPanel panelOrigen = new JPanel(new BorderLayout());
        panelOrigen.add(new JLabel("Departamento Origen", SwingConstants.CENTER), BorderLayout.NORTH);
        panelOrigen.add(new JScrollPane(tablaOrigen), BorderLayout.CENTER);
        panelTablas.add(panelOrigen);

        // Destino
        modeloDestino = new DefaultTableModel(new Object[]{"ID", "Nombre"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaDestino = new JTable(modeloDestino);
        tablaDestino.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JPanel panelDestino = new JPanel(new BorderLayout());
        panelDestino.add(new JLabel("Departamento Destino", SwingConstants.CENTER), BorderLayout.NORTH);
        panelDestino.add(new JScrollPane(tablaDestino), BorderLayout.CENTER);
        panelTablas.add(panelDestino);

        add(panelTablas, BorderLayout.CENTER);
        
        // panel inferior con boton y resultado
        JPanel panelInferior = new JPanel(new BorderLayout());
        
        JButton btnTrasladar = new JButton("Trasladar Artículos");
        btnTrasladar.addActionListener(e -> realizarTraslado());
        panelInferior.add(btnTrasladar, BorderLayout.NORTH);
        
        // area de resultado
        resultadoArea = new JTextArea(4, 40);
        resultadoArea.setEditable(false);
        panelInferior.add(new JScrollPane(resultadoArea), BorderLayout.CENTER);

        add(panelInferior, BorderLayout.SOUTH);
        
        llenarTablas();
        
    }

    private void llenarTablas() {
        modeloOrigen.setRowCount(0);
        modeloDestino.setRowCount(0);
        for (int i = tope; i >= 0; i--) {
            Object[] fila = new Object[]{pila[i].getId(), pila[i].getNombre()};
            modeloOrigen.addRow(fila);
            modeloDestino.addRow(fila);
        }
    }

    private void realizarTraslado() {
        resultadoArea.setText("");

        int filaOrigen = tablaOrigen.getSelectedRow();
        int filaDestino = tablaDestino.getSelectedRow();

        if (tope < 1) {
            mostrar("Debe haber al menos dos departamentos registrados.");
            return;
        }

        if (filaOrigen == -1 || filaDestino == -1) {
            mostrar("Debe seleccionar un departamento origen y uno destino.");
            return;
        }

        if (filaOrigen == filaDestino) {
            mostrar("El origen y el destino no pueden ser el mismo departamento.");
            return;
        }

        Departamento origen = pila[tope - filaOrigen];
        Departamento destino = pila[tope - filaDestino];

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
