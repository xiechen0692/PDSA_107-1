# HW3-1 Using stacks.
In HW3-1, you are requested to implement a class named: Calculator  
This class must contain a public function with the following API:  
public Double ans (String e) 
```
{
    // please replace the following null to the answer you calculated.
    return null
}
```
Input to the function 'ans':
```
( ( ( 1 + ( 12 * 5 ) ) - ( 3 * 4 ) ) + ( 4 / 5 ) )
```
Return value of the function 'ans':  
49.80

Note:
The judge system will construct an object by calling Calculator cct = new Calculator().  
We won't execute your main function in Calculator.java.  
You do not need to worry about the format of printing the Double value.  
All the numbers, operators, and brackets are seperated by 'single space', so you don't have to spend much time on parsing string.  
You only need to handle with the operator such as (+, -, *, /)  
Each bracket contains one operator only, there are not ( 3 + 2 / 4).  
File to be submitted to the judge system: Calculator.java  
# HW3-2 Josephus problem.  
In the Josephus problem from antiquity, N people are in dire straits and agree to the following strategy to reduce the population.  
They arrange themselves in a circle (at positions numbered from 0 to N–1) and proceed around the circle, eliminating every Mth person until only one person is left.  
Legend has it that Josephus figured out where to sit to avoid being eliminated.  
Please implment CircularQueue.java with the folloinwg API:  
```
public class CircularQueue <Item> implements Iterable 
{
    public CircularQueue() { }
    public boolean isEmpty() { }
    public int size() { }
    public void enqueue(Item item) { // Add item to the end of the list }
    public Item removeFirst() { // Remove item from the beginning of the list }
    public Iterator iterator() { }
    public static void main(String[] args) { }
}
```
In a circular queue, no links are null and the value of last.next is first whenever the list is not empty. Keep only one Node instance variable (last).

And write a client using the main function of CircularQueue that takes N and M from the command line and prints out the order in which people are eliminated (and thus would show Josephus where to sit in the circle).

% java Josephus 7 2

1 3 5 0 4 2 6

Please note that we might test your Iterator even though your Josephus client might not use it. 
