import java.util.Scanner;

public class Main {

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
                       System.out.println("Fila: " + (x+1) + " Columna: " + (y+1));
                    }

                    if(found && !alreadyFound) {
                        System.out.println("La submatriz fue encontrada comenzando en : ");
                        System.out.println("Fila: " + (x+1) + " Columna: " + (y+1) );
                        alreadyFound = true;
                    }
                }
            }
        }
    
        if(!alreadyFound)
            System.out.println("La submatriz no fue encontrada.");

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

        // =================================================================Ingreso de la matriz base

        System.out.print("¿Cuántas filas tiene la matriz base? (n>0) :  ");
        s = in.next().trim();
        int n = parser(s);

        while(n <= 0) {
            System.out.print("La cantidad de filas debe ser un número mayor que 0, ingréselo nuevamente: ");
            s = in.next().trim();
            n = parser(s);
        }

        System.out.print("¿Cuántas columnas tiene la matriz base? (m>0) :  ");
        s = in.next().trim();
        int m = parser(s);
        
        while(m <= 0) {
            System.out.print("La cantidad de columnas debe ser un número mayor que 0, ingréselo nuevamente: ");
            s = in.next().trim();
            m = parser(s);
        }

        boolean[][] matriz = new boolean[n][m];

        System.out.println("Ingrese los elementos de la matriz base (0 o false para 0, cualquier otra entrada será tomada como 1): ");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                s = in.next().trim().toLowerCase();
                matriz[i][j] = parseBoolean(s);
            }
        }
        
        // ===========================================================Ingreso de la submatriz a buscar

        System.out.print("¿Cuántas filas tiene la submatriz a buscar? (1-" + n + ") :  ");
        s = in.next().trim();
        int subN = parser(s);

        while(subN > n || subN <= 0) {
            System.out.print("La cantidad de filas debe ser número menor o igual a " + n + " y mayor que 0, ingréselo nuevamente: ");
            s = in.next().trim();
            subN = parser(s);
        }

        System.out.print("¿Cuántas columnas tiene la submatriz a buscar? (1-" + m + ") :  ");
        s = in.next().trim();
        int subM = parser(s);

        while(subM > m || subM <= 0) {
            System.out.print("La cantidad de columnas debe ser un número menor o igual a " + m + " y mayor que 0, ingréselo nuevamente: ");
            s = in.next().trim();
            subM = parser(s);
        }
        
        boolean[][] subMatriz = new boolean[subN][subM];

        System.out.println("Ingrese los elementos de la submatriz (0 o false para 0, cualquier otra entrada será tomada como 1): ");

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