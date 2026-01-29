import java.util.Random;
import java.util.Scanner;
public class Adivina {
    public static int MAX_EXCEDIDO = 0;
    public static int MIN_EXCEDIDO = 0;
    public static int NO_NUMERICO = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int valorMinimo = 1;
        int valorMaximo = 100;
        int cantidadIntentos = 0;
        int limiteIntentos = 7;
        int secreto = random.nextInt(valorMaximo) + valorMinimo;
        boolean jugadorGano = false;
        System.out.println("--- Juego : Adivina el numero ---");
        System.out.println("Adivina el numero ingresando numeros del 1 al 100 mientras aun tengas intentos, el juego te dira si es mayor o menor.");
        System.out.println("Tienes " + limiteIntentos + " intentos. ¡Suerte!");
        while(cantidadIntentos < limiteIntentos && !jugadorGano){
            int valor = obtenerNumeroValido (valorMinimo, valorMaximo, scanner, "Intento No. " + (cantidadIntentos + 1) + ": ");
            cantidadIntentos++;
            if(valor == secreto) {
                System.out.println("¡Ganaste! Los itnentos realizados en total fueron de " + cantidadIntentos + " intentos.");
                System.out.println("Excediste el mayor " + MAX_EXCEDIDO + " veces.");
                System.out.println("Estabas por debajo del minimo " + MIN_EXCEDIDO + " veces.");
                System.out.println("Ingresaste un valor no numerico " + NO_NUMERICO + " veces.");
                jugadorGano = true;
            } else if(valor > secreto) {
                System.out.println("El numero secreto es menor al ingresado, ¡intenta nuevamente!");
            } else{
                System.out.println("El numero secreto es mayor al ingresado, ¡intenta nuevamente!");
            }
        }
        if (!jugadorGano) {
            System.out.println("Perdiste, el numero secreto era " + secreto + ".");
            System.out.println("Excediste el mayor " + MAX_EXCEDIDO + " veces.");
            System.out.println("Estabas por debajo del minimo " + MIN_EXCEDIDO + " veces.");
            System.out.println("Ingresaste un valor no numerico " + NO_NUMERICO + " veces.");
        }
        scanner.close();
    }
    /**
     * Metodo que obtiene el valor ingresado por el usuario y comprueba si es mayor o menor al limite y si es un valor numerico entero
     * @param valorMinimo -> El minimo permitido por el codigo para el valor
     * @param valorMaximo -> El maximo permitido por el codigo para el valor
     * @param scanner -> El que lee el valor igresado por el usuario
     * @param mensaje -> El mensaje para que el usuario sepa que hacer
     * @return -> Regresa el valor leido del usuario ya comprobado
     */
    public static int obtenerNumeroValido(int valorMinimo, int valorMaximo, Scanner scanner, String mensaje){
        int valor;
        while (true) {
            System.out.print(mensaje);
            if (scanner.hasNextInt()) {
                valor = scanner.nextInt();
                if (valor >= valorMinimo && valor <= valorMaximo) {
                    return valor;
                }else {
                    if (valor > valorMaximo) {
                        System.out.println("El numero que ingresaste excedio el mayor, intenta nuevamente.");
                        MAX_EXCEDIDO++;
                    } else if (valor < 1) {
                        System.out.println("El numero que ingresaste esta por debajo del menor, intenta nuevamente.");
                        MIN_EXCEDIDO++;
                    }
                }
            } else {
                System.out.println("El dato ingresado no es un numero, intenta de nuevo con un verdadero numero (sin fracciones o decimales).");
                NO_NUMERICO++;
                scanner.next();
            }
        }
    }
}