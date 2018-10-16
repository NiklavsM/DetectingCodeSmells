import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.stmt.SwitchStmt;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.List;

public class SwitchStatementDetector extends VoidVisitorAdapter<Void> {

    @Override
    public void visit(MethodDeclaration n, Void arg) {

        if (findSwitchStatements(n.getChildNodes())) {
            System.out.println("Method \"" + n.getName() + "\" is using switch statement, is it really necessary?");
        }

        //     System.out.println("Method: " + n.getName() + " has too many parameters");

    }

    private boolean findSwitchStatements(List<Node> nodes) {
        for (Node node : nodes) {
//            System.out.println("Node " + node.getClass().getName());
            if (node instanceof SwitchStmt) {
//                System.out.println("SwitchStmt " + node.toString());
//                System.out.println("SwitchStmt selector " + (((SwitchStmt)node).getSelector()).getClass().getName());

                return true;
            }
            if (findSwitchStatements(node.getChildNodes())) {
                return true;
            }
        }
        return false;
    }

}
