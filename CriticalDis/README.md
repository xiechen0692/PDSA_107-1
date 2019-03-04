# HW8 CriticalDis
## Assignment:
Finding the CriticalDistance d

## Description:
Please write a program (CriticalDis.java) that reads in N 2-dimensional points. 

An edge is defined as:
1. v is pointing to w, if and only if the distance between v and w is smaller than d 
2. x(v) < x(w) and y(v) < y(w). 

We further define the source s as the point with the smallest x(s)+y(s), and target t as the point with the largest x(t)+y(t). 

Please report the smallest d, which generates at least one path from s to t. 

Please print the distance using:  
System.out.printf("%5.5f\n", d);

### Example Input
hw8.txt
### Example Output
0.35715

Note
You can use Digraph and DirectedDFS class in algs4.jar.
