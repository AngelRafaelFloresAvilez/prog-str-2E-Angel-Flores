package com.example.demolistview.services;

import com.example.demolistview.repositories.PersonFileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonService {
    PersonFileRepository repo = new PersonFileRepository();
    public List<String> loadDataForListView() throws IOException {
        List<String> lines = repo.readAllLines();
        List<String> result = new ArrayList<>();



        for(String line : lines){
            if (line == null || line.isBlank()){
                continue;
            }
            String[] parts = line.split(",");
            String name = parts[0];
            String email = parts[1];
            String edad = parts[2];
            result.add(name + " - " + email + " - " + edad);
        }
        return result;
    }

    private List<String> getCleanLines() throws IOException {
        List<String> lines = repo.readAllLines();
        List<String> cleanLines = new ArrayList<>();
        for(String line : lines){
            if(line!=null && !line.isBlank()){
                cleanLines.add(line);
            }
        }
        return cleanLines;
    }

    public void updatePerson(int index, String name, String email, String edad) throws IOException {
        validate(name, email, edad);
        if(index < 0){
            throw new IllegalArgumentException("El indice es invalido");
        }
        List<String> data = getCleanLines();
        data.set(index, name + "," + email + "," + edad);
        repo.saveFile(data);
    }

    public void removePerson(int index) throws IOException {
        List<String> data = getCleanLines();
        if(index < 0 || index >= data.size()){
            throw new IllegalArgumentException("el indice esta fuera de rango");
        }
        data.remove(index);
        repo.saveFile(data);
    }


    public void addPerson (String name, String email, String edad) throws IOException {
        validate(name, email, edad);
        repo.appendNewLine(name + "," + email + "," + edad);

    }

    private void validate(String name, String email, String edad){
        if(name == null || name.isBlank() || name.length() < 3){
            throw new IllegalArgumentException("Eror - Nombre invalido - Compruebe la longitud de su nombre o si esta vacio");
        }
        String ema = (email == null) ? "" : email.trim();
        if (ema.isBlank() || !ema.contains("@") || !ema.contains(".")){
            throw new IllegalArgumentException("Correo electronico invalido - Compruebe que usa @ y .");
        }
        int edadFinal = Integer.parseInt(edad);
        if (edadFinal < 18){
            throw new IllegalArgumentException("Edad invalida - Eres menor de edad, intentalo con alguien mayo de edad");
        }
    }

}
