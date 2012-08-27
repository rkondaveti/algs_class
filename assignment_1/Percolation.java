public class Percolation {

    private int N;
    private int[] grid;
    private WeightedQuickUnionUF UF;

    public Percolation(int N) {
    //create an N-by-N grid with all sites blocked
        this.N = N;
        grid = new int[N*N];
        
        //every cell plus virual top site and virtual bottom site
        UF = new WeightedQuickUnionUF(N*N+2);
        
        //union each top & bottom row to respective virtual sites
        for (int j = 1; j < N; j++) {
            UF.union(coordinatesToPosition(1, j), N);
            UF.union(coordinatesToPosition(N, j), N+1);
        }
    }
    
    private int coordinatesToPosition(int i, int j) {
    //returns the Array positon from grid coordinates orignating 1,1 upper left
        checkInBounds(i, j);
        return N*i-(N-j+1);
    }
    
    private void checkInBounds(int i, int j) {
        if (i <= 0 || i > N) 
            throw new IndexOutOfBoundsException("row index i out of bounds");
        if (j <= 0 || j > N) 
            throw new IndexOutOfBoundsException("column index j out of bounds");
    }    
    
    public boolean isOpen(int i, int j) {    
    // is site (row i, column j) open?        
        checkInBounds(i, j);
        if (grid[coordinatesToPosition(i, j)] != 0) { return true; } 
        return false; 

    } 
     
    public boolean isFull(int i, int j) {    
    // is site (row i, column j) full?
        checkInBounds(i, j);
        if (grid[coordinatesToPosition(i, j)] == 0) { return true; }
        return false;
    
    }
    
    public void open(int i, int j) {
    //open a site if it is not already
        checkInBounds(i, j);
        this.grid[coordinatesToPosition(i, j)] = 1;
        
    }
    
    public boolean percolates() {
    //does the system percolate?
        
        System.out.println(UF.count());
        
        return true;
    }
    
    public static void main(String[] args) {
    //test client
     
        Percolation perc = new Percolation(100);
        System.out.println(perc.isFull(50, 50));
        System.out.println(perc.isOpen(50, 50));
        perc.open(50, 50);
        System.out.println(perc.isFull(50, 50));
        System.out.println(perc.isOpen(50, 50));
        System.out.println(perc.coordinatesToPosition(50, 50));
        System.out.println(perc.coordinatesToPosition(1, 1));
        System.out.println(perc.coordinatesToPosition(2, 1));
        System.out.println(perc.grid.length);
        perc.percolates();
        
    
    }
    
    
}