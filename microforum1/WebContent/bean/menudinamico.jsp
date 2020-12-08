<%-- 
    Document   : menudinamico
    Created on : 13-jun-2011, 14:38:40
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="mibean" scope="page" class="paquetebeans.menudinamico" />

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        String pagina = "menudinamico.jsp";   
        
        //String pagina="otra.jsp";
        if(request.getParameter("pagina")!=null)
        {
            pagina=request.getParameter("pagina");
        }

        %>
        <div style="float: left">
             <div border-bottom: fuchsia; border: double">
            <img src="../img/LogoMadrid.jpg" />
            <a href="<%=pagina%>?tabla=dept">Departamentos</a>
            <a href="<%=pagina%>?tabla=hospital">Hospitales</a>
        </div>
            <%
            String tabla = request.getParameter("tabla");
            String menu = "";
            String consulta = "";
            if (tabla != null) {
                if (tabla.equals("dept")) {
                    consulta = "select dnombre, dept_no from dept";
                    menu = mibean.crearMenu(consulta, pagina, "dept");
                } else if (tabla.equals("hospital")) {
                    consulta = "select nombre, hospital_cod from hospital";
                    menu = mibean.crearMenu(consulta, pagina, "hospital");
                }
                
            } else if (request.getParameter("dept") != null) {
                String dept = request.getParameter("dept");
                consulta = "select apellido, emp_no from emp where dept_no=" +
                        dept;
                menu = mibean.crearMenu(consulta, pagina, "emp");
                menu += "<hr><a href='" + pagina + "?tabla=dept'>Volver</a>";
            }
               else if(request.getParameter("hospital")!=null)
               {
                   String hospital =request.getParameter("hospital");
                   consulta="select apellido,doctor_no from doctor where hospital_cod=" + hospital;
                   menu =mibean.crearMenu(consulta,pagina,"doctor");
                   menu +="<hr><a href='" + pagina + "?tabla=hospital'>Volver</a>";
               } 
            %>
            <div style="border-width: 2px; border-color: blue">
                <%=menu%>
            </div>
    </div>
    </body>
</html>
