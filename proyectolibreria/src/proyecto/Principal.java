package proyecto;

import javax.swing.*;

import pantallas.Pantalla;
import pantallas.PantallaAltasCliente;
import pantallas.PantallaBajasCliente;
import pantallas.PantallaConsultasCliente;



import java.awt.event.*;
import java.awt.*;

public class Principal extends JFrame {

	public Principal() {
		 
		//set the Frame size
		this.setSize(1350, 750);

		//Create the menu bar.
		JMenuBar menuBar = new JMenuBar();

		//Build the first menu.
		JMenu clientes = new JMenu("Gestion de clientes");
		JMenu libros = new JMenu("Gestion de libros");
		JMenu usuarios = new JMenu("Gestion de usuarios");

		//add the submenu's to the menu bar (File, Edit, Color)
		menuBar.add(clientes);
		menuBar.add(libros);
		menuBar.add(usuarios);

		//start creating the menu items.
		JMenuItem altaclientes = new JMenuItem("Altas");
		JMenuItem bajaclientes = new JMenuItem("Bajas");
		JMenuItem consultaclientes = new JMenuItem("Consultas");
		JMenuItem panta = new JMenuItem("Pantalla");
		
		final JPanel pan=new JPanel();
		final JPanel Pantalla=new JPanel();
		final JLabel l = new JLabel("PANTALLA PRINCIPAL");
		final PantallaAltasCliente pantallaaltas =new PantallaAltasCliente();
		final PantallaBajasCliente pantallabajas=new PantallaBajasCliente();
		final PantallaConsultasCliente pantallaconsultas=new PantallaConsultasCliente();
		
		final Pantalla pantalla=new Pantalla();
		pan.add(l);
		getContentPane().add(pan);
		
		
		
		panta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.exit(-1);
				//JFrame f=new JFrame();
				l.setText("Apellidos");
				//pan=creaPanel(DemoPanel.class);
				getContentPane().removeAll();				
				getContentPane().add(pantalla.mainPanel);
				pantalla.mainPanel.setVisible(true);
				pantalla.mainPanel.setSize(1300, 1000);
				getContentPane().update(getGraphics());
				//Container cpane = f.getContentPane();
				//f.setContentPane(pan);
			}
		});
		
		
		
		
		altaclientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.exit(-1);
				//JFrame f=new JFrame();
				l.setText("Apellidos");
				//pan=creaPanel(DemoPanel.class);
				getContentPane().removeAll();				
				getContentPane().add(pantallaaltas.mainPanel);
				pantallaaltas.mainPanel.setVisible(true);
				pantallaaltas.mainPanel.setSize(1300, 1000);
				getContentPane().update(getGraphics());
				//Container cpane = f.getContentPane();
				//f.setContentPane(pan);
			}
		});
		
		bajaclientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.exit(-1);
				//JFrame f=new JFrame();
				l.setText("Apellidos");
				//pan=creaPanel(DemoPanel.class);
				getContentPane().removeAll();				
				getContentPane().add(pantallabajas.mainPanel);
				pantallabajas.mainPanel.setVisible(true);
				pantallabajas.mainPanel.setSize(1300, 1000);
				getContentPane().update(getGraphics());
				//Container cpane = f.getContentPane();
				//f.setContentPane(pan);
			}
		});

		consultaclientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.exit(-1);
				//JFrame f=new JFrame();
				l.setText("Apellidos");
				//pan=creaPanel(DemoPanel.class);
				getContentPane().removeAll();				
				getContentPane().add(pantallaconsultas.mainPanel);
				pantallaconsultas.mainPanel.setVisible(true);
				pantallaconsultas.mainPanel.setSize(1300, 1000);
				getContentPane().update(getGraphics());
				//Container cpane = f.getContentPane();
				//f.setContentPane(pan);
			}
		});

		//do the same for all the menu items.
		JMenuItem altalibros = new JMenuItem("Altas");
		altalibros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//getContentPane().setBackground(Color.white);
				getContentPane().removeAll();				
				//pan.setEnabled(true);				
				getContentPane().add(pan);
				pan.setVisible(true);
				pan.setSize(1000, 1000);
				getContentPane().update(getGraphics());
			}
		});
		
		JMenuItem bajalibros = new JMenuItem("Bajas");
		bajalibros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//getContentPane().setBackground(Color.white);
				getContentPane().removeAll();				
				//pan.setEnabled(true);				
				getContentPane().add(pan);
				pan.setVisible(true);
				pan.setSize(1000, 1000);
				getContentPane().update(getGraphics());
			}
		});
		JMenuItem consultalibros = new JMenuItem("Consultas");
		consultalibros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//getContentPane().setBackground(Color.white);
				getContentPane().removeAll();				
				//pan.setEnabled(true);				
				getContentPane().add(pan);
				pan.setVisible(true);
				pan.setSize(1000, 1000);
				getContentPane().update(getGraphics());
			}
		});
		
		
		JMenuItem altausuarios = new JMenuItem("Alta");
		altausuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setBackground(Color.red);
			
			}
		});
		JMenuItem bajausuarios = new JMenuItem("Bajas");
		bajausuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setBackground(Color.green);
			}
		});
		JMenuItem consultausuarios = new JMenuItem("Consultas");
		consultausuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setBackground(Color.blue);
			}
		});
		

		//add the sub menu items to their respective menus
		clientes.add(altaclientes);
		clientes.add(bajaclientes);
		clientes.add(consultaclientes);
		clientes.add(panta);
		
		libros.add(altalibros);
		libros.add(bajalibros);
		libros.add(consultalibros);
		usuarios.add(altausuarios);
		usuarios.add(bajausuarios);
		usuarios.add(consultausuarios);
		

		//exit the program when the user clicks on the X in the window
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//start the background as white.
		this.getContentPane().setBackground(Color.white);
		this.setJMenuBar(menuBar); //set the Frames JMenuBar
		this.setTitle("Menu Example"); //title of the frame
		this.setVisible(true); //show the Frame
	}
	  static JPanel creaPanel( Class clase ) {
		    String titulo = clase.getName();
		    titulo = titulo.substring( titulo.lastIndexOf('.') + 1 );
		    JPanel panel=null;
		    try {
		      panel = (JPanel)clase.newInstance();
		    } catch ( Exception e ) {
		      System.out.println( e );
		      }
		    //panel.setBorder( new TitledBorder( titulo ) );
		    return(panel);
		    }
	public static void main(String[] args) {
		new Principal();
		
	}
}