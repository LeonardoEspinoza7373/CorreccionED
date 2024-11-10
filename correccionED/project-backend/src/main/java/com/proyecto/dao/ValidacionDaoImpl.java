package com.proyecto.dao;

import com.proyecto.modelo.ValidacionHTML;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

public class ValidacionDaoImpl implements ValidacionDao {
    private final String archivoJson = "/home/leonardo/Escritorio/correccionED/project-backend/src/main/resources/validaciones.json";

    @Override
    public void guardarValidacion(ValidacionHTML validacion) {
        List<ValidacionHTML> validaciones = obtenerValidaciones();
        validaciones.add(validacion);
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(archivoJson), validaciones);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ValidacionHTML> obtenerValidaciones() {
        ObjectMapper mapper = new ObjectMapper();
        List<ValidacionHTML> validaciones = new ArrayList<>();
        try {
            validaciones = mapper.readValue(new File(archivoJson), new TypeReference<List<ValidacionHTML>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return validaciones;
    }
}
