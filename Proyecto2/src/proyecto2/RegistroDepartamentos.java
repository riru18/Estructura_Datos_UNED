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


public class RegistroDepartamentos extends JFrame {
    
    //agregar variables a usar    
    
    private Departamento[] pila;
    private int tope;  
    
   

    private JTextField txtNombre;
    private DefaultTableModel modeloTabla;
    private JTable tabla;
    
    public RegistroDepartamentos(Departamento[] pilaExistente, int topeExistente) {
        this.pila = pilaExistente;
        this.tope = topeExistente;
        
        setTitle("Registro de Departamentos");
        setSize(900,600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        
        JPanel panelSuperior = new JPanel();
        panelSuperior.add(new JLabel("Nombre del Departamento:"));
        txtNombre = new JTextField(20);
        panelSuperior.add(txtNombre);
        JButton btnAgregar = new JButton("Agregar Departamento");
        btnAgregar.addActionListener(e -> agregarDepartamento());
        panelSuperior.add(btnAgregar);
        add(panelSuperior, BorderLayout.NORTH);
        
        modeloTabla = new DefaultTableModel(new Object[]{"ID", "Nombre"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabla = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tabla);
        add(scroll, BorderLayout.CENTER);
        

        actualizarTabla();
    
    }
    
    // prototipo metodo agregarDpto
    private void agregarDepartamento() {
        String nombre = txtNombre.getText().trim();

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un nombre.");
            return;
        }
        
        
        int idTentativo = Proyecto2.getSiguienteIdDepto();

        if (tope >= pila.length - 1) {
            JOptionPane.showMessageDialog(this, "Se alcanzó el límite de departamentos.");
            return;
        }

        Departamento nuevo = new Departamento(idTentativo, nombre);
        pila[++tope] = nuevo;
        Proyecto2.incrementarIdDepto();
        
        
        Proyecto2.setTope(tope);

        actualizarTabla();
        txtNombre.setText("");

    }
    
    
    //prototipo metodo actualizar
    
    private void actualizarTabla(){
        modeloTabla.setRowCount(0);
        for (int i = tope; i >= 0; i--) {
            modeloTabla.addRow(new Object[]{pila[i].getId(), pila[i].getNombre()});
        }
        
    }
        
}
