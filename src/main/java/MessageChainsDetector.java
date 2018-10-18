import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.awt.*;

public class MessageChainsDetector extends VoidVisitorAdapter<Void> {


    @Override
    public void visit(MethodCallExpr n, Void args) {
        NodeList<Expression> arguments = n.getArguments();
        int count = 1;
        for (Node child : n.getChildNodes()) {
            if (child instanceof MethodCallExpr) {
                if (notArgument(arguments, child.toString())) {
                    count += countMethodChain((MethodCallExpr) child, 0);
                }
            }
        }
        if (count > 2) {
            System.out.println("MethodChain detected : " + n.toString());
        }
        super.visit(n, args);
    }

    private boolean notArgument(NodeList<Expression> args, String maybeArg) {
        for (Expression arg : args) {
            if (arg.toString().equals(maybeArg)) return false;
        }
        return true;
    }

    private int countMethodChain(MethodCallExpr n, int count) {
        
        count++;
        for (Node child : n.getChildNodes()) {
//            System.out.println("child2 " + child.getClass().getName() + "  " + child.toString() + " " + count);
            if (child instanceof MethodCallExpr) {
                if (notArgument(n.getArguments(), child.toString())) {
//                    System.out.println("child3 " + child.getClass().getName() + "  " + count);
                    count +=countMethodChain((MethodCallExpr) child, count);
                }
            }
        }
        return count;
    }

}

