import java.util.Scanner;
public class Validator {
    public int getValidInt(Scanner sc, String msg){
        while(true){
            try {
                System.out.print(msg);
                return sc.nextInt();
            } catch (Exception e) {
                System.out.println("El valor no es numerico");
                sc.next();
            }
        }
    }

    public double getValidProm(Scanner sc, String msg){
        while (true){
            try {
                System.out.print(msg);
                double promedio = sc.nextDouble();
                if(promedio >= 0 && promedio <= 10){
                    return promedio;
                } else {
                    System.out.println("Ingrese un valor entre 0 y 10");
                }
            } catch (Exception e) {
                System.out.println("El valor no es numerico");
                sc.next();
            }
        }
    }
}