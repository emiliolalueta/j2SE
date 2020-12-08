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
public class buscasalario 
{
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
    
    public void getsalariomayor(int salario){             
        try            
            {  
                DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BBDD","BBDD");  
                PreparedStatement pst=cn.prepareStatement("select apellido from emp where salario>?");
                //pst.setString(1,salario);
                pst.setInt(1,salario);
                ResultSet rs=pst.executeQuery();     
                
            }
        catch(Exception ex)
            {
                System.out.print("Exception:" + ex.toString());                 
            }    
}
}
