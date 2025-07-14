/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto2;

/**
 *
 * @author Ricardo
 */

import javax.swing.*;
import java.awt.*;
//import java.awt.event.*;


public class Proyecto2 extends JFrame{
    
    private static final int MAX_DEPARTAMENTOS = 20;
    private static Departamento[] pilaDepartamentos = new Departamento[MAX_DEPARTAMENTOS];
    private static int tope = -1;

    private static int idDepto = 1;
    private static int idArticulo = 1;
    
    public Proyecto2() {
        // configuración del frame principal para el programa.
        setTitle("Gestión de Tienda Departamental y de Artículos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1, 5, 5));
        setSize(600,500);
        setLocationRelativeTo(null);
        
        
        // botones del menu principal 
            
        
        JButton btnRegistroDpto = new JButton("Registro de Departamentos");
        JButton btnRegistroArt = new JButton("Registro de Artículos");
        JButton btnEliminarArt = new JButton("Eliminación de artículos");
        JButton btnTrasladoArt = new JButton("Traslado de artículos");
        JButton btnEliminarDpto = new JButton("Eliminación de departamentos");
        
        // asignacion de ActionListener a cada boton para abrir la ventana respectiva
        btnRegistroDpto.addActionListener(e -> new RegistroDepartamentos(pilaDepartamentos, tope).setVisible(true));
        btnRegistroArt.addActionListener(e -> new RegistroArticulos(pilaDepartamentos, tope).setVisible(true));
        btnEliminarArt.addActionListener(e -> new EliminacionArticulos(pilaDepartamentos, tope).setVisible(true));
        btnTrasladoArt.addActionListener(e -> new TrasladoArticulos(pilaDepartamentos, tope).setVisible(true));
        btnEliminarDpto.addActionListener(e -> new EliminacionDepartamentos(pilaDepartamentos, tope).setVisible(true));
        
        // agriega botones al menu principal
        add (btnRegistroDpto);
        add (btnRegistroArt);
        add (btnEliminarArt);
        add (btnTrasladoArt);
        add (btnEliminarDpto);
               
        
    }
    
    public static int getSiguienteIdDepto() {
        return idDepto;
    }

    public static void incrementarIdDepto() {
        idDepto++;
    }

    public static int getSiguienteIdArticulo() {
        return idArticulo; 
    }

    public static void incrementarIdArticulo() {
        idArticulo++; 
    }

    public static void setTope(int nuevoTope) {
        tope = nuevoTope;
    }

    public static int getTope() {
        return tope;
    }

    public static Departamento[] getPilaDepartamentos() {
        return pilaDepartamentos;
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Proyecto2().setVisible(true);
        });
    }
    
}
