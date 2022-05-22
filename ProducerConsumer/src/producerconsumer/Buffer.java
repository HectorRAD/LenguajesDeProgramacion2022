
package producerconsumer;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.Semaphore;

public class Buffer {
    
    private String buffer;
    private int size;
    javax.swing.JProgressBar jProgressBar1;
    private static Semaphore cSemaphore = new Semaphore(1),
                             pSemaphore = new Semaphore(1);
    private static Double created = 0.0, done = 0.0;
    javax.swing.table.DefaultTableModel pModel;
    
    Buffer(javax.swing.JProgressBar jProgressBar1, javax.swing.table.DefaultTableModel pModel, int size) {
        this.jProgressBar1 = jProgressBar1;
        this.pModel = pModel;
        this.buffer = null;
        this.size = size;
    }
    
    synchronized String consume() {
        String product = null;
        while(this.buffer == null) {
            try {
                wait(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            cSemaphore.acquire();
            done++;
            product = this.buffer;
            int deleteRow = -1;
            int rows = pModel.getRowCount();
            for (int j = 0; j < rows; j++){
                String value = (String) this.pModel.getValueAt(j, 1);
                if (value.equals(product)){
                    deleteRow = j;
                }
            }
            this.pModel.removeRow(deleteRow);
            this.setProgress();
            this.buffer = null;
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
    }
    
    synchronized void produce(String product) {
        while (this.buffer != null){
            try {
                wait(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
           
        try {
            pSemaphore.acquire();
            created++;
            this.setProgress();
            this.buffer = product;
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
