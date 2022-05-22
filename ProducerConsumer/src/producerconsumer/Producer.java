
package producerconsumer;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Producer extends Thread {
    Buffer buffer;
    String operations;
    int minValue, 
        maxValue;
    
    Producer(Buffer buffer, int minValue, int maxValue) {
        this.buffer = buffer;
        this.operations = "+-*/";
        this.minValue = minValue;
        this.maxValue = maxValue;
    }
    
    @Override
    public void run() {
        System.out.println("Running Producer...");
        Random r = new Random(System.currentTimeMillis());
        String product;
        Integer val1,
                val2;
        char operation;
        for(int i=0 ; i<5 ; i++) {
            operation = this.operations.charAt(r.nextInt(this.operations.length()));
            val1 = this.minValue + r.nextInt(this.maxValue + 1);
            val2 = this.minValue + r.nextInt(this.maxValue + 1);
            product = "("+operation+" "+val1.toString()+" "+val2.toString()+")";
            this.buffer.produce(product);
            //System.out.println("Producer produced: " + product);
            Buffer.print("Producer produced: " + product);
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
