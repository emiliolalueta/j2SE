package es.com.estudio.java.swing.jdbc;

//Procedure para modificar productos:
//CREATE OR REPLACE PROCEDURE MODIFICAR
//(NOM PEDIDOS.PRODUCTO%TYPE
//,PROD PEDIDOS.PRODUCTO%TYPE
//,PREC PEDIDOS.PRECIO%TYPE)AS
//BEGIN
//    UPDATE PEDIDOS
//    SET PRODUCTO=PROD,PRECIO=PREC
//    WHERE PRODUCTO=NOM;
//    COMMIT;
//
//END;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.tree.*;

public class Form_Pedidos extends javax.swing.JFrame {

    Connection conexion;//lo ponemos a nivel de clase para poder llamarlo desde donde queramos
    Vector<String> vectorLista = new Vector<String>();//Vector para la lista
    DefaultTreeModel modelo;
    DefaultMutableTreeNode clientes = new DefaultMutableTreeNode("CLIENTES");

    //constructor
    public Form_Pedidos() {
        initComponents();
        this.setTitle("EXAMEN JAVA DBC");
        this.conectar();//conectamos a la BBDD
        

        this.crearNodos(clientes);
        modelo = new DefaultTreeModel(clientes);
        this.jTree1.setModel(modelo);
    }
    //Metodo para conectar con Driver

    private void conectar() {
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            String cadenaconexion = "jdbc:oracle:thin:@LOCALHOST:1521:XE";    //@SERVIDOR--->el servidor que sea y XE en la base de datos
            this.conexion = DriverManager.getConnection(cadenaconexion, "System", "java");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ERROR!!! " + ex.toString());
        }
    }

    private void crearNodos(DefaultMutableTreeNode clientes) {
        clientes.removeAllChildren();
        String consulta = "SELECT * FROM CLIENTES";//escribimos la consulta que vamos a hacer a la BBDD

        try {
            Statement sentencia = this.conexion.createStatement();//necesitamos un Statement para realizar un consulta cerrada(sin parametros) 
            ResultSet rs = sentencia.executeQuery(consulta);//el resultado de la consulta se mete en un ResulSset

            while (rs.next()) {
                DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(rs.getString(2));
                clientes.add(nodo);

                DefaultMutableTreeNode subnodo1 = new DefaultMutableTreeNode("CLIENTE_COD: " + rs.getString(1));
                nodo.add(subnodo1);
                DefaultMutableTreeNode subnodo2 = new DefaultMutableTreeNode("EMPRESA: " + rs.getString(2));
                nodo.add(subnodo2);
                DefaultMutableTreeNode subnodo3 = new DefaultMutableTreeNode("CONTACTO: " + rs.getString(3));
                nodo.add(subnodo3);
                DefaultMutableTreeNode subnodo4 = new DefaultMutableTreeNode("CARGO: " + rs.getString(4));
                nodo.add(subnodo4);
                DefaultMutableTreeNode subnodo5 = new DefaultMutableTreeNode("CIUDAD: " + rs.getString(5));
                nodo.add(subnodo5);
                DefaultMutableTreeNode subnodo6 = new DefaultMutableTreeNode("TELEFONO: " + rs.getString(6));
                nodo.add(subnodo6);
                DefaultMutableTreeNode subnodo7 = new DefaultMutableTreeNode("PEDIDOS: ");
                nodo.add(subnodo7);

                String consulta2 = "SELECT PRODUCTO FROM PEDIDOS WHERE CLIENTE_COD=?";
                String cod = rs.getString(1).toUpperCase();//capturamos el cod del cliente
                PreparedStatement pst = this.conexion.prepareStatement(consulta2);//Lo hacemos con prepared Statement ya que se pasan parametros y es mas facil
                pst.setString(1, cod);//Cargamos los valores

                ResultSet rs2 = pst.executeQuery();
                while (rs2.next()) {
                    DefaultMutableTreeNode pedido = new DefaultMutableTreeNode(rs2.getString(1));
                    subnodo7.add(pedido);
                }

            }
            rs.close(); //conveniente cerrar el ResultSet


        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ERROR!!! " + ex.toString());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstPedidos = new javax.swing.JList();
        txtProducto = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        btnModificar = new javax.swing.JButton();
        lblPedidos = new javax.swing.JLabel();
        lblClientes = new javax.swing.JLabel();
        lblProducto = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTree1.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jTree1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jTree1);

        jScrollPane2.setViewportView(lstPedidos);

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        lblPedidos.setText("Pedidos");

        lblClientes.setText("Clientes");

        lblProducto.setText("Producto");

        lblPrecio.setText("Precio");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblClientes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblPedidos)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(lblProducto)
                    .addComponent(lblPrecio)
                    .addComponent(txtProducto)
                    .addComponent(txtPrecio)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPedidos)
                    .addComponent(lblClientes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(lblProducto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPrecio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnModificar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTree1ValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jTree1ValueChanged
        // TODO add your handling code here:
        this.vectorLista.removeAllElements();
        DefaultMutableTreeNode nodo;
        nodo = (DefaultMutableTreeNode) evt.getPath().getLastPathComponent();
        if (nodo.toString().equals("PEDIDOS: ")) {
            int numPedidos = nodo.getChildCount();
            if (numPedidos > 0) {
                for (int i = 0; i < numPedidos; i++) {
                    this.vectorLista.add(nodo.getChildAt(i).toString());
                }
            }

        }
        this.lstPedidos.setListData(vectorLista);
    }//GEN-LAST:event_jTree1ValueChanged

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:

        try {
            CallableStatement cst = this.conexion.prepareCall("{call MODIFICAR(?,?,?)}");//consulta
            String producto = this.lstPedidos.getSelectedValue().toString();
            String nuevoProducto = this.txtProducto.getText().toUpperCase();//capturamos lo que se pone en la caja de texto
            double nuevoPrecio = Double.parseDouble(this.txtPrecio.getText());

            cst.setString(1, producto); //le pasamos el parametro de entrada (1ª?) que es un numero
            cst.setString(2, nuevoProducto);
            cst.setDouble(3, nuevoPrecio);


            int numero = cst.executeUpdate(); //ejecutamos el procedure y nos devuelve un numero
            JOptionPane.showMessageDialog(this, "Productos Modificados: " + numero);


            this.crearNodos(clientes);//cargamos de nuevo el arbol de clientes
            modelo = new DefaultTreeModel(clientes);
            this.jTree1.setModel(modelo);
            
            this.vectorLista.removeAllElements();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "ERROR!!! " + ex.toString());
        }

    }//GEN-LAST:event_btnModificarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Form_Pedidos().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTree jTree1;
    private javax.swing.JLabel lblClientes;
    private javax.swing.JLabel lblPedidos;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JList lstPedidos;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtProducto;
    // End of variables declaration//GEN-END:variables
}
