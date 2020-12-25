<%-- 
    Document   : newjsp
    Created on : 08-jun-2011, 8:34:13
    Author     : Alumno
--%>

<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletRequestContext"%>
<%@page import="java.io.File"%>
<%@page language="java" contentType="text/html;charset=ISO-8859-1" pageEncoding="ISO-8859-1"
import="java.util.*"
import="org.apache.commons.fileupload.*"
import="org.apache.commons.fileupload.servlet.*"
import="org.apache.commons.fileupload.disk.*"
import="java.io.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    
        <form method="POST" enctype="multipart/form-data">
            <table border="6">
                <tr>
                    <td>Seleccionar fichero</td>
                    <td>
                        <input type="file" name="fichero">
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Subir Archivo" name="btnsubir">
                    </td>    
                </tr>               
            </table>
        </form>
        <%
        String rutaservidor=application.getRealPath("/ficheros/");%>
        <h1><%=rutaservidor%></h1>
        <%File destino=new File(rutaservidor);
        ServletRequestContext src=new ServletRequestContext(request);
        if(ServletFileUpload.isMultipartContent(src))
        {
            DiskFileItemFactory factory=new DiskFileItemFactory((1024*1024),destino);
            ServletFileUpload upload=new ServletFileUpload(factory);
            List lista=upload.parseRequest(src);
            
            File file=null;
            Iterator it=lista.iterator();
            while(it.hasNext())
            {
                FileItem item=(FileItem)it.next();
                if(item.isFormField())
                {
                    %>
                    <h1> <%=item.getFieldName()%></h1>
                    <%out.println(item.getFieldName()+"<br>");
                }else
                {
                 file=new File(item.getName());
                 item.write(new File(destino,file.getName()));%>
                 <h1>Fichero subido</h1>
                 <%}                
            }
        }
        %>
    </body>
</html>
