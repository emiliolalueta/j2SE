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
public class DatosClub {
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
            LectorClubXML lector=new LectorClubXML();
            sp.parse("c:\\futbol.xml",lector);
            //lector.getLista();
            Listaclub clubes=lector.recuperarLista();                    
            String tabla ="<table border='6'>";
            tabla +="<tr><th>nombre</th><th>apellidos</th><th>calificacion</th></tr>";                        
            for(Club Clu:clubes)
            { 
                tabla +="<tr>";
                tabla +="<td>" + Clu.getNombre() + "</td>";
                tabla +="<td>" + Clu.getFundacion() + "</td>";
                tabla +="<td>" + Clu.getPresidente() + "</td>";
                tabla +="</tr>";
            }
            tabla +="</table>";
         }
         catch (Exception ex)
         {
                throw new JspTagException(ex.toString());                
         } 
                return TagSupport.EVAL_PAGE;
     }      
}
