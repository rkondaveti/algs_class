/* Soulution to http://coursera.cs.princeton.edu/algs4/assignments/percolation.html 
 * 
 */

public class PercolationStats {
    
    public double[] simulationResults;
    
    public PercolationStats(int N, int T) {
    //perform T independent computational experiments on an N-by-N grid
        
        simulationResults = new double[T];
        
    }    
    
/*
    public double mean(int[] SimulationResults){
    //computed sample mean of percolation threshold from T experiments
    
    
    }
    
    
    public double stddev() {
    //computed sample standard deviation percolation threshold
    
    }
    
  */  
    public static void main(String[] args){
    //test client    
        
        PercolationStats PercSimulation = new PercolationStats(200, 100);
        
        for (int i = 0; i < PercSimulation.simulationResults.length; i++) {
            System.out.println(PercSimulation.simulationResults[i]);
        }   
    
    
    }
    
    
    
}