// Demostraci�n de los men�s
package ejemplos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PruebaMenu extends JFrame
{
   private final Color valoresColor[]={Color.black,Color.blue,Color.red,Color.green };   
   private JRadioButtonMenuItem elementosColor[], tiposLetra[];
   private JCheckBoxMenuItem elementosEstilo[];
   private JLabel pantallaEtiqueta;
   private ButtonGroup grupoTiposLetra, grupoColores;
   private int estilo;
   
   
   
   // configurar GUI
   public PruebaMenu()
   {
      super( "Uso de objetos JMenu" );     

      // establecer men� Archivo y sus elementos de men�
      JMenu menuArchivo = new JMenu( "Archivo" );
      menuArchivo.setMnemonic( 'A' );

      // establecer elemento de men� Acerca de...
      JMenuItem elementoAcerca = new JMenuItem( "Acerca de..." );
      elementoAcerca.setMnemonic( 'c' );
      menuArchivo.add( elementoAcerca );
      elementoAcerca.addActionListener(

         new ActionListener() {  // clase interna an�nima

            // mostrar cuadro de di�logo de mensaje cuando el usuario seleccione Acerca de...
            public void actionPerformed( ActionEvent evento )
            {
               JOptionPane.showMessageDialog( PruebaMenu.this,
                  "�ste es un ejemplo\ndel uso de men�s",
                  "Acerca de", JOptionPane.PLAIN_MESSAGE );
            }

         }  // fin de la clase interna an�nima

      ); // fin de la llamada a addActionListener
 
      // establecer elemento de men� Salir
      JMenuItem elementoSalir = new JMenuItem( "Salir" );
      elementoSalir.setMnemonic( 'S' );
      menuArchivo.add( elementoSalir );
      elementoSalir.addActionListener(

         new ActionListener() {  // clase interna an�nima

            // terminar la aplicaci�n cuando el usuario haga clic en elementoSalir
            public void actionPerformed( ActionEvent evento )
            {
               System.exit( 0 );
            }

         }  // fin de la clase interna an�nima

      ); // fin de la llamada a addActionListener

      // crear barra de men�s y adjuntarla a la ventana PruebaMenu
      JMenuBar barra = new JMenuBar();  
      setJMenuBar( barra );  
      barra.add( menuArchivo );    

      // crear men� Formato, con sus submen�s y elementos de men�
      JMenu menuFormato = new JMenu( "Formato" );  
      menuFormato.setMnemonic( 'F' );

      // crear submen� Color
      String colores[] = { "Negro", "Azul", "Rojo", "Verde" };

      JMenu menuColor = new JMenu( "Color" );
      menuColor.setMnemonic( 'C' );

      elementosColor = new JRadioButtonMenuItem[ colores.length ];
      grupoColores = new ButtonGroup();
      ManejadorEventos manejadorEventos = new ManejadorEventos();

      // crear elementos de men� tipo botones de opci�n para el men� Color
      for ( int cuenta = 0; cuenta < colores.length; cuenta++ ) {
         elementosColor[ cuenta ] = 
            new JRadioButtonMenuItem( colores[ cuenta ] );
         menuColor.add( elementosColor[ cuenta ] );
         grupoColores.add( elementosColor[ cuenta ] );
         elementosColor[ cuenta ].addActionListener( manejadorEventos );
      }

      // seleccionar primer elemento del men� Color
      elementosColor[ 0 ].setSelected( true );  

      // agregar el men� Formato a la barra de men�s
      menuFormato.add( menuColor );
      menuFormato.addSeparator();

      // crear submen� Tipo de letra
      String nombresTiposLetra[] = { "Serif", "Monospaced", "SansSerif" };

      JMenu menuTiposLetra = new JMenu( "Tipo de letra" );
      menuTiposLetra.setMnemonic( 'T' );

      tiposLetra = new JRadioButtonMenuItem[ nombresTiposLetra.length ];
      grupoTiposLetra = new ButtonGroup();

      // crear elementos de men� tipo botones de opci�n para el men� Tipos de letra
      for ( int cuenta = 0; cuenta < tiposLetra.length; cuenta++ ) {
         tiposLetra[ cuenta ] = new JRadioButtonMenuItem( nombresTiposLetra[ cuenta ] );
         menuTiposLetra.add( tiposLetra[ cuenta ] );
         grupoTiposLetra.add( tiposLetra[ cuenta ] );
         tiposLetra[ cuenta ].addActionListener( manejadorEventos );
      }

      // seleccionar el primer elemento del men� Tipo de letra
      tiposLetra[ 0 ].setSelected( true );

      menuTiposLetra.addSeparator();

      // establecer elementos del men� Estilo
      String nombresEstilo[] = { "Negrita", "Cursiva" };

      elementosEstilo = new JCheckBoxMenuItem[ nombresEstilo.length ];
      ManejadorEstilo manejadorEstilo = new ManejadorEstilo();

      // crear elementos de men� tipo casilla de verificaci�n para el men� Estilo
      for ( int cuenta = 0; cuenta < nombresEstilo.length; cuenta++ ) {
         elementosEstilo[ cuenta ] = 
            new JCheckBoxMenuItem( nombresEstilo[ cuenta ] );
         menuTiposLetra.add( elementosEstilo[ cuenta ] );
         elementosEstilo[ cuenta ].addItemListener( manejadorEstilo );
      }

      // colocar men� Tipo de letra en el men� Formato
      menuFormato.add( menuTiposLetra );

      // agregar men� Formato a la barra de men�s
      barra.add( menuFormato );  
     
      // establecer etiqueta para mostrar texto
      pantallaEtiqueta = new JLabel( "Texto de ejemplo", SwingConstants.CENTER );
      pantallaEtiqueta.setForeground( valoresColor[ 0 ] );
      pantallaEtiqueta.setFont( new Font( "Serif", Font.PLAIN, 72 ) );

      getContentPane().setBackground( Color.CYAN );
      getContentPane().add( pantallaEtiqueta, BorderLayout.CENTER );

      setSize( 550, 200 );
      setVisible( true );

   } // fin del constructor

   public static void main( String args[] )
   {
      PruebaMenu aplicacion = new PruebaMenu();
      
      aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   }

   // clase interna para manejar eventos de acci�n de los elementos de men�
   private class ManejadorEventos implements ActionListener {

      // procesar selecciones de color y tipo de letra
      public void actionPerformed( ActionEvent evento )
      {
         // procesar selecci�n de color
         for ( int cuenta = 0; cuenta < elementosColor.length; cuenta++ )
  
            if ( elementosColor[ cuenta ].isSelected() ) {
               pantallaEtiqueta.setForeground( valoresColor[ cuenta ] );
               break;
               
            }
 
         // procesar selecci�n de tipo de letra
         for ( int cuenta = 0; cuenta < tiposLetra.length; cuenta++ )

            if ( evento.getSource() == tiposLetra[ cuenta ] ) {
               pantallaEtiqueta.setFont( 
                  new Font( tiposLetra[ cuenta ].getText(), estilo, 72 ) );
               break;
            }

         repaint();  

      } // fin del m�todo actionPerformed

   } // fin de la clase ManejadorEventos

   // clase interna para manejar eventos de los elementos de men� tipo casilla de verificaci�n
   private class ManejadorEstilo implements ItemListener {

      // procesar selecciones de estilo de tipo de letra
      public void itemStateChanged( ItemEvent e )
      {
         estilo = 0;

         // checar selecci�n de negrita
         if ( elementosEstilo[ 0 ].isSelected() )
            estilo += Font.BOLD;

         // checar selecci�n de cursiva
         if ( elementosEstilo[ 1 ].isSelected() )
            estilo += Font.ITALIC;

         pantallaEtiqueta.setFont( 
            new Font( pantallaEtiqueta.getFont().getName(), estilo, 72 ) );

         repaint();
      }

   } // fin de la clase ManejadorEstilo

} // fin de la clase PruebaMenu