/**
* TreeNode: a node in the binary tree, with Visitor pattern
**/
public class TreeNode implements Element
{

/* bad code! attributes should not be this accessible! */
int value;
TreeNode left, right;

/**
* Constructor
* @param v is the node's data
**/
public TreeNode(int v)
{
   value = v;
   left = null;
   right = null;
}

/**
* Override Object::toString()
**/
@Override
public String toString()
{
   return String.valueOf(value);
}

/**
* Visitor pattern accept()
* - this method lets the visitor visit this
*   object by using the Visitor's "visit" callback,
*   and then this object passes the visitor on to
*   other objects, namely the child tree nodes
**/
public void accept(Visitor v,TraversalType type)
{
   if (type == TraversalType.PREORDER)
      v.visit(this);
   if (left != null)
      left.accept(v,type);
   if (type == TraversalType.INORDER)
      v.visit(this);
   if (right != null)
      right.accept(v,type);
   if (type == TraversalType.POSTORDER)
      v.visit(this);
}

} // end class

