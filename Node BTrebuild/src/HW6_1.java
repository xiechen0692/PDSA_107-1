/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lab228
 */
public class HW6_1
{  
    private static Node root = null;
    private int n;
    public  Node BTrebuild(String inString, String postString) 
    {
        // Build a binary tree based on in-order and post-order traversal and return the root of binary tree constructed.
        // The judging system will traverse your binary tree from this root, therefore DO NOT return only the key or value of the root.
        String[] inArray = inString.split(" ") ;
        String[] outArray = postString.split(" ") ;
        int end = outArray.length;
        int[] int_inArray = new int[end];
        int[] int_outArray = new int[end];
        for(int i=0;i<end;i++)
        {
        int_inArray[i]=Integer.parseInt(inArray[i]);
        }
        for(int i=0;i<end;i++)
        {
        int_outArray[i]=Integer.parseInt(outArray[i]);
        }        
//        if (start > end) 
//            return null;
         
        n = outArray.length - 1;
//        Node new_root = new Node(int_outArray[outArray.length - 1],null); 
//        root=new_root;
        root = build(int_inArray, int_outArray, 0, end-1);
        return root;
    }
//    String a = "4 2 5 1 6 7 3 8 ";
//    String b = "4 5 2 6 7 8 3 1 ";
    public  Node build(int in[], int post[], int inStrt, int inEnd)
    {
        
        // Base case 
        if (inStrt > inEnd) 
            return null; 
        /* Pick current node from Postrder traversal using 
           postIndex and decrement postIndex */
        Node node = new Node( post[n] , null ); 
        System.out.println("inStrt: "+inStrt+", "+"inEnd: " + inEnd);
        System.out.println("poseindex: "+n+" getKey(): " + node.getKey()+ ", n="+n+"-->"+(n-1));
        
        n --;
        /* If this node has no children then return */
        if (inStrt == inEnd) 
            return node; 
        int iIndex = search(in, inStrt, inEnd, node.getKey()); 
        System.out.println("iIndex:"+iIndex);
        System.out.println("**********************");
//        System.out.println(iIndex);
        //Index ii = search(in, inStrt, inEnd,int_inArray[inArray.length]);
        /* Using index in Inorder traversal, construct left and 
           right subtress */
        node.setRight(build(in, post, iIndex + 1, inEnd)); 
        node.setLeft(build(in, post, inStrt, iIndex - 1));         
        return node;
    }
    
    public static int search(int arr[], int strt, int end, int value) 
    { 
        int i; 
        for (i = strt; i <= end; i++) 
        { 
            if (arr[i] == value) 
                break; 
        } 
        return i; 
    }
    
//        void preOrder(Node node) 
//    { 
//        if (node == null) 
//            return; 
//        System.out.print(node.getKey() + " "); 
//        preOrder(node.getLeft()); 
//        preOrder(node.getRight()); 
//    } 
    
//    public static void main(String[] args) throws Exception
//    {
//        HW6_1 kk = new HW6_1();
//        String a = "4 2 5 1 6 7 3 8 ";
//        String b = "4 5 2 6 7 8 3 1 ";
//        Node AA = kk.BTrebuild(a,b);
////        System.out.println(AA.getKey());
////        System.out.println("Preorder of the constructed tree : "); 
////        kk.preOrder(root); 
//    }
    
}
