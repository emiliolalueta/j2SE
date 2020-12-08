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
@WebServlet(name = "Consulta", urlPatterns = {"/Consulta"})
public class Consulta extends HttpServlet {

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
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","BBDD","BBDD");
            Statement st=cn.createStatement();     
            ResultSet rs1=st.executeQuery("select oficios  from emp");
            
           
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Consulta</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<form action='Consulta' method='POST'>");
            
            out.println("<input type='checkbox' name='chckb' value='ON'/><br>");
            
            
            
            out.println("<input type='checkbox' name='chckb' value='ON'/><br>");
            out.println("<input type='checkbox' name='chckb' value='ON'/><br>");
            out.println("<input type='checkbox' name='chckb' value='ON'/><br>");            
            out.println("<input type='submit' value='Iniciar'/>");                
            String[] dato=request.getParameterValues("chckb");
            ResultSet rs2=st.executeQuery("select apellido  from emp where oficio=" + dato );
            
            if (dato!=null){
                            int i=-1;
                            String tabla="<table border='5'>";
                            while(rs2.next())
                            {                                
                                tabla +="<tr>";                        
                                        i++;
                                        tabla +="<td>";
                                        tabla +=dato[i];
                                        tabla +="</td>";                 
                                    
                                tabla +="</tr>";
                            }
                            tabla +="</table>";
            }                    
             out.println("</form>");
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
