
package producerconsumer;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumer extends Thread {
    Buffer buffer;
    
    Consumer(Buffer buffer) {
        this.buffer = buffer;
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
        System.out.println("Running Consumer...");
        String product;
        
        for(int i=0 ; i<5 ; i++) {
            product = this.buffer.consume();
            //System.out.println("Consumer consumed: " + product);
            Buffer.print("Consumer consumed: " + product);
            String[] opComponents = product.substring(1,product.length()-1).split(" ");
            String result = solve(opComponents[0].charAt(0), Double.parseDouble(opComponents[1]), Double.parseDouble(opComponents[2]));
            System.out.println(result);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
