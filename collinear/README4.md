# HW4-1 Point
Please implement Point.java. (Following the API provided in the coursera page). Note that the judge system will not run your main function.

# HW4-2 FastCollinearPoints
Write a program FastCollinearPoints.java that implements this algorithm.
```
public class FastCollinearPoints 
{
    public FastCollinearPoints(Point[] points) // finds all line segments containing 4 or more points
    public int numberOfSegments() // the number of line segments 
    public LineSegment[] segments() // the line segments
}
```
Note:
- To ensure the LineSegments you print is same as the judge system, you should sort the points first. (Sort by y-coordinates, breaking ties by x-coordinates)
- The judge system will run your main function.
- The judge system will use the Point.java provided by itself.
- The judge system will use the LineSegment.java provided by course author.  

Example Image:

```
Input Example:
8
10000	0
0	10000
3000	7000
7000	3000
20000	21000
3000	4000
14000	15000
6000	7000
  
Output Example:
(10000, 0) -> (0, 10000) 
(3000, 4000) -> (20000, 21000)
```