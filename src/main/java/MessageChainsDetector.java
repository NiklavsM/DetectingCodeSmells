import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.LinkedList;

public class MessageChainsDetector extends VoidVisitorAdapter<Void> {

    private LinkedList<String> messageChains = new LinkedList<>();

    @Override
    public void visit(MethodCallExpr n, Void args) {
        if (countMessageChain(n) > 2 && notPresent(n.toString())) {
            System.out.println("MessageChain detected : " + n.toString());
            messageChains.add(n.toString());
        }
        super.visit(n, args);
    }

    private int countMessageChain(MethodCallExpr n) {

        int count = 1;
        for (Node child : n.getChildNodes()) {
            if (child instanceof MethodCallExpr) {
                if (notArgument(n.getArguments(), child.toString())) {
                    count += countMessageChain((MethodCallExpr) child);
                }
            }
        }
        return count;
    }

    private boolean notArgument(NodeList<Expression> args, String maybeArg) {
        for (Expression arg : args) {
            if (arg.toString().equals(maybeArg)) return false;
        }
        return true;
    }

    private boolean notPresent(String potentialChain) {
        for (String chain : messageChains) {
            if (chain.contains(potentialChain)) return false;
        }
        return true;
    }

}

