# HW2: Percolation
Please implement Percolation.java according to the API provided in this URL: http://coursera.cs.princeton.edu/algs4/assignments/percolation.html 

In summary, your Percolation class must contain the following functions: 
- public Percolation(int n) // create n-by-n grid, with all sites blocked
- public void open(int row, int col) // open site (row, col) if it is not open already
- public boolean isOpen(int row, int col) // is site (row, col) open?
- public boolean isFull(int row, int col) // is site (row, col) full?
- public int numberOfOpenSites() // number of open sites
- public boolean percolates() // does the system percolate?


Notice:  
Throw a java.lang.IllegalArgumentException if any argument to open(), isOpen(), or isFull() is outside its prescribed range.  
Take care of the backwash issue.

Other resources related to this assignment are provided here: https://www.coursera.org/learn/algorithms-part1/programming/Lhp5z/percolation