package utez.edu.mx.practicaexamen.model;

public class Contacto {
    private String name;
    private String tel;
    private String parent;

    public Contacto() {
    }

    public Contacto(String name, String tel, String parent) {
        this.name = name;
        this.tel = tel;
        this.parent = parent;

    }

    @Override
    public String toString() {
        return name + " / " +
                tel + " / " +
                parent
                ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }
}
