import java.util.Scanner;
public class Base {
    public static void main(String[] args) throws Exception {
        int opc;
        Scanner sc = new Scanner(System.in);
        AlumnoService service = new AlumnoService();
        Alumno[] alumnos = new Alumno[25];
        do{
            System.out.println("===Menu===");
            System.out.println("0) Salir");
            System.out.println("1) Alta de alumno");
            System.out.println("2) Buscar por ID");
            System.out.println("3) Actualizar promedio por ID");
            System.out.println("4) Baja logica por ID");
            System.out.println("5) Listar activos");
            System.out.println("6) Reportes");
            System.out.print("Ingrese su opcion (0 - 6) : ");
            opc = sc.nextInt();
            switch (opc) {
                case 0:
                    System.out.println("Saliendo del menu");
                    break;
                case 1:
                    service.alta(alumnos, sc);
                    break;
                case 2:
                    service.buscarId(alumnos, sc);
                    break;
                case 3:
                    service.actualizarPromedio(alumnos, sc);
                    break;
                case 4:
                    service.bajaId(alumnos, sc);
                    break;
                case 5:
                    service.listaActivos(alumnos);
                    break;
                case 6:
                    service.reportes(alumnos);
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        }while(opc != 0);
    }
}