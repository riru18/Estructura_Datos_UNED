/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 *
 * @author Ricardo
 */
public class Articulo {
    private int id;
    private String nombre;
    private String categoria;

    public Articulo(int id, String nombre, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }
}
