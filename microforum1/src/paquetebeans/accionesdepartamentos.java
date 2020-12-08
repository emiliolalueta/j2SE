/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetebeans;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alumno
 */
public class accionesdepartamentos {
    Connection cn;
    public void insertar(int dept_no,String nom,String loc) throws Exception{
        try
        {
            this.conectar();        
            CallableStatement cst=this.cn.prepareCall("{call accion_departamentos.insertar_dept(???)}");
            cst.setInt(1,dept_no);
            cst.setString(2, nom);
            cst.setString(3, loc);
            cst.executeUpdate();
        }
        catch(Exception ex)
            {
               // System.out.print("Exception:" + ex.toString()); 
                throw new Exception("Mi fallo" + ex.toString());
                //return lista;
            }   
    }
    public void borrar(int dept_no) throws Exception{
        try
        {
                this.conectar(); 
                CallableStatement cst=this.cn.prepareCall("{call accion_departamentos.borrar_dept(?)}");
                cst.setInt(1,dept_no);
                cst.executeUpdate();
        }
        catch(Exception ex)
        {
                throw new Exception("Mi fallo" + ex.toString());
        }
                
    }
    public void modificar(int dept_no,String nom,String loc) throws Exception{
         try
            {
                this.conectar();
                CallableStatement cst=this.cn.prepareCall("{call accion_departamentos.modificar_dept(?)}");
                cst.setInt(1,dept_no);
                cst.executeUpdate();
            
            }
        catch(Exception ex)
            {
                throw new Exception("Mi fallo" + ex.toString());
            }
    }
    
     public String getLocalidad(int dept_no) throws Exception{             
        try            
            {  
                this.conectar();                 
                PreparedStatement pst=cn.prepareStatement("select loc from dept where dept_no=?");                
                pst.setInt(1, dept_no);
                ResultSet rs=pst.executeQuery();     
                String  lista="";
                while(rs.next()){
                lista = rs.getString("loc") ;                
                }
                rs.close();                
                return lista;
            }
        catch(Exception ex)
            {
               // System.out.print("Exception:" + ex.toString()); 
                throw new Exception("Mi fallo" + ex.toString());
                //return lista;
            }    
    }            
     public String getNombre(int dept_no) throws Exception{             
        try            
            {  
                this.conectar();                 
                PreparedStatement pst=cn.prepareStatement("select dnombre from dept where dept_no=?");                
                pst.setInt(1, dept_no);
                ResultSet rs=pst.executeQuery();     
                String  lista="";
                while(rs.next()){
                lista = rs.getString("dnombre");                
                }
                rs.close();                
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
