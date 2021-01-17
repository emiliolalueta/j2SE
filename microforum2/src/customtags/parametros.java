/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package customtags;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;
import javax.servlet.*;
/**
 *
 * @author Alumno
 */
public class parametros extends TagSupport
{
private String nombre;
public String getNombre(){
    return nombre;
}
public void setNombre(String nombre){
    this.nombre=nombre;
}
@Override
public int doStartTag()throws JspTagException {
	try 
    {
		
        pageContext.getOut().write("Bienvenido a mi pagina <b>" + this.getNombre() + "</b><br>");
    }
    catch(Exception ex)
    {
        throw new JspTagException(ex.toString());
    }
    return TagSupport.SKIP_BODY;
}
@Override
public int doEndTag()throws JspTagException
{
    
    return TagSupport.EVAL_PAGE;
}        
}
