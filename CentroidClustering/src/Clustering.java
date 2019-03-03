/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import java.util.Arrays;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Collections;
/**
 *
 * @author Lab228
 */
public class Clustering 
{ 
    static class Point {
		public Point() 
              {
		}
 
		public Point(double x, double y , double weight) 
              {
			this.x = x;
			this.y = y;
                     this.weight = weight;
		}
		double x;
		double y;
              double weight;
	}    
    
    public static double distance(Point p1, Point p2) 
    {
//            if (p1 == p2)
//                    return 10000;
            return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }
       


    public static void main(String[] args) throws Exception
    {
        ArrayList<Point> points = new ArrayList<Point>();
        Clustering kk = new Clustering();
        //ArrayList<Integer> weights = new ArrayList<Integer>();
        
        Comparator<Point> hahaha = new Comparator<Point>()
        {
            public int compare(Point s1, Point s2) 
                {
                    if(s1.weight < s2.weight)
                        return 1;
                    else if(s1.weight > s2.weight)
                        return -1;
                    else 
                        return 0;
                }       
        };
        
        In in = new In("data.in");
        int n = in.readInt();
        for (int i = 0; i < n; i++) 
        {
             double x=(double)in.readFloat();
             double y=(double)in.readFloat();
             points.add(new Point(x,y,1));
             //weights.add(1);
        }
        if (points.size()==0)
        {
            throw new NullPointerException();
        }
        else if (points.size()<=3)
        {
            Collections.sort(points, hahaha);
            for (int i=0;i<points.size();i++)
                {
                    int weightprint = (int)points.get(i).weight;
                    double get_x = (double)(Math.round((points.get(i).x)*100)/100.0);
                    double get_y = (double)(Math.round((points.get(i).y)*100)/100.0);
                    System.out.println(weightprint+" "+get_x+" "+get_y);
                }
        }
        else
        {   
            PriorityQueue<ArrayList<Double>> priorityQueue = new PriorityQueue<ArrayList<Double>>(points.size()*(points.size()-1),new Comparator<ArrayList<Double>>()
            {
                @Override
                public int compare(ArrayList<Double> p1, ArrayList<Double> p2) 
                    {
                            if(p1.get(0) > p2.get(0))
                                return 1;
                            else if(p1.get(0) < p2.get(0))
                                return -1;
                            else 
                                return 0;
                    }
            });

            for (int i=0;i<points.size();i++)
            {
                for (int j=i;j<points.size();j++)
                {
                    if (j==i)
                        continue;
                    ArrayList<Double> PUTIN = new ArrayList<Double>();
                    double now_distance = Clustering.distance(points.get(i), points.get(j));

                    PUTIN.add((Double)now_distance);
                    PUTIN.add((double)i); 
                    PUTIN.add((double)j);
                    //PUTIN.add((double)1);

                    priorityQueue.add( PUTIN );          
                }
            }
            
            int flag = 0;
            
            while ( points.size() > 3 )
            {   
                //System.out.println("flag"+flag);
                int num = points.size()-1;
                if (flag == 0)
                {
                    flag++;  
                }
                
                //System.out.println("okok");
                else
                {
                    for (int nn=0; nn < points.size()-1; nn++ )
                    {
                        //System.out.println(flag);
                        ArrayList<Double> PUTIN2 = new ArrayList<Double>();
                        double newp_distance = Clustering.distance(points.get(num), points.get(nn));
                        PUTIN2.add((Double)newp_distance);
                        PUTIN2.add((double)nn); 
                        PUTIN2.add((double)num);                   
                        priorityQueue.add( PUTIN2 );
                        ArrayList<ArrayList> a = new ArrayList<ArrayList>();
                       
                    }
                }
                //System.out.println("num"+num);
                //System.out.println(points.size());
                ArrayList<Double> OUT = priorityQueue.poll();
                //System.out.println(OUT);
                double ii = OUT.get(1);
                int iii = (int) ii;
                double jj = OUT.get(2);
                int jjj = (int) jj;//取出pq里面的最小元素中的i，j索引并转换成整型
                double xx; 
                double yy;
                System.out.println(iii+","+jjj);
                System.out.println(points.size());
                if (points.get(iii).x < points.get(jjj).x)
                { 
                    xx = points.get(iii).x + (Math.abs(points.get(iii).x - points.get(jjj).x)/(points.get(iii).weight+points.get(jjj).weight) * points.get(jjj).weight);                //删掉pair两个点，新增一个点，考虑权重
                }
                else
                {
                    xx = points.get(jjj).x + (Math.abs(points.get(iii).x - points.get(jjj).x)/(points.get(iii).weight+points.get(jjj).weight) * points.get(iii).weight);
                }
                if (points.get(iii).y < points.get(jjj).y)
                {
                    yy = points.get(iii).y + (Math.abs(points.get(iii).y - points.get(jjj).y)/(points.get(iii).weight+points.get(jjj).weight) * points.get(jjj).weight);                //删掉pair两个点，新增一个点，考虑权重
                }
                else
                {
                    yy = points.get(jjj).y + (Math.abs(points.get(iii).y - points.get(jjj).y)/(points.get(iii).weight+points.get(jjj).weight) * points.get(iii).weight);
                }            

                double addweight = points.get(iii).weight + points.get(jjj).weight;
                points.add(new Point(xx,yy,addweight));
                //weights.add(weights.get(iii)+weights.get(jjj));
                //System.out.println(iii+","+jjj);
                if (iii>jjj)
                {
                points.remove(iii);
                points.remove(jjj);
                //weights.remove(iii);
                //weights.remove(jjj);
                }
                else
                {
                points.remove(jjj);
                points.remove(iii);
                //weights.remove(jjj);
                //weights.remove(iii);  
                }
            }
            Collections.sort(points, hahaha);

            //System.out.println(points.size());
            for (int i=0;i<points.size();i++)
            {
                int weightprint = (int)points.get(i).weight;
                double get_x = (double)(Math.round((points.get(i).x)*100)/100.0);
                double get_y = (double)(Math.round((points.get(i).y)*100)/100.0);
                System.out.println(weightprint+" "+get_x+" "+get_y);
                //System.out.println(weights.get(i));
            }
        } 
    }
} 


