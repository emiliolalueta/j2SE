package es.com.estudio.java;

public class EjecutarString {

	public static void main(String[] args) {
		
		String string = "Esta es mi frase";
		String[] parts = string.split(" ");

		
		String numeros="";
		String demas="";		
		String vocales="";
		
		
		for (String string2 : parts) {
			System.out.println(string2);
			int contador=0;

			for(int x=0;x<string2.length();x++) {
				 if ((string2.charAt(x)=='a') || 
					 (string2.charAt(x)=='e') || 
					 (string2.charAt(x)=='i') || 
					 (string2.charAt(x)=='o') || 
					 (string2.charAt(x)=='u') ||
					 (string2.charAt(x)=='A') || 
					 (string2.charAt(x)=='E') || 
					 (string2.charAt(x)=='I') || 
					 (string2.charAt(x)=='O') || 
					 (string2.charAt(x)=='U')){ 
				  
				    contador++;
				     vocales=vocales.concat(String.valueOf(string2.charAt(x)));
				    System.out.println(vocales);
				  }else if ((string2.charAt(x)=='1') ||
						    (string2.charAt(x)=='2') ||
					  		(string2.charAt(x)=='3') ||
					  		(string2.charAt(x)=='4') ||
					  		(string2.charAt(x)=='5') ||
					  		(string2.charAt(x)=='6') ||
					  		(string2.charAt(x)=='7') ||
					  		(string2.charAt(x)=='8') ||
					  		(string2.charAt(x)=='9') ||
					  		(string2.charAt(x)=='0')) {
					  numeros= numeros.concat(String.valueOf(string2.charAt(x)));
					  		
				}else {
					demas=demas.concat(String.valueOf(string2.charAt(x)));
				}
			}
				 System.out.println("Este String tiene " + contador + " vocales");
				// vocal=voca.concat(vocales);
		}
		System.out.println("Este es el string de letras " + vocales);
		System.out.println("Este es el string de numeros " + numeros);
		System.out.println("Este es el string de consonantes " + demas);


	}

}

		/*
		String part1 = parts[0]; // 004
		String part2 = parts[1]; // 034556
		
		String frase="Esta es mi frase";
		
		for(int i=0;i<frase.length();i++) {
			char letra = frase.charAt(i);
			if((letra>=65 && letra<=90) || 
			   (letra>=97 && letra<=122) || 
			    letra=='Ñ' || letra=='ñ') {
				
			}
			
			*/

/*
class EsString{
	public EsString(String args) {
		StringTokenizer st = new StringTokenizer(args, " ");
		while(st.hasMoreElements()) {
			System.out.println("La palabra es : " + st.nextElement());
		}
	}
}*/
