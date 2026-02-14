import java.util.Scanner;
public class Principal {
    public static void main(String[] args) throws Exception {
        int opc;
        Scanner sc= new Scanner(System.in);
        PersonaService personaService= new PersonaService();
        Persona[] personas = new Persona[20];
        do{
            System.out.println("===Menu===");
            System.out.println("0) Salir del menu");
            System.out.println("1) Alta");
            System.out.println("2) Buscar por ID ");
            System.out.println("3) Baja por id");
            System.out.println("4) Listar activos");
            System.out.println("5) Actualizar nombre");
            System.out.print("Ingrese su opcion (0 - 5) : ");
            opc = sc.nextInt();
            switch (opc) {
                case 0:
                    System.out.println("Saliendo del menu");
                    break;
                case 1:
                    personaService.alta(personas, sc);
                    break;
                case 2:
                    personaService.buscarId(personas, sc);
                    break;
                case 3:
                    personaService.bajaId(personas, sc);
                    break;
                case 4:
                    personaService.listaActivos(personas);
                    break;
                case 5:
                    personaService.actualizaNombre(personas, sc);
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        }while(opc != 0);
    }
}