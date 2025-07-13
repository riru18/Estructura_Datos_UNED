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
    
    private JTable tablaDepartamentos;
    private DefaultTableModel modeloDepartamentos;
    
    private JTextField txtNombreArticulo;
    
    private Departamento[] pilaDeptos;
    private int topeDeptos;
    
    
    public RegistroArticulos() {
        setTitle("Registro de Artículos");
        setSize(900,600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
    }
    
}