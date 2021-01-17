/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package customtags;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 *
 * @author Alumno
 */
public class LectorFutbolXML extends DefaultHandler{
  String contenido="";
    listaequipos lista=new listaequipos();
    Equipo equi;
    public listaequipos recuperarLista()
    {
        return this.lista;
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
        if("Equipo".equals(tag)){
            this.equi=new Equipo();
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
            this.equi.setNombre(contenido);
        }
        else if(tag.equals("fundacion")){
            this.equi.setFundacion(contenido);
        }
        else if (tag.equals("presidente"))
        {
            this.equi.setPresidente(contenido);
        }
        else if (tag.equals("presupuesto"))
        {
            this.equi.setPresupuesto(contenido);
        }        
        else if (tag.equals("Equipo"))
        {
            this.lista.add(this.equi);
        }      
    }     
}
