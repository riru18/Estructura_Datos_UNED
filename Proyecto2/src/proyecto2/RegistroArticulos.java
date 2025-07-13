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
    
    
    public RegistroArticulos(Departamento[] pilaDeptos, int topeDeptos) {
        this.pilaDeptos = pilaDeptos;
        this.topeDeptos = topeDeptos;
        
        setTitle("Registro de Artículos");
        setSize(900,600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        modeloDepartamentos = new DefaultTableModel(new Object[]{"ID", "Nombre"}, 0);
        tablaDepartamentos = new JTable(modeloDepartamentos);
        tablaDepartamentos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollTabla = new JScrollPane(tablaDepartamentos);
        add(scrollTabla, BorderLayout.CENTER);
        
        JPanel panelArticulo = new JPanel();
        panelArticulo.setLayout(new GridLayout(3, 2, 10, 10));
        panelArticulo.setBorder(BorderFactory.createTitledBorder("Agregar nuevo artículo"));

        panelArticulo.add(new JLabel("Nombre del Artículo:"));
        txtNombreArticulo = new JTextField();
        panelArticulo.add(txtNombreArticulo);
        
        JButton btnAgregar = new JButton("Agregar Artículo");
        btnAgregar.addActionListener(e -> registrarArticulo());
        panelArticulo.add(btnAgregar);

        add(panelArticulo, BorderLayout.SOUTH);
        
        llenarTablaDepartamentos();
    }
    
    private void llenarTablaDepartamentos(){
        
    }
    
    private void registrarArticulo(){

    }
    
}