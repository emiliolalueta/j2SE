/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetebeans;
// ejemplo de setproperty
/**
 *
 * @author Alumno
 */
public class formulario {
    private int cantidad;
    private String nombre;
    private int inferior;
    private int superior;

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * @param inferior the inferior to set
     */
    public void setInferior(int inferior) {
        this.inferior = inferior;
    }
    /**
     * @param superior the superior to set
     */
    public void setSuperior(int superior) {
        this.superior = superior;
    }
    public String getAleatorios()
    {
        String respuesta="<h1>";
        respuesta +=nombre + "</h1>";
        respuesta +="<ul>";
            for(int i=0;i<cantidad;i++)
            {
                Double d=new Double(Math.random()*(superior-inferior+1));
                int num=inferior + d.intValue();
                respuesta +="<li>" + num + "</li>";
            }
                respuesta +="</ul>";
                return respuesta;
    }
}
