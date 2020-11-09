package pantallas;
/** 
*/
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

import java.sql.ResultSet;
import java.util.*;

import javax.swing.event.*;

import proyecto.ConsultaClientes;
public class  PantallaConsultasCliente extends JPanel implements ActionListener, TableModelListener{
public static int c=0;	
//public static JFrame frame;
public JTable table;
public Vector rows,columns;
public DefaultTableModel tabModel;
public JScrollPane scrollPane;
public JLabel lblbienvenida,lblId,lblNombre,lblPrimerApellido,lblSegundoApellido,lblDireccion,lblTelefono,lblCifnif,lblPoblacion,lblCp,lblSexo,lblMovil,lblFax,lblEmail,lblNcuenta,lblFechanacimiento,lblFechainicio,lblComentarios;
public JTextField txtId,txtNombre,txtPrimerApellido,txtSegundoApellido,txtDireccion,txtTelefono,txtCifnif,txtPoblacion,txtCp,txtSexo,txtMovil,txtFax,txtEmail,txtNcuenta,txtFechanacimiento,txtFechainicio,txtComentarios;
public JButton cmdAdd,cmdDelete,cmdSetValue,cmdExit,cmdChange;
public JPanel mainPanel;
public ResultSet resulta;

 public PantallaConsultasCliente(){	 
	   
	 	 setLayout( new BorderLayout() );   
		rows=new Vector();
		columns= new Vector();
		String[] columnNames ={"ID","Nombre","Primer apellido","Segundo apellido","Direccion","Telefono","Poblacion","CP","SEXO","Telefono","Movil","Fax","Email","Ncuenta","Fecha nacimiento","Fecha alta","Comentarios"};
		addColumns(columnNames);
		
		tabModel=new DefaultTableModel();
		tabModel.setDataVector(rows,columns);
		resulta=ConsultaClientes.resultado();
		addcontent(resulta);
		//scrollPane.setViewportView(table);//Esto añade la tabla al portView del scrollPane, si estaba puesto anteriormente
        //hay que borrarlo del otro sitio, sino puede dar error de NullPointerException
				
		table = new JTable(tabModel);
		mainPanel=new JPanel();
		scrollPane= new JScrollPane(table);//ScrollPane
		mainPanel.setLayout(null);
		mainPanel.add(scrollPane);
		scrollPane.setBounds(50,50,500,300);
		scrollPane.setSize(1250, 200);
		table.setRowSelectionAllowed(true);
		table.getModel().addTableModelListener(this);
		table.setSize(1250, 400);
		lblbienvenida=new JLabel("CONSULTAS DE  CLIENTES");lblbienvenida.setBounds(600, 10, 100, 30);mainPanel.add(lblbienvenida);

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
lblTelefono=new JLabel("Telefono:");				lblTelefono.setBounds(300, 500, 120, 30);			mainPanel.add(lblTelefono);
txtTelefono=new JTextField(5);						txtTelefono.setBounds(410, 500, 120, 25);			mainPanel.add(txtTelefono);
lblPoblacion=new JLabel("Poblacion:");				lblPoblacion.setBounds(550, 500, 120, 30);			mainPanel.add(lblPoblacion);
txtPoblacion=new JTextField(5);						txtPoblacion.setBounds(650,500, 120, 25);			mainPanel.add(txtPoblacion);
lblCp=new JLabel("Cp:");							lblCp.setBounds(800, 500, 120, 30);					mainPanel.add(lblCp);
txtCp=new JTextField(5);							txtCp.setBounds(900, 500, 120, 25);					mainPanel.add(txtCp);
lblSexo=new JLabel("Sexo:");						lblSexo.setBounds(1050, 500, 120, 30);				mainPanel.add(lblSexo);
txtSexo=new JTextField(5);							txtSexo.setBounds(1100, 500, 120, 25);				mainPanel.add(txtSexo);
lblMovil=new JLabel("Movil:");						lblMovil.setBounds(60, 550, 120, 30);				mainPanel.add(lblMovil);
txtMovil=new JTextField(5);							txtMovil.setBounds(160, 550, 120, 25);				mainPanel.add(txtMovil);
lblFax=new JLabel("Fax:");			   				lblFax.setBounds(300, 550, 120, 30);				mainPanel.add(lblFax);
txtFax=new JTextField(5);							txtFax.setBounds(410, 550, 120, 25);				mainPanel.add(txtFax);
lblEmail=new JLabel("Fax:");			   			lblEmail.setBounds(550, 550, 120, 30);				mainPanel.add(lblEmail);
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
//frame=new JFrame("Agenda de clientes");
//frame.setSize(600,700);

mainPanel.setBackground(Color.white);

table.getParent().setBackground(Color.lightGray);
//frame.getContentPane().add(mainPanel);
//frame.setVisible(true);
}
public void addColumns(String[] colName)//Table Columns
 	{
	 		for(int i=0;i<colName.length;i++)
	 			columns.addElement((String) colName[i]);
 	}
 
public void addcontent(ResultSet resultado){	
	 try {
         while(resultado.next()){
             Object[] fila = new Object[17];//Creamos un Objeto con tantos parámetros como datos retorne cada fila de la consulta
             fila[0] = resultado.getDouble("ID");
             fila[1] = resultado.getString("NOMBRE"); //Lo que hay entre comillas son los campos de la base de datos
             fila[2] = resultado.getString("APELLIDO1");
             fila[3] = resultado.getString("APELLIDO2");
             fila[4] = resultado.getString("CIFNIF");
             fila[5] = resultado.getString("DIRECCION");             
             fila[6] = resultado.getString("POBLACION");
             fila[7] = resultado.getString( "CP");
             fila[8] = resultado.getString("SEXO");
             fila[9] = resultado.getString("TELEFONO");           
             fila[10] = resultado.getString("MOVIL");
             fila[11] = resultado.getString("FAX");
             fila[12] = resultado.getString( "EMAIL");
             fila[13] = resultado.getString("NCUENTA");
             fila[14] = resultado.getString("FECHANACIMIENTO");
             fila[15] = resultado.getString("FECHAINICIO");
             fila[16] = resultado.getString("COMENTARIOS");
             tabModel.addRow(fila); // Añade una fila al final del modelo de la tabla
         }
         
         table.updateUI();//Actualiza la tabla


     } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
     }
}
public void addRow() //Add Row
{
	Vector r=new Vector();
	r=createBlankElement();
	rows.addElement(r);
	table.addNotify();
}

