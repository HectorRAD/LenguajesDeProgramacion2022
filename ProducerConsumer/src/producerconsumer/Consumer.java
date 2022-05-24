
package producerconsumer;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Consumer extends Thread {
    Buffer buffer;
    int ID,
        waitTime;
    javax.swing.table.DefaultTableModel cModel;
    javax.swing.JProgressBar jProgressBar1;
    
    
    
    Consumer(int ID, Buffer buffer,javax.swing.table.DefaultTableModel cModel, javax.swing.JProgressBar jProgressBar1, int waitTime) {
        this.buffer = buffer;
        this.ID = ID;
        this.cModel = cModel;
        this.jProgressBar1 = jProgressBar1;
        this.waitTime = waitTime;
    }
    
    private String solve(char operation, double val1, double val2) {
        Double result = 0.0;
        boolean undefined = false;
        
        switch (operation) {
            case '+':
                result = val1 + val2;
                break;
            case '-':
                result = val1 - val2;
                break;
            case '*':
                result = val1 * val2;
                break;
            case '/':
                if (val2 == 0){
                    undefined = true;
                    break;
                }
                result = val1 / val2;
                break;
            default:
                System.out.println("Operation "+operation+"not supported. Operations allowed are +, -, *, and /");
        }
        return undefined ? "undefined" : result.toString();
    }
    
    @Override
    public void run() {
        //System.out.println("Running Consumer...");
        
        String product;
        
        while(!this.isInterrupted()){
            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {  
                product = this.buffer.consume();
                //Buffer.print("Consumer consumed: " + product);
                String[] opComponents = product.substring(1,product.length()-1).split(" ");
                String result = solve(opComponents[0].charAt(0), Double.parseDouble(opComponents[1]), Double.parseDouble(opComponents[2]));
                this.cModel.addRow(new Object[]{this.ID,product,result});
            //System.out.println(result); 
            }catch(Exception e){
               System.out.println(e.toString());
            }
        }
    }
}
