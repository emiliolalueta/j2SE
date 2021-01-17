/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package customtags;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;



/**
 *
 * @author Alumno
 */
public class selecciondepartamento extends TagSupport{
	Connection cn;
	private String nombre;  
	public void setNombre(String nombre) {  
	    this.nombre = nombre;  
	}  

    public void conectar() throws JspTagException{
        try
        {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
             cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "BBDD","BBDD");
            String consulta = "select DEPT_NO, DNOMBRE FROM DEPT";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            //String dept_no = request.getParameter("cmbdept");
        }
        catch(Exception ex){
            throw new JspTagException(ex.toString());
        }
    }
    public int doStartTag()throws JspTagException
    {
//        try 
//        {
//            this.conectar();
//            
//        } 
//        catch (JspTagException ex)
//        {
//            Logger.getLogger(selecciondepartamento.class.getName()).log(Level.SEVERE, null, ex);
//        }      
    	 return TagSupport.SKIP_BODY;
    }
    public int doEndTag() throws JspTagException
    {
    	try
        {
            boolean resultado;
            this.conectar(); 
            
            PreparedStatement ps=cn.prepareStatement("select DEPT_NO, DNOMBRE from DEPT where DNOMBRE=?");  
            ps.setString(1,nombre);  //Integer.parseInt(id)
            ResultSet rs=ps.executeQuery(); 
            pageContext.getOut().write("<table border='3'>");             
	            while(rs.next()){                   
	            		pageContext.getOut().write("<tr>");		                
			            pageContext.getOut().write("<td>"+ rs.getString(2) + "</td>");		                
			            pageContext.getOut().write("</tr>");
	            } 
            pageContext.getOut().write("</table>");
            rs.close();
        }
    catch(Exception ex)
        {
            //throw new Exception("Mi fallo" + ex.toString());
    	throw new JspTagException(ex.toString());
        }   
    	 return TagSupport.EVAL_PAGE;
    }
}

