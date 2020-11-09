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
public class  Pantalla extends JPanel implements ActionListener, TableModelListener{
public static int c=0;	
//public static JFrame frame;
public JTable table;
public Vector rows,columns;
public DefaultTableModel tabModel;
public JScrollPane scrollPane;
public JLabel lblId,lblNombre,lblPrimerApellido,lblSegundoApellido,lblDireccion,lblTelefono,lblOcupacion;
public JTextField txtId,txtNombre,txtPrimerApellido,txtSegundoApellido,txtDireccion,txtTelefono,txtOcupacion;
public JButton cmdAdd,cmdDelete,cmdSetValue,cmdExit,cmdChange;
public JPanel mainPanel;
public ResultSet resulta;

 public Pantalla(){	 
	 	setLayout( new BorderLayout() );   
		rows=new Vector();
		columns= new Vector();
		String[] columnNames ={"ID","Nombre","Primer apellido","Segundo apellido","Direccion","Telefono","Ocupacion"};
		addColumns(columnNames);
		
		tabModel=new DefaultTableModel();
		tabModel.setDataVector(rows,columns);
		resulta=ConsultaClientes.resultado();
		addcontent(resulta);
		
		table = new JTable(tabModel);
		mainPanel=new JPanel();
		scrollPane= new JScrollPane(table);//ScrollPane
		mainPanel.setLayout(null);
		mainPanel.add(scrollPane);
		scrollPane.setBounds(50,50,500,300);
		table.setRowSelectionAllowed(true);
		table.getModel().addTableModelListener(this);
		
cmdDelete=new JButton("Borrar");					cmdDelete.setBounds(50, 375,100 ,30);				mainPanel.add(cmdDelete);
cmdSetValue=new JButton("Añadir");					cmdSetValue.setBounds(170, 375,100 ,30);			mainPanel.add(cmdSetValue);
cmdExit=new JButton("Salir");						cmdExit.setBounds(300, 375,120 ,30);				mainPanel.add(cmdExit);
cmdChange=new JButton("Modificar");					cmdChange.setBounds(450, 375,100 ,30);				mainPanel.add(cmdChange);
lblId=new JLabel("ID:");							lblId.setBounds(60, 450, 120, 30);					mainPanel.add(lblId);
txtId= new JTextField(5);							txtId.setBounds(160, 450, 120, 25);					mainPanel.add(txtId);
lblNombre=new JLabel("Nombre:");					lblNombre.setBounds(300, 450, 120, 30);				mainPanel.add(lblNombre);
txtNombre= new JTextField( 5 );						txtNombre.setBounds(410, 450, 120, 25);				mainPanel.add(txtNombre);
lblPrimerApellido=new JLabel("Primer Apellido:");	lblPrimerApellido.setBounds(60, 500, 120, 30);		mainPanel.add(lblPrimerApellido);
txtPrimerApellido=new JTextField(5);				txtPrimerApellido.setBounds(160, 500, 120, 25);		mainPanel.add(txtPrimerApellido);
lblSegundoApellido=new JLabel("Segundo Apellido:");	lblSegundoApellido.setBounds(300, 500, 120, 30);	mainPanel.add(lblSegundoApellido);
txtSegundoApellido=new JTextField(5);				txtSegundoApellido.setBounds(410, 500, 120, 25);	mainPanel.add(txtSegundoApellido);
lblDireccion=new JLabel("Direccion:");				lblDireccion.setBounds(60, 550, 120, 30);			mainPanel.add(lblDireccion);
txtDireccion=new JTextField(5);						txtDireccion.setBounds(160, 550, 120, 25);			mainPanel.add(txtDireccion);
lblTelefono=new JLabel("Telefono:");				lblTelefono.setBounds(300, 550, 120, 30);			mainPanel.add(lblTelefono);
txtTelefono=new JTextField(5);						txtTelefono.setBounds(410, 550, 120, 25);			mainPanel.add(txtTelefono);
lblOcupacion=new JLabel("Ocupacion:");				lblOcupacion.setBounds(60, 600, 120, 30);			mainPanel.add(lblOcupacion);
txtOcupacion=new JTextField(5);						txtOcupacion.setBounds(160, 600, 120, 25);			mainPanel.add(txtOcupacion);

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
             Object[] fila = new Object[7];//Creamos un Objeto con tantos parámetros como datos retorne cada fila de la consulta
             fila[0] = resultado.getDouble("ID");
             fila[1] = resultado.getString("NOMBRE"); //Lo que hay entre comillas son los campos de la base de datos
             fila[2] = resultado.getString("APELLIDO1");
             fila[3] = resultado.getString("APELLIDO2");
             fila[4] = resultado.getString("DIRECCION");
             fila[5] = resultado.getString("TELEFONO");
             fila[6] = resultado.getString("OCUPACION");
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
        	 String SegundoApellido=txtSegundoApellido.getText();String Direccion=txtDireccion.getText();
        	 String Telefono=txtTelefono.getText();String Ocupacion=txtOcupacion.getText();
        	
              if(!nombre.trim().equals("") && !id.trim().equals("") ){
            	  addRow();
            	  selectCell(table.getRowCount()-1,0);	table.setValueAt(txtId.getText(),table.getRowCount()-1,0);
                  selectCell(table.getRowCount()-1,1);	table.setValueAt(txtNombre.getText(),table.getRowCount()-1,1);
                  selectCell(table.getRowCount()-1,2);	table.setValueAt(txtPrimerApellido.getText(),table.getRowCount()-1,2);
                  selectCell(table.getRowCount()-1,3);	table.setValueAt(txtSegundoApellido.getText(),table.getRowCount()-1,3);
                  selectCell(table.getRowCount()-1,4);	table.setValueAt(txtDireccion.getText(),table.getRowCount()-1,4);
                  selectCell(table.getRowCount()-1,5);	table.setValueAt(txtTelefono.getText(),table.getRowCount()-1,5);
                  selectCell(table.getRowCount()-1,6);	table.setValueAt(txtOcupacion.getText(),table.getRowCount()-1,6);
                  
                  txtId.setText("");		txtNombre.setText("");		txtPrimerApellido.setText("");	txtSegundoApellido.setText("");
                  txtDireccion.setText("");	txtTelefono.setText("");	txtOcupacion.setText("");     
                  //ConsultaClientes.insertar(Integer.parseInt(id), nombre, PrimerApellido, SegundoApellido, Direccion, Integer.parseInt(Telefono), Ocupacion);
              }
         }
         if(source.getSource()==(JButton)cmdChange){
           	 String id=txtId.getText();String nombre=txtNombre.getText();String PrimerApellido=txtPrimerApellido.getText();
        	 String SegundoApellido=txtSegundoApellido.getText();String Direccion=txtDireccion.getText();
        	 String Telefono=txtTelefono.getText();String Ocupacion=txtOcupacion.getText();
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
	                  selectCell(table.getSelectedRow(),6);	table.setValueAt(txtOcupacion.getText(),table.getSelectedRow(),6); 
	                  txtId.setText("");		txtNombre.setText("");		txtPrimerApellido.setText("");	txtSegundoApellido.setText("");
	                  txtDireccion.setText("");	txtTelefono.setText("");	txtOcupacion.setText("");       
	                  //ConsultaClientes.modificar(i,Integer.parseInt(id), nombre, PrimerApellido, SegundoApellido, Direccion, Integer.parseInt(Telefono), Ocupacion);
            	 }    	 
         }
         if (source.getSource()==(JButton) cmdExit)
         	{            
        	 System.exit(0);                    
         	}    
    }
public static void main(String[] args) {
	Pantalla pan=new Pantalla();
}

}
