package com.proyecto.dao;

import com.proyecto.modelo.ValidacionHTML;
import java.util.List;

public interface ValidacionDao {
    void guardarValidacion(ValidacionHTML validacion);
    List<ValidacionHTML> obtenerValidaciones();
}
