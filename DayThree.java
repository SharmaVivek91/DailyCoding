class TreeNode {
    TreeNode leftChild;
    TreeNode rightChild;
    int data;
    TreeNode(int data) {
        this.data = data;
    }
}
class InvertTree {
    TreeNode rightNode;
    void invertNodes(TreeNode node) {
        if(node == null)
            return ;
        rightNode = node.rightChild;
        node.rightChild = node.leftChild;
        node.leftChild = rightNode;
        invertNodes(node.rightChild);
        invertNodes(node.leftChild);
    }
    //Pre-order Traversal
    void displayTree(TreeNode node) {
        if(node == null)
            return;
        System.out.println(node.data);
        displayTree(node.leftChild);
        displayTree(node.rightChild);
    }
} 
public class DayThree {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(5);
        root.leftChild = new TreeNode(3);
        root.rightChild = new TreeNode(6);
        root.rightChild.leftChild = new TreeNode(4);
        root.rightChild.rightChild = new TreeNode(8);
        InvertTree invertTree = new InvertTree();
        invertTree.displayTree(root);
        invertTree.invertNodes(root);
        System.out.println("test");
        invertTree.displayTree(root);
    }
    
}
