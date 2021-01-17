/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package customtags;
import java.io.*;
import javax.servlet.jsp.tagext.TagSupport;
import javax.xml.parsers.*;
import org.w3c.dom.*;
/**
 *
 * @author Alumno
 */
public class ClaseAlumnos extends TagSupport
{
    public int doStartTag()
    {
        return TagSupport.SKIP_BODY;
    }
    
    public int doEndTag()
    {
        try
            {            
                String ruta="C:\\alumnos.xml";
                //File relativeFile = new File(getClass().getResource("alumnos.xml").getPath());
                DocumentBuilderFactory f=DocumentBuilderFactory.newInstance();
                Document  documento;
                DocumentBuilder builder;
                builder =f.newDocumentBuilder();
                documento=(Document) builder.parse(new File(ruta));  //new File(ruta)
                Element raiz=documento.getDocumentElement();            

                NodeList listanodos=raiz.getElementsByTagName("alumno");
                String elementos ="<h3>Lista de alumnos</h3>";
                int numeroalumnos=listanodos.getLength();
                elementos +="<p>Numero de alumnos: " + numeroalumnos + "</p>";
                //elementos= +="<table border=6>";
                for(int i=0;i<listanodos.getLength();i++)
                {
                    Element nodo= (Element)listanodos.item(i);                
                    if(nodo.getNodeType()==Node.ELEMENT_NODE)
                    {                  
                       String nombre;
                       String apellidos;
                       String calificacion;                    
                       nombre=nodo.getChildNodes().item(1).getChildNodes().item(0).getNodeValue();
                       apellidos=nodo.getChildNodes().item(3).getChildNodes().item(0).getNodeValue();
                       calificacion=nodo.getChildNodes().item(5).getChildNodes().item(0).getNodeValue();                    
                       //System.out.println("Nombre " + nombre + " Apellidos: " + apellidos +  " Calificacion " + calificacion ); 
                       pageContext.getOut().write("Nombre:  " + nombre + "  Apellidos:  " + apellidos + "  Calificacion:  " + calificacion  );
                    }
                }           
            }
        catch (Exception ex)
            {
                System.out.println("Error" + ex.toString());                
            }
        return TagSupport.EVAL_PAGE;
    }  
}
