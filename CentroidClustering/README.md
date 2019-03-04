# HW5 Using the Priority Queue
Assignment: CentroidClustering.java (your main function will be judged)
In this homework, you are going to implement a clustering algorithm called 'centroid hierarchical clustering algorithm' to hierarchically group N 2-dimensional points in the plane.
Descriptions
Your program (CentroidClustering.java) must acquire the input file name from the command line (args[0]) and then open it. The first line of the input file specifies the number of points (N), followed by the 2-dimensional coordinates of the N points.

The clustering procedures are described as follows:
1. Treat each point as a cluster;
2. Find cluster pair of a and b, which has the minimum distance;
3. Create a new cluster, c, of which the coordinates are the centroid of all the points it contains after merging the clusters a and b;
4. Delete the two old clusters: a and b;
5. N = N - 1;
6. Re-calculate the distance of the new cluster, c, to the other remaining clusters;
7. go to Step 1 unless N = 3;  

Output the size and coordinates of the remaining three clusters.  
Example Image:
![](https://github.com/xiechen0692/PDSA_107-1/blob/master/CentroidClustering/hw5.png)
```
Input Example
hw5.zip
Output Example
11 0.29 0.42 
5 0.76 0.81 
4 0.75 0.17 
(You can use String.format("%.2f", d)to format a double d)
```
