/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetebeans;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
/**
 *
 * @author Alumno
 */
public class plantilla {
    private String oficio;
    private String apellido;
    private int salario;
    private String turno;
    
    private Connection cn;
       public void conectar() throws Exception
      {
          try   
          {
              DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
              setCn(DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BBDD","BBDD"));          
          }  
          catch(Exception ex){
               //System.out.print("Exception:" + ex.toString());    
               throw new Exception("Mi fallo" + ex.toString());
          }
      }
        public void modificar(String ape) throws Exception{
         try
            {
                this.conectar();
                Statement st=cn.createStatement();                
                String consulta="update emp set=" +  ape + "where apellido='" + apellido + "'" ;
                st.executeUpdate(consulta);
            
            }
        catch(Exception ex)
            {
                throw new Exception("Mi fallo" + ex.toString());
            }
    }
    /**
     * @return the oficio
     */
    public String getOficio() {
        return oficio;
    }
    /**
     * @param oficio the oficio to set
     */
    public void setOficio(String oficio) {
        this.oficio = oficio;
    }
    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }
    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    /**
     * @return the salario
     */
    public int getSalario() {
        return salario;
    }
    /**
     * @param salario the salario to set
     */
    public void setSalario(int salario) {
        this.salario = salario;
    }
    /**
     * @return the turno
     */
    public String getTurno() {
        return turno;
    }
    /**
     * @param turno the turno to set
     */
    public void setTurno(String turno) {
        this.turno = turno;
    }
    /**
     * @return the cn
     */
    public Connection getCn() {
        return cn;
    }
    /**
     * @param cn the cn to set
     */
    public void setCn(Connection cn) {
        this.cn = cn;
    }       
}
