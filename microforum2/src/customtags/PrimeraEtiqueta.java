/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package customtags;

import java.io.IOException;
import java.util.Date;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author Alumno
 */
public class PrimeraEtiqueta extends TagSupport {
    public int doStartTag() throws JspTagException{
        return SKIP_BODY;
    }
    public int doEndTag() throws JspTagException
    {
        String dateString=new Date().toString();
        try
        {
            pageContext.getOut().write("Hola programador<br/>");
            pageContext.getOut().write("El nombre de mi clase es");
            pageContext.getOut().write(getClass().getName());
            pageContext.getOut().write("y hoy es" + dateString + "<p/>");     
            
        }
        catch(IOException ex){
            throw new JspTagException("Exception" + ex.toString());
        }
        return EVAL_PAGE;
    }    
}
