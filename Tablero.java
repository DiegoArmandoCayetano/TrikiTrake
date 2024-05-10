package triquitraque;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jonathanrolandoreycastillo
 */
public class Tablero {
    private char[][] tablero;

    public Tablero(int filas, int columnas) {
        tablero = new char[filas][columnas];
        inicializarTablero(3,3);// Inicializar el tablero
    }
    
        private void inicializarTablero(int filas, int columnas) {
        tablero = new char[filas][columnas];
        
    }
      private void activarTablero3x3() {
       inicializarTablero(3, 3); // Inicializar el tablero con un tamaño de 3x3
        // Otras operaciones para activar el tablero 3x3 en la interfaz de usuario
    }

    private void activarTablero4x4() {
        inicializarTablero(4, 4); 
    }

    private void activarTablero5x5() {
        inicializarTablero(5, 5); 
    }
 
    public void seleccionarTablero(String seleccion) {
        switch (seleccion) {
            case "3*3":
                activarTablero3x3();
                break;
            case "4*4":
                activarTablero4x4();
                break;
            case "5*5":
                activarTablero5x5();
                break;
            default:
                System.out.println("Selección no válida. Por favor, seleccione una opción válida.");
                break;
        }
    }

   
 


    public boolean verificarGanador() {
    // Verificar filas
    for (int i = 0; i < tablero.length; i++) {
        if (tablero[i][0] != '-' && todasIguales(tablero[i])) {
            return true; // Hay una línea ganadora en la fila i
        }
    }
    
    // Verificar columnas
    for (int j = 0; j < tablero[0].length; j++) {
        char[] columna = new char[tablero.length];
        for (int i = 0; i < tablero.length; i++) {
            columna[i] = tablero[i][j];
        }
        if (columna[0] != '-' && todasIguales(columna)) {
            return true; // Hay una línea ganadora en la columna j
        }
    }
    
    // Verificar diagonal principal
    char[] diagonalPrincipal = new char[tablero.length];
    for (int i = 0; i < tablero.length; i++) {
        diagonalPrincipal[i] = tablero[i][i];
    }
    if (diagonalPrincipal[0] != '-' && todasIguales(diagonalPrincipal)) {
        return true; // Hay una línea ganadora en la diagonal principal
    }
    
    // Verificar diagonal secundaria
    char[] diagonalSecundaria = new char[tablero.length];
    for (int i = 0; i < tablero.length; i++) {
        diagonalSecundaria[i] = tablero[i][tablero.length - 1 - i];
    }
    if (diagonalSecundaria[0] != '-' && todasIguales(diagonalSecundaria)) {
        return true; // Hay una línea ganadora en la diagonal secundaria
    }
    
    // Si no se encontró ninguna línea ganadora, devolver false
    return false;
}

// Método auxiliar para verificar si todos los elementos de un array son iguales
private boolean todasIguales(char[] array) {
    for (int i = 1; i < array.length; i++) {
        if (array[i] != array[0]) {
            return false;
        }
    }
    return true;
}


    public boolean verificarEmpate() {
    // Recorremos todas las celdas del tablero
    for (int i = 0; i < tablero.length; i++) {
        for (int j = 0; j < tablero[0].length; j++) {
            // Si encontramos al menos una celda vacía, no hay empate
            if (tablero[i][j] == '-') {
                return false; // Hay al menos una celda vacía, no hay empate
            }
        }
    }
    if (!verificarGanador()) { // Verificamos que no haya ganador
        reiniciarPartida(); // Llamamos al método para reiniciar la partida
    }
    return true; // Indicamos que hay un empate
}

  
   public void reiniciarPartida() {
        inicializarTablero(tablero.length, tablero[0].length); // Reiniciar el tablero
        // Otras operaciones para reiniciar cualquier otro estado del juego si es necesario
    }

    
     public void mostrarTablero() {
    // Recorremos todas las filas del tablero
    for (int i = 0; i < tablero.length; i++) {
        // Imprimimos una línea horizontal antes de cada fila
        System.out.print("|");
        // Recorremos todas las columnas de la fila actual
        for (int j = 0; j < tablero[0].length; j++) {
            // Imprimimos el contenido de la celda actual seguido de una línea vertical
            System.out.print(" " + tablero[i][j] + " |");
        }
        // Imprimimos una nueva línea al final de cada fila para separarlas
        System.out.println();
        // Imprimimos una línea horizontal después de cada fila
        for (int k = 0; k < tablero[0].length; k++) {
            System.out.print("----");
        }
        System.out.println();
    }
}

    public void colocarFicha(int fila, int columna, char ficha) {
        tablero[fila][columna] = ficha;
    }

}
