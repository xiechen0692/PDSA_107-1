# HW7 Building and using 2d-tree
## Assignment:  
Finding the k-nearest neighbors

Description:  
Please design a class 'FindNeighbors.java' which contains the following two public functions:
1. Construct a 2d-tree when given a Point2D array
```
public void init(Point2D[] points)
{

  return;

}
```    
2. Report the k-nearest neighbors when given a new coordinates
```
public Point2D[] query(Point2D point, int k)
{
  Point2D[] result = new Point2D[k];
  return result;
  // the points should be sorted accordingly to their distances to the query, from small to large

} 
```    
Notes
1. Use the Point2D.java in algs4.jar.
2. Use priority queue to fasten your query.
