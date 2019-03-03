/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lab228
 */

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.PrimMST;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Mst 
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new FileReader("test.txt"));
        int N = Integer.parseInt(br.readLine());
        Point2D[] group = new Point2D[N];
        for (int i = 0; i < N; i++) 
        {
            String line = br.readLine();
            String[] numbersArray=line.split(" ");
            double x = Double.parseDouble(numbersArray[0]);
            double y = Double.parseDouble(numbersArray[1]);
            group[i] = new Point2D(x, y);
        } 
        EdgeWeightedGraph EWG = new EdgeWeightedGraph(N);
        for (int i = 0; i < N; i++)
        {
            for (int j = i+1; j < N; j++)
            {
                double weight = group[i].distanceTo(group[j]);
                Edge e = new Edge(i,j,weight);
                EWG.addEdge(e);
            }
        }        
        PrimMST prim_mst = new PrimMST(EWG);
        System.out.printf("%5.5f\n", prim_mst.weight());
    }    
}
