package proyecto;

import javax.swing.*;

import pantallas.Pantalla;
import pantallas.PantallaAltasCliente;
import pantallas.PantallaBajasCliente;
import pantallas.PantallaConsultasCliente;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.*;

public class Principal extends JFrame 
{

	public static void main(String[] args) 
	{
		new Principal();
		
		//**************************************************************
		//*Pruebas clase ConsultaClientes
		//**************************************************************			
		//new ConsultaClientes();
		
		//**************************************************************
		//*Prueba de consulta de clientes
		//**************************************************************		
		/*
		Vector<Clientes> vec = ConsultaClientes.consulta();
		
		for (Clientes cliente : vec) 
		{
			System.out.println(cliente.getNombre());
		}
		*/
		//**************************************************************
		//*Prueba de insertar clientes
		//**************************************************************		
		/*
		ArrayList<Clientes> clientes = new ArrayList<Clientes>();
		
		clientes.add(new Clientes(99, "Pepe", "alucine", "mucho", "9000000", "en la calle", "cualquier sitio", 19200, 0, 918889992, 620873355, 620873355, "unemail", "es su cuenta", "2010-01-01", "2015-01-01", "esto es un comentario"));
		
		Iterator<Clientes> itr = clientes.iterator();
		
		while(itr.hasNext()) {
			Clientes cliente = (Clientes) itr.next();
			ConsultaClientes.insertar(cliente);
		}
		*/
		//**************************************************************
		//*Prueba de modificar clientes
		//**************************************************************		
		/*
		ArrayList<Clientes> clientes = new ArrayList<Clientes>();
		
		clientes.add(new Clientes(99, "Jose", "alucine", "mucho", "9000000", "en la calle", "cualquier sitio", 19200, 0, 918889992, 620873355, 620873355, "unemail", "es su cuenta", "2010-01-02", "2015-01-02", "esto es un comentario"));
		
		Iterator<Clientes> itr = clientes.iterator();
		
		while(itr.hasNext()) {
			Clientes cliente = (Clientes) itr.next();
			ConsultaClientes.modificar(cliente);
		}
		*/		
}

	public Principal() 
	{ 
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

		//do the same for all the menu items.
		JMenuItem altalibros = new JMenuItem("Altas");
		JMenuItem bajalibros = new JMenuItem("Bajas");
		JMenuItem consultalibros = new JMenuItem("Consultas");
		
		JMenuItem altausuarios = new JMenuItem("Alta");
		JMenuItem bajausuarios = new JMenuItem("Bajas");
		JMenuItem consultausuarios = new JMenuItem("Consultas");
		
		final JPanel pan=new JPanel();
		final JPanel Pantalla=new JPanel();
		final JLabel l = new JLabel("PANTALLA PRINCIPAL");
		
		final PantallaAltasCliente pantallaaltas =new PantallaAltasCliente();
		final PantallaBajasCliente pantallabajas=new PantallaBajasCliente();
		final PantallaConsultasCliente pantallaconsultas=new PantallaConsultasCliente();
			
		final Pantalla pantalla=new Pantalla();
		pan.add(l);
		getContentPane().add(pan);
			
		panta.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
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
	
		altaclientes.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
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
			
		bajaclientes.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
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
	
		consultaclientes.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
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
	
		altalibros.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					//getContentPane().setBackground(Color.white);
					getContentPane().removeAll();				
					//pan.setEnabled(true);				
					getContentPane().add(pan);
					pan.setVisible(true);
					pan.setSize(1000, 1000);
					getContentPane().update(getGraphics());
				}
			});
			
		bajalibros.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent e) 
				{
					//getContentPane().setBackground(Color.white);
					getContentPane().removeAll();				
					//pan.setEnabled(true);				
					getContentPane().add(pan);
					pan.setVisible(true);
					pan.setSize(1000, 1000);
					getContentPane().update(getGraphics());
				}
			});
			
		consultalibros.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//getContentPane().setBackground(Color.white);
				getContentPane().removeAll();				
				//pan.setEnabled(true);				
				getContentPane().add(pan);
				pan.setVisible(true);
				pan.setSize(1000, 1000);
				getContentPane().update(getGraphics());
			}
		});
			
		altausuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				getContentPane().setBackground(Color.red);
			
			}
		});
		
		bajausuarios.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				getContentPane().setBackground(Color.green);
			}
		});
		
		consultausuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
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
	
	static JPanel creaPanel( Class clase ) 
	{
		String titulo = clase.getName();
	    titulo = titulo.substring( titulo.lastIndexOf('.') + 1 );
	    JPanel panel=null;
	    try 
	    {
	      panel = (JPanel)clase.newInstance();
	    } catch ( Exception e ) 
	    {
	      System.out.println( e );
	    }
	    //panel.setBorder( new TitledBorder( titulo ) );
	    return(panel);
    }
}