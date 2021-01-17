/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package customtags;

import java.util.ArrayList;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 *
 * @author Alumno
 */
public class ClaseAlumnosSax extends TagSupport
{
    public int doStartTag() throws JspTagException
    {
        //return SKIP_BODY;
    	try
        {
           SAXParserFactory factory= SAXParserFactory.newInstance();
           SAXParser sp=factory.newSAXParser();
           LectorXML lector=new LectorXML();
           sp.parse("C:\\alumnos.xml",lector);
           //lector.getLista();
           Curso micurso=lector.recuperarCurso();
           String tabla ="<table border='6'>";
           tabla +="<tr><th>nombre</th><th>apellidos</th><th>calificacion</th></tr>";                        
           for(alumno al:micurso)
           { 
               tabla +="<tr>";
               tabla +="<td>" + al.getNombre() + "</td>";
               tabla +="<td>" + al.getApellidos() + "</td>";
               tabla +="<td>" + al.getCalificacion() + "</td>";
               tabla +="</tr>";
           }
           tabla +="</table>";
           
               pageContext.getOut().write("Lectura de XML con <b>SAX</b><hr>");
               pageContext.getOut().write(tabla);
        }
        catch (Exception ex)
        {
               throw new JspTagException(ex.toString());                
        } 
        return TagSupport.SKIP_BODY;
    }    
    
     public int doEndtag() throws JspTagException
     {
         
        return TagSupport.EVAL_PAGE;
     } 
}
