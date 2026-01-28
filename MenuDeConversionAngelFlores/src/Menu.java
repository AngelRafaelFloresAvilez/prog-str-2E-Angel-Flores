import java.util.Scanner;
public class Menu {

    public static double DIFERENCIA_CELCIUS_FARENHEIT = 1.8;
    public static double DESPLAZAMIENTO_GRADOS = 32;
    public static double DISTANCIA_MILLAS = 1.60934;
    public static double DISTANCIA_KILOMETROS = 1.60934;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int opcionMenuSwitch;
        double gradosCelsius = 0.0;
        double gradosFarenheit = 0.0;
        double distanciaKilometros = 0.0;
        double distanciaMillas = 0.0;
        int contadorFarenheit = 0;
        int contadorCelsius = 0;
        int contadorMillas = 0;
        int contadorKm = 0;

        do {
            System.out.println("---------- Menu ----------");
            System.out.println("1. Convertir °C a °F");
            System.out.println("2. Convertir °F a °C");
            System.out.println("3. Convertir Km a Millas");
            System.out.println("4. Convertir Millas a Km");
            System.out.println("5. Salir");
            System.out.print("Ingresa tu opcion (1 - 5): ");

            while (!sc.hasNextInt()) {
                System.out.println("El valor que ingresaste es invalido, intenta de nuevo.");
                System.out.println("Ingresa tu opcion (1 - 5): ");
                sc.next();
            }

            opcionMenuSwitch = sc.nextInt();

            switch (opcionMenuSwitch) {
                case 1:
                    System.out.println("Seleccionaste Opcion A - Convertir °C a °F");
                    gradosCelsius = obtenerDouble(sc,"Ingresa los grados en Celsius (ej. 27): ");
                    gradosFarenheit = conversionCelsiusFarenheit(gradosCelsius);
                    System.out.println("La conversión de Celsius a Farenheit es de: " + gradosFarenheit);
                    contadorFarenheit = contadorFarenheit + 1;
                    break;
                case 2:
                    System.out.println("Seleccionaste Option B - Convertir °F a °C");
                    gradosFarenheit = obtenerDouble(sc,"Ingresa los grados en Farenheit (ej. 44): ");
                    gradosCelsius = conversionFarenheitCelsius(gradosFarenheit);
                    System.out.println("La conversión de Farenheit a Celsius es de: " + gradosCelsius);
                    contadorCelsius = contadorCelsius + 1;
                    break;
                case 3:
                    System.out.println("Seleccionaste Option C - Convertir Km a Millas");
                    distanciaKilometros = obtenerDouble(sc,"Ingresa la distancia en kilometros (ej. 88): ");
                    distanciaMillas = conversionKilometrosMillas(distanciaKilometros);
                    System.out.println("La conversión de Kilometros a Millas es de: " + distanciaMillas);
                    contadorMillas = contadorMillas + 1;
                    break;
                case 4:
                    System.out.println("Seleccionaste Option D - Convertir Millas a Km");
                    distanciaMillas = obtenerDouble(sc,"Ingresa la distancia en millas (ej. 38): ");
                    distanciaKilometros = conversionMillasKilometros(distanciaMillas);
                    System.out.println("La conversión de millas a kilometros es de: " + distanciaKilometros);
                    contadorKm = contadorKm + 1;
                    break;
                case 5:
                    System.out.println("Seleccionaste Salir");

                    System.out.println("Total de conversiones realizadas : " + (contadorCelsius + contadorFarenheit + contadorKm + contadorMillas));
                    System.out.println("Convertiste de Celsius a Farenheit " + contadorFarenheit + " veces.");
                    System.out.println("Convertiste de Farenheit a Celsius " + contadorCelsius + " veces.");
                    System.out.println("Convertiste de Kilometros a Millas " + contadorMillas + " veces.");
                    System.out.println("Convertiste de Millas a Kilometros " + contadorKm + " veces.");


                    break;
                default:
                    System.out.println("Opcion incorrecta, vuelve a intentarlo");
            }
        } while (opcionMenuSwitch != 5);
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

    /**
     * Metodo que convierte de grados celcius a farenheit
     * @param gradosCelsius -> El valor de los grados Celsius ingresado por el usuario
     * @return -> Regresa el valor calculado y transformado de celcius a farenheit
     */
    public static double conversionCelsiusFarenheit(double gradosCelsius){
        return ((gradosCelsius * DIFERENCIA_CELCIUS_FARENHEIT) + DESPLAZAMIENTO_GRADOS);
    }
    /**
     * Metodo que convierte de grados farenheit a celsius
     * @param gradosFarenheit -> El valor de los grados farenheit ingresado por el usuario
     * @return -> Regresa el valor calculado y transformado de farenheit a celsius
     */
    public static double conversionFarenheitCelsius(double gradosFarenheit){
        return ((gradosFarenheit - DESPLAZAMIENTO_GRADOS) / DIFERENCIA_CELCIUS_FARENHEIT);
    }
    /**
     * Metodo que convierte de kilometros a millas
     * @param distanciaKilometros -> El valor de los la distancia en kilometros ingresado por el usuario
     * @return -> Regresa el valor calculado y transformado de kilometros a millas
     */
    public static double conversionKilometrosMillas(double distanciaKilometros){
        return (distanciaKilometros / DISTANCIA_MILLAS);
    }
    /**
     * Metodo que convierte de millas a kilometros
     * @param distanciaMillas -> El valor de los la distancia en millas ingresado por el usuario
     * @return -> Regresa el valor calculado y transformado de millas a kilometros
     */
    public static double conversionMillasKilometros(double distanciaMillas){
        return (distanciaMillas * DISTANCIA_KILOMETROS);
    }
}

