/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package findneighbors;
import edu.princeton.cs.algs4.Point2D;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.ArrayList;
import edu.princeton.cs.algs4.In;
/**
 *
 * @author Lab228
 */
public class FindNeighbors 
{
    private Node root;
    private double bestdist = 1000000000;       
    //PriorityQueue<Point2D> priorityQueue = new PriorityQueue<Point2D>();
    //private Point2D[] pointss;
    ArrayList<Point2D> pointss = new ArrayList<Point2D>();
    private double dist(Point2D p1, Point2D p2)
    {
        return Math.sqrt(Math.pow(p1.x() - p2.x() , 2) + Math.pow(p1.y() - p2.y() , 2));
    }
    
    public boolean isEmpty() { return root == null; }
    
    private class Node 
    {
        private Point2D p;
        private int level; // 1 or 2 (2d-tree)
        private Node left, right;
        private Node parents;
        
        public Node(Point2D p, int level) 
        {
            this.p = p;
            this.level = level;
        }
    }
    private void extend(Point2D p) 
    {
    Node node = root;
    int level = 1; // level = 1 (x), level = 2 (y)
    while (true) 
        {
            if (level == 1) 
            {
                if (p.x() < node.p.x()) 
                {
                    if (node.left == null) 
                    {
                        node.left = new Node(p, 3-level);
                        return;
                    }
                    node = node.left;
                }
                else 
                {
                    if (node.right == null) 
                    {
                        node.right = new Node(p, 3-level);
                        return;
                    }
                    node = node.right;
                }
            }
            else 
            { // level = 2
                if (p.y() < node.p.y()) 
                {
                    if (node.left == null) 
                    {
                        node.left = new Node(p, 3-level);
                        return;
                    }
                    node = node.left;
                }
                else 
                {
                    if (node.right == null) 
                    {
                        node.right = new Node(p, 3-level);
                        return;
                    }
                    node = node.right;
                }
            }
            level = 3 - level; // 1 <-> 2
        }
    }

    private void add(Point2D p) {
        if (root == null) 
        {
            root = new Node(p, 1);
            return;
        }
        extend(p);
    }

    public void init(Point2D[] points)
    {
        
        //for (Point2D p:points) 
        for (int i=0 ; i < points.length;i++)
        {
            //pointss[i]=points[i];
            //pointss.add(points[i]);
            add(points[i]);
        }
        return;            
    }

//    public void searchNN(Node n , Point2D p0)
//    {
//        PriorityQueue<Point2D> priorityQueue = new PriorityQueue<Point2D>(new Comparator<Point2D>()
//        {
//            @Override
//            public int compare(Point2D p1, Point2D p2) 
//                {
//                        if(dist(p1,p0) > dist(p2,p0))
//                            return 1;
//                        else if(dist(p1,p0) < dist(p2,p0))
//                            return -1;
//                        else 
//                            return 0;
//                }
//        }); 
//        
//        double d = dist ( n.p , p0 );
//        if (d < bestdist)
//        {
//            bestdist = d;
//        }
//        if (n.level==1)
//        {
//           if(p0.x()<n.p.x())
//        }
//    }

//    public void postOrder(Node current ,Point2D point) 
//    {
//            double d = dist(current.p,point);
//            query()
//            priorityQueue.add( d );
//            if (current != null) 
//            {
//                    postOrder(current.left);
//                    postOrder(current.right);
//                    System.out.print(current);
//            }
//    }

    public Point2D[] query(Point2D point, int k)
    {
        Point2D[] result = new Point2D[k];
        PriorityQueue<Point2D> priorityQueue = new PriorityQueue<Point2D>(new Comparator<Point2D>()
        {
            @Override
            public int compare(Point2D p1, Point2D p2) 
                {
                        if(dist(p1,point) > dist(p2,point))
                            return 1;
                        else if(dist(p1,point) < dist(p2,point))
                            return -1;
                        else 
                            return 0;
                }
        });
        Point2D kkk = nearest2(point);
        System.out.println(kkk);
        for (int i=0; i<pointss.size();i++)
        {
            priorityQueue.add(pointss.get(i));
        }
        while(true)
        {
           System.out.println(priorityQueue.poll());
        }
//        int flag =0;
//        for(int j = 0; j < k ; j++)
//        {
//            Point2D xxx = priorityQueue.poll(); 
//            if (flag==0)

//            {
//                result[j]=xxx;
//            }
//            if (xxx!=result[j-1])
//            {
//                result[j]=xxx;
//            }
//            flag++;
//        }
        //System.out.println(result[1]);
        return result;
        // the points should be sorted accordingly to their distances to the query, from small to large


    } 

    private Point2D nearest(Node x, Point2D p, Point2D mp) 
    {
        Point2D min = mp;
        pointss.add(min);
        //System.out.println("ok");
        if (x == null) return min;
        if (p.distanceSquaredTo(x.p) < p.distanceSquaredTo(min))
        {
            min = x.p;
        }
        // choose the side that contains the query point first
        if (x.level==1) {
            if (x.p.x() < p.x()) {
                min = nearest(x.right, p, min);
                if (x.left != null
                        && (min.distanceSquaredTo(p)
                            > x.left.p.distanceSquaredTo(p)))
                    min = nearest(x.left, p, min);
            } else {
                min = nearest(x.left, p, min);
                if (x.right != null
                        && (min.distanceSquaredTo(p)
                         > x.right.p.distanceSquaredTo(p)))
                    min = nearest(x.right, p, min);
            }
        } else {
            if (x.p.y() < p.y()) {
                min = nearest(x.right, p, min);
                if (x.left != null
                        && (min.distanceSquaredTo(p)
                            > x.left.p.distanceSquaredTo(p)))
                    min = nearest(x.left, p, min);
            } else {
                min = nearest(x.left, p, min);
                if (x.right != null
                        && (min.distanceSquaredTo(p)
                            > x.right.p.distanceSquaredTo(p)))
                    min = nearest(x.right, p, min);
            }
        }
        return min;
    }

    // a nearest neighbor in the set to p: null if set is empty
    public Point2D nearest2(Point2D p) 
    {
        if (isEmpty()) return null;
        return nearest(root, p, root.p);
    }



        /**
         * TODO WORST CASE: ????????? 
         *
         * All points that are inside the rectangle
         */

    
//    public Node test_search(Point2D point, Node node)
//    {
//        if ( node == null ) ;
//        if (node.level==1) // for X
//        {
//            if (point.x() > node.p.x()) // for right
//            {
//                if (bestdist>dist(node.p,point)) bestdist=dist(node.p,point);
//                if ( ( point.x()-node.p.x() ) >= dist(node.p,point))
//                {
//                    test_search(point, node.right);
//                }
//            }
//            else    // for left
//            {
//                if (bestdist>dist(node.p,point)) bestdist=dist(node.p,point);
//                if ( ( point.x()-node.p.x() ) >= dist(node.p,point))
//                {
//                    test_search(point, node.left);
//                }
//            }
//        }
//        else // for Y
//        {
//            if (point.y() > node.p.y()) // for right
//            {
//                if (bestdist>dist(node.p,point)) bestdist=dist(node.p,point);
//                if ( ( point.x()-node.p.x() ) >= dist(node.p,point))
//                {
//                    test_search(point, node.right);
//                }
//            }
//            else    // for left
//            {
//                if (bestdist>dist(node.p,point)) bestdist=dist(node.p,point);
//                if ( ( point.x()-node.p.x() ) >= dist(node.p,point))
//                {
//                    test_search(point, node.left);
//                }
//            }
//        }
//        
//    }
    

    
    public static void main(String[] args) 
    {
        //System.out.println("1");
        FindNeighbors fn = new FindNeighbors();
//        if (args.length > 0) 
//        {
        In in = new In("test.txt");
        int N = 6;
        Point2D[] group = new Point2D[N];
        //System.out.println("okok");
        for (int i = 0; i < N ; i++) 
        {
            //System.out.println("2");
            String[] coordinate = in.readLine().split(" ");
            double X_co = Double.parseDouble(coordinate[0]);
            double Y_co = Double.parseDouble(coordinate[1]);
            group[i] = new Point2D(X_co, Y_co);
            //System.out.println(group[i]);
        } 
        Point2D point = new Point2D(2 , 4.5);
        //System.out.println("3");
        
        fn.init(group);
        Point2D[] hhhhh=fn.query(point, 4);
        System.out.println(hhhhh[0]+"  "+hhhhh[1]+"    "+hhhhh[2]+"    "+hhhhh[3]);
        // TODO code application logic here
//        }
    }
}
