package proyecto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.mysql.jdbc.Driver;

public class Conexion {
	static Connection conexion ;
	static Statement sentencia;
	static ResultSet resultado;
	public static void conectar(){
		Connection conexion;			
			try{
		     Class.forName( "com.mysql.jdbc.Driver" );		     
	   		}catch( Exception e ) {
	   			e.printStackTrace();
			}		   		
			    try {			       
			     // Establecemos la conexión con la base de datos.	
			     conexion = DriverManager.getConnection ("jdbc:mysql://178.32.68.44/libreria","root", "thecult-rise");	
			    // conexion = DriverManager.getConnection ("jdbc:mysql://localhost/libreria","admin", "pass");
			     sentencia = conexion.createStatement();		        
			        
			      }
			    catch( Exception e ) {
			        System.out.println(e);
			        
			        }
			      
	}	
}