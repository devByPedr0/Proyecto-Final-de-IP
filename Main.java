import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("¿Cuántas filas tiene la matriz base? (n>0) :  ");
        int n = in.nextInt();

        while(n <= 0) {
            System.out.print("La cantidad de filas debe ser mayor que 0, ingrese nuevamente: ");
            n = in.nextInt();
        }

        System.out.print("¿Cuántas columnas tiene la matriz base? (m>0) :  ");
        int m = in.nextInt();

        while(m <= 0) {
            System.out.print("La cantidad de columnas debe ser mayor que 0, ingrese nuevamente: ");
            m = in.nextInt();
        }

        boolean[][] matriz = new boolean[n][m];

        System.out.println("Ingrese los elementos de la matriz base (0 para false, cualquier otro numero para true): ");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matriz[i][j] = in.nextInt() != 0;
            }
        }

        System.out.print("¿Cuántas filas tiene la submatriz a buscar? (1-" + n + ") :  ");
        int subN = in.nextInt();

        while(subN > n || subN <= 0) {
            System.out.print("La cantidad de filas debe ser menor o igual a " + n + " y mayor que 0, ingrese nuevamente: ");
            subN = in.nextInt();
        }

        System.out.print("¿Cuántas columnas tiene la submatriz a buscar? (1-" + m + ") :  ");
        int subM = in.nextInt();

        while(subM > m || subM <= 0) {
            System.out.print("La cantidad de columnas debe ser menor o igual a " + m + " y mayor que 0, ingrese nuevamente: ");
            subM = in.nextInt();
        }
        
        boolean[][] subMatriz = new boolean[subN][subM];

        System.out.println("Ingrese los elementos de la submatriz (0 para false, cualquier otro numero para true): ");

        for (int i = 0; i < subN; i++) {
            for (int j = 0; j < subM; j++) {
                subMatriz[i][j] = in.nextInt() != 0;
            }
        }

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
}