/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lab228
 */
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton. cs.algs4.WeightedQuickUnionUF;

public class Percolation 
{
    private boolean[] opensituation;
    private int n;
    private WeightedQuickUnionUF connectStates;
    private WeightedQuickUnionUF connectStatesBW;
    
    public Percolation(int n)
    {
        this.n=n;
        opensituation=new boolean[n*n];
        connectStates = new WeightedQuickUnionUF(n * n + 2);
	connectStatesBW = new WeightedQuickUnionUF(n * n + 1);
        
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
		opensituation[i * n + j] = false;
		
            }
        }           
    }
    
    public void open(int row, int col)
    {
        if (row<=0||col<=0||row>n||col>n)
        {
        throw new java.lang.IllegalArgumentException();
        }
        int x = row-1;//initializate the coordinate 
        int y = col-1;//initializate the coordinate 
        if (!opensituation[x * n + y])//if site is close,enter the if
		{
			opensituation[x * n + y] = true;//open the site
                        if (y > 0 && opensituation[x * n + y-1]) 
                        {
                            connectStates.union(x * n + y+1, x * n + y-1+1);
                            connectStatesBW.union(x * n + y+1, x * n + y-1+1);
                        }
                        if (x > 0 && opensituation[x * n + y - n]) 
                        {
                            connectStates.union(x * n + y+1, x * n + y-n+1);
                            connectStatesBW.union(x * n + y+1, x * n + y-n+1);
                            //union(key, key - n);
                        }
                        if (y < n - 1 && opensituation[x * n + y + 1])
                        {
                            connectStates.union(x * n + y+1, x * n + y+1+1);
                            connectStatesBW.union(x * n + y+1, x * n + y+1+1);
                            //union(key, key + 1);
                        }
                        if (x < n - 1 && opensituation[x * n + y + n]) {
                            connectStates.union(x * n + y+1, x * n + y+n+1);
                            connectStatesBW.union(x * n + y+1, x * n + y+n+1);
                        }  
                       
//			if ((x - 1) >= 0 && y >= 0 && (x - 1) < n && y < n && opensituation[(x - 1) * n + y]) 
//                        {
//				
//                                connectStates.union(x * n + y + 1, (x - 1) * n + y + 1);
//				connectStatesBW.union(x * n + y + 1, (x - 1) * n + y +1);
//			   }
//                     if ((x + 1) >= 0 && y >= 0 && (x + 1) < n && y < n && opensituation[(x + 1) * n + y]) 
//                        {
//				connectStates.union(x * n + y + 1, (x + 1) * n + y + 1);
//                                
//				connectStatesBW.union(x * n + y + 1, (x + 1) * n + y +1);
//			   }
//                     if (x >= 0 && y >= 0 && (x - 1) < n && y < n && opensituation[x * n + (y-1)] && y != 0) 
//                        {
//				connectStates.union(x * n + y + 1, x * n + (y-1) + 1);
//				connectStatesBW.union(x * n + y + 1, x * n + (y-1) +1);
//			   }
//                     if (x >= 0 && y >= 0 && (x - 1) < n && y < n && opensituation[x * n + (y+1) ] && y!= n-1) 
//                        {
//				connectStates.union(x * n + y + 1, x * n + (y+1) + 1);
//				connectStatesBW.union(x * n + y + 1, x * n + (y+1) +1);
//                        }
                        if (x == 0) 
                        {
				connectStates.union(x * n + y + 1, 0);
				connectStatesBW.union(x * n + y + 1, 0);
                        }
                        if (x == n-1)
				connectStates.union(x * n + y + 1, n * n + 1);
                            
              }
    }
    
    public boolean isOpen(int row, int col)
    {
            if (row<=0||col<=0||row>n||col>n)
            {
            throw new java.lang.IllegalArgumentException();
            }
            int x = row-1;
            int y = col-1;
            return (opensituation[x * n + y]);
    }
    
    public boolean isFull(int row, int col)
    {
            int yes=0;
            if (row<=0||col<=0||row>n||col>n)
            {
            throw new java.lang.IllegalArgumentException();
            }
            int x = row-1;
            int y = col-1;
            return connectStatesBW.connected(x * n + y + 1, 0);
//            for (int i=0;i<=n;i++)
//            {
//               if(connectStates.connected(0 * n + i,x * n + y))
//               {
//                   yes++;
//               }
//            }
//            if (yes!=0)
//            {
//                return true;
//            }
//            else
//                return false;
    }
    
    public int numberOfOpenSites()
    {
            
        int numsiteopen=0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
		if (opensituation[i * n + j] == true)
                    numsiteopen++;		
            }
        } 
        return numsiteopen;
    }
    
    public boolean percolates() 
    {
        return connectStates.connected(0,n*n+1);

    }
}

