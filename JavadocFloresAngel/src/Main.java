import java.util.Scanner;
public class Main {
    public static double CLASIFICACION_BAJA = 18.5;
    public static double CLASIFICACION_MEDIA = 25;
    public static double CLASIFICACION_ALTA = 30;

    // Esta variable se llama asi por que en Celcius el agua se congela en °0 e hierve en °100,
    // (diferencia de 100 unidades), mientrras que en Farenheit la diferencia es de °180 (180 divido en 100 = 1.8).
    public static double DIFERENCIA_CELCIUS_FARENHEIT = 1.8;
    // Esta variable se llama asi por el punto de congelación en Celcius (°0) y Farenheit (°32),
    // una diferencia de 32 unidades.
    public static double DESPLAZAMIENTO_GRADOS = 32;

    public static double PI = 3.1416;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcionMenuSwitch;
        do {
            System.out.println("---------- Menu ----------");
            System.out.println("1. Option A - Calcular IMC");
            System.out.println("2. Option B - Calcular área de un rectángulo");
            System.out.println("3. Option C - Convertir °C a °F");
            System.out.println("4. Option D - calcular area de un circulo");
            System.out.println("5. Salir");
            System.out.print("Ingresa tu opcion (1 - 5): ");

            opcionMenuSwitch = sc.nextInt();
            switch (opcionMenuSwitch) {
                case 1:
                    System.out.println("Seleccionaste Opcion A - Calcular IMC");
                    double pesoKg = obtenerDouble(sc,"Ingresa el peso en Kilogramos (ej. 85):");
                    double alturaM = obtenerDouble(sc,"Ingresa la altura en metros (ej. 1.70):");
                    double IMC = calcularIMC(pesoKg, alturaM);
                    System.out.println("IMC: " + IMC);
                    String clasificacion = obtenerClasificicacionIMC(IMC);
                    System.out.println("!Yo te clasifico con " + clasificacion + "¡");
                    break;
                case 2:
                    System.out.println("Seleccionaste Option B - Calcular área de un rectángulo");
                    double baseRectangulo = obtenerDouble(sc,"Ingresa la base en cm (ej. 15):");
                    double alturaRectangulo = obtenerDouble(sc,"Ingresa la altura en cm (ej. 20):");
                    double areaRectangulo = calcularAreaRectangulo(baseRectangulo, alturaRectangulo);
                    System.out.println("La altura del rectangulo es de: " + areaRectangulo);
                    break;
                case 3:
                    System.out.println("Seleccionaste Option C - Convertir °C a °F");
                    double gradosCelsius = obtenerDouble(sc,"Ingresa los grados en Celsius (ej. 27):");
                    double gradosFarenheit = conversionCelsiusFarenheit(gradosCelsius);
                    System.out.println("La conversión de Celsius a Farenheit es de: " + gradosFarenheit);
                    break;
                case 4:
                    System.out.println("Seleccionaste Option D - calcular area de un circulo");
                    double radioCirculo = obtenerDouble(sc,"Ingresa el radio del cirulo en cm (ej. 33):");
                    double areaCirculo = obtenerAreaCirculo(radioCirculo);
                    System.out.println("El area del circulo es de: " + areaCirculo);
                    break;
                case 5:
                    System.out.println("Seleccionaste Salir");
                    break;
                default:
                    System.out.println("Opcion incorrecta, vuelve a intentarlo");
            }
        } while (opcionMenuSwitch != 5);
    }
    /**
     * Metodo que calcula y muestra la clasificacion del IMC en base al IMC calculado previamente
     * @param IMC -> Valor equivalente al IMC del usuario previamente calculado por otro metodo
     * @return -> Regresa la clasificación del calculo del IMC del usuario
     */
    public static String obtenerClasificicacionIMC(double IMC){
        if  (IMC < CLASIFICACION_BAJA) return "Peso Bajo";
        else if (IMC < CLASIFICACION_MEDIA) return "Peso Medio";
        else if (IMC < CLASIFICACION_ALTA) return "Sobrepeso";
        else return "Obesidad";
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
     * Metodo que calcula el IMC del usuario en base a su peso y altura mas adelante mencionados y usados
     * @param pesoKg -> Peso en kilgoramos del usuario
     * @param alturaM -> Altura en metros del usuario
     * @return -> Regresa el valor del IMC calculado en base a PesoKg y alturaM
     */
    public static double calcularIMC(double pesoKg, double alturaM){
        return pesoKg / (alturaM * alturaM);
    }
    /**
     * Metodo que calcula el area de un triangulo en base a la base y la altura usadas en centimetros
     * @param baseRectangulo -> Base del rectangulo a calcular en centimetros
     * @param alturaRectangulo -> Altura del rectangulo a calcular en centimetros
     * @return -> Regresa el valor del area del rectangulo en centimetros
     */
    public static double calcularAreaRectangulo(double baseRectangulo, double alturaRectangulo){
        return baseRectangulo * alturaRectangulo;
    }
    /**
     * Metodo que convierte de grados Celcius a grados Farenheit
     * @param gradosCelsius -> Grados en Celsius a transformar
     * @return -> Regresa los grados Farenheit
     */
    public static double conversionCelsiusFarenheit(double gradosCelsius){
        return ((gradosCelsius * DIFERENCIA_CELCIUS_FARENHEIT) + DESPLAZAMIENTO_GRADOS);
    }
    /**
     * Metodo que calcula y obtiene el area de un circulo en base a su radio antes pedido en centimetros
     * @param radioCirculo -> Radio del circulo en cm entregado por el usuario
     * @return -> Regresa el area del circulo en centimetros
     */
    public static double obtenerAreaCirculo(double radioCirculo){
        return PI * (radioCirculo * radioCirculo);
    }
}