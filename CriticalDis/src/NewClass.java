
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedDFS;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Point2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lab228
 */
public class CriticalDis {
    
    public double d;
    public Point2D points[], source, target;
    public int index_source = 0, index_target = 0;
    public Digraph graph;
    
    //initializer
    public CriticalDis(Point2D[] points){
        //sort points and save array as data member
        Arrays.sort(points);
        this.points = points;
        
        /* 1. find source & target
           2. calc every edge & store to a priority queue*/
        MinPQ<Edge> edgePQ = new MinPQ<>();
        source = points[0];
        target = points[0];
        double sourcesum, targetsum, pointsum;
        sourcesum = source.x() + source.y();
        targetsum = target.x() + target.y();
        for(int i = 0; i < points.length; i++){
            //1.
            pointsum = points[i].x() + points[i].y();
            if(pointsum < sourcesum){
                source = points[i];
                index_source = i;
                sourcesum = pointsum;
            }
            if(pointsum > targetsum){
                target = points[i];
                index_target = i;
                targetsum = pointsum;
            }
            //2.
            for(int j = 0; j < points.length; j++){
                if(points[i].x()<points[j].x() && points[i].y()<points[j].y())
                    edgePQ.insert(new Edge(points[i], points[j], i, j));
            }
        }
        /////
        
        /*create graph, add edge with minimum length, run DFS & check if target is called*/ 
        graph = new Digraph(points.length);
        int v, w;   //edge v to w 
        while(true){
            Edge minedge = edgePQ.delMin();
            
            
            v = minedge.index_a;
            w = minedge.index_b;
            graph.addEdge(v, w);
            d = minedge.length;
            DirectedDFS dfs = new DirectedDFS(graph, index_source);
            if(dfs.marked(index_target))
                    break;
        }
        /////

        System.out.printf("%5.5f\n", d);
        
    }
    
    //inner class EDGE
    private class Edge implements Comparable<Edge>{
        public Point2D a, b;
        public int index_a, index_b;
        public double length;
        
        public Edge(Point2D a, Point2D b, int index_a, int index_b){
            this.a = a;
            this.b = b;
            this.index_a = index_a;
            this.index_b = index_b;
            double sqlength = Math.pow(a.x() - b.x(), 2) + Math.pow(a.y() - b.y(), 2);
            length = Math.sqrt(sqlength);
        }

        @Override
        public int compareTo(Edge o) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            if(this.length > o.length) return 1;
            if(this.length < o.length) return -1;
            return 0;
        }
    }
    
    //main
    public static void main(String args[]) throws Exception{
        try(BufferedReader br = new BufferedReader(new FileReader("test.txt"))){
//        In in = new In(args[0]);
//        int n = in.readInt();
        int n = Integer.parseInt(br.readLine());
        Point2D[] points = new Point2D[n];
        for(int i = 0; i < n; i++){
            String in = br.readLine();
            String[] s = in.split(" ");
            double x = Double.parseDouble(s[0]);
            double y = Double.parseDouble(s[1]);
            points[i] = new Point2D(x, y);
        }
        
        CriticalDis c = new CriticalDis(points);
    }
    }
}
