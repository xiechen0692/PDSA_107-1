/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CriticalDis;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;
import java.util.Comparator;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Digraph;
import java.util.Arrays;
import java.text.DecimalFormat;
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

    public static void main(String[] args) 
    {
        In in = new In("test.txt");
        MinPQ<Double> pq = new MinPQ<Double>();
        int N = in.readInt();
//        System.out.println(N);
        Point2D[] group = new Point2D[N];
        Point2D[] group_sort = new Point2D[N];
        group_sort = group;
        for (int i = 0; i < N; i++) 
        {
            double x = in.readDouble();
            double y = in.readDouble();
            group[i] = new Point2D(x, y);
            //System.out.println(group[i]);
        }
        Arrays.sort(group_sort , new xyComparator());
        int num = 0;
        for (int x = 0; x < N; x++)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
        {
            for (int y = x+1 ; y < N; y++)
            {
                double dist = group_sort[x].distanceTo(group_sort[y]);      
                //System.out.println(dist);
                pq.insert(dist);
                num++;
            }
        }
        for (int n = 0; n < num; n++)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
        {
            Digraph DG = new Digraph(N);
            double mindist = pq.delMin();
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
            BreadthFirstDirectedPaths Dbfp = new BreadthFirstDirectedPaths(DG,0);
            if (Dbfp.hasPathTo(N-1))
            {
                System.out.printf("%5.5f\n", mindist);
                break;
            }
        }
    }
    
}
