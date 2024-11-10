package com.proyecto.servicio;

import com.proyecto.dao.ValidacionDao;
import com.proyecto.dao.ValidacionDaoImpl;
import com.proyecto.modelo.ValidacionHTML;
import com.proyecto.utilidades.Pila;
import org.springframework.stereotype.Service;

@Service
public class ValidacionService {
    private final ValidacionDao validacionDao = new ValidacionDaoImpl();
    private final String[] palabrasReservadas = {"html", "head", "body", "input", "select"};

    public boolean validarHtml(String codigoHTML) {
        Pila pilaApertura = new Pila();
        Pila pilaCaracteres = new Pila();

        for (int i = 0; i < codigoHTML.length(); i++) {
            char c = codigoHTML.charAt(i);

            if (c == '<') {
                pilaApertura.push('<');
                i++;
                StringBuilder tag = new StringBuilder();
                while (i < codigoHTML.length() && codigoHTML.charAt(i) != '>') {
                    tag.append(codigoHTML.charAt(i++));
                }

                String tagContent = tag.toString();
                if (isPalabraReservada(tagContent)) {
                    pilaCaracteres.push(tagContent);
                } else {
                    return false;
                }
            }
        }

        return pilaApertura.isEmpty() && pilaCaracteres.isEmpty();
    }

    private boolean isPalabraReservada(String tag) {
        for (String palabra : palabrasReservadas) {
            if (palabra.equals(tag)) {
                return true;
            }
        }
        return false;
    }

    public void guardarValidacion(String codigoHTML) {
        boolean esValido = validarHtml(codigoHTML);
        ValidacionHTML validacion = new ValidacionHTML(codigoHTML, esValido);
        validacionDao.guardarValidacion(validacion);
    }
}
