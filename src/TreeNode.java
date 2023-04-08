public class TreeNode {
    private final String val;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(String val){
        this.val = val;
    }

    public TreeNode(String val, TreeNode l, TreeNode r){
        this.val = val;
        this.left = l;
        this.right = r;
    }


    public String getVal(){return val;}
    public TreeNode getLeft(){return left;}
    public TreeNode getRight(){return right;}
}
