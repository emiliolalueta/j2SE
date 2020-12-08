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

public class combo {
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
         public String pintarCombo(String consulta,String nombre,String seleccionado) throws Exception{
            String combo="";
             try{
                this.conectar();
                Statement st=this.cn.createStatement();
                ResultSet rs=st.executeQuery(consulta);
                combo="<select name='"+ nombre + "'>";
             while(rs.next())
             {
                    if(rs.getString(2).equals(seleccionado)){
                        combo +="<option selected ";
                    }
                    else
                    {
                        combo +="<option ";
                    }
                        combo +="value='" + rs.getString(2) + "'>";
                        combo +=rs.getString(1) + "</option>";
             }
                rs.close();
                combo +="</select>";
                return combo;
             }
             catch(Exception ex){
                 throw new Exception("Mi fallo" + ex.toString());
                 //return combo;
             }
         }
}
