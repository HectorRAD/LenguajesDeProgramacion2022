
package producerconsumer;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.Semaphore;
import java.util.Queue;
import java.util.LinkedList;

public class Buffer {
    
    private String buffer;
    private int size;
    private Queue<String> queue;
    javax.swing.JProgressBar jProgressBar1;
    javax.swing.JSpinner jSpinner4;
    private static Semaphore cSemaphore = new Semaphore(1),
                             pSemaphore = new Semaphore(1);
    private static Double created = 0.0, done = 0.0;
    javax.swing.table.DefaultTableModel pModel,
                                        pModel2;
    
    public void reiniciar(){
        done=0.0;
        created=0.0;
        size=0;
        jSpinner4.setValue(0);
        jProgressBar1.setValue(0);
        queue.clear();
        if (cSemaphore.availablePermits() == 0) cSemaphore.release();
        if (pSemaphore.availablePermits() == 0) pSemaphore.release();
    }
    
    public Buffer(javax.swing.JProgressBar jProgressBar1, javax.swing.table.DefaultTableModel pModel, int size, javax.swing.JSpinner jSpinner4, javax.swing.table.DefaultTableModel pModel2) {
        this.jProgressBar1 = jProgressBar1;
        this.pModel = pModel;
        this.buffer = null;
        this.size = size;
        this.queue = new LinkedList<>();
        this.jSpinner4 = jSpinner4;
        this.pModel2 = pModel2;
    }
    
    synchronized String consume() {
        String product = null;
        while(this.queue.isEmpty()) {
            try {
                wait(); //Esperar a que se produzca algo que consumir
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            cSemaphore.acquire();
            done++;
            //product = this.buffer;
            product = this.queue.poll();
            int deleteRow = -1;
            int rows = pModel.getRowCount();
            for (int j = 0; j < rows; j++){
                String value = (String) this.pModel.getValueAt(j, 1);
                if (value.equals(product)){
                    this.pModel.setValueAt("", j, 0);
                    this.pModel.setValueAt("", j, 1);
                }
            }
            //this.pModel.removeRow(deleteRow);
            this.setProgress();
            //this.buffer = null;
            notify();
            cSemaphore.release();
        }catch(Exception e){
            System.out.println(e.toString());
            cSemaphore.release();
        }
       
        return product;
    }
    
    public void setProgress(){
        //System.out.println(created+" C");
        //System.out.println(done+" D");
        Double percent = done / created * 100;
        //if(done != 0)System.out.println(percent);
        if(done != 0)this.jProgressBar1.setValue((int)Math.round(percent));
        if(done != 0) this.jSpinner4.setValue(done);
    }
    
    synchronized void produce(String product, int ID) {
        while (this.queue.size()>size){
            try {
                wait(); //Esperar a que haya espacio para producir
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
           
        try {
            pSemaphore.acquire();
            created++;
            this.setProgress();
            //this.buffer = product;
            this.queue.add(product);
            for (int i = 0; i < this.pModel.getRowCount(); i++){
                if (this.pModel.getValueAt(i, 1).equals("")) {
                    this.pModel.setValueAt(ID, i, 0);
                    this.pModel.setValueAt(product, i, 1);
                    break;
                }
            }
            pSemaphore.release();
            notify();
        }catch(Exception e){
            System.out.println(e.toString());
            pSemaphore.release();
        }
    }
    
    static int count = 1;
    synchronized static void print(String string) {
        System.out.print(count++ + " ");
        System.out.println(string);
    }
    
}
