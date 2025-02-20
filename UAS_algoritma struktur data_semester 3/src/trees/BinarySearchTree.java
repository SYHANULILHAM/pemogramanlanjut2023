package trees;

class TreeNode {
    int key;

    TreeNode left, right;

    public TreeNode(int item) {
        key = item;
        left = right = null;
    }
}

public class BinarySearchTree {
    TreeNode root;
    BinarySearchTree(){ root = null;}
     void  insert(int key){root = insertRec(root,key); }

    TreeNode insertRec(TreeNode root, int key ) {
        if (root == null ) {
            return new TreeNode(key);
        }
        if (key < root.key)
            root.left= insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
        return root;
    }
    void inorder(){inoderRec(root); }

    void inoderRec(TreeNode root) {
        if (root != null) {
            inoderRec(root.left);
            System.out.println(root.key + " " );
            inoderRec(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        System.out.println("inorder traversal");
        bst.inorder();
    }

}
