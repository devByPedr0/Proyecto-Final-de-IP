import java.util.Scanner;

public class Control {

    public static void start() {

        Scanner in = new Scanner(System.in);
        String s;

    System.out.println(
      Colors.RED   + "=="
    + Colors.WHITE + "=="
    + Colors.RED   + "=="
    + Colors.WHITE + "=="
    + Colors.RED   + "=="
    + Colors.WHITE + "== "
    + Colors.WHITE + "BUS"
    + Colors.RED   + "CA"
    + Colors.WHITE + "DOR "
    + Colors.RED   + "DE "
    + Colors.WHITE + "SUBM"
    + Colors.RED   + "ATR"
    + Colors.WHITE + "ICES "
    + Colors.WHITE + "=="
    + Colors.RED   + "=="
    + Colors.WHITE + "=="
    + Colors.RED   + "=="
    + Colors.WHITE + "=="
    + Colors.RED   + "=="
    + Colors.RESET
    );

        // =================================================================Ingreso de la matriz base

        System.out.print(Colors.WHITE + "¿Cuántas filas tiene la matriz base? (0-30) :  " + Colors.RESET);
        s = in.next().trim();
        int n = parser(s);

        while(n <= 0 || n > 30) {
            System.out.print(Colors.RED + "La cantidad de filas debe ser un número mayor que 0 y menor o igual que 30, ingréselo nuevamente: " + Colors.RESET);
            s = in.next().trim();
            n = parser(s);
        }

        System.out.print(Colors.WHITE + "¿Cuántas columnas tiene la matriz base? (0-30) :  " + Colors.RESET);
        s = in.next().trim();
        int m = parser(s);
        
        while(m <= 0 || m > 30) {
            System.out.print(Colors.RED + "La cantidad de columnas debe ser un número mayor que 0 y menor o igual que 30, ingréselo nuevamente: " + Colors.RESET);
            s = in.next().trim();
            m = parser(s);
        }

        boolean[][] matriz = new boolean[n][m];

        System.out.println(Colors.WHITE + "Ingrese los elementos de la matriz base"+ Colors.RED +" (0/false = 0, otra entrada = 1): " + Colors.RESET);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                s = in.next().trim().toLowerCase();
                matriz[i][j] = parseBoolean(s);
            }
        }
        
        // ===========================================================Ingreso de la submatriz a buscar

        System.out.print(Colors.WHITE + "¿Cuántas filas tiene la submatriz a buscar? (1-" + n + ") :  " + Colors.RESET);
        s = in.next().trim();
        int subN = parser(s);

        while(subN > n || subN <= 0) {
            System.out.print(Colors.RED + "La cantidad de filas debe ser número menor o igual a " + n + " y mayor que 0, ingréselo nuevamente: " + Colors.RESET);
            s = in.next().trim();
            subN = parser(s);
        }

        System.out.print(Colors.WHITE + "¿Cuántas columnas tiene la submatriz a buscar? (1-" + m + ") :  " + Colors.RESET);
        s = in.next().trim();
        int subM = parser(s);

        while(subM > m || subM <= 0) {
            System.out.print(Colors.RED + "La cantidad de columnas debe ser un número menor o igual a " + m + " y mayor que 0, ingréselo nuevamente: " + Colors.RESET);
            s = in.next().trim();
            subM = parser(s);
        }
        
        boolean[][] subMatriz = new boolean[subN][subM];

        System.out.println(Colors.WHITE + "Ingrese los elementos de la submatriz"+ Colors.RED +" (0/false = 0, otra entrada = 1): " + Colors.RESET);

        for (int i = 0; i < subN; i++) {
            for (int j = 0; j < subM; j++) {
                s = in.next().trim().toLowerCase();
                subMatriz[i][j] = parseBoolean(s);
            }
        }

        // ============================================Llamada a la función para encontrar la submatriz

        findSubmatrix(matriz, subMatriz, n, m, subN, subM);

    }

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
                       System.out.println(Colors.GREEN + "Fila: " + (x+1) + " Columna: " + (y+1) + Colors.RESET);
                    }

                    if(found && !alreadyFound) {
                        System.out.println(Colors.GREEN + "La submatriz fue encontrada comenzando en : " + Colors.RESET);
                        System.out.println(Colors.GREEN + "Fila: " + (x+1) + " Columna: " + (y+1) + Colors.RESET);
                        alreadyFound = true;
                    }
                }
            }
        }
    
        if(!alreadyFound)
            System.out.println(Colors.RED + "La submatriz no fue encontrada." + Colors.RESET);

    }

    // =========================================Función para convertir String a enteros para validación de entradas

    public static int parser(String s) {

    if (s.length() == 0)
        return -1;

    char[] c = {'0','1','2','3','4','5','6','7','8','9'};

    for(int i = 0; i < s.length(); i++){ 
        boolean isNumber = false;

        for(int j = 0; j < c.length; j++){
            if(s.charAt(i) == c[j]){
                isNumber = true;
                break;
            }
        }

        if(!isNumber){
            return -1;
        }
    }

    return Integer.parseInt(s);
}

    // =========================================Función para validar la entrada de las matrices booleanas

    public static boolean parseBoolean(String s) {
        
        if(s.equals("0") || s.equals("false")) {
            return false;
        } 
        
        else return true;
    }
}
