package driver;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Consulta.consulta();
		 Menus00 panel = new Menus00();
		    JFrame ventana = new JFrame();
		    Pantalla00 pan=new Pantalla00();
		    
		    ventana.getContentPane().add( panel,BorderLayout.NORTH );
		    ventana.getContentPane().add( pan.mainPanel,BorderLayout.CENTER );
		    ventana.addWindowListener( new WindowAdapter() {
		      public void windowClosing( WindowEvent evt ) {
		        System.exit( 0 );
		        }
		      } );

		    ventana.setSize( 620,700 );
		    ventana.setTitle( "GESTIÓN DE LIBRERIA" );
		    ventana.setVisible( true );
	}
}
