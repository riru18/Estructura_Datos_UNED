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
    
    private static final int MAX_DEPTOS = 20;
    private Departamento[] pilaDepartamentos = new Departamento[MAX_DEPTOS];
    private int tope = -1;
    
    private static int idDeptoActual = 1;
   

    private JTextField txtNombre;
    private DefaultTableModel modeloTabla;
    private JTable tabla;
    
    public RegistroDepartamentos() {
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
        
        
        modeloTabla = new DefaultTableModel(new Object[]{"ID", "Nombre"}, 0);
        tabla = new JTable(modeloTabla);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scroll = new JScrollPane(tabla);
        add(scroll, BorderLayout.CENTER);
        
    }
    
    // prototipo metodo agregarDpto
    private void agregarDepartamento() {
        String nombre = txtNombre.getText().trim();

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un nombre.");
            return;
        }
        if (tope >= MAX_DEPTOS - 1) {
            JOptionPane.showMessageDialog(this, "Se alcanzó el límite de departamentos.");
            return;
        }

        Departamento nuevo = new Departamento(idDeptoActual++, nombre);
        pilaDepartamentos[++tope] = nuevo;


    }
    
    
    //prototipo metodo actualizar
    
    private void actualizarTabla(){
        modeloTabla.setRowCount(0);
        
        
    }
    
    public static void main(String[] args){
        new RegistroDepartamentos();
    }
    
}
