import java.util.Scanner;
public class AlumnoService {
    public void alta(Alumno[] alumnos, Scanner sc){
        Validator valid = new Validator();
        int id;
        while(true){
            id = valid.getValidInt(sc, "Ingresa el Id del nuevo usuario : ");
            if(id <= 0){
                System.out.println("Solo se admiten IDs mayores a 0");
                return;
            }else if(verificarId(id, alumnos)){
                System.out.println("Ese id existe");
                return;
            }else{
                break;
            }
        }
        System.out.print("Ingresa el nombre del nuevo usuario : ");
        sc.nextLine();
        String name = sc.nextLine();
        if(name.isBlank()){
            System.out.println("No se admite valores vacios");
            return;
        }
        double promedio = valid.getValidProm(sc, "Ingresa el promedio del nuevo usuario : ");

        int indice = obtenerIndice(alumnos);
        if(indice == -1){
            System.out.println("El arreglo esta lleno");
            return;
        }
        Alumno nuevoAlumno = new Alumno(id, name, promedio);
        nuevoAlumno.setActivo(true);
        alumnos[indice] = nuevoAlumno;
        System.out.println("Persona agregada");
    }

    public void buscarId(Alumno[] alumnos, Scanner sc){
        InputValidatorT input = new InputValidatorT();
        int id = input.getValidInt(sc, "Ingresa el Id del usuario que vas a buscar: ");
        boolean existePersona = false;

        for(Alumno alumno : alumnos){
            if (alumno != null){
                if(alumno.getId() == id && alumno.isActivo()){
                    System.out.println("Persona : " + alumno);
                    existePersona = true;
                    return;
                }
            }
        }
        if(existePersona == false){
            System.out.println("No hubo nadie con ese id");
        }
    }

    public void actualizarPromedio(Alumno[] alumnos, Scanner sc){
        Validator valid = new Validator();
        int id = valid.getValidInt(sc, "Ingresa el id del usuario que vas a actualizar : ");
        boolean existePersona = false;

        for(Alumno alumno : alumnos){
            if(alumno != null && alumno.getId() == id && alumno.isActivo()){
                double promedio = valid.getValidProm(sc, "Ingresa el nuevo promedio : ");

                alumno.setPromedio(promedio);
                System.out.println("Se actualizo el promedio correctamente");

                existePersona = true;
                return;
            }
        }
        if(existePersona == false){
            System.out.println("No hubo persona con ese id");
        }
    }

    public void bajaId(Alumno[] alumnos, Scanner sc){
        Validator valid = new Validator();
        int id = valid.getValidInt(sc, "Ingresa el Id del usuario que daras de baja: ");
        boolean existePersona = false;
        for(Alumno alumno : alumnos){
            if(alumno != null){
                if(alumno.getId() == id && alumno.isActivo()){
                    alumno.setActivo(false);
                    System.out.println("La persona se dio de baja");
                    existePersona = true;
                    return;
                }
            }
        }
        if(existePersona == false){
            System.out.println("No existe una persona con ese id");
        }
    }

    public void listaActivos(Alumno[] alumnos){
        boolean activos = false;

        for(Alumno alumno : alumnos){
            if(alumno != null && alumno.isActivo()){
                System.out.println("Nombre | Id | Status | Promedio");
                System.out.println(alumno);
                activos = true;
            }
        }
        if(activos == false){
            System.out.println("No hay activos");
        }
    }

    public void reportes(Alumno[] alumnos){
        double sumatoriaPromedio = 0.0;
        int contador = 0;
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null && alumnos[i].isActivo()) {
                sumatoriaPromedio = sumatoriaPromedio + alumnos[i].getPromedio();
                contador++;
            }
        }
        if (contador > 0) {
            double promedioTotal = sumatoriaPromedio / contador;
            System.out.println("Promedio general de alumnos : " + promedioTotal);
        } else {
            System.out.println("No hay activos");
        }

        int indice = -1;
        double maximo = 0.0;
        for (int i = 0; i < alumnos.length; i++){

            if (alumnos[i] != null && alumnos[i].isActivo()) {
                if(alumnos[i].getPromedio() > maximo){
                    indice = i;
                    maximo = alumnos[i].getPromedio();
                }
            }
        }
        if (indice != -1){
            System.out.println("Alumno activo con mayor promedio : " + alumnos[indice].getId() + " | " + alumnos[indice].getNombre() + " | " + alumnos[indice].getPromedio());
        } else{
            System.out.println("No hay activos");
        }

        int indiceMin = -1;
        double minimo = 10;
        for (int i = 0; i < alumnos.length; i++){

            if (alumnos[i] != null && alumnos[i].isActivo()) {
                if(alumnos[i].getPromedio() < minimo){
                    indiceMin = i;
                    minimo = alumnos[i].getPromedio();
                }
            }
        }
        if (indiceMin != -1){
            System.out.println("Alumno activo con menor promedio : " + alumnos[indiceMin].getId() + " | " + alumnos[indiceMin].getNombre() + " | " + alumnos[indiceMin].getPromedio());
        } else{
            System.out.println("No hay activos");
        }

        int mayores = 0;
        for (int i = 0; i < alumnos.length; i++){
            if (alumnos[i] != null && alumnos[i].isActivo()) {
                if(alumnos[i].getPromedio() >= 8.0){
                    mayores++;
                }
            }
        }
        if (mayores > 0){
            System.out.println("Hay " + mayores + " alumnos con mayor o igual calificacion a 8");
        } else {
            System.out.println("No hubo alumnos por encima o igual a 8");
        }
    }

    public boolean verificarId(int id, Alumno[] alumnos){
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null && alumnos[i].getId() == id) {
                return true;
            }
        }
        return false;
    }

    public int obtenerIndice(Alumno[] alumnos){
        for (int i = 0; i < alumnos.length; i++) {
            if(alumnos[i] == null){
                return i;
            }
        }
        return -1;
    }
}