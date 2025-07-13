/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto2;

/**
 *
 * @author Ricardo
 */
public class Departamento {
    private int id;
    private String nombre;

    private static final int MAX_ARTICULOS = 20;
    private Articulo[] articulos = new Articulo[MAX_ARTICULOS];
    private int frente = 0;
    private int fin = 0;
    
    public Departamento(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public boolean agregarArticulo(Articulo art) {
        if ((fin + 1) % MAX_ARTICULOS == frente) {
            return false; // cola llena 
        }
        articulos[fin] = art;
        fin = (fin + 1) % MAX_ARTICULOS;
        return true;
    }

    public Articulo[] getArticulos() {
        Articulo[] resultado = new Articulo[(fin - frente + MAX_ARTICULOS) % MAX_ARTICULOS];
        int idx = 0;
        for (int i = frente; i != fin; i = (i + 1) % MAX_ARTICULOS) {
            resultado[idx++] = articulos[i];
        }
        return resultado;
    }
    
    
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
    
    
}
