/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lab228
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lab228
 */
public class HW6_2
{  
    private static Node root = null;
    static int preIndex = 0;
    public  void BTprint(String inString, String preString) 
    {
        // Build a binary tree based on in-order and post-order traversal and return the root of binary tree constructed.
        // The judging system will traverse your binary tree from this root, therefore DO NOT return only the key or value of the root.
        String[] inArray = inString.split(" ") ;
        String[] preArray = preString.split(" ") ;
        int end = preArray.length;
        int[] int_inArray = new int[end];
        int[] int_preArray = new int[end];
        for(int i=0;i<end;i++)
        {
        int_inArray[i]=Integer.parseInt(inArray[i]);
        }
        for(int i=0;i<end;i++)
        {
        int_preArray[i]=Integer.parseInt(preArray[i]);
        }        
        root = build(int_inArray, int_preArray, 0, end-1);
        printpostorder(root);   
    }
//    String a = "4 2 5 1 6 7 3 8 ";
//    String b = "4 5 2 6 7 8 3 1 ";
    public  Node build(int in[], int pre[], int inStrt, int inEnd)
    {
        if (inStrt > inEnd) 
            return null; 
        Node node = new Node(pre[preIndex++] , null);
        if (inStrt == inEnd) 
            return node; 
        int iIndex = search(in, inStrt, inEnd, node.getKey()); 
        node.setLeft(build(in, pre, inStrt, iIndex - 1)); 
        node.setRight(build(in, pre, iIndex + 1, inEnd));         
        return node;
    }
    
    public static int search(int arr[], int strt, int end, int value) 
    { 
        int i; 
        for (i = strt; i <= end; i++) 
        { 
            if (arr[i] == value) 
                return i; 
        } 
        return i; 
    }
    
    public void printpostorder(Node node) 
    { 
        if (node == null) 
            return; 
  
        /* first recur on left child */
        printpostorder(node.getLeft()); 
        printpostorder(node.getRight());
        /* then print the data of node */
        System.out.print(node.getKey() + " ");    
    } 
    
//    public static void main(String[] args) throws Exception
//    {
//        HW6_2 kk = new HW6_2();
//        String a = "4 2 5 1 3 6 ";
//        String b = "1 2 4 5 3 6 ";
//        kk.BTrebuild(a,b);
////        System.out.println(AA.getKey());
////        System.out.println("Preorder of the constructed tree : "); 
////        kk.preOrder(root); 
//    }
}

