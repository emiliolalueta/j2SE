/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetebeans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Alumno
 */
public class buscasalario1 
{
    
Connection cn;
    public int getSalario(String apellido)
    {    
        int salario=0;
        try
            {                       
                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BBDD","BBDD");
                Statement st=cn.createStatement();
                String consulta="select salario from emp where apellido='" + apellido + "'" ;
                ResultSet rs=st.executeQuery(consulta);
                
                while(rs.next())
                {
                    salario=rs.getInt("salario");
                }   
                    return  salario;
            }
        catch(Exception ex)
            {
                System.out.print("Exception:" + ex.toString());  
                return  salario;
            }
    }
    
    public int getSal(String apellido){
        //funcion igual que la anterior pero corregida por el profesor mirarla
         int salario=-1;
         try
            {         
               
                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BBDD","BBDD");
                PreparedStatement pst=cn.prepareStatement("select salario from emp where apellido=?");
                pst.setString(1,apellido.toUpperCase());
                ResultSet rs=pst.executeQuery();                
               if (rs.next()==true)
               {
                   salario=rs.getInt("salario");
               }
               rs.close();
               return salario;
            }
        catch(Exception ex)
            {
                System.out.print("Exception:" + ex.toString());  
                return  salario;
            }
    }  
    
    public String getSalariomayor(int salario) throws Exception{             
        try            
            {  
                this.conectar();                
                //Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BBDD","BBDD");  
                PreparedStatement pst=cn.prepareStatement("select apellido from emp where salario>?");                
                pst.setInt(1, salario);
                ResultSet rs=pst.executeQuery();     
                String  lista="<ul>";
                while(rs.next()){
                lista +="<li>" + rs.getString("apellido") +"</li>";                
                }
                rs.close();
                lista +="</ul>";
                return lista;
            }
        catch(Exception ex)
            {
               // System.out.print("Exception:" + ex.toString()); 
                throw new Exception("Mi fallo" + ex.toString());
                //return lista;
            }    
    }
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
}
