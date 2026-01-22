import java.util.Scanner;
public class ActividadIfElseTarifa {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tarifa = 0;
        boolean esEstudiante = false;

        double edad = obtenerInt(sc,"Ingrese su edad: ");
        System.out.println("¿Es usted estudiante?");
        sc.nextLine();
        String estudianteCadena = sc.nextLine();

        if (estudianteCadena.equals("si") || estudianteCadena.equals("Si")){
            esEstudiante = true;
        }else if (estudianteCadena.equals("no") || estudianteCadena.equals("No")){
            esEstudiante = false;
        }else{
            System.out.println("Ingrese un valor correcto");
            return;
        }

        if(edad < 0 || edad > 120){
            System.out.println("Edad invalida.");
            return;
        }else if (edad < 12){
            tarifa = 50;
        }else if(edad >= 12 && edad <= 17){
            if(esEstudiante == true){
                tarifa = 60;
            }else {
                tarifa = 80;
            }
        }else if(edad >= 18){
            if(esEstudiante == true){
                tarifa = 90;
            }else {
                tarifa = 120;
            }
        }

        System.out.println("Edad ingresada: " + edad);
        System.out.println("¿Es estudiante? " + estudianteCadena);
        System.out.println("Tarifa final: " + tarifa);

    }
    /**
     * Metodo que obtiene el valor ingresado por el usuario
     * @param sc -> El objeto para poder leer lo que escriba el usuario
     * @param mensaje -> El texto que se mostrara y proveniente de println
     * @return -> Regresa el valor leido del usuario
     */
    public static double obtenerInt(Scanner sc, String mensaje){
        System.out.println(mensaje);
        return sc.nextInt();
    }
}