
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
    
    
    Buffer(javax.swing.JProgressBar jProgressBar1, javax.swing.table.DefaultTableModel pModel, int size, javax.swing.JSpinner jSpinner4, javax.swing.table.DefaultTableModel pModel2) {
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
                    deleteRow = j;
                }
            }
            //this.pModel.removeRow(deleteRow);
            this.setProgress();
            //this.buffer = null;
            notify();
            cSemaphore.release();
        }catch(Exception e){
            System.out.println(e.toString());
        }
       
        return product;
    }
    
    public void setProgress(){
        System.out.println(created+" C");
        System.out.println(done+" D");
        Double percent = done / created * 100;
        if(done != 0)System.out.println(percent);
        if(done != 0)this.jProgressBar1.setValue((int)Math.round(percent));
        if(done != 0) this.jSpinner4.setValue(done);
    }
    
    synchronized void produce(String product) {
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
            pSemaphore.release();
            notify();
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
    
    static int count = 1;
    synchronized static void print(String string) {
        System.out.print(count++ + " ");
        System.out.println(string);
    }
    
}
