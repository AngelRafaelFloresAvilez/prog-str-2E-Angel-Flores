import java.util.Scanner;
public class App {
    public static double minPeso = 0.1;
    public static double maxPeso = 50.0;
    public static int minDistancia = 1;
    public static int maxDistancia = 2000;
    public static int servicioEstandar = 1;
    public static int servicioExpress = 2;

    public static void main(String[] args) {
        ShippingCalculator shippingCalculator = new ShippingCalculator();
        Scanner sc = new Scanner(System.in);

        double pesoKg = InputValidator.leerDoubleEnRango(sc, "Ingresa el peso (kg) : ", minPeso, maxPeso);
        int distanciaKm = InputValidator.leerIntEnRango(sc, "Ingresa la distancia (km) : ", minDistancia, maxDistancia);
        int tipoServicio = InputValidator.leerIntEnRango(sc, "Ingresa el tipo de servicio (1. estandar, 2. express) : ", servicioEstandar, servicioExpress);
        boolean esZonaRemota = InputValidator.leerBoolean(sc, "Es zona remota? (true/false) : ");

        shippingCalculator.procesar(pesoKg, distanciaKm, tipoServicio, esZonaRemota);
        shippingCalculator.imprimirTicket(pesoKg, distanciaKm, tipoServicio, esZonaRemota);
    }
}
