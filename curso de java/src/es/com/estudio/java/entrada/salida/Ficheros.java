package es.com.estudio.java.entrada.salida;
import java.io.*;

class LeeFichero {
   public static void main(String [] arg) {
	   FileReader fr=null;
      try {
         // Apertura del fichero y creacion de BufferedReader
    	 File archivo= new File ("C:\\archivo.txt");
         fr = new FileReader (archivo);
         BufferedReader br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         while((linea=br.readLine())!=null)
            System.out.println(linea);
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
   }
}
