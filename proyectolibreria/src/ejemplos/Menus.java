package ejemplos;

/**
 * Este ejempolo presenta un completo sistema de men�s, partiendo de los
 * items que est�n situados en la barra superior y depleg�ndose las
 * opciones que se pueden seleccionar. Tambi�n se muestra c�mo se
 * colocan iconos sobre etiquetas y la inserci�n de items a la
 * barra de men�
 * 
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menus extends JPanel {
  static final Boolean bT = new Boolean( true ); 
  static final Boolean bF = new Boolean( false );
  static ButtonGroup grupoBotones;
  
  // Clase que se utiliza para crear los distintos tipos de men�s que se
  // va a presentar en la ventana
  static class TipoMenu {
    TipoMenu( int i ) {} 
    };

  static final TipoMenu mi = new TipoMenu( 1 ); // Men� con elementos normales
  static final TipoMenu cb = new TipoMenu( 2 ); // Men� con cajas de selecci�n
  static final TipoMenu rb = new TipoMenu( 3 ); // Men� con botones de radio
  JTextField txt = new JTextField( 10 );
  JLabel lbl = new JLabel( "Gesti�n de libreria", JLabel.CENTER );
  ActionListener al1 = new ActionListener() {
    public void actionPerformed( ActionEvent evt ) {
      txt.setText( ((JMenuItem)evt.getSource() ).getText() );
      }
    };
  ActionListener al2 = new ActionListener() {
    public void actionPerformed( ActionEvent evt ) {
      JMenuItem mi = (JMenuItem)evt.getSource();
      lbl.setText( mi.getText() );
      lbl.setIcon( mi.getIcon() );
      }
    };
  ActionListener al3 = new ActionListener() {
    public void actionPerformed( ActionEvent evt ) {
    	
    	 	//pan.setLayout( new BorderLayout() );  
    	   // pan.add( lbl,BorderLayout.CENTER );
    	    //pan.Pantalla();
    	   //add( pan.mainPanel,BorderLayout.CENTER );
    		JMenuItem mi = (JMenuItem)evt.getSource();
    	      lbl.setText( mi.getText() );
    	      lbl.setIcon( mi.getIcon() );	  	     
    	
      }
    };
   
    
  // En estas estructuras se almacenas los datos de los men�s como si se
  // tratara de los t�picos recursos de X
  public Object menuArchivo[][] = {
    // Nombre del men� y tecla r�pida asociada
    { "Clientes",new Character('A')},
    // Nombre, tipo, tecla r�pida, receptor asociado, habilitado o no
    // para cada uno de los elementos del men�
    { "Altas",mi,new Character('N'),al1,bT},
    { "Bajas",mi,new Character('b'),al1,bT},
    { "Consultas",mi,new Character('G'),al1,bF},
    { "Guardar como...",mi,new Character('c'),al1,bF},
    { null}, // Separador
    { "Salir",mi,new Character('S'),al2,bT},
    };
  public Object menuEdicion[][] = {
    // Nombre del men� y tecla r�pida asociada
    { "Libros disponibles",new Character('E')},
    // Nombre, tipo, tecla r�pida, receptor asociado, habilitado o no
    { "Cortar",mi,new Character('t'),al3,bT},
    { "Copiar",mi,new Character('C'),al1,bT},
    { "Pegar",mi,new Character('P'),al1,bT},
    { null}, // Separator
    { "Seleccionar Todo",mi,new Character('S'),al1,bT},
    };
  public Object menuIconos[][] = {
    // Nombre del men� y tecla r�pida asociada
    { "Gesti�n de usuarios",new Character('I')},
    // Se le a�ade un �ltimo elemento opcional que corresponde al
    // icono que se presenta en medio de la ventana
    { "Icono 0",rb,new Character('0'),al2,bT},
    { "Icono 1",rb,new Character('1'),al2,bT},
    { "Icono 2",rb,new Character('2'),al2,bT},
    { "Icono 3",rb,new Character('3'),al2,bT},
    { "Icono 4",rb,new Character('4'),al2,bT},
    };
  public Object menuOpciones[][] = {
    // Nombre del men� y tecla r�pida asociada
    { "Opciones",new Character('O')},
    // Nombre, tipo, tecla r�pida, receptor asociado, habilitado o no
    { "Opcion 1",cb,new Character('1'),al1,bT},
    { "Opcion 2",cb,new Character('2'),al1,bT},
    };
  public Object menuAyuda[][] = {
    // Nombre del men� y tecla r�pida asociada
    { "Ayuda",new Character('y')},
    // Nombre, tipo, tecla r�pida, receptor asociado, habilitado o no
    { "Indice",mi,new Character('I'),al1,bT},
    { "Contenido",mi,new Character('C'),al1,bT},
    { null}, // Separator
    { "Acerca de...",mi,new Character('A'),al1,bT},
    };
  public Object barraMenu[] = {
    menuArchivo,menuEdicion,menuIconos,menuOpciones,menuAyuda,
    };

  static public JMenuBar creaMenuBarra( Object barraMenuDato[] ) {
    JMenuBar barraMenu = new JMenuBar();

    for ( int i=0; i < barraMenuDato.length; i++ )
      barraMenu.add( creaMenu((Object[][])barraMenuDato[i]) );
    return( barraMenu );
    }

  static public JMenu creaMenu( Object[][] menuDato ) {
    JMenu menu = new JMenu();

    menu.setText( (String)menuDato[0][0] );
    menu.setMnemonic( ((Character)menuDato[0][1]).charValue() );
    grupoBotones = new ButtonGroup();
    for ( int i=1; i < menuDato.length; i++ ) {
      if ( menuDato[i][0] == null )
        menu.add( new JSeparator() );
      else
        menu.add( creaMenuItem( menuDato[i] ) );
      }
    return( menu );
    }

  static public JMenuItem creaMenuItem( Object[] dato ) {
    JMenuItem m = null;
    TipoMenu tipo = (TipoMenu)dato[1];

    if ( tipo == mi )
      m = new JMenuItem();
    else if ( tipo == cb )
      m = new JCheckBoxMenuItem();
    else if ( tipo == rb ) {
      m = new JRadioButtonMenuItem();
      grupoBotones.add( m );
      }
    m.setText( (String)dato[0] );
    m.setMnemonic( ((Character)dato[2]).charValue() );
    m.addActionListener( (ActionListener)dato[3] );
    m.setEnabled( ((Boolean)dato[4]).booleanValue() );
    // Y ahora el caso opcional de los iconos
    if ( dato.length == 6 )
      m.setIcon( (Icon)dato[5] );
    return( m );
    }

Menus() {	  
    setLayout( new BorderLayout() );
	add( creaMenuBarra( barraMenu ),BorderLayout.NORTH );    
	JPanel p = new JPanel();     
	p.setLayout( new BorderLayout() );  
	p.add( lbl,BorderLayout.CENTER );
	add( p,BorderLayout.CENTER );
    } 
  } 

