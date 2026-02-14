import java.util.Scanner;
public class PersonaService {
    public void alta(Persona[] personas, Scanner sc){
        InputValidatorT input = new InputValidatorT();
        int id;
        while(true){
            id = input.getValidInt(sc, "Ingresa el Id del nuevo usuario");

            if(id <= 0){
                System.out.println("No se admiten valores menores que 1");
                return;
            }else if(verificarId(id, personas)){
                System.out.println("Ese id existe");
                return;
            }else{
                break;
            }
        }

        System.out.println("Ingresa el nombre del nuevo usuario");
        sc.nextLine();
        String name = sc.nextLine();
        if(name.isBlank()){
            System.out.println("No se admite valores vacios");
            return;
        }
        int indiceInsercion= obtenerIndice(personas);
        if(indiceInsercion == -1){
            System.out.println("El arreglo esta lleno");
            return;
        }
        Persona nuevaPersona = new Persona(id, name);
        nuevaPersona.setActive(true);
        personas[indiceInsercion] = nuevaPersona;
        System.out.println("Persona agregada");
    }

    public void buscarId(Persona[] personas, Scanner sc){
        InputValidatorT input = new InputValidatorT();
        int id = input.getValidInt(sc, "Ingresa el Id del usuario que vas a buscar: ");
        boolean existePersona = false;

        for(Persona persona : personas){
            if (persona != null){
                if(persona.getId() == id && persona.isActive()){
                    System.out.println("Persona : " + persona);
                    existePersona = true;
                    return;
                }
            }
        }
        if(existePersona == false){
            System.out.println("No hubo nadie con ese id");
        }
    }

    public void bajaId(Persona[] personas, Scanner sc){
        InputValidatorT input = new InputValidatorT();
        int id = input.getValidInt(sc, "Ingresa el Id del usuario que daras de baja: ");
        boolean existePersona = false;
        for(Persona persona : personas){
            if(persona != null){
                if(persona.getId() == id && persona.isActive()){
                    persona.setActive(false);
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

    public void listaActivos(Persona[] personas){
        boolean activos = false;
        for(Persona persona : personas){
            if(persona != null && persona.isActive()){
                    System.out.println("Nombre | Id | Status");
                    System.out.println(persona);
                    activos = true;
            }
        }
        if(activos == false){
            System.out.println("No hay activos");
        }
    }

    public void actualizaNombre(Persona[] personas, Scanner sc){
        InputValidatorT input = new InputValidatorT();
        int id = input.getValidInt(sc, "Ingresa el Id del usuario que vas a actualizar : ");
        boolean existePersona = false;

        for(Persona persona : personas){
            if(persona != null && persona.getId() == id && persona.isActive()){
                System.out.println("Ingresa el nombre nuevo : ");
                sc.nextLine();
                String nombre = sc.nextLine();

                if(!nombre.isBlank()){
                    persona.setName(nombre);
                    System.out.println("Se actualizo el nombre correctamente");
                }
                else{
                    System.out.println("El nombre esta vacio");
                }
                existePersona = true;
                return;
            }
        }
        if(existePersona == false){
            System.out.println("No hubo persona con ese id");
        }
    }

    public boolean verificarId(int id, Persona[] personas){
        for (Persona persona : personas) {
            if(persona!=null && persona.getId()==id) {
                return true;
            }
        }
        return false;
    }

    public int obtenerIndice(Persona[] personas){
        for (int i = 0; i < personas.length; i++) {
            if(personas[i]==null){
                return i;
            }
        }
        return -1;
    }
}