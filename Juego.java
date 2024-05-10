package triquitraque;

import javax.swing.JLabel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 
/**
 *
 * @author jonathanrolandoreycastillo
 */
public class Juego {
    private Jugador jugador1;
    private Jugador jugador2;
    private Tablero tablero;
    Jugador jugadorActual;
    private final JLabel labelJugador1;
    private  final JLabel labelJugador2;

    public Juego(String nombreJugador1, String nombreJugador2, JLabel labelJugador1, JLabel labelJugador2) {
        jugador1 = new Jugador(nombreJugador1);
        jugador2 = new Jugador(nombreJugador2);
        tablero = new Tablero(3, 3); // Tablero de 3x3 por defecto
        jugadorActual = jugador1; // Comienza el jugador 1
        this.labelJugador1 = labelJugador1;
        this.labelJugador2 = labelJugador2;
    }

   
    

 public void setFichaJugador1(char ficha) {
        jugador1.setFicha(ficha);
    }

    public void setFichaJugador2(char ficha) {
        jugador2.setFicha(ficha);
    }
    
    public void iniciarPartida() {
        // Iniciar la partida
    }

    public void finalizarPartida() {
        // Finalizar la partida
    }

    public void cambiarTurno() {
      jugadorActual = (jugadorActual==jugador1)?jugador2:jugador1;
    }

    
    
    
    public void realizarMovimiento(int fila, int columna) {
    // Colocar la ficha del jugador actual en el tablero en la posición especificada
        tablero.colocarFicha(fila, columna, jugadorActual.getFicha());
        // Actualizar la interfaz gráfica con la ficha del jugador actual
        actualizarInterfaz();
        // Verificar si el jugador actual ha ganado
        if (tablero.verificarGanador()) {
            System.out.println("¡" + jugadorActual.obtenerNombre() + " ha ganado!");
            // Aquí puedes agregar lógica adicional, como mostrar un mensaje de victoria en la interfaz
        } else {
            // Cambiar al siguiente jugador
            cambiarTurno();
        }
}
  private void actualizarInterfaz() {
        // Actualizar el label correspondiente en la interfaz gráfica
        if (jugadorActual == jugador1) {
            labelJugador1.setText("X");
          
        } else {
           
            labelJugador2.setText("O");
        }
    }

  
}
