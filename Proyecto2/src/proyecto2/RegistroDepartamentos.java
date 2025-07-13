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
    
    
    private static int idActual = 1;

    private JTextField txtNombre;
    private DefaultTableModel modeloTabla;
    private JTable tabla;
    
    public RegistroDepartamentos() {
        setTitle("Registro de Departamentos");
        setSize(900,600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        
        
    }
    
    // prototipo metodo agregarDpto
    private void agregarDepartamento() {
        String nombre = txtNombre.getText().trim();

            

    }
    
    
    //prototipo metodo actualizar
    
    private void actualizarTabla(){
        modeloTabla.setRowCount(0);
        
        
    }
    
    public static void main(String[] args){
        new RegistroDepartamentos();
    }
    
}
