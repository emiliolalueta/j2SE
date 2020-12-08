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
public class plantilla1
{
    private int empleadono;
    private String oficio;
    private String apellido;
    private int salario;
    private String turno;
    private String funcion;
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
         public boolean guardar() throws Exception{
         try
            {
                boolean resultado;
                this.conectar();                                
                String consulta="select apellido,funcion,salario,turno from plantilla where empleado_no=?";
                PreparedStatement pst=cn.prepareStatement(consulta);
                pst.setInt(1, getEmpleadono());
                ResultSet rs=pst.executeQuery();
                resultado=rs.next();
                if(resultado==true)
                {
                    this.funcion=rs.getString("funcion");
                    this.apellido=rs.getString("apellido");
                    this.salario=rs.getInt("salario");
                    this.turno=rs.getString("turno");                    
                }
                rs.close();
                return resultado;
            }
        catch(Exception ex)
            {
                throw new Exception("Mi fallo" + ex.toString());
            }
    }             
        public int modificar(String ape) throws Exception{
         try
            {
                int resultado;
                this.conectar();
                String consulta="update plantilla set apellido=? where emplead_no=?";
                PreparedStatement pst=cn.prepareStatement(consulta);      
                pst.setString(1,this.apellido);
                pst.setInt(2, this.getEmpleadono());
                resultado=pst.executeUpdate();
                return resultado;          
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

    /**
     * @return the funcion
     */
    public String getFuncion() {
        return funcion;
    }

    /**
     * @param funcion the funcion to set
     */
    public void setFuncion(String funcion) {
        this.funcion = funcion;
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

    /**
     * @return the empleadono
     */
    public int getEmpleadono() {
        return empleadono;
    }

    /**
     * @param empleadono the empleadono to set
     */
    public void setEmpleadono(int empleadono) {
        this.empleadono = empleadono;
    }
}