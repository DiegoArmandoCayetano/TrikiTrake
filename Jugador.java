package triquitraque;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/

/**
 *
 * @author jonathanrolandoreycastillo
 */
public class Jugador {
    private String nombre;
    private String color;
    private char ficha;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public String obtenerNombre() {
        return nombre;
    }

    
    // Métodos para establecer y obtener el color del jugador
    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public char getFicha() {
        return ficha;
    }

    public void setFicha(char ficha) {
        this.ficha = ficha;
    }
    
}