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


public class RegistroArticulos extends JFrame {
    
    //agregar variables a usar
    
    private Departamento[] pila;
    private int tope;
    
    private JTable tabla;
    private DefaultTableModel modelo;

    private JTextField txtNombreArticulo;
    private JComboBox<String> cmbCategoria;

    private static final String[] CATEGORIAS = {
        "Ropa y accesorios", "Electrónica", "Hogar y muebles",
        "Belleza y cuidado personal", "Deportes y aire libre",
        "Juguetes y juegos", "Alimentos y bebidas"
    };
    
        
    
    public RegistroArticulos(Departamento[] pilaExistente, int topeExistente) {
        this.pila = pilaExistente;
        this.tope = topeExistente;
        
        setTitle("Registro de Artículos");
        setSize(900,600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        modelo = new DefaultTableModel(new Object[]{"ID", "Nombre"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabla = new JTable(modelo);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.setBorder(BorderFactory.createTitledBorder("Nuevo artículo"));

        panel.add(new JLabel("Nombre:"));
        txtNombreArticulo = new JTextField();
        panel.add(txtNombreArticulo);

        panel.add(new JLabel("Categoría:"));
        cmbCategoria = new JComboBox<>(new String[]{
            "Ropa y accesorios", "Electrónica", "Hogar y muebles",
            "Belleza y cuidado personal", "Deportes y aire libre",
            "Juguetes y juegos", "Alimentos y bebidas"
        });
        panel.add(cmbCategoria);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> guardarArticulo());
        panel.add(btnGuardar);

        add(panel, BorderLayout.SOUTH);
        actualizarTabla();
    }
    
    private void actualizarTabla() {
        modelo.setRowCount(0);
        for (int i = tope; i >= 0; i--) {
            modelo.addRow(new Object[]{pila[i].getId(), pila[i].getNombre()});
        }
    }

    private void guardarArticulo() {
        int fila = tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un departamento.");
            return;
        }

        String nombre = txtNombreArticulo.getText().trim();
        String categoria = (String) cmbCategoria.getSelectedItem();

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar el nombre del artículo.");
            return;
        }

        Departamento depto = pila[tope - fila]; // LIFO
        Articulo nuevo = new Articulo(Proyecto2.getNuevoIdArticulo(), nombre, categoria);

        if (!depto.agregarArticulo(nuevo)) {
            JOptionPane.showMessageDialog(this, "Lista de artículos llena.");
            return;
        }
        
        txtNombreArticulo.setText("");
    }
    
}