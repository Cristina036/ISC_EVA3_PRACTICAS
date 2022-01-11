package eva3_1_ordenamientos;

/**
 *
 * @author anacr
 */
public class EVA3_1_ORDENAMIENTOS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Ordenar
        int[] datos = new int[20];
        int[] copiaSel = new int[datos.length];
        int[] copiaIns = new int[datos.length];
        int[] copiaBubble = new int[datos.length];
        int[] copiaQuickSort = new int[datos.length];
        long iniT, finT;

        llenar(datos);

        System.out.println("PRUEBA CON INSERTION SORT: ");
        duplicar(datos, copiaSel);
        imprimir(copiaSel);
        iniT = System.nanoTime(); //TIEMPO ANTES DE EMPEZAR MÉTODO
        //Lo ordenamos
        selectionSort(copiaSel);
        finT = System.nanoTime();//TIEMPO AL TERMINAR MÉTODO
        imprimir(copiaSel);
        System.out.println("\nTiempo en ordenar: " + (finT - iniT));

        System.out.println("\nPRUEBA CON SELECTION SORT: ");
        duplicar(datos, copiaIns);
        imprimir(copiaIns);
        iniT = System.nanoTime(); //TIEMPO ANTES DE EMPEZAR MÉTODO
        //Lo ordenamos
        insertionSort(copiaIns);
        finT = System.nanoTime();//TIEMPO AL TERMINAR MÉTODO
        imprimir(copiaIns);
        System.out.println("\nTiempo en ordenar: " + (finT - iniT));

        System.out.println("\nPRUEBA CON BUBBLE SORT: ");
        duplicar(datos, copiaBubble);
        imprimir(copiaBubble);
        iniT = System.nanoTime(); //TIEMPO ANTES DE EMPEZAR MÉTODO
        //Lo ordenamos
        bubbleSort(copiaBubble);
        finT = System.nanoTime();//TIEMPO AL TERMINAR MÉTODO
        imprimir(copiaBubble);
        System.out.println("\nTiempo en ordenar: " + (finT - iniT));

        System.out.println("\nPRUEBA CON QUICK SORT: ");
        duplicar(datos, copiaQuickSort);
        imprimir(copiaQuickSort);
        iniT = System.nanoTime(); //TIEMPO ANTES DE EMPEZAR MÉTODO
        //Lo ordenamos
        quickSort(copiaQuickSort);
        finT = System.nanoTime();//TIEMPO AL TERMINAR MÉTODO
        imprimir(copiaQuickSort);
        System.out.println("\nTiempo en ordenar: " + (finT - iniT));
    }
    //Llenado de arreglo

    public static void llenar(int[] datos) {
        for (int i = 0; i < datos.length; i++) {
            datos[i] = (int) (Math.random() * 100);
        }
    }

    //Duplicar arreglo(arreglos del mismo tamaño)
    public static void duplicar(int[] datos, int[] copia) {
        for (int i = 0; i < datos.length; i++) {
            copia[i] = datos[i];
        }
    }
    //Copia del arreglo
    //Imprimir arreglo 

    public static void imprimir(int[] datos) {
        System.out.println("");
        for (int i = 0; i < datos.length; i++) {
            System.out.print("[" + datos[i] + "]");
        }
    }
//O(N^2)

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

    public static void insertionSort(int[] datos) {
        for (int i = 1; i < datos.length; i++) { //CONTROLA Arreglo[i]
            int temp = datos[i]; //Valor a insertar 
            int insP = i; //posición donde vamos a insertar
            for (int prev = i - 1; prev >= 0; prev--) { //Buscar donde insertar
                if (datos[prev] > temp) {
                    datos[insP] = datos[prev]; //Movemos valor de previo a la posición de insP
                    insP--; //Restrocede una posición     
                } else {
                    break;
                }
            }//Insertamos
            datos[insP] = temp;

        }
    }//N^2

    public static void bubbleSort(int[] datos) {
        for (int i = 0; i < datos.length; i++) { //PASADAS
            for (int j = 0; j < (datos.length - 1); j++) { //COMPARA E INTERCAMBIA
                //Comparamos j vs j+1
                if (datos[j] > datos[j + 1]) {
                    //Intercambiamos
                    int temp = datos[j];
                    datos[j] = datos[j + 1];
                    datos[j + 1] = temp;
                }

            }
        }
    } //QuickSort de arranque

    public static void quickSort(int[] datos) { //O(NlogN) Logaritmo base 2
        quickSortRecu(datos, 0, datos.length - 1); //QuickSort a todo el arreglo
    }

    public static void quickSortRecu(int[] datos, int ini, int fin) {
        int iPivote; //inicio
        int too_big;//Busca mas grandes que pivote
        int too_small; //Busca mas pequeños que pivote
        boolean stopBig = false, stopSmall = false;
        //control recursividad
        int tama = fin - ini + 1;
        if (tama > 1) { //¿Cuando si puedo realizar quikSort?
            iPivote = ini;
            too_big = ini + 1;
            too_small = fin;
            for (int i = ini + 1; i <= fin; i++) {
                if ((datos[too_big] < datos[iPivote]) && (!stopBig)) { //Avanzo
                    too_big++;
                } else {
                    stopBig = true;//Me detengo cuando encuentro uno más grande 
                }
                if ((datos[too_small] >= datos[iPivote]) && (!stopSmall)) { //Avanzo
                    too_small--;
                } else {
                    stopSmall = true;//Me detengo cuando encuentro uno más grande 
                }
                //Ambos se detienen (swap)
                if (stopBig && stopSmall) {
                    if (too_big < too_small) { //Intercambio
                        int temp = datos[too_big];
                        datos[too_big] = datos[too_small];
                        datos[too_small] = temp;
                        stopBig = false;
                        stopSmall = false; //Seguir avanzando                   
                    } else {
                        break;//Terminamos el ciclo  
                    }
                }
            }
            //Intercambio del pivote
            int temp = datos[iPivote];
            datos[iPivote] = datos[too_small];
            datos[too_small] = temp;
            iPivote = too_small;//Tambien cambia posición del pivote
//QuickSort izq
            quickSortRecu(datos, ini, iPivote-1);
//QuickSort der
            quickSortRecu(datos, iPivote + 1, fin);
        }
    }

}
