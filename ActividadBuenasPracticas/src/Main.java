import java.util.Scanner;
public class Main {
    public static int inicializador = 0;
    public static void main(String[] args){
        Scanner scannerUsuario = new Scanner(System.in);
        int sumaConteo = inicializador;
        System.out.println("Programa para calcular la suma acumulada en base a un valor ingresado por el usuario.");
        int numeroUsuario = pedirEntero(scannerUsuario,"Ingresa un numero entero : ");
        int resultadoSuma = sumarHastaN(sumaConteo, numeroUsuario);
        System.out.println("El resultado de la suma acumulada es : " + resultadoSuma);
    }
    /**
     * Metodo que obtiene el numero que el usuario ingrese
     * @param scannerUsuario -> Objeto de parte del import Scanner para leer variables ingresadas
     * @param mensaje -> El texto que se mostrara y proveniente de println
     * @return -> Regresa el valor leido del usuario
     */
    public static int pedirEntero(Scanner scannerUsuario, String mensaje){
        System.out.println(mensaje);
        return scannerUsuario.nextInt();
    }
    /**
     * Metodo que calcula la suma de los antecesores al numero ingresado por el usuario mas el ingresado
     *
     * @param sumaConteo    -> Almacena el resultado de la suma realizada por el If
     * @param numeroUsuario -> Es el numero ingresado por el usuario previamente procesado en el metodo anterior
     * @return -> Regresa el resultado de la suma
     */
    public static int sumarHastaN(int sumaConteo, int numeroUsuario){
        int contador;
        for(contador = inicializador; contador <= numeroUsuario; contador++){
            sumaConteo += contador;
        }
        return sumaConteo;
    }
}