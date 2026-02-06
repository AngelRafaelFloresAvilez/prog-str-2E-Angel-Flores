import java.util.Scanner;
public class AppCalif {

    public static double min = 0;
    public static double max= 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GradeService gradeService = new GradeService();

        String nombreAlumno = InputValidatorClass.leerTextoNoVacio(sc, "Ingresa tu nombre : ");
        double califUno = InputValidatorClass.leerDoubleEnRango(sc, "Ingresa tu primera calificacion : ", min, max);
        double califDos = InputValidatorClass.leerDoubleEnRango(sc, "Ingresa tu segunda calificacion : ", min, max);
        double califTres = InputValidatorClass.leerDoubleEnRango(sc, "Ingresa tu tercera calificacion : ", min, max);
        int asistencia = InputValidatorClass.leerIntEnRango(sc, "Ingresa la cantidad de asistencias : ", min, max);
        boolean entregoProyecto  = InputValidatorClass.leerBoolean(sc, "Entrego proyecto? (true/false) : ");

        gradeService.procesar(califUno, califDos, califTres, asistencia, entregoProyecto);
        gradeService.imprimirReporte(nombreAlumno, califUno, califDos, califTres, asistencia, entregoProyecto);
    }
}

