import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.LinkedList;

public class MessageChainsDetector extends VoidVisitorAdapter<Void> {

    private LinkedList<String> messageChanins = new LinkedList<String>();
    @Override
    public void visit(MethodCallExpr n, Void args) {
        if (countMethodChain(n) > 2 && notPresent(n.toString())) {
            System.out.println("MethodChain detected : " + n.toString());
            messageChanins.add(n.toString());
        }
        super.visit(n, args);
    }

    private int countMethodChain(MethodCallExpr n) {

        int count = 1;
        for (Node child : n.getChildNodes()) {
            if (child instanceof MethodCallExpr) {
                if (notArgument(n.getArguments(), child.toString())) {
                    count += countMethodChain((MethodCallExpr) child);
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

    private boolean notPresent(String potentialChain){
        for(String chain: messageChanins){
            if(chain.contains(potentialChain)) return false;
        }
        return true;
    }

}

