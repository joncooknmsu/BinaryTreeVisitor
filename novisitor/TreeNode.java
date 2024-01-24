/**
* TreeNode: a node in the binary tree
**/
public class TreeNode 
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

} // end class

