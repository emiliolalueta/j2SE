<%-- 
    Document   : carrito
    Created on : 08-jun-2011, 11:56:38
    Author     : Alumno
--%>

<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.*,java.sql.*,java.lang.*"%>
<!DOCTYPE html>
<html>
    <head>    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../css/panel.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
      
    
   <div id="invisible"> 
   <jsp:include page="menus/horizontaldemas.jsp" flush="true"/><br><br><br>
   
        <form name="jubilados" action="carrito_1.jsp" method="POST">
            <%
            Statement sentencia;
            ResultSet registros;
            String consulta;
            int num=0;
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","BBDD","BBDD");
            sentencia=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            consulta="select titulo,precio,foto from peliculas";
            registros=sentencia.executeQuery(consulta);
            int posicion=1;
            
            if(request.getParameter("pos")!=null)
            {
                posicion=Integer.parseInt(request.getParameter("pos"));
            }
            registros.last();
            num=registros.getRow();
            registros.absolute(posicion);
            %>
            <center><h3>Peliculas</h3></center><br><br>
            <table border="8" align="center" bgcolor="yellow">
                <%
                for(int i=0;i<5&&!registros.isAfterLast();i++)
                {%>
                <tr><td><input type="checkbox" name="peliculas" value="<%=registros.getString(1)%>"></td>
                <td><%=registros.getString(1)%></td>
                <td><%=registros.getString(2)%></td>
                </tr>
                <%registros.next();
                }
                
                %>
            </table><br><br>
            <table border="8"><tr><%
                        int numpagina=1;
                        for(int i=0;i<num;i+=3)
                        {%>
                        <td><a href=carrito_1.jsp?valor=3&pos=<%=i+1%>><%=numpagina%></a></td>
                        <%numpagina++;                    
                        }%>
                    </tr>
            </table>
                <br><br>
                <center><input type="submit" name="anadir" value="Comprar peliculas"></center>                  
        </form>
        <form name ="form2" action="compra_1.jsp" method="post">
                    <input type="submit" name="suma" value="ver carrito compra">
                    <%cn.close();%>
        </form>
     </div>        
         <jsp:include page="menus/menu.jsp" flush="true"/>
        
    	<a href="index.jsp">  
       
       
        
        
        
        
        
        
                    <%
                    HttpSession sesion=request.getSession();                    
                    String [] listapeliculas=null;
                    HashMap lista=new HashMap();
                    if(sesion.getAttribute("ahorro")!=null)
                    {                    
                        if(request.getParameterValues("peliculas")!=null)
                        {
                            listapeliculas=request.getParameterValues("peliculas");                            
                            for (int i=0;i<listapeliculas.length;i++)
                            {
                                //ahorroEmp +=Integer.parseInt(listapeliculas[i]);
                                lista.put(listapeliculas[i].toString(),i);
                            }
                            
                            sesion.setAttribute("carrito",lista);
                        }
                    }else
                    {
                        sesion.setAttribute("carrito",lista);
                        // ************ otra solucion****************
                        //<%ArrayList<Integer>productos;
                        //productos=(ArrayList<Integer>)request.getSession().getAttribute("compra");
                        //HashMap elementos=new HashMap();
                        //String datos="";
                        //for (Integer num:productos)
                        //{
                        //      elementos.put(num,0);
                        //}
                        //for (Integer peli:productos)
                        //{
                        //  for(object obj:elementos.entrySet())
                        //   {
                        //          Entry ent=(Entry)obj;
                        //          int idpeli=Integer.ParseInt(ent.getKey().toString());
                        //          int repeticiones=Integer.parseInt(ent.getValue().toString());
                        //      if(idpeli==peli)
                        //      {
                        //          repeticiones +=1;
                        //          ent.setvalue(repeticiones);
                        //      }
                        //   }
                        //      datos +=peli + ",";
                        //}
                        //      datos=datos.subString(0,datos.lastIndexOf(","));
                        //      String consulta="seleciona idpelicula,precio,foto,titulo from pelicula where idpelicula in("+datos+")";
                        //      Statement st=cn.createStatement();      
                        //      ResultSet rs=st.executeQuery(consulta);
                        //      String tabla="<table border='1'>";
                        //      int total=0;
                        //      while(rs.next())
                        //      {
                        //          tabla +="<tr>";
                        //          int preciounidad=rs.getInt("PRECIO");
                        //          int idpeli=rs.getInt("IDPELICULA");
                        //          Integer cantidad=(Integer) elementos.get(idpeli);
                        //          tabla +="<td><img src='carteles/" + rs.getString("foto");
                        //          tabla +="'width='50' height='70'/></td>";
                        //          tabla +="<td>" + rs.getString("TITULO") + "</td>";
                        //          tabla +="<td>" + preciounidad + "</td>";
                        //          tabla +="<td>" + cantidad + "</td>";
                        //          tabla +="<td>" + (preciounidad *cantidad) + "</td>";
                        //          total +=(preciounidad *cantidad);
                        //          tabla +="</tr>";
                        //      }                        
                        //**********************************************************
                    }%>
     
    
   
    </body>
</html>