public Vector createBlankElement() 
{
Vector t = new Vector();
t.addElement((String) " ");
t.addElement((String) " ");
t.addElement((String) " ");
t.addElement((String) " ");
t.addElement((String) " ");
t.addElement((String) " ");
t.addElement((String) " ");
return t;
}

void deleteRow(int index) 
   {
     if(index!=-1)//At least one Row in Table
      { 
        rows.removeElementAt(index);
        table.addNotify();
       }

   }//Delete Row

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

public void selectCell(int row,int col)
    {
         if(row!=-1 && col !=-1)            
          {
          table.setRowSelectionInterval(row,row);
          table.setColumnSelectionInterval(col,col);
          }
    }
public void actionPerformed(ActionEvent source)
    {	
      
         if (source.getSource()==(JButton) cmdDelete)
         {               
             // capturo el primer dato de la celda seleccionada
        	 if(table.getSelectedRow()>=0){   
	             String dato=String.valueOf(tabModel.getValueAt(table.getSelectedRow(),0));             
	             int i=Math.round(Float.parseFloat(dato));            
	             ConsultaClientes.borrar(i);
	             deleteRow(table.getSelectedRow()); 
        	 }
         }
         if (source.getSource()==(JButton) cmdSetValue){
        	 
        	 String id=txtId.getText();String nombre=txtNombre.getText();String PrimerApellido=txtPrimerApellido.getText();
        	 String SegundoApellido=txtSegundoApellido.getText();String Cifnif=txtCifnif.getText();String Direccion=txtDireccion.getText();
        	 int Telefono=Integer.parseInt(txtTelefono.getText()); String Poblacion=txtPoblacion.getText();String Cp=txtCp.getText();
        	 String Sexo=txtSexo.getText();int Movil=Integer.parseInt(txtMovil.getText());int Fax=Integer.parseInt(txtFax.getText());
        	 String Email=txtEmail.getText();String Ncuenta=txtNcuenta.getText(); String Fechanacimiento=txtFechanacimiento.getText();
        	 String Fechainicio=txtFechainicio.getText();String Comentarios=txtComentarios.getText();        	 
              if(!nombre.trim().equals("") && !id.trim().equals("") ){
            	  addRow();
            	  selectCell(table.getRowCount()-1,0);	table.setValueAt(txtId.getText(),table.getRowCount()-1,0);
                  selectCell(table.getRowCount()-1,1);	table.setValueAt(txtNombre.getText(),table.getRowCount()-1,1);
                  selectCell(table.getRowCount()-1,2);	table.setValueAt(txtPrimerApellido.getText(),table.getRowCount()-1,2);
                  selectCell(table.getRowCount()-1,3);	table.setValueAt(txtSegundoApellido.getText(),table.getRowCount()-1,3);
                  selectCell(table.getRowCount()-1,4);	table.setValueAt(txtDireccion.getText(),table.getRowCount()-1,4);
                  selectCell(table.getRowCount()-1,5);	table.setValueAt(txtTelefono.getText(),table.getRowCount()-1,5);                  
                  selectCell(table.getRowCount()-1,6);	table.setValueAt(txtCifnif.getText(),table.getRowCount()-1,6);                  
                  selectCell(table.getRowCount()-1,7);	table.setValueAt(txtPoblacion.getText(),table.getRowCount()-1,7);                  
                  selectCell(table.getRowCount()-1,8);	table.setValueAt(txtCp.getText(),table.getRowCount()-1,8);                  
                  selectCell(table.getRowCount()-1,9);	table.setValueAt(txtSexo.getText(),table.getRowCount()-1,9);                  
                  selectCell(table.getRowCount()-1,10);	table.setValueAt(txtMovil.getText(),table.getRowCount()-1,10);                  
                  selectCell(table.getRowCount()-1,11);	table.setValueAt(txtFax.getText(),table.getRowCount()-1,11);                  
                  selectCell(table.getRowCount()-1,12);	table.setValueAt(txtEmail.getText(),table.getRowCount()-1,12);                  
                  selectCell(table.getRowCount()-1,13);	table.setValueAt(txtNcuenta.getText(),table.getRowCount()-1,13);                  
                  selectCell(table.getRowCount()-1,14);	table.setValueAt(txtFechanacimiento.getText(),table.getRowCount()-1,14);                  
                  selectCell(table.getRowCount()-1,15);	table.setValueAt(txtFechainicio.getText(),table.getRowCount()-1,15);
                  selectCell(table.getRowCount()-1,16);	table.setValueAt(txtComentarios.getText(),table.getRowCount()-1,16);
                  
                  txtId.setText(""); txtNombre.setText("");		txtPrimerApellido.setText("");	txtSegundoApellido.setText("");
                  txtDireccion.setText("");	txtTelefono.setText("");txtCifnif.setText("");           	 
             	  txtPoblacion.setText("");txtCp.setText("");
             	  txtSexo.setText("");txtMovil.setText("");txtFax.setText("");
             	  txtEmail.getText();txtNcuenta.getText(); txtFechanacimiento.setText("");
             	  txtFechainicio.setText("");txtComentarios.setText("");      
                  ConsultaClientes.insertar(Integer.parseInt(id), nombre, PrimerApellido, SegundoApellido, Cifnif, Direccion,Telefono, Poblacion,Cp,Sexo,Movil,Fax,Email,Ncuenta,Fechanacimiento,Fechainicio,Comentarios);             
                 }
         }
         if(source.getSource()==(JButton)cmdChange){
           	 String id=txtId.getText();String nombre=txtNombre.getText();String PrimerApellido=txtPrimerApellido.getText();
        	 String SegundoApellido=txtSegundoApellido.getText();String Direccion=txtDireccion.getText();
        	 String Telefono=txtTelefono.getText();
        	 	if(table.getSelectedRow()>=0){            	 
                    // capturo el primer dato de la celda seleccionada
        	 		  String dato=String.valueOf(tabModel.getValueAt(table.getSelectedRow(),0));        	 		              	  
        	 		  int i=Math.round(Float.parseFloat(dato));   
	            	  selectCell(table.getSelectedRow(),0);	table.setValueAt(txtId.getText(),table.getSelectedRow(),0);
	                  selectCell(table.getSelectedRow(),1);	table.setValueAt(txtNombre.getText(),table.getSelectedRow(),1);
	                  selectCell(table.getSelectedRow(),2);	table.setValueAt(txtPrimerApellido.getText(),table.getSelectedRow(),2);
	                  selectCell(table.getSelectedRow(),3);	table.setValueAt(txtSegundoApellido.getText(),table.getSelectedRow(),3);
	                  selectCell(table.getSelectedRow(),4);	table.setValueAt(txtDireccion.getText(),table.getSelectedRow(),4);
	                  selectCell(table.getSelectedRow(),5);	table.setValueAt(txtTelefono.getText(),table.getSelectedRow(),5);
	                  selectCell(table.getSelectedRow(),6);	table.setValueAt(txtCifnif.getText(),table.getSelectedRow(),6);
	                  selectCell(table.getSelectedRow(),7);	table.setValueAt(txtPoblacion.getText(),table.getSelectedRow(),7);
	                  selectCell(table.getSelectedRow(),8);	table.setValueAt(txtCp.getText(),table.getSelectedRow(),8);
	                  selectCell(table.getSelectedRow(),9);	table.setValueAt(txtSexo.getText(),table.getSelectedRow(),9);
	                  selectCell(table.getSelectedRow(),10);table.setValueAt(txtMovil.getText(),table.getSelectedRow(),10);
	                  selectCell(table.getSelectedRow(),11);table.setValueAt(txtFax.getText(),table.getSelectedRow(),11);
	                  selectCell(table.getSelectedRow(),12);table.setValueAt(txtEmail.getText(),table.getSelectedRow(),12);
	                  selectCell(table.getSelectedRow(),13);table.setValueAt(txtNcuenta.getText(),table.getSelectedRow(),13);
	                  selectCell(table.getSelectedRow(),14);table.setValueAt(txtFechanacimiento.getText(),table.getSelectedRow(),14);
	                  selectCell(table.getSelectedRow(),15);table.setValueAt(txtFechainicio.getText(),table.getSelectedRow(),15);
	                  selectCell(table.getSelectedRow(),16);table.setValueAt(txtComentarios.getText(),table.getSelectedRow(),16);	                  
	                  
	                  txtId.setText(""); txtNombre.setText("");		txtPrimerApellido.setText("");	txtSegundoApellido.setText("");
	                  txtDireccion.setText("");	txtTelefono.setText("");txtCifnif.setText("");           	 
	             	  txtPoblacion.setText("");txtCp.setText("");
	             	  txtSexo.setText("");txtMovil.setText("");txtFax.setText("");
	             	  txtEmail.getText();txtNcuenta.getText(); txtFechanacimiento.setText("");
	             	  txtFechainicio.setText("");txtComentarios.setText("");       
	                  //Consulta.modificar(i,Integer.parseInt(id), nombre, PrimerApellido, SegundoApellido, Direccion, Integer.parseInt(Telefono), Ocupacion);
            	 }    	 
         }
         if (source.getSource()==(JButton) cmdExit)
         	{            
        	 System.exit(0);                    
         	}    
    }
public static void main(String[] args) {
	PantallaConsultasCliente pan=new PantallaConsultasCliente();
}

}
