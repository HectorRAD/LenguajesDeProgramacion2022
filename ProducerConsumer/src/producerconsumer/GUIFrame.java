/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package producerconsumer;

//import java.awt.*;  
import java.awt.event.*;  
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.JOptionPane;

/**
 *
 * @author sdegante
 */
public class GUIFrame extends javax.swing.JFrame {

    /**
     * Creates new form GUIFrame
     */
    //productores y consumidores
    Producer[] producer;
    Consumer[] consumer;
    Buffer buffer;
    boolean hasStarted=false;
    
    
    public GUIFrame() {
        initComponents();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jSpinner3 = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jSpinner4 = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel5.setText("Tiempo de Espera (ms)");

        jLabel6.setText("Rango de Valores (n, m)");

        jLabel1.setText("Productores");

        jLabel2.setText("Consumidores");

        jLabel3.setText("Tama??o del Buffer");

        jLabel4.setText("Cantidad");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSpinner2)
                    .addComponent(jTextField3)
                    .addComponent(jSpinner1)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addComponent(jTextField2)
                    .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Configuraci??n", jPanel2);
        javax.swing.table.DefaultTableModel model1 = new javax.swing.table.DefaultTableModel(null,
            new String [] {
                 "Producer", "Operation"
            }
        );
        jTable1.setModel(model1);
        
        jScrollPane1.setViewportView(jTable1);
        
        javax.swing.table.DefaultTableModel model2 = new javax.swing.table.DefaultTableModel(null,
            new String [] {
                 "Consumer", "Operation", "Result"
            }
        );
        jTable2.setModel(model2);
        
        jScrollPane2.setViewportView(jTable2);

        jLabel7.setText("Tareas por hacer");

        jLabel8.setText("Tareas realizadas");

        jProgressBar1.setValue(0);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                    .addComponent(jSpinner4))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Procesos", jPanel3);

        jButton1.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 102, 51));
        jButton1.setText("INICIAR");

        //opcion1
        jButton1.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                int numPro,numProTiempo,numCon,numConTiempo,numBuffer,rango0,rango1;
                numPro=0;
                numCon=0;
                rango0=0;
                rango1=0;
                numConTiempo=0;
                numProTiempo=0;
                numBuffer=0;
                
                if(!hasStarted){
                    boolean datosValidos;
                    StringBuilder errorMessage = new StringBuilder();
                    
                    try { //validar
			numPro=Integer.parseInt(jSpinner1.getValue().toString());//prodcutor
                        numProTiempo=Integer.parseInt(jTextField1.getText()); //tiempo de espera productor
                        numCon=Integer.parseInt(jSpinner2.getValue().toString());//consumidor
                        numConTiempo=Integer.parseInt(jTextField2.getText()); //tiempo de espera consumidor
                        numBuffer=Integer.parseInt(jTextField3.getText());//tama??o del buffer 
                        rango0=Integer.parseInt(jTextField4.getText());//rango de valores
                        rango1=Integer.parseInt(jSpinner3.getValue().toString());
                        datosValidos=true;//los datos si son integers
                        
                        if(!(0<=numPro && numPro<=10)){
                            //System.out.println("fallo 1");
                            datosValidos=false;
                            errorMessage.append("\n Numero de productores no aceptado.");
                        }
                        if(!(0<=numProTiempo && numProTiempo<=10000)){
                            //System.out.println("fallo 2");
                            datosValidos=false;
                            errorMessage.append("\n Tiempo de espera de productores no aceptado.");
                        }
                        if(!(0<=numCon && numCon<=10)){
                            //System.out.println("fallo 3");
                            datosValidos=false;
                            errorMessage.append("\n Numero de consumidores no aceptado.");
                        }
                        if(!(0<=numConTiempo && numConTiempo<=10000)){
                            //System.out.println("fallo 4");
                            datosValidos=false;
                            errorMessage.append("\n Tiempo de espera de consumidores no aceptado.");
                        }
                        if(!(1<=numBuffer && numBuffer<=100)){
                            //System.out.println("fallo 5");
                            datosValidos=false;
                            errorMessage.append("\n Tamano de Buffer no aceptado.");
                        }
                        if(!(0<=rango0 && rango0<=9)){
                            //System.out.println("fallo 6");
                            datosValidos=false;
                            errorMessage.append("\n Elemento n del rango no aceptado.");
                        }
                        if(!(0<=rango1 && rango1<=9)){
                            //System.out.println("fallo 7");
                            datosValidos=false;
                            errorMessage.append("\n Elemento m del rango no aceptado.");
                        }
                        if(rango0>=rango1){
                           datosValidos=false;
                           errorMessage.append("\n El rango 0 no puede ser mayor o igual al rango 1.");
                        }
                    }  
                    catch (NumberFormatException exept)  
                    { 
                        datosValidos=false;
                    } 
                    if(datosValidos){//si son validos asignamos y reiniciamos valores en la gui
                        //System.out.println("DATOS VALIDADOS");
                        jSpinner1.setValue(0);//resetear valores
                        jSpinner2.setValue(0);
                        jSpinner3.setValue(0);
                        jTextField1.setText("");
                        jTextField2.setText("");
                        jTextField3.setText("");
                        jTextField4.setText("");
                        
                        jButton1.setForeground(new java.awt.Color(255, 0, 0));
                        jButton1.setText("Parar");
                     
                        //System.out.println(hasStarted);
                        hasStarted=true;
                    
                        buffer = new Buffer(jProgressBar1, model1, numBuffer, jSpinner4, model2);      
                        
                        producer = new Producer[numPro];
                        consumer = new Consumer[numCon];

                        Object[] rows = new Object[numBuffer];
                        for (int i = 0; i < numBuffer; i++){
                            rows[i] = new String[] {"",""};
                            model1.addRow(new String[] {"",""});
                        }
                        
                        //System.out.println(rango0+"_________");
                        //System.out.println(rango1+"_________");
                        Semaphore pRowSemaphore = new Semaphore(1);
                        for (int i = 0; i < numPro; i++) {
                            producer[i]= new Producer(i,buffer,pRowSemaphore,model1, jProgressBar1,rango0,rango1, numProTiempo);
                            producer[i].start();
                        }
                        //System.out.println("_______");
                        for (int i = 0; i < numCon; i++) {
                            consumer[i]= new Consumer(i,buffer,model2,jProgressBar1, numConTiempo);
                            consumer[i].start();
                        }
                        //System.out.println(producer.length+"_____________");
                        //System.out.println(consumer.length+"______________");
                        
                        
                        //System.out.println("iniciar el trhead");
                    }else{
                        //System.out.println("Datos no validos: " + errorMessage.toString());
                        JOptionPane.showMessageDialog(null,"Datos no validos: " + errorMessage.toString());
                    }
                }else{
                    hasStarted=false;
                    /*for (int i = 0; i < numPro; i++) {    
                        producer[i].interrupt();
                    }
                    for (int i = 0; i < numCon; i++) {    
                        consumer[i].interrupt();
                    }*/
                     for(Consumer c : consumer){
                        c.stop();
                     }
                    for(Producer p : producer){
                        p.stop();
                    }
                    
                    //System.out.println("parar el trhead");
                    
                    
                    model1.setRowCount(0);
                    model2.setRowCount(0);

                    producer = new Producer[0];
                    consumer = new Consumer[0];
                    
                    buffer.reiniciar();
                    
                    jButton1.setForeground(new java.awt.Color(0, 102, 51));
                    jButton1.setText("INICIAR");
                } 
        }});  
        
        
        
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration                   
}
