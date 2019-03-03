///////////////////////////////////////////
//    Please do not modify this file.    //
///////////////////////////////////////////
public class Node{
    private Integer key;
    private Integer value;
    private Node left;
    private Node right;
    
    public Node(Integer key, Integer value){
        this.key = key;
        this.value = value;
    }
    
    public Node getLeft(){
        return this.left;
    }
    
    public Node getRight(){
        return this.right;
    }
    
    public Integer getKey(){
        return this.key;
    }
    
    public Integer getValue(){
        return this.value;
    }
    
    public void setLeft(Node node){
        this.left = node;
    }
    
    public void setRight(Node node){
        this.right = node;
    }
    
}