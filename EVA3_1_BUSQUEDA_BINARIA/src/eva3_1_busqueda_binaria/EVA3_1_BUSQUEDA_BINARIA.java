package eva3_1_busqueda_binaria;

import java.util.Scanner;

/**
 *
 * @author anacr
 */
public class EVA3_1_BUSQUEDA_BINARIA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] datos = new int[20];
        llenar(datos);
        System.out.println("PRUEBA CON SELECTION SORT: ");

        imprimir(datos);
        selectionSort(datos);
        imprimir(datos);
        Scanner input = new Scanner(System.in);
        System.out.println("\nValor a buscar: ");
        int valor = input.nextInt();
        int iResu = binarySearch(datos, valor);
        System.out.println("El elemento esta en la posición: " + iResu);

    }

    public static void llenar(int[] datos) {
        for (int i = 0; i < datos.length; i++) {
            datos[i] = (int) (Math.random() * 100);
        }
    }

    public static void imprimir(int[] datos) {
        System.out.println("");
        for (int i = 0; i < datos.length; i++) {
            System.out.print("[" + datos[i] + "]");
        }
    }

public static void selectionSort(int[] datos) {
        for (int i = 0; i < datos.length; i++) {
            int iMin = i; //EMPIEZA EL ALGORITMO, EL MINIMO ES EL PRIMER ELEMENTO 
            for (int j = i + 1; j < datos.length; j++) { //BUSCAR POSICION DEL MAS PEQUEÑO
                //COMPARAR
                if (datos[j] < datos[iMin]) {//COMPARO ACTUAL CONTRA MINIMO 
                    iMin = j;
                }
                //SWAP
                if (i != iMin) {
                    //3 PASOS (1. RESPALDAR VALOR, 2. INTERCAMBIAR Y 3.REPONER EL VALOR RESPALDADO)
                    //1.
                    int iTemp = datos[i];
                    //2.
                    datos[i] = datos[iMin];
                    //3.
                    datos[iMin] = iTemp;
                }
            }
        }
    }

    //BUSQUEDA BINARIA RECURSIVA O(LogN)
    public static int binarySearch(int[] datos, int valBuscar) {
        return binarySearchRecu(datos, valBuscar, 0, datos.length - 1);
    }

    private static int binarySearchRecu(int[] datos, int valBuscar, int ini, int fin) {
        int iMid, iResu;
        iMid = ini + ((fin - ini) / 2); //Posición a la mitad de la busqueda
        iResu = -1; //SI EL VALOR NO EXISTE REGRESAMOS -1
        if (fin >= ini) { //Buscamos
            if (valBuscar == datos[iMid]) { //EL valor esta a la mitad 
                iResu = iMid; //Aqui esta valor y lo regresmaos 

            } else if (valBuscar < datos[iMid]) { //NO esta a la mitad, pero puede estar en la izq
                iResu = binarySearchRecu(datos, valBuscar, ini, iMid - 1);
            } else {//NO esta a la mitad, pero puede estar a la der
                iResu = binarySearchRecu(datos, valBuscar, iMid + 1, fin);
            }
        } //Se detiene el proceso 
        return iResu;

    }

}
