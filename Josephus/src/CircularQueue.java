/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lab228
 */
public class CircularQueue <Item> implements Iterable 
{
    private Node first, last;
    public CircularQueue() { }
    public boolean isEmpty() 
    { 
      return first == null;  
    }
    public int size() { }
    public void enqueue(Item item) { // Add item to the end of the list }
    public Item removeFirst() { // Remove item from the beginning of the list }
    public Iterator iterator() { }
    public static void main(String[] args) { }
}
