# HW6 Practices on binary tree construction
## HW6-1:
Assignment:
Construct the binary tree from inorder and postorder traversals.

Description:
Please upload HW6_1.java that contains the following function:
```
public Node BTrebuild(String inString, String postString) 
{ 
  //return the root of the binary tree constructed 
}
```
Example input:
4 2 5 1 6 7 3 8 
4 5 2 6 7 8 3 1

Note 1:

- The first line is the inorder traversal and the second line is the postorder traversal.
- The Node.java is provided in the following file: HW6.zip, and it will be provided by the judge system, too.
- When constructing the binary tree, put the number to a node as key.
## HW6-2:
Assignment: Print the postorder traversal from given inorder and preorder traversals. Description: Please upload HW6_2.java that contains the following function:

public void BTprint(String inString, String preString)
{ 
  //print the postorder string inside this function 
}
      
Example input:
4 2 5 1 3 6
1 2 4 5 3 6

Note 2: the first line is the inorder traversal and the second line is the preorder traversal.

Example output:
4 5 2 6 3 1

Note 3: For both HW6-1 and HW6-2, only positive integers are used in the test data. The numbers in one test file are distinct, but please do take care of multi-digit integers.
