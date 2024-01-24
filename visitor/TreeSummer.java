
public class TreeSummer implements Visitor
{

private int sum=0;

public int treeSum()
{
   return sum;
}

public void visit(BinaryTree tree)
{
   sum = 0;
   //System.out.println("visited tree");
}

public void visit(TreeNode node)
{
   sum += node.value;
   //System.out.println("visited node");
}

}

