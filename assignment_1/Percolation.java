public class Percolation {

	public int[][] grid;

    public Percolation(int N) {
    //create an N-by-N grid with all sites blocked
        grid = new int[N][N];
    }
    
    public boolean isOpen(int i, int j) {    
    // is site (row i, column j) open?
    
    }	
    	
    public boolean isFull(int i, int j) {    
    // is site (row i, column j) full?	
        if (this.grid[i][j] == 0) {return true;}
        else {return false;}
    
    }
    
    public void open(int i, int j){
    //open a site if it is not already
    	
        
    }
    
    public static void main(String[] args) {
    //test client
    	
    	Percolation Perc = new Percolation(10);
    	System.out.println(Perc.isFull(5,5));
	    //WeightedQuickUnionUF UF = new WeightedQuickUnionUF(10);
	    //System.out.println(UF.count());
    
    }
    
    
}