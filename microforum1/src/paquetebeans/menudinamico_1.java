/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetebeans;

import java.sql.*;

/**
 *
 * @author Alumno
 */
public class menudinamico_1 {
    private Connection cn;
    
    public void conectar() throws Exception {
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            this.cn = DriverManager.getConnection
                        ("jdbc:oracle:thin:@localhost:1521:XE", "BBDD",
                        "BBDD");
        } catch (Exception ex) {
            System.out.println("Excepcion: " + ex.toString());
            throw new Exception(ex.toString());
        }
    }
    
    public String crearMenu(String consulta, String pagina, String dato) {
        String menu;
        try {
            this.conectar();
            menu = "<table>";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            while (rs.next()) {
                menu += "<tr>";
                menu += "<td>";
                menu += "<img src='LogoMadrid.jpg'>&nbsp;";
                menu += "<a href='" + pagina + "?" + dato + "=" +
                        rs.getString(2) + "'>";
                menu += rs.getString(1) + "</a>";
                menu += "</td>";
                menu += "</tr>";
            }
            menu += "</table>";
        } catch (Exception ex) {
            menu = ex.toString();
        }
        return menu;
    }
}
