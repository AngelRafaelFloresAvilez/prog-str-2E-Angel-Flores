public class Persona {
    private int id;
    private String name;
    private boolean isActive;

    public Persona(){
    }
    public Persona(int id, String name){
        this.id = id;
        this.name = name;
    }
    @Override
    public String toString() {
        String activo = "";
        if(isActive){
            activo = "activo";
        } else{
            activo = "inactivo";
        }
        return name + " | " + id + " | " + activo;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean active) {
        isActive = active;
    }
}