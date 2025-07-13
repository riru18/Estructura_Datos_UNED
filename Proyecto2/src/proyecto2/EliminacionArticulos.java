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
import java.awt.*;
import javax.swing.table.DefaultTableModel;



public class EliminacionArticulos extends JFrame {
    
    //agregar variables a usar
    
    
    private JTable tablaDepartamentos;
    private JTable tablaArticulos;
    private DefaultTableModel modeloDepartamentos;
    private DefaultTableModel modeloArticulos;

    private Departamento[] pila;
    private int tope;

    public EliminacionArticulos(Departamento[] pilaExistente, int topeExistente) {
        this.pila = pilaExistente;
        this.tope = topeExistente;

        setTitle("Eliminar Artículos");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel de tablas
        JPanel panelTablas = new JPanel(new GridLayout(1, 2));

        modeloDepartamentos = new DefaultTableModel(new Object[]{"ID", "Nombre"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaDepartamentos = new JTable(modeloDepartamentos);
        tablaDepartamentos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        panelTablas.add(new JScrollPane(tablaDepartamentos));

        modeloArticulos = new DefaultTableModel(new Object[]{"ID", "Nombre", "Categoría"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaArticulos = new JTable(modeloArticulos);
        panelTablas.add(new JScrollPane(tablaArticulos));

        add(panelTablas, BorderLayout.CENTER);

        // botón para eliminar artículo 
        JButton btnEliminar = new JButton("Eliminar artículo");
        btnEliminar.addActionListener(e -> eliminarPrimerArticulo());
        add(btnEliminar, BorderLayout.SOUTH);

        
        tablaDepartamentos.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                mostrarArticulos();
            }
        });

        llenarTablaDepartamentos();
        
    }

    private void llenarTablaDepartamentos() {
        modeloDepartamentos.setRowCount(0);
        for (int i = tope; i >= 0; i--) {
            modeloDepartamentos.addRow(new Object[]{
                pila[i].getId(), pila[i].getNombre()
            });
        }
    }

    private void mostrarArticulos() {
        modeloArticulos.setRowCount(0);
        int fila = tablaDepartamentos.getSelectedRow();
        if (fila == -1) return;

        Departamento depto = pila[tope - fila];
        Articulo[] articulos = depto.getArticulos();

        for (Articulo art : articulos) {
            modeloArticulos.addRow(new Object[]{
                art.getId(), art.getNombre(), art.getCategoria()
            });
        }
    }

    private void eliminarPrimerArticulo() {
        int fila = tablaDepartamentos.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un departamento.");
            return;
        }

        Departamento depto = pila[tope - fila];
        boolean eliminado = depto.eliminarArticulo();

        if (!eliminado) {
            JOptionPane.showMessageDialog(this, "La lista de artículos está vacía.");
        } 

        mostrarArticulos(); // refrescar tabla
    }
    
}