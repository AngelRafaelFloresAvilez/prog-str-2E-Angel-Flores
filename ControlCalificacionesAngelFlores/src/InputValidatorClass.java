import java.util.Scanner;
public class InputValidatorClass {
    /**
     * Metodo que procesa los valores de tipo string ingresados por el usuario para verificar que sean string
     * @param sc -> El objeto que leyo el valor del usuario
     * @param mensaje -> El mensaje que tenia la funcion
     */
    public static String leerTextoNoVacio(Scanner sc, String mensaje){
        String valor;
        while (true) {
            System.out.println(mensaje);
            if(sc.hasNextLine()){
                valor = sc.nextLine();
                if (!valor.equals("")){
                    return valor;
                }
                System.out.println("El dato esta vacio.");
            }else{
                System.out.println("El numero no es string.");
                sc.nextLine();
            }
        }
    }
    /**
     * Metodo que procesa los valores de tipo double ingresados por el usuario para verificar que sean doubles
     * @param sc -> El objeto que leyo el valor del usuario
     * @param mensaje -> El mensaje que tenia la funcion
     * @param min -> El minimo
     * @param max -> El maximo
     */
    public static double leerDoubleEnRango(Scanner sc, String mensaje, double min, double max){
        double valor;
        while (true) {
            System.out.println(mensaje);
            if(sc.hasNextDouble()){
                valor = sc.nextDouble();
                sc.nextLine();
                if (valor >= min && valor <= max){
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
     * @param min -> El minimo de distancia
     * @param max -> El maximo de distancia
     */
    public static int leerIntEnRango(Scanner sc, String mensaje, double min, double max){
        int valor;
        while (true) {
            System.out.println(mensaje);
            if(sc.hasNextInt()){
                valor = sc.nextInt();
                sc.nextLine();
                if (valor >= min && valor <= max){
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
        String texto;
        boolean valor;
        while (true) {
            System.out.println(mensaje);
            if(sc.hasNextLine() ){
                texto = sc.nextLine();
                if (texto.equals("true")){
                    valor = true;
                    return valor;
                } else if(texto.equals("false")){
                    valor = false;
                    return valor;
                }
                System.out.println("Ingrese una opcion valida (true o false).");
            }else{
                System.out.println("El dato no es de cadena.");
                sc.nextLine();
            }
        }
    }
}