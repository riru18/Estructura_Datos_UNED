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
import java.awt.event.*;


public class Proyecto2 extends JFrame{
    
    public Proyecto2() {
        // configuración del frame principal para el programa.
        // tomando de referencia mi Proyecto1 y adaptado para el presente proyecto
        setTitle("Gestión de Tienda Departamental y de Artículos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1, 5, 5));
        setSize(600,500);
        setLocationRelativeTo(null);
        
        
        // botones del menu principal 
        
        /*
        btnRegistroDpto
        btnRegistroArt
        btnEliminarArt
        btnTrasladoArt
        btnEliminarDpto        
        
        */        
        
        JButton btnRegistro = new JButton("Registro de Departamentos");
        JButton btnRegistroArt = new JButton("Registro de Artículos");
        JButton btnEliminarArt = new JButton("Eliminación de artículos");
        JButton btnTrasladoArt = new JButton("Traslado de artículos");
        JButton btnEliminarDpto = new JButton("Eliminación de departamentos");
        
        // asignacion de ActionListener a cada boton para abrir la ventana respectiva
        .addActionListener(e -> new ().setVisible(true));
        .addActionListener(e -> new ().setVisible(true));
        .addActionListener(e -> new ().setVisible(true));
        .addActionListener(e -> new ().setVisible(true));
        .addActionListener(e -> new ().setVisible(true));
        
    }
    
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("hello world");
    }
    
}
