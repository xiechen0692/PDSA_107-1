/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.princeton.cs.algs4.In;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Arrays;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
/**
 *
 * @author Lab228
 */
public class FastCollinearPoints 
{
    private ArrayList<LineSegment> Segments = new ArrayList<>();
    public FastCollinearPoints(Point[] points)
    {
        double k[];
        double slope;
        if (points == null)
            throw new NullPointerException();
        for (int i=0 ; i < points.length-3 ; i++)
        {
            Arrays.sort(points);
            Arrays.sort(points,points[i].slopeOrder());
           for (int p = 0, first = 1, last = 2; last < points.length; last++) 
           {
              //對已經排序好的point array的slope做連續相等的判斷
              while (last < points.length && Double.compare(points[p].slopeTo(points[first]), points[p].slopeTo(points[last])) == 0) 
              {
                    last++;//有相等的就讓last++ 不連續就跳出while
              }
              if (last - first >= 3 ) //判斷是否大於等於三個的
              {
                    Segments.add(new LineSegment(points[p], points[last - 1]));//因爲last不連續時跳出，所以要減1
              }
                // Try to find next
                //System.out.println(last);
                first = last;//一個排序號的array能有多個連續的片段
           } // finds all line segments containing 4 or more points
        }
    }
    
    public int numberOfSegments()
    {
        return Segments.size();
    } 
    // the number of line segments    
    public LineSegment[] segments()
    {
        return Segments.toArray(new LineSegment[Segments.size()]);
    } 

    
    public static void main(String[] args) 
    {
    // read the n points from a file
    int j;
    In in = new In("input.txt");
    int n = in.readInt();
    Point[] points = new Point[n];
    Point[] pointchange = new Point[2];
    for (int i = 0; i < n; i++) 
    {
        int x = in.readInt();
        int y = in.readInt();
        points[i] = new Point   (x, y);
    }
    
//    for (int i = 1; i < n ; i++) 
//    {
//      pointchange[0]=points[i];//tmp
//            for( j=i; j > 0  ; j-- ) 
//            {
//               if(pointchange[0].compareTo(points[j-1])!=-1)
//                   break;
//               pointchange[1]=points[j];
//               points[j]=points[j-1];
//               points[j-1]=pointchange[1];
//            }
//            points[j]=pointchange[0]; 
//    }
    
    FastCollinearPoints collinear = new FastCollinearPoints(points);
//    for (LineSegment segment : collinear.segments()) 
//    {
//        System.out.println(segment);
//        segment.draw();
//    }
//    while(Segments.hasNext())
//    {
//    System.out.print(Segments.next() + " ");
//    }
       for (int i = 1; i < n ; i++) 
    {
       System.out.println(points[i]);
    }
     //draw the points
    StdDraw.enableDoubleBuffering();
    StdDraw.setXscale(0, 25000);
    StdDraw.setYscale(0, 25000);
    for (Point p : points) {
        p.draw();
    }
    StdDraw.show();

//     print and draw the line segments
//    FastCollinearPoints collinear = new FastCollinearPoints(points);
    for (LineSegment segment : collinear.segments()) {
        StdOut.println(segment);
        segment.draw();
    }
    StdDraw.show();
    }
}
