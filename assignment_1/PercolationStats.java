/* Soulution to http://coursera.cs.princeton.edu/algs4/assignments/percolation.html  
 * Perform T independent computational experiments on an N-by-N grid
 */

public class PercolationStats {
    
    int N; //size of grid
    int T; //number of simulations to run
    
    public double[] simulationResults;
    
    public PercolationStats(int N, int T) {
        this.N = N;
        this.T = T;
        simulationResults = new double[T];
        
        for (int t = 0; t < T; t++) {
            simulationResults[t] = runSimulation();
        } 
    }
    
    private double runSimulation() {
        
        Percolation percolation = new Percolation(N);
        
        double counter = 0;
        
        while(!percolation.percolates()) {
        
            counter++;
            
            //pick a random site (N+1 because second value to uniform is exclusive)
            int i = StdRandom.uniform(1, N+1);
            int j = StdRandom.uniform(1, N+1);
            
            //generate new random sites until a blocked one is found
            while(percolation.isOpen(i, j)){
                
                i = StdRandom.uniform(1, N+1);
                j = StdRandom.uniform(1, N+1);
                
            }
            
            //open that site
            percolation.open(i, j);
        
        }
        return counter / (N*N); //return percolation threshold estimate
    }
    

    public double mean() {
    //computed sample mean of percolation threshold from T experiments
        return StdStats.mean(simulationResults);
    }
    
    public double stddev() {
    //computed sample standard deviation percolation threshold
        return StdStats.stddev(simulationResults);
    }
    
    public static void main(String[] args){
    //test client
        
        int gridSize;
        int simulationCount;
  
        if (args.length == 0) {
            gridSize = 100;
            simulationCount = 10;
        } else {
            gridSize = Integer.parseInt(args[0]);
            simulationCount = Integer.parseInt(args[1]);
        }
        
        if (gridSize <= 0 || simulationCount <= 0) {
            throw new java.lang.IllegalArgumentException("Arguments must be greater than 0");
        }
            
        
        PercolationStats PercSim = new PercolationStats(gridSize, simulationCount);
        
        double confidenceLeft  = PercSim.mean() - 1.96 * PercSim.stddev() / Math.sqrt(PercSim.T);
        double confidenceRight = PercSim.mean() + 1.96 * PercSim.stddev() / Math.sqrt(PercSim.T);
        
        
        System.out.println("mean                    = " + PercSim.mean()); 
        System.out.println("stddev                  = " + PercSim.stddev());
        System.out.println("95% confidence interval = " + confidenceLeft + ", " + confidenceRight);
                            
    
    }
}