// Uso de un objeto JPanel personalizado.
package ejemplos;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class PruebaPanelPersonalizado extends JFrame
{
	private JPanel panelBotones;
	private PanelPersonalizado miPanel;
	private JButton botonCirculo, botonCuadrado;
	DemoPanel comp;
	// configurar GUI
	public PruebaPanelPersonalizado()
	{
		super( "Prueba de PanelPersonalizado" );
		// crear �rea personalizada de dibujo
		miPanel = new PanelPersonalizado();
		miPanel.setBackground( Color.GREEN );
		
		// establecer botonCuadrado
		botonCuadrado = new JButton( "Cuadrado" );
		botonCuadrado.addActionListener(
			new ActionListener()
			{
				 // clase interna an�nima
				 // dibujar un cuadrado
				 public void actionPerformed( ActionEvent evento )
				 {
				 	miPanel.dibujar( PanelPersonalizado.CUADRADO );
				 }
			} // fin de la clase interna an�nima
		); // fin de la llamada a addActionListener
		
		botonCirculo = new JButton( "C�rculo" );
		botonCirculo.addActionListener(
			new ActionListener()
			{
				// clase interna an�nima
				// dibujar un c�rculo
				public void actionPerformed( ActionEvent evento )
				{
					miPanel.dibujar( PanelPersonalizado.CIRCULO );
				
				}
			} // fin de la clase interna an�nima
		); // fin de la llamada a addActionListener
		// establecer panel con botones
		panelBotones = new JPanel();
		panelBotones.setLayout( new GridLayout( 1, 2 ) );
		panelBotones.add( botonCirculo );
		panelBotones.add( botonCuadrado );
		
		// adjuntar panel de botones y �rea personalizada de dibujo al panel de contenido
		Container contenedor = getContentPane();
		contenedor.add( miPanel, BorderLayout.CENTER );
		contenedor.add( panelBotones, BorderLayout.SOUTH );
		//contenedor.add( DemoPanel.class, BorderLayout.SOUTH );
		
		
		setSize(300,150);
		setVisible(true);
	} // fin del constructor PruebaPanelPersonalizado
	public static void main( String args[] )
	{
		PruebaPanelPersonalizado aplicacion = new PruebaPanelPersonalizado();
		aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
} // fin de la clase PruebaPanelPersonalizado