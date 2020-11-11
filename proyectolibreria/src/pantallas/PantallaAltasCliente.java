package pantallas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.table.*;
import java.util.*;
import javax.swing.event.*;

import proyecto.Clientes;
import proyecto.ConsultaClientes;

public class  PantallaAltasCliente extends JPanel implements ActionListener{
//public class  PantallaAltasCliente extends JPanel implements ActionListener, TableModelListener {

	public JPanel mainPanel;
	
	
	public JTable table;
	public DefaultTableModel tabModel;
	
	public JScrollPane scrollPane;
	
	public JLabel lblbienvenida,lblId,lblNombre,lblPrimerApellido,lblSegundoApellido,lblDireccion,lblTelefono,lblCifnif,lblPoblacion,lblCp,lblSexo,lblMovil,lblFax,lblEmail,lblNcuenta,lblFechanacimiento,lblFechainicio,lblComentarios;
	public JTextField txtId,txtNombre,txtPrimerApellido,txtSegundoApellido,txtDireccion,txtTelefono,txtCifnif,txtPoblacion,txtCp,txtSexo,txtMovil,txtFax,txtEmail,txtNcuenta,txtFechanacimiento,txtFechainicio,txtComentarios;
	
	public JButton cmdAdd,cmdDelete,cmdSetValue,cmdExit,cmdChange;
	
	public PantallaAltasCliente() throws SQLException {	 
		   
		 	setLayout( new BorderLayout() );   
		 	
		 	DefaultTableModel tabModel=ConsultaClientes.buildTableModel();
			
		 	//******************************************************
		 	//* MIKE NO SE PARA QUE SIRVE
		 	//******************************************************
		 	//*table.updateUI();//Actualiza la tabla
			
			//scrollPane.setViewportView(table);//Esto añade la tabla al portView del scrollPane, si estaba puesto anteriormente
	        //hay que borrarlo del otro sitio, sino puede dar error de NullPointerException
			
			mainPanel=new JPanel();
			
			table = new JTable(tabModel);
			
			scrollPane= new JScrollPane(table);
			
			mainPanel.setLayout(null);
			mainPanel.add(scrollPane);
			
			scrollPane.setBounds(10,50,500,300);
			scrollPane.setSize(1250, 200);
			
			table.setRowSelectionAllowed(true);
			//table.getModel().addTableModelListener(this);
			table.setSize(1250, 400);
			
			
			lblbienvenida=new JLabel("ALTA CLIENTES");lblbienvenida.setBounds(600, 10, 100, 30);mainPanel.add(lblbienvenida);
	
	cmdDelete=new JButton("Borrar");					cmdDelete.setBounds(300, 350,100 ,30);				mainPanel.add(cmdDelete);
	cmdSetValue=new JButton("Añadir");					cmdSetValue.setBounds(500, 350,100 ,30);			mainPanel.add(cmdSetValue);
	cmdExit=new JButton("Salir");						cmdExit.setBounds(700, 350,120 ,30);				mainPanel.add(cmdExit);
	cmdChange=new JButton("Modificar");					cmdChange.setBounds(900, 350,100 ,30);				mainPanel.add(cmdChange);
	
	lblId=new JLabel("ID:");							lblId.setBounds(60, 450, 120, 30);					mainPanel.add(lblId);
	txtId= new JTextField(5);							txtId.setBounds(160, 450, 120, 25);					mainPanel.add(txtId);
	lblNombre=new JLabel("Nombre:");					lblNombre.setBounds(300, 450, 120, 30);				mainPanel.add(lblNombre);
	txtNombre= new JTextField( 5 );						txtNombre.setBounds(410, 450, 120, 25);				mainPanel.add(txtNombre);
	lblPrimerApellido=new JLabel("Primer Apellido:");	lblPrimerApellido.setBounds(550, 450, 120, 30);		mainPanel.add(lblPrimerApellido);
	txtPrimerApellido=new JTextField(5);				txtPrimerApellido.setBounds(650, 450, 120, 25);		mainPanel.add(txtPrimerApellido);
	lblSegundoApellido=new JLabel("Segundo Apellido:");	lblSegundoApellido.setBounds(800, 450, 120, 30);	mainPanel.add(lblSegundoApellido);
	txtSegundoApellido=new JTextField(5);				txtSegundoApellido.setBounds(900, 450, 120, 25);	mainPanel.add(txtSegundoApellido);
	lblCifnif=new JLabel("Nif:");	                    lblCifnif.setBounds(1050, 450, 120, 30);            mainPanel.add(lblCifnif);
	txtCifnif=new JTextField(5);				        txtCifnif.setBounds(1100, 450, 120, 25);            mainPanel.add(txtCifnif);
	
	lblDireccion=new JLabel("Direccion:");				lblDireccion.setBounds(60, 500, 120, 30);			mainPanel.add(lblDireccion);
	txtDireccion=new JTextField(5);						txtDireccion.setBounds(160, 500, 120, 25);			mainPanel.add(txtDireccion);
	lblPoblacion=new JLabel("Poblacion:");				lblPoblacion.setBounds(300, 500, 120, 30);			mainPanel.add(lblPoblacion);
	txtPoblacion=new JTextField(5);						txtPoblacion.setBounds(410, 500, 120, 25);			mainPanel.add(txtPoblacion);
	lblCp=new JLabel("Cp:");							lblCp.setBounds(550, 500, 120, 30);					mainPanel.add(lblCp);
	txtCp=new JTextField(5);							txtCp.setBounds(650,500, 120, 25);					mainPanel.add(txtCp);
	lblSexo=new JLabel("Sexo:");						lblSexo.setBounds(800, 500, 120, 30);				mainPanel.add(lblSexo);
	txtSexo=new JTextField(5);							txtSexo.setBounds(900, 500, 120, 25);				mainPanel.add(txtSexo);
	lblTelefono=new JLabel("Telefono:");				lblTelefono.setBounds(1050, 500, 120, 30);			mainPanel.add(lblTelefono);
	txtTelefono=new JTextField(5);						txtTelefono.setBounds(1100, 500, 120, 25);			mainPanel.add(txtTelefono);
	
	lblMovil=new JLabel("Movil:");						lblMovil.setBounds(60, 550, 120, 30);				mainPanel.add(lblMovil);
	txtMovil=new JTextField(5);							txtMovil.setBounds(160, 550, 120, 25);				mainPanel.add(txtMovil);
	lblFax=new JLabel("Fax:");			   				lblFax.setBounds(300, 550, 120, 30);				mainPanel.add(lblFax);
	txtFax=new JTextField(5);							txtFax.setBounds(410, 550, 120, 25);				mainPanel.add(txtFax);
	lblEmail=new JLabel("Email:");			   			lblEmail.setBounds(550, 550, 120, 30);				mainPanel.add(lblEmail);
	txtEmail=new JTextField(5);							txtEmail.setBounds(650, 550, 120, 25);				mainPanel.add(txtEmail);
	lblNcuenta=new JLabel("Ncuenta:");			   		lblNcuenta.setBounds(800, 550, 120, 30);			mainPanel.add(lblNcuenta);
	txtNcuenta=new JTextField(5);						txtNcuenta.setBounds(900, 550, 120, 25);			mainPanel.add(txtNcuenta);
	lblFechanacimiento=new JLabel("F.nac.:");	        lblFechanacimiento.setBounds(1050, 550, 120, 30);	mainPanel.add(lblFechanacimiento);
	txtFechanacimiento=new JTextField(5);				txtFechanacimiento.setBounds(1100, 550, 120, 25);	mainPanel.add(txtFechanacimiento);
	
	lblFechainicio=new JLabel("Fechainicio:");			lblFechainicio.setBounds(60, 600, 120, 30);		    mainPanel.add(lblFechainicio);
	txtFechainicio=new JTextField(5);					txtFechainicio.setBounds(160, 600, 120, 25);		mainPanel.add(txtFechainicio);
	lblComentarios=new JLabel("Comentarios:");			lblComentarios.setBounds(300, 600, 120, 30);		mainPanel.add(lblComentarios);
	txtComentarios=new JTextField(5);					txtComentarios.setBounds(410, 600, 120, 25);		mainPanel.add(txtComentarios);
	
	cmdDelete.addActionListener(this);
	cmdSetValue.addActionListener(this);
	cmdExit.addActionListener(this);
	cmdChange.addActionListener(this);
		
	mainPanel.setBackground(Color.white);
	
	table.getParent().setBackground(Color.lightGray);
	
	cmdChange.setEnabled(false);
	cmdDelete.setEnabled(false);


	table.addMouseListener(new MouseAdapter() 
	{
		public void mousePressed(MouseEvent mouse_evt) {
			JTable table = (JTable) mouse_evt.getSource();
			Point point = mouse_evt.getPoint();
			int fila = table.rowAtPoint(point);
			if(mouse_evt.getClickCount()==1) {
				txtId.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
				txtNombre.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
				txtPrimerApellido.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
				txtSegundoApellido.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
				txtCifnif.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
				txtDireccion.setText(table.getValueAt(table.getSelectedRow(), 5).toString());
				txtPoblacion.setText(table.getValueAt(table.getSelectedRow(), 6).toString());
				txtCp.setText(table.getValueAt(table.getSelectedRow(), 7).toString());
				txtSexo.setText(table.getValueAt(table.getSelectedRow(), 8).toString());
				txtTelefono.setText(table.getValueAt(table.getSelectedRow(), 9).toString());
				txtMovil.setText(table.getValueAt(table.getSelectedRow(), 10).toString());
				txtFax.setText(table.getValueAt(table.getSelectedRow(), 11).toString());
				txtEmail.setText(table.getValueAt(table.getSelectedRow(), 12).toString());
				txtNcuenta.setText(table.getValueAt(table.getSelectedRow(), 13).toString());
				txtFechanacimiento.setText(table.getValueAt(table.getSelectedRow(), 14).toString());
				txtFechainicio.setText(table.getValueAt(table.getSelectedRow(), 15).toString());
				txtComentarios.setText(table.getValueAt(table.getSelectedRow(), 16).toString());
				
				txtId.setEnabled(false);
				cmdSetValue.setEnabled(false);
				cmdDelete.setEnabled(true);
				cmdChange.setEnabled(true);
			}
			if(mouse_evt.getClickCount()==2) {
				txtId.setText("");
				txtNombre.setText("");
				txtPrimerApellido.setText("");
				txtSegundoApellido.setText("");
				txtCifnif.setText("");
				txtDireccion.setText("");
				txtPoblacion.setText("");
				txtCp.setText("");
				txtSexo.setText("");
				txtTelefono.setText("");
				txtMovil.setText("");
				txtFax.setText("");
				txtEmail.setText("");
				txtNcuenta.setText("");
				txtFechanacimiento.setText("");
				txtFechainicio.setText("");
				txtComentarios.setText("");
				
				txtId.setEnabled(true);
				cmdSetValue.setEnabled(true);
				cmdDelete.setEnabled(false);
				cmdChange.setEnabled(false);
			}
		}
		});
	}

 	//******************************************************
 	//* MIKE NO SE PARA QUE SIRVE
 	//******************************************************
/*
public void tableChanged(javax.swing.event.TableModelEvent source)     {
        String msg="";
        TableModel tabMod = (TableModel)source.getSource();
 switch (source.getType())
  {
     case TableModelEvent.UPDATE:
     //msg="Table Value Updated for  cell "+table.getSelectedRow()+","+table.getSelectedColumn()+"\nWhich is "+table.getValueAt(table.getSelectedRow(),table.getSelectedColumn()).toString();
     //JOptionPane.showMessageDialog(null,msg,"Table Example",JOptionPane.INFORMATION_MESSAGE);
     break;

  }

}//Table Changed Method
*/
public void actionPerformed(ActionEvent source)
    {	
      
         if (source.getSource()==(JButton) cmdDelete)
         {               
             // capturo el primer dato de la celda seleccionada
        	 if(!txtId.getText().isEmpty()) {
        		         	 
        	     int i=Integer.parseInt(txtId.getText());            
	             ConsultaClientes.borrar(i);
	             try {
					DefaultTableModel tabModel=ConsultaClientes.buildTableModel();
					table.setModel(tabModel);
					tabModel.fireTableDataChanged();
					dejartextosenblanco();
					cmdChange.setEnabled(false);
		        	cmdDelete.setEnabled(false);
		        	cmdSetValue.setEnabled(true);
		        	txtId.setEnabled(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

        	 }
         }
         if (source.getSource()==(JButton) cmdSetValue){
        	
        	 Clientes altaCliente = new Clientes(
        			 Integer.parseInt(txtId.getText()), 
        			 txtNombre.getText(), 
        			 txtPrimerApellido.getText(), 
        			 txtSegundoApellido.getText(), 
        			 txtCifnif.getText(), 
        			 txtDireccion.getText(), 
        			 txtPoblacion.getText(), 
        			 Integer.parseInt(txtCp.getText()), 
        			 Boolean.getBoolean(txtSexo.getText()), 
        			 Integer.parseInt(txtTelefono.getText()), 
        			 Integer.parseInt(txtMovil.getText()),
        			 Integer.parseInt(txtFax.getText()), 
        			 txtEmail.getText(), 
        			 txtNcuenta.getText(), 
        			 txtFechanacimiento.getText(),
        			 txtFechainicio.getText(),
        			 txtComentarios.getText());
	 		 ConsultaClientes.insertar(altaCliente);
             try {
				DefaultTableModel tabModel=ConsultaClientes.buildTableModel();
				table.setModel(tabModel);
				tabModel.fireTableDataChanged();
				dejartextosenblanco();
	        	cmdChange.setEnabled(false);
	        	cmdDelete.setEnabled(false);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

         }
         if(source.getSource()==(JButton)cmdChange){
        	 Clientes modiCliente = new Clientes(
        			 Integer.parseInt(txtId.getText()), 
        			 txtNombre.getText(), 
        			 txtPrimerApellido.getText(), 
        			 txtSegundoApellido.getText(), 
        			 txtCifnif.getText(), 
        			 txtDireccion.getText(), 
        			 txtPoblacion.getText(), 
        			 Integer.parseInt(txtCp.getText()), 
        			 Boolean.getBoolean(txtSexo.getText()), 
        			 Integer.parseInt(txtTelefono.getText()), 
        			 Integer.parseInt(txtMovil.getText()),
        			 Integer.parseInt(txtFax.getText()), 
        			 txtEmail.getText(), 
        			 txtNcuenta.getText(), 
        			 txtFechanacimiento.getText(),
        			 txtFechainicio.getText(),
        			 txtComentarios.getText());
        	 cmdChange.setEnabled(false);
        	 cmdDelete.setEnabled(false);
        	 cmdSetValue.setEnabled(true);
        	 txtId.setEnabled(true);
        	 

	 		 ConsultaClientes.modificar(modiCliente);
             try {
				DefaultTableModel tabModel=ConsultaClientes.buildTableModel();
				table.setModel(tabModel);
				tabModel.fireTableDataChanged();
				dejartextosenblanco();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

         }
         
         if (source.getSource()==(JButton) cmdExit)
         	{            
        	 System.exit(0);                    
         	}    
    }
private void dejartextosenblanco() {
    txtId.setText(""); 
    txtNombre.setText("");		
    txtPrimerApellido.setText("");	
    txtSegundoApellido.setText("");
    txtDireccion.setText("");	
    txtTelefono.setText("");
    txtCifnif.setText("");           	 
	txtPoblacion.setText("");
	txtCp.setText("");
	txtSexo.setText("");
	txtMovil.setText("");
	txtFax.setText("");
	txtEmail.setText("");
	txtNcuenta.setText(""); 
	txtFechanacimiento.setText("");
	txtFechainicio.setText("");
	txtComentarios.setText("");       
	
}
public static void main(String[] args) throws SQLException {
	PantallaAltasCliente pan=new PantallaAltasCliente();
}
}
