import java.util.Random;
import java.util.Scanner;

public class Main {

    static int MAX_FIL_YODA = 10;
    static int MAX_COL_YODA = 10;
    static int MAX_FIL_DM = 10;
    static int MAX_COL_DM = 10;

    static void imprimirTableroYoda(char[][] tableroYoda) {
        for (int fila = 0; fila < MAX_FIL_YODA; fila++) {
            for (int columna = 0; columna < MAX_COL_YODA; columna++) {
                System.out.print(tableroYoda[fila][columna] + " ");
            }
            System.out.println();
        }
    }

    static void imprimirTableroDM(char[][] tableroDM) {
        for (int fila = 0; fila < MAX_FIL_DM; fila++) {
            for (int columna = 0; columna < MAX_COL_DM; columna++) {
                System.out.print(tableroDM[fila][columna] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // DEFINIR VARIABLES
        char YODA = 'Y';
        char LIBRE = 'L';
        char DM = 'D';
        char MURO = 'M';
        char VADER = 'V';
        char POCIMA = 'P';

        boolean yodaActive = true;
        boolean dmActive = false;

        int vidasYoda = 10;
        int vidasDM = 10;

        boolean objetoYodaElegido = false;
        boolean objetoDMElegido = false;

        // TABLEROS
        char[][] tableroYoda = new char[MAX_FIL_YODA][MAX_COL_YODA];
        char[][] tableroDM = new char[MAX_FIL_DM][MAX_COL_DM];

        Random aleat = new Random();

        int filaAl;
        int colAl;

        // ================= TABLERO YODA =================

        for (int i = 0; i < MAX_FIL_YODA; i++) {
            for (int j = 0; j < MAX_COL_YODA; j++) {
                tableroYoda[i][j] = LIBRE;
            }
        }

        // COLOCAR YODA
        do {
            filaAl = aleat.nextInt(MAX_FIL_YODA);
            colAl = aleat.nextInt(MAX_COL_YODA);
        } while (tableroYoda[filaAl][colAl] != LIBRE);

        tableroYoda[filaAl][colAl] = YODA;

        int filaOficialYoda = filaAl;
        int columnaOficialYoda = colAl;

        // COLOCAR MUROS
        for (int i = 0; i < 10; i++) {
            do {
                filaAl = aleat.nextInt(MAX_FIL_YODA);
                colAl = aleat.nextInt(MAX_COL_YODA);
            } while (tableroYoda[filaAl][colAl] != LIBRE);

            tableroYoda[filaAl][colAl] = MURO;
        }

        // COLOCAR VADERS
        for (int i = 0; i < 7; i++) {
            do {
                filaAl = aleat.nextInt(MAX_FIL_YODA);
                colAl = aleat.nextInt(MAX_COL_YODA);
            } while (tableroYoda[filaAl][colAl] != LIBRE);

            tableroYoda[filaAl][colAl] = VADER;
        }

        // COLOCAR POCIMAS
        for (int i = 0; i < 5; i++) {
            do {
                filaAl = aleat.nextInt(MAX_FIL_YODA);
                colAl = aleat.nextInt(MAX_COL_YODA);
            } while (tableroYoda[filaAl][colAl] != LIBRE);

            tableroYoda[filaAl][colAl] = POCIMA;
        }

        // ================= TABLERO DM =================

        for (int i = 0; i < MAX_FIL_DM; i++) {
            for (int j = 0; j < MAX_COL_DM; j++) {
                tableroDM[i][j] = LIBRE;
            }
        }

        // COLOCAR DM
        do {
            filaAl = aleat.nextInt(MAX_FIL_DM);
            colAl = aleat.nextInt(MAX_COL_DM);
        } while (tableroDM[filaAl][colAl] != LIBRE);

        tableroDM[filaAl][colAl] = DM;

        int filaOficialDM = filaAl;
        int columnaOficialDM = colAl;

        // COLOCAR MUROS
        for (int i = 0; i < 10; i++) {
            do {
                filaAl = aleat.nextInt(MAX_FIL_DM);
                colAl = aleat.nextInt(MAX_COL_DM);
            } while (tableroDM[filaAl][colAl] != LIBRE);

            tableroDM[filaAl][colAl] = MURO;
        }

        // COLOCAR VADERS
        for (int i = 0; i < 7; i++) {
            do {
                filaAl = aleat.nextInt(MAX_FIL_DM);
                colAl = aleat.nextInt(MAX_COL_DM);
            } while (tableroDM[filaAl][colAl] != LIBRE);

            tableroDM[filaAl][colAl] = VADER;
        }

        // COLOCAR POCIMAS
        for (int i = 0; i < 5; i++) {
            do {
                filaAl = aleat.nextInt(MAX_FIL_DM);
                colAl = aleat.nextInt(MAX_COL_DM);
            } while (tableroDM[filaAl][colAl] != LIBRE);

            tableroDM[filaAl][colAl] = POCIMA;
        }

        // ================= EMPIEZA EL JUEGO =================

        Scanner lector = new Scanner(System.in);

        System.out.println("EMPIEZA EL JUEGO!!");

        do {

            // ================= TURNO YODA =================

            if (yodaActive && !dmActive) {

                System.out.println("TABLERO YODA (vidas: " + vidasYoda + ")");
                imprimirTableroYoda(tableroYoda);

                // POSICION DE RESPALDO
                int filaAnteriorYoda = filaOficialYoda;
                int colAnteriorYoda = columnaOficialYoda;

                char mov;
                boolean movido = false;

                // ELEGIR OBJETO UNA SOLA VEZ
                if (!objetoYodaElegido) {

                    System.out.println("ELIGE UNO DE ESTOS TRES OBJETOS:");
                    System.out.println("1. +1 VIDA");
                    System.out.println("2. MOVIMIENTO DIAGONAL");
                    System.out.println("3. PREGUNTA (+2 VIDAS)");

                    int objeto = lector.nextInt();

                    if (objeto == 1) {
                        vidasYoda = vidasYoda + 1;
                        System.out.println("HAS CONSEGUIDO +1 VIDA");
                    }

                    if (objeto == 2) {

                        System.out.println("Te mueves con QEZC");
                        System.out.println("Dime una letra de movimiento:");

                        mov = lector.next().toUpperCase().charAt(0);

                        switch (mov) {
                            case 'Q':
                                filaOficialYoda = filaOficialYoda - 1;
                                columnaOficialYoda = columnaOficialYoda - 1;
                                movido = true;
                                break;
                            case 'E':
                                filaOficialYoda = filaOficialYoda - 1;
                                columnaOficialYoda = columnaOficialYoda + 1;
                                movido = true;
                                break;
                            case 'Z':
                                filaOficialYoda = filaOficialYoda + 1;
                                columnaOficialYoda = columnaOficialYoda - 1;
                                movido = true;
                                break;
                            case 'C':
                                filaOficialYoda = filaOficialYoda + 1;
                                columnaOficialYoda = columnaOficialYoda + 1;
                                movido = true;
                                break;
                        }
                    }

                    if (objeto == 3) {
                        System.out.println("¿CUANTO ES 5!?");
                        int respuesta = lector.nextInt();

                        if (respuesta == 25) {
                            vidasYoda = vidasYoda + 2;
                            System.out.println("HAS ACERTADO +2 VIDAS");
                        } else {
                            System.out.println("HAS FALLADO");
                        }
                    }

                    objetoYodaElegido = true;
                }

                // MOVIMIENTO NORMAL (si no se movio en diagonal)
                if (!movido) {

                    System.out.println("Te mueves con WASD");
                    System.out.println("Dime una letra de movimiento:");

                    mov = lector.next().toUpperCase().charAt(0);

                    switch (mov) {
                        case 'W':
                            filaOficialYoda = filaOficialYoda - 1;
                            break;
                        case 'A':
                            columnaOficialYoda = columnaOficialYoda - 1;
                            break;
                        case 'S':
                            filaOficialYoda = filaOficialYoda + 1;
                            break;
                        case 'D':
                            columnaOficialYoda = columnaOficialYoda + 1;
                            break;
                    }
                }

                // COMPROBAR LIMITES
                if (filaOficialYoda < 0 ||
                        filaOficialYoda > 9 ||
                        columnaOficialYoda < 0 ||
                        columnaOficialYoda > 9) {

                    System.out.println("LIMITE DE TABLERO!!");

                    filaOficialYoda = filaAnteriorYoda;
                    columnaOficialYoda = colAnteriorYoda;

                } else {

                    if (tableroYoda[filaOficialYoda][columnaOficialYoda] == MURO) {

                        System.out.println("NO PUEDES PASAR!!");

                        filaOficialYoda = filaAnteriorYoda;
                        columnaOficialYoda = colAnteriorYoda;

                    } else if (tableroYoda[filaOficialYoda][columnaOficialYoda] == POCIMA) {

                        tableroYoda[filaOficialYoda][columnaOficialYoda] = YODA;
                        tableroYoda[filaAnteriorYoda][colAnteriorYoda] = LIBRE;

                        System.out.println("¿CUANTO ES 1+1?");
                        int pregunta = lector.nextInt();

                        if (pregunta == 2) {
                            vidasYoda = vidasYoda + 1;
                            System.out.println("HAS ACERTADO +1 VIDA");
                        } else {
                            vidasYoda = vidasYoda - 1;
                            System.out.println("HAS FALLADO -1 VIDA");
                        }

                    } else if (tableroYoda[filaOficialYoda][columnaOficialYoda] == VADER) {

                        tableroYoda[filaOficialYoda][columnaOficialYoda] = YODA;
                        tableroYoda[filaAnteriorYoda][colAnteriorYoda] = LIBRE;

                        vidasYoda--;

                    } else if (tableroYoda[filaOficialYoda][columnaOficialYoda] == LIBRE) {

                        tableroYoda[filaOficialYoda][columnaOficialYoda] = YODA;
                        tableroYoda[filaAnteriorYoda][colAnteriorYoda] = LIBRE;
                    }
                }

                // CAMBIO DE TURNO
                yodaActive = false;
                dmActive = true;

                // ================= TURNO DARTH MAUL =================

            } else {

                System.out.println("TABLERO DM (vidas: " + vidasDM + ")");
                imprimirTableroDM(tableroDM);

                // POSICION DE RESPALDO
                int filaAnteriorDM = filaOficialDM;
                int colAnteriorDM = columnaOficialDM;

                char mov;
                boolean movido = false;

                // ELEGIR OBJETO UNA SOLA VEZ
                if (!objetoDMElegido) {

                    System.out.println("ELIGE UNO DE ESTOS TRES OBJETOS:");
                    System.out.println("1. +1 VIDA");
                    System.out.println("2. MOVIMIENTO DIAGONAL");
                    System.out.println("3. PREGUNTA (+2 VIDAS)");

                    int objeto = lector.nextInt();

                    if (objeto == 1) {
                        vidasDM = vidasDM + 1;
                        System.out.println("HAS CONSEGUIDO +1 VIDA");
                    }

                    if (objeto == 2) {

                        System.out.println("Te mueves con QEZC");
                        System.out.println("Dime una letra de movimiento:");

                        mov = lector.next().toUpperCase().charAt(0);

                        switch (mov) {
                            case 'Q':
                                filaOficialDM = filaOficialDM - 1;
                                columnaOficialDM = columnaOficialDM - 1;
                                movido = true;
                                break;
                            case 'E':
                                filaOficialDM = filaOficialDM - 1;
                                columnaOficialDM = columnaOficialDM + 1;
                                movido = true;
                                break;
                            case 'Z':
                                filaOficialDM = filaOficialDM + 1;
                                columnaOficialDM = columnaOficialDM - 1;
                                movido = true;
                                break;
                            case 'C':
                                filaOficialDM = filaOficialDM + 1;
                                columnaOficialDM = columnaOficialDM + 1;
                                movido = true;
                                break;
                        }
                    }

                    if (objeto == 3) {
                        System.out.println("¿CUANTO ES 5!?");
                        int respuesta = lector.nextInt();

                        if (respuesta == 25) {
                            vidasDM = vidasDM + 2;
                            System.out.println("HAS ACERTADO +2 VIDAS");
                        } else {
                            System.out.println("HAS FALLADO");
                        }
                    }

                    objetoDMElegido = true;
                }

                // MOVIMIENTO NORMAL (si no se movio en diagonal)
                if (!movido) {

                    System.out.println("Te mueves con WASD");
                    System.out.println("Dime una letra de movimiento:");

                    mov = lector.next().toUpperCase().charAt(0);

                    switch (mov) {
                        case 'W':
                            filaOficialDM = filaOficialDM - 1;
                            break;
                        case 'A':
                            columnaOficialDM = columnaOficialDM - 1;
                            break;
                        case 'S':
                            filaOficialDM = filaOficialDM + 1;
                            break;
                        case 'D':
                            columnaOficialDM = columnaOficialDM + 1;
                            break;
                    }
                }

                // COMPROBAR LIMITES
                if (filaOficialDM < 0 ||
                        filaOficialDM > 9 ||
                        columnaOficialDM < 0 ||
                        columnaOficialDM > 9) {

                    System.out.println("LIMITE DE TABLERO!!");

                    filaOficialDM = filaAnteriorDM;
                    columnaOficialDM = colAnteriorDM;

                } else {

                    if (tableroDM[filaOficialDM][columnaOficialDM] == MURO) {

                        System.out.println("NO PUEDES PASAR!!");

                        filaOficialDM = filaAnteriorDM;
                        columnaOficialDM = colAnteriorDM;

                    } else if (tableroDM[filaOficialDM][columnaOficialDM] == POCIMA) {

                        tableroDM[filaOficialDM][columnaOficialDM] = DM;
                        tableroDM[filaAnteriorDM][colAnteriorDM] = LIBRE;

                        System.out.println("¿CUANTO ES (9*9)+9?");
                        int pregunta2 = lector.nextInt();

                        if (pregunta2 == 90) {
                            vidasDM = vidasDM + 1;
                            System.out.println("HAS ACERTADO +1 VIDA");
                        } else {
                            vidasDM = vidasDM - 1;
                            System.out.println("HAS FALLADO -1 VIDA");
                        }

                    } else if (tableroDM[filaOficialDM][columnaOficialDM] == VADER) {

                        tableroDM[filaOficialDM][columnaOficialDM] = DM;
                        tableroDM[filaAnteriorDM][colAnteriorDM] = LIBRE;

                        vidasDM--;

                    } else if (tableroDM[filaOficialDM][columnaOficialDM] == LIBRE) {

                        tableroDM[filaOficialDM][columnaOficialDM] = DM;
                        tableroDM[filaAnteriorDM][colAnteriorDM] = LIBRE;
                    }
                }

                // CAMBIO DE TURNO
                yodaActive = true;
                dmActive = false;
            }

        } while (vidasYoda > 0 && vidasDM > 0);

        // ================= FIN DEL JUEGO =================

        System.out.println("FIN DEL JUEGO");

        if (vidasYoda <= 0) {
            System.out.println("DARTH MAUL HA GANADO");
        } else {
            System.out.println("YODA HA GANADO");
        }

        System.out.println("TABLERO YODA");
        imprimirTableroYoda(tableroYoda);

        System.out.println("TABLERO DM");
        imprimirTableroDM(tableroDM);

        lector.close();
    }
}
