import java.time.Year;
import java.util.Scanner;

public class Main {

    // =====Colores ANSI para consola
    public static final String RESET  = "\u001B[0m";

    public static final String BLACK  = "\u001B[30m";
    public static final String RED    = "\u001B[31m";
    public static final String GREEN  = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE   = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN   = "\u001B[36m";
    public static final String WHITE  = "\u001B[37m";

    // ==============================Función para encontrar la submatriz dentro de la matriz principal
    public static void findSubmatrix(boolean[][] matriz, boolean[][] subMatriz, int n, int m, int subN, int subM) {
    
        boolean found = true;
        boolean alreadyFound = false;

        for(int x = 0; x <= n - subN; x++){
            for(int y = 0; y <= m - subM; y++){

                found = true;
                
                if(matriz[x][y] == subMatriz[0][0]) {
                    for(int i = 0; i < subN; i++) {
                        for(int j = 0; j < subM; j++) {
                            if(matriz[x + i][y + j] != subMatriz[i][j]) {
                                found = false;
                                break;
                            }
                        }
                        if(!found) break;
                    }

                    if(found && alreadyFound){
                       System.out.println(GREEN + "Fila: " + (x+1) + " Columna: " + (y+1) + RESET);
                    }

                    if(found && !alreadyFound) {
                        System.out.println(GREEN + "La submatriz fue encontrada comenzando en : " + RESET);
                        System.out.println(GREEN + "Fila: " + (x+1) + " Columna: " + (y+1) + RESET);
                        alreadyFound = true;
                    }
                }
            }
        }
    
        if(!alreadyFound)
            System.out.println(RED + "La submatriz no fue encontrada." + RESET);

    }
    
    // =========================================Función para convertir String a enteros para validación de entradas

    public static int parser(String s) {
    
        try {
        
            return Integer.parseInt(s);
    
        } catch (Exception e) {
        
            return -1;

        }
    }

    // =========================================Función para validar la entrada de las matrices booleanas

    public static boolean parseBoolean(String s) {
        
        if(s.equals("0") || s.equals("false")) {
            return false;
        } 
        
        else return true;
    } 

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        String s;

        System.out.println(CYAN + "================ BUSCADOR DE SUBMATRICES ================" + RESET);

        // =================================================================Ingreso de la matriz base

        System.out.print(YELLOW + "¿Cuántas filas tiene la matriz base? (0-30) :  " + RESET);
        s = in.next().trim();
        int n = parser(s);

        while(n <= 0 || n > 30) {
            System.out.print(RED + "La cantidad de filas debe ser un número mayor que 0 y menor o igual que 30, ingréselo nuevamente: " + RESET);
            s = in.next().trim();
            n = parser(s);
        }

        System.out.print(YELLOW + "¿Cuántas columnas tiene la matriz base? (0-30) :  " + RESET);
        s = in.next().trim();
        int m = parser(s);
        
        while(m <= 0 || m > 30) {
            System.out.print(RED + "La cantidad de columnas debe ser un número mayor que 0 y menor o igual que 30, ingréselo nuevamente: " + RESET);
            s = in.next().trim();
            m = parser(s);
        }

        boolean[][] matriz = new boolean[n][m];

        System.out.println(YELLOW + "Ingrese los elementos de la matriz base"+ RED +" (0/false = 0, otra entrada = 1): " + RESET);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                s = in.next().trim().toLowerCase();
                matriz[i][j] = parseBoolean(s);
            }
        }
        
        // ===========================================================Ingreso de la submatriz a buscar

        System.out.print(YELLOW + "¿Cuántas filas tiene la submatriz a buscar? (1-" + n + ") :  " + RESET);
        s = in.next().trim();
        int subN = parser(s);

        while(subN > n || subN <= 0) {
            System.out.print(RED + "La cantidad de filas debe ser número menor o igual a " + n + " y mayor que 0, ingréselo nuevamente: " + RESET);
            s = in.next().trim();
            subN = parser(s);
        }

        System.out.print(YELLOW + "¿Cuántas columnas tiene la submatriz a buscar? (1-" + m + ") :  " + RESET);
        s = in.next().trim();
        int subM = parser(s);

        while(subM > m || subM <= 0) {
            System.out.print(RED + "La cantidad de columnas debe ser un número menor o igual a " + m + " y mayor que 0, ingréselo nuevamente: " + RESET);
            s = in.next().trim();
            subM = parser(s);
        }
        
        boolean[][] subMatriz = new boolean[subN][subM];

        System.out.println(YELLOW + "Ingrese los elementos de la submatriz"+ RED +" (0/false = 0, otra entrada = 1): " + RESET);

        for (int i = 0; i < subN; i++) {
            for (int j = 0; j < subM; j++) {
                s = in.next().trim().toLowerCase();
                subMatriz[i][j] = parseBoolean(s);
            }
        }

        // ============================================Llamada a la función para encontrar la submatriz

        findSubmatrix(matriz, subMatriz, n, m, subN, subM);

    }
}