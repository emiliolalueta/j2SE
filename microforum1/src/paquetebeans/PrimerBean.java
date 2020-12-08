package paquetebeans;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alumno
 */
import java.util.*;
import java.text.*;
public class PrimerBean {
    public String getHora()
    {
        Date horaactual=Calendar.getInstance().getTime();
        DateFormat formato=DateFormat.getTimeInstance();
        String hora=formato.format(horaactual);
        return hora;
    }
    public String getSaludo(String nombre)
    {
        return "<h1>Bienvenido" + nombre + "</h1>"; 
    }
}
