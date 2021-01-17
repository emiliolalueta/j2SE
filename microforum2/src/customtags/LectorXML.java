/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package customtags;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 *
 * @author Alumno
 */
public class LectorXML extends  DefaultHandler{
    String contenido="";
    Curso micurso=new Curso();
    alumno alum;
    public Curso recuperarCurso()
    {
        return this.micurso;
    }
    
    
    
    @Override
    public void startDocument()
    {
        System.out.println("Estoy al principio del documento");
    }
    @Override
    public void endDocument()throws SAXException
    {
        System.out.println("Estoy al final del documento");
    }
    @Override
    public void startElement(String uri,String nombrelocal,String tag,Attributes atributos)throws SAXException
    {
        if("alumno".equals(tag)){
            this.alum=new alumno();
        }
    }
    @Override
    public void characters(char[] letras,int inicio,int longitud)throws SAXException
    {
        contenido=new String(letras,inicio,longitud);
    }
    public void endelement(String uri,String localName,String tag)throws SAXException{
        //System.out.println("he leido la etiqueta:" + tag + " y su contenido es:" + contenido);
        if(tag.equals("nombre"))
        {
            this.alum.setNombre(contenido);
        }
        else if(tag.equals("apellidos")){
            this.alum.setApellidos(contenido);
        }
        else if (tag.equals("calificacion"))
        {
            this.alum.setCalificacion(contenido);
        }
        else if (tag.equals("alumno"))
        {
            this.micurso.add(this.alum);
        }      
    }  
} 