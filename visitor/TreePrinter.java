
public class TreePrinter implements Visitor
{

public void visit(BinaryTree tree)
{
   System.out.println("Tree: "+tree);
}

public void visit(TreeNode node)
{
   System.out.println("  Node: "+node);
}

}

