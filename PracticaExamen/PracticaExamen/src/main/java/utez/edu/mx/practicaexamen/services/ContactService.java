package utez.edu.mx.practicaexamen.services;

import utez.edu.mx.practicaexamen.model.Contacto;

import java.util.ArrayList;
import java.util.List;

public class ContactService {
    private List<Contacto> listContacts = new ArrayList<>();
    public List<Contacto> getAllContacts(){
        return listContacts;
    }

    public void addContact (Contacto contacto){
        listContacts.add(contacto);
    }
    public void deleteContact(Contacto contacto){
        listContacts.remove(contacto);
    }
    public void updateContact(Contacto contactoViejo, Contacto contactoNuevo) {
        int index = listContacts.indexOf(contactoViejo);
        if (index != -1) {
            listContacts.set(index, contactoNuevo);
        }
    }
    public Contacto findByName(String nombreABuscar) {
        for (Contacto contactoObjeto : listContacts) {
            if (contactoObjeto.getName().equals(nombreABuscar)) {
                return contactoObjeto;

            }
        }
    return null;
    }
}
