import java.util.Scanner;
public class InputValidator {
    /**
     * Metodo que procesa los valores de tipo double ingresados por el usuario para verificar que sean doubles
     * @param sc -> El objeto que leyo el valor del usuario
     * @param mensaje -> El mensaje que tenia la funcion
     * @param minPeso -> El minimo de peso
     * @param maxPeso -> El maximo de peso
     */
    public static double leerDoubleEnRango(Scanner sc, String mensaje, double minPeso, double maxPeso){
        double valor;
        while (true) {
            System.out.println(mensaje);
            if(sc.hasNextDouble()){
                valor = sc.nextDouble();
                if (valor >= minPeso && valor <= maxPeso){
                    return valor;
                }
                System.out.println("El numero esta fuera de rango.");
            }else{
                System.out.println("El dato no es numerico.");
                sc.nextLine();
            }
        }
    }
    /**
     * Metodo que procesa los valores de tipo int ingresados por el usuario para verificar que sean int
     * @param sc -> El objeto que leyo el valor del usuario
     * @param mensaje -> El mensaje que tenia la funcion
     * @param minDistancia -> El minimo de distancia
     * @param maxDistancia -> El maximo de distancia
     */
    public static int leerIntEnRango(Scanner sc, String mensaje, double minDistancia, double maxDistancia){
        int valor;
        while (true) {
            System.out.println(mensaje);
            if(sc.hasNextInt()){
                valor = sc.nextInt();
                if (valor >= minDistancia && valor <= maxDistancia){
                    return valor;
                }
                System.out.println("El numero esta fuera de rango.");
            }else{
                System.out.println("El dato no es un entero.");
                sc.nextLine();
            }
        }
    }
    /**
     * Metodo que procesa los valores de tipo boolean ingresados por el usuario para verificar que sean booleans
     * @param sc -> El objeto que leyo el valor del usuario
     * @param mensaje -> El mensaje que tenia la funcion
     */
    public static Boolean leerBoolean(Scanner sc, String mensaje){
        String servicio;
        boolean zonaRemota;
        while (true) {
            System.out.println(mensaje);
            if(sc.hasNextBoolean()){
                servicio = sc.nextLine();
                if (servicio.equals("true")){
                    zonaRemota = true;
                    return zonaRemota;
                } else if(servicio.equals("false")){
                    zonaRemota = false;
                    return zonaRemota;
                }
                System.out.println("Ingrese una opcion valida (true o false).");
            }else{
                System.out.println("El dato no es de cadena.");
                sc.nextLine();
            }
        }
    }
}