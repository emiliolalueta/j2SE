package ejemplos;

import javax.swing.*;

import model.Pantalla;

import java.awt.event.*;
import java.awt.*;

public class MenuExample extends JFrame {

	public MenuExample() {
		 
		//set the Frame size
		this.setSize(400, 400);

		//Create the menu bar.
		JMenuBar menuBar = new JMenuBar();

		//Build the first menu.
		JMenu filemenu = new JMenu("File");
		JMenu editmenu = new JMenu("Edit");
		JMenu colormenu = new JMenu("Color");

		//add the submenu's to the menu bar (File, Edit, Color)
		menuBar.add(filemenu);
		menuBar.add(editmenu);
		menuBar.add(colormenu);

		//start creating the menu items.
		JMenuItem quititem = new JMenuItem("Quit");
		/* for each menu item add an ActionListener:when a user chooses
		 this menu item the actionPerformed function will be called. 
		 Since an ActionListener is being created the required 
		 function actionPerformed(ActionEvent e) must be declared.
		 In this case we don't need the actionEvent that occured
		 because we only need to change the background color 
		 of the frame
		 */
		final JPanel pan=new JPanel();
		final JPanel Pantalla=new JPanel();
		final JLabel l = new JLabel("NOMBRE");
		final Pantalla p =new Pantalla();
		
		pan.add(l);
		getContentPane().add(pan);
		
		quititem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.exit(-1);
				//JFrame f=new JFrame();
				l.setText("Apellidos");
				//pan=creaPanel(DemoPanel.class);
				getContentPane().removeAll();				
				getContentPane().add(p.mainPanel);
				p.mainPanel.setVisible(true);
				p.mainPanel.setSize(1000, 1000);
				getContentPane().update(getGraphics());
				//Container cpane = f.getContentPane();
				//f.setContentPane(pan);
			}
		});

		//do the same for all the menu items.
		JMenuItem eraseitem = new JMenuItem("Erase");
		eraseitem.addActionListener(new ActionListener() {
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
		JMenuItem reditem = new JMenuItem("Red");
		reditem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setBackground(Color.red);
			
			}
		});
		JMenuItem greenitem = new JMenuItem("Green");
		greenitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setBackground(Color.green);
			}
		});
		JMenuItem blueitem = new JMenuItem("Blue");
		blueitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setBackground(Color.blue);
			}
		});
		JMenuItem pinkitem = new JMenuItem("Pink");
		pinkitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setBackground(Color.pink);
			}
		});
		JMenuItem blackitem = new JMenuItem("Black");
		blackitem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().setBackground(Color.black);
				
			}
		});

		//add the sub menu items to their respective menus
		filemenu.add(quititem);
		editmenu.add(eraseitem);
		colormenu.add(reditem);
		colormenu.add(greenitem);
		colormenu.add(blueitem);
		colormenu.add(pinkitem);
		colormenu.add(blackitem);

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
		new MenuExample();
		
	}
}