/**
* Binary tree class with Visitor pattern
* - this is a "header" object for the tree
* - uses TreeNode class for nodes in the tree
**/
public class BinaryTree implements Element
{

private TreeNode root; // the actual tree root
private int nodeCount; // current size of tree

/** Default constructor **/
public BinaryTree()
{
   root = null;
   nodeCount = 0;
}

/**
* Generate random tree
* @param numNodes is size of tree
**/
public BinaryTree(int numNodes)
{
   root = null;
   nodeCount = 0;
   for (int i=0; i < numNodes; i++)
      insert((int)(Math.random()*1000));
}

/**
* Insert a new node into tree
* @param val is the node's data
**/
public boolean insert(int val)
{
   if (root == null) {
      root = new TreeNode(val);
      return true;
   }
   return insert(root,val);
}

/**
* Recursive insertion helper; walks the tree
* and inserts the node in the right place
**/
private boolean insert(TreeNode node, int val)
{
   if (node.value > val) {
      if (node.left == null) {
         node.left = new TreeNode(val);
         return true;
      } else {
         return insert(node.left, val);
      }
   } else {
      if (node.right == null) {
         node.right = new TreeNode(val);
         return true;
      } else {
         return insert(node.right, val);
      }
   }
}

/**
* Visitor pattern accept()
* - this method lets the visitor visit this
*   object by using the Visitor's "visit" callback,
*   and then this object passes the visitor on to
*   other objects, namely the root of the tree
**/
public void accept(Visitor v, TraversalType type)
{
   v.visit(this);
   if (root != null)
      root.accept(v,type);
}

/**
* Main: creates a tree of a size given by one argument,
* then prints it
**/
public static void main(String args[])
{
   int n = Integer.parseInt(args[0]);
   System.out.println("Tree should have "+n+" nodes...");
   BinaryTree tree = new BinaryTree(n);
   System.out.println("Tree created!");
   TreePrinter tp = new TreePrinter();
   tree.accept(tp,TraversalType.INORDER);
   TreeSummer ts = new TreeSummer();
   tree.accept(ts,TraversalType.INORDER);
   System.out.println("Tree sum is " + ts.treeSum());
}

} // end class

