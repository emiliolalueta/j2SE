/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alumno
 */
@WebServlet(name = "tabladinamica", urlPatterns = {"/tabladinamica"})
public class tabladinamica extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet tabladinamica</title>");  
            out.println("</head>");
            out.println("<body>");            
            
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","BBDD","BBDD");
            Statement st=cn.createStatement();
            String dato=request.getParameter("txttabla");
            ResultSet rs= st.executeQuery("select * from "  + dato );
            ResultSetMetaData rsmd=rs.getMetaData();
            int columnas=rsmd.getColumnCount();
            String tabla="<table border='5'>";
            while(rs.next())
            {
                tabla +="<tr>";
                    for(int c=1;c<=columnas;c++)
                    {
                        tabla +="<td>" + rs.getString(c) + "</td>";                        
                    }     
                tabla +="</tr>";
            }
            tabla +="</table>";
            rs.close();
            out.println(tabla); 
           
            out.println("</body>");
            out.println("</html>");   
        
        }
            catch(Exception ex)
            {
                out.println("Error" + ex.toString());
            }               
            
         finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
