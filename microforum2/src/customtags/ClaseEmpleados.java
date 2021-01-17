/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package customtags;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.jsp.tagext.TagSupport;


import java.io.IOException;
import java.util.Date;
import javax.servlet.jsp.*;

/**
 *
 * @author Alumno
 */
public class ClaseEmpleados extends TagSupport
{
    Connection cn;
      public void conectar() throws Exception
      {
          try   
          {
              DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
              cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BBDD","BBDD");          
          }  
          catch(Exception ex){
               //System.out.print("Exception:" + ex.toString());    
               throw new Exception("Mi fallo" + ex.toString());
          }
      }    
    
    
    public int doStartTag()throws JspTagException{
     
            return TagSupport.SKIP_BODY;
        
    }
    public int doEndTag()throws JspTagException{
    	
               try
            {
                boolean resultado;
                this.conectar();            
                
                Statement st=cn.createStatement();
                String consulta="select emp_no,apellido,oficio,dir,salario from emp";
                ResultSet rs=st.executeQuery(consulta);
                resultado=rs.next();  
                pageContext.getOut().write("<table border='3'>");
                
                while(rs.next()){                   
                		pageContext.getOut().write("<tr>");
		                pageContext.getOut().write("<td>"+ rs.getString(1)+ "</td>");
		                pageContext.getOut().write("<td>"+ rs.getString(2) + "</td>");
		                pageContext.getOut().write("<td>"+ rs.getString(3) + "</td>");
		                pageContext.getOut().write("<td>"+ rs.getString(4) + "</td>");
		                pageContext.getOut().write("<td>"+ rs.getString(5) + "</td>");
		                pageContext.getOut().write("</tr>");
                }    
                
                pageContext.getOut().write("</table>");
                rs.close();
            }
        catch(Exception ex)
            {
                //throw new Exception("Mi fallo" + ex.toString());
            }          
        
        return TagSupport.EVAL_PAGE;
    }
}
