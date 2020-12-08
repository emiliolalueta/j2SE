/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alumno
 */
@WebServlet(name = "ServletCookies", urlPatterns = {"/ServletCookies"})
public class ServletCookies extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void peticionLlamada(HttpServletRequest peticion, HttpServletResponse respuesta)throws ServletException,IOException{
    Cookie[]galletas;
    Cookie galletausuario=null;
    String valorcookie="";
    String fechahoy="";
    boolean nuevo=true;
    int numvisitas=0;
    String usuario=peticion.getParameter("txtusuario");
    String password=peticion.getParameter("txtpassword");
    galletas=peticion.getCookies();
    if(galletas!=null){
        for(int i=0;i<galletas.length;i++)
        {
            if(galletas[i].getName().equals(usuario+password))// &&  galletas[i].getValue().equals(password))
            {
                galletausuario=galletas[i];
                nuevo=false;
                break;
            }
        }
    }
    respuesta.setContentType("text/html");
    PrintWriter flujo=respuesta.getWriter();
    flujo.println("<html>");
    flujo.println("<head><title>Respuesta del servlet</title></head>");
    flujo.println("<body text='#FFFFFF' BGCOLOR='#FF00FF><CENTER><H1>");
    if (nuevo==true)
    {
        fechahoy=this.crearFechaVisita();
        valorcookie=usuario + "," + password + ",1," + fechahoy;
        //creamos la cookie para el usuario
        galletausuario=new Cookie(usuario + password,valorcookie);
        galletausuario.setMaxAge(30);
        respuesta.addCookie(galletausuario);
        flujo.println("gracias por registrarse con galletas triqui<br>");
        flujo.println("hoy es" +fechahoy+"<br>");
        flujo.println("<h3>Esperamos que disfrute Sr/Sra "+usuario+"<h3>");
    }
    else{
        flujo.println("Bienvenido a tu sitio de galletas triqui");
        valorcookie=galletausuario.getValue();
        String datos[]=valorcookie.split(",");
        usuario=datos[0];
        password=datos[1];
        numvisitas=Integer.parseInt(datos[2]);        
        numvisitas++;
        String fechaultimavisita=datos[3];
        flujo.println("<h1> Hola de nuevo Sr/Sra "+usuario+"</h1>");
        flujo.println("<h2>Su ultima visita fue el" +   fechaultimavisita +"</h2>");
        flujo.println("<h3>Numero de visitas a la web "+String.valueOf(numvisitas)+ "</h3>");
        fechahoy=this.crearFechaVisita();
        valorcookie=usuario+"," +password+","+String.valueOf(numvisitas)+","+fechahoy;
        galletausuario.setValue(valorcookie);             
                
    }
    flujo.println("</h1></center></body></html>");
    flujo.close();    
    }

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletCookies</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletCookies at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
            
          }
        catch(Exception ex)
        {
            out.println("Error" + ex.toString());            
            
        } finally {            
            out.close();
        }
    }

    
  private String crearFechaVisita(){
     Calendar calendario=new GregorianCalendar();
     String fechaactual;
     String dia;
     String mes;
     String anyo;
     dia =String.valueOf(calendario.get(Calendar.DATE));
     mes =String.valueOf(calendario.get(Calendar.MONTH)+1);
     anyo =String.valueOf(calendario.get(Calendar.YEAR)); 
     fechaactual=dia+"/" + mes + "/" +anyo;
     return fechaactual;
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
