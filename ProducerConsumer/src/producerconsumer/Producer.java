
package producerconsumer;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.Semaphore;


public class Producer extends Thread {
    Buffer buffer;
    int ID;
    Semaphore rowsemaphore;
    String operations;
    javax.swing.table.DefaultTableModel model;
    int minValue, 
        maxValue,
        waitTime;
    
    javax.swing.JProgressBar jProgressBar1;
    
    Producer(int ID, Buffer buffer, Semaphore rowsemaphore, javax.swing.table.DefaultTableModel model, javax.swing.JProgressBar jProgressBar1, int minValue, int maxValue, int waitTime) {
        this.ID = ID;
        this.buffer = buffer;
        this.model = model;
        this.rowsemaphore = rowsemaphore;
        this.jProgressBar1 = jProgressBar1;
        this.operations = "+-*/";
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.waitTime = waitTime;
    }
    
    @Override
    public void run() {
        //System.out.println("Running Producer...");
        Random r = new Random(System.currentTimeMillis());
        String product;
        Integer val1,
                val2;
        char operation;
        while(!this.isInterrupted()) {
            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
            operation = this.operations.charAt(r.nextInt(this.operations.length()));
            val1 = (int)(Math.random()*(this.maxValue-this.minValue+1)+ this.minValue);
            val2 = (int)(Math.random()*(this.maxValue-this.minValue+1)+ this.minValue);
            //val1 = this.minValue + r.nextInt(this.maxValue + 1);//viejo
            //val2 = this.minValue + r.nextInt(this.maxValue + 1);//viejo
            product = "("+operation+" "+val1.toString()+" "+val2.toString()+")";
            try {        
                /* this.rowsemaphore.acquire();
                this.model.addRow(new Object[]{this.ID,product});
                this.rowsemaphore.release();*/
                this.buffer.produce(product, this.ID); 
                //Buffer.print("Producer produced: " + product);
            }catch(Exception e){
                System.out.println(e.toString());
            }
        }
    }
    
}
