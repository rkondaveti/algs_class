/* Getting my feet wet with the supplied StdRandom and StdStats libraries
 * http://introcs.cs.princeton.edu/java/stdlib/StdRandom.java.html
 * http://introcs.cs.princeton.edu/java/stdlib/StdStats.java.html
 */

public class LearnStats {
    
    double[] randomNumbers;
    
    public LearnStats(int size) {
    //create an array of requested size, fill it with random numbers
        
        randomNumbers = new double[size];
        
        for (int i = 0; i < size; i++) {
            randomNumbers[i] = StdRandom.random();
        }
    }
    
    public void printValues() {
            
        for (int i = 0; i < randomNumbers.length; i++) {
            System.out.println(randomNumbers[i]);
        }        
    
    }
    
    public static void main(String[] args) {
        
        LearnStats tester = new LearnStats(10);
        tester.printValues();
        
        System.out.println("Mean: " + StdStats.mean(tester.randomNumbers));
        System.out.println("Standard Deviation: " + StdStats.stddev(tester.randomNumbers));
        
    }   

}
