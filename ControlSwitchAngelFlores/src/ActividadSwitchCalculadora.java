import java.util.Scanner;
public class ActividadSwitchCalculadora {
    public static void main(String[] args) {
        double resultadoOperacion = 0;
        String opcionElegida = "";
        Scanner sc = new Scanner(System.in);

        System.out.println("1) Sumar");
        System.out.println("2) Restar");
        System.out.println("3) Multiplicar");
        System.out.println("4) Dividir");

        int opcion = obtenerInt(sc,"Ingresa tu opción: ");

        if(opcion >= 1 && opcion <= 4){
            double variableA = obtenerDouble(sc,"Ingresa el primer numero: ");
            double variableB = obtenerDouble(sc,"Ingresa el segundo numero: ");


            if (variableB == 0) {
                System.out.println("No se puede dividir entre cero");
                return;
            } else {
                switch (opcion){
                    case 1:
                        System.out.println("Operación : Suma");
                        opcionElegida = "suma";
                        resultadoOperacion = variableA + variableB;
                        break;
                    case 2:
                        System.out.println("Operación : Resta");
                        opcionElegida = "Rresta";
                        resultadoOperacion = variableA - variableB;
                        break;
                    case 3:
                        System.out.println("Operación : Multiplicación");
                        opcionElegida = "multiplicación";
                        resultadoOperacion = variableA * variableB;
                        break;
                    case 4:
                        System.out.println("Operación : División");
                        opcionElegida = "división";
                        resultadoOperacion = variableA / variableB;
                        break;
                }
                System.out.println("La operación elegida fue una " + opcionElegida);
                System.out.println("Ingresaste el número " + variableA + " y el número " + variableB);
                System.out.println("El resultado de la " + opcionElegida + " es " + resultadoOperacion);

            }
        }else{
            System.out.println("Opción inválida");
            return;
        }

    }

    /**
     * Metodo que obtiene el valor ingresado por el usuario
     * @param sc -> El objeto para poder leer lo que escriba el usuario
     * @param mensaje -> El texto que se mostrara y proveniente de println
     * @return -> Regresa el valor leido del usuario
     */
    public static int obtenerInt(Scanner sc, String mensaje){
        System.out.println(mensaje);
        return sc.nextInt();
    }
    /**
     * Metodo que obtiene el valor ingresado por el usuario
     * @param sc -> El objeto para poder leer lo que escriba el usuario
     * @param mensaje -> El texto que se mostrara y proveniente de println
     * @return -> Regresa el valor leido del usuario
     */
    public static double obtenerDouble(Scanner sc, String mensaje){
        System.out.println(mensaje);
        return sc.nextDouble();
    }
}