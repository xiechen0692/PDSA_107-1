/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lab228
 */
import java.lang.Math;
import  java.io.FileReader;
import java.io.BufferedReader;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;
import edu.princeton.cs.algs4.DirectedDFS;
import java.util.Comparator;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Digraph;
import java.util.Arrays;
import java.util.ArrayList;
import java.text.DecimalFormat;
import java.util.Collections;
/**
 *
 * @author Lab228
 */
public class CriticalDis 
{
    public static class xyComparator implements Comparator<Point2D>
    {
    @Override
    public int compare(Point2D p1, Point2D p2) 
        {
            if ((p1.x()+p1.y()) > (p2.x()+p2.y()))
            return 1;
            else return -1;
        }
    }

//    public class binary()
//    {
//        
//    }
    
    
    public static void main(String[] args) throws Exception
    {
        //In in = new In(args[0]);
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        ArrayList<Double> min_d = new ArrayList<Double>();
        //MinPQ<Double> pq = new MinPQ<Double>();
        //int N = in.readInt();
        int N = Integer.parseInt(br.readLine());
//        System.out.println(N);
        Point2D[] group = new Point2D[N];
        Point2D[] group_sort = new Point2D[N];
        group_sort = group;
        for (int i = 0; i < N; i++) 
        {
            String line = br.readLine();
            String[] numbersArray=line.split(" ");
            //double x = Double.parseDouble(br.readLine());
            //double y = Double.parseDouble(br.readLine());
            double x = Double.parseDouble(numbersArray[0]);
            double y = Double.parseDouble(numbersArray[1]);
            group[i] = new Point2D(x, y);
            //System.out.println(group[i]);
        }
        Arrays.sort(group_sort , new xyComparator());
        //int num = 0;
        for (int x = 0; x < N; x++)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
        {
            for (int y = x+1 ; y < N; y++)
            {
                double dist = group_sort[x].distanceTo(group_sort[y]);      
                //System.out.println(dist);
                min_d.add(dist);
                //num++;
            } 
        }
        Collections.sort(min_d);
//        for ( int i = 0 ; i < min_d.size() ; i++)
//        {
//            System.out.println(min_d.get(i));
//        }
        
        int l = 0;
        int r = min_d.size() - 1;           
        while(true)
        {
            Digraph DG = new Digraph(N);
            int m = l + ((r-l) / 2) ;
//            System.out.println("l  "+l);
//            System.out.println("r  "+r);
//            System.out.println("m  "+m);
//            System.out.println("**********");
            double mindist = min_d.get(m);
            //System.out.printf("%5.5f\n", mindist);
            for (int i = 0; i < N; i++)
            {
                for (int j = i+1; j < N; j++)
                {
                    if ((group_sort[i].distanceTo(group_sort[j]) <= mindist) && (group_sort[i].x()<group_sort[j].x()) && (group_sort[i].y()<group_sort[j].y()))
                    {
                        DG.addEdge(i, j);
                    }
                }
            }
            DirectedDFS dfs = new DirectedDFS(DG,0);
            //BreadthFirstDirectedPaths Dbfp = new BreadthFirstDirectedPaths(DG,0);
            
            if (  l <= r )
            {
                if (dfs.marked(N-1))
                {
                    r = m-1;
                }
                else
                {
                    l = m+1;
                }

            }
            else
            {   
                //System.out.println("ok");
                System.out.printf("%5.5f\n", mindist);
                break;
            }
        }
    }
    
}
