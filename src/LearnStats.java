/* Getting my feet wet with the supplied StdRandom and StdStats libraries
 * http://introcs.cs.princeton.edu/java/stdlib/StdRandom.java.html
 * http://introcs.cs.princeton.edu/java/stdlib/StdStats.java.html
 */

public class LearnStats {
    
    double[] randomNumbers;
    ConfidenceInterval confidenceInterval;
    
    public LearnStats(int size) {
    //create an array of requested size, fill it with random numbers
        
        randomNumbers = new double[size];
        
        for (int i = 0; i < size; i++) {
            randomNumbers[i] = StdRandom.random();
        }
        
        confidenceInterval = new ConfidenceInterval(randomNumbers);
        
    }
    
    public void printValues() {
            
        for (int i = 0; i < randomNumbers.length; i++) {
            System.out.println(randomNumbers[i]);
        }        
    
    }
    
    final class ConfidenceInterval{
        private final double left;
        private final double right;
        
        public ConfidenceInterval(double[] inputArray) {
            
            double mean = StdStats.mean(inputArray);
            double stddev = StdStats.stddev(inputArray);
        
            this.left = mean - 1.96 * stddev / Math.sqrt(inputArray.length);
            this.right = mean + 1.96 * stddev / Math.sqrt(inputArray.length);
        }
        
        public double getLeft(){
            return left;
        }
        
        public double getRight(){
            return right;
        }
    }
    
    public static void main(String[] args) {
        
        LearnStats tester = new LearnStats(100);
        tester.printValues();
        
        System.out.println("Mean: " + 
                           StdStats.mean(tester.randomNumbers));
        System.out.println("Standard Deviation: " + 
                           StdStats.stddev(tester.randomNumbers));
        System.out.println("95% Confidence Interval: " + 
                           tester.confidenceInterval.getLeft() + ", " +
                           tester.confidenceInterval.getRight()
                          );
    }   

}
