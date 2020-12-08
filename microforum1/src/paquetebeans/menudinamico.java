/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetebeans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Alumno
 */
public class menudinamico {
         Connection cn;
         public void conectar() throws Exception
      {
          try   
          {
              DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
              cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BBDD","BBDD");          
          }  
          catch(Exception ex){
               System.out.println("Exception:" + ex.toString());    
               throw new Exception("Mi fallo" + ex.toString());
          }
      }
 public String crearMenu(String consulta,String pagina,String dato)
 {
  String menu;
  try
  {
      this.conectar();
      menu="<table>";
      Statement st=cn.createStatement();
      ResultSet rs=st.executeQuery(consulta);
      while(rs.next()){
          menu +="<tr>";
          menu +="<td>";
          menu +="<img src='1.gif'>&nbsp;";
          menu +="<a href='" + pagina + "?" + dato + "=" + rs.getString(2) + "'>";
          menu +=rs.getString(1) + "</a>";
          menu +="</td>";
          menu +="</tr>";
      }
       menu +="</table>";
  }catch(Exception ex)
  {
      menu=ex.toString();
  }
  return menu;
 }
}
