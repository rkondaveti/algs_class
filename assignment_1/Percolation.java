public class Percolation {

    public int N;
    public int[][] grid;

    public Percolation(int N) {
    //create an N-by-N grid with all sites blocked
        this.N = N;
        grid = new int[N][N];
    }
    
    private void checkInBounds(int i, int j){
        if (i <= 0 || i > N) throw new IndexOutOfBoundsException("row index i out of bounds");
        if (j <= 0 || j > N) throw new IndexOutOfBoundsException("column index j out of bounds");
    }    
    
    public boolean isOpen(int i, int j) {    
    // is site (row i, column j) open?        
        checkInBounds(i, j);
        if (this.grid[i][j] != 0) {return true;}
        else {return false;}

    } 
     
    public boolean isFull(int i, int j) {    
    // is site (row i, column j) full?
        checkInBounds(i, j);
        if (this.grid[i][j] == 0){return true;}
        else {return false;}
    
    }
    
    public void open(int i, int j){
    //open a site if it is not already
        checkInBounds(i, j);
        this.grid[i][j] = 1 ;
        
    }
    
    public static void main(String[] args) {
    //test client
     
     Percolation Perc = new Percolation(100);
     System.out.println(Perc.isFull(50,50));
     System.out.println(Perc.isOpen(50,50));
     Perc.open(50,50);
     System.out.println(Perc.isFull(50,50));
     System.out.println(Perc.isOpen(50,50));
     
     //WeightedQuickUnionUF UF = new WeightedQuickUnionUF(10);
     //System.out.println(UF.count());
    
    }
    
    
}