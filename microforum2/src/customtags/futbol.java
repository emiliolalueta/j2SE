/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package customtags;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 *
 * @author Alumno
 */
public class futbol extends TagSupport{
    public int doStartTag() throws JspTagException
    {
        //return SKIP_BODY;
        return TagSupport.SKIP_BODY;
    }
     
        public int doEndtag() throws JspTagException
     {
         try
         {
            SAXParserFactory factory= SAXParserFactory.newInstance();
            SAXParser sp=factory.newSAXParser();
            LectorFutbolXML lector=new LectorFutbolXML();
            sp.parse("c:\\futbol.xml",lector);
            //lector.getLista();
            listaequipos equipos=lector.recuperarLista();                    
            String combo ="<select name='lista'>";                                        
            for(Equipo equi:equipos)
            {                 
                combo +="<option>" + equi.getNombre() + "</option>";                
            }
                combo += "</select>";            
                pageContext.getOut().write("Lectura de XML con <b>SAX</b><hr>");
                pageContext.getOut().write(combo);
         }
         catch (Exception ex)
         {
                throw new JspTagException(ex.toString());                
         } 
                return TagSupport.EVAL_PAGE;
     }  
    
}
