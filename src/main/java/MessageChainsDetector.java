import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.List;

public class MessageChainsDetector extends VoidVisitorAdapter<Void> {
    @Override
    public void visit(MethodDeclaration n, Void arg) {
//        loopThroughNodes(n.getChildNodes());

        MethodChainCounter mcc = new MethodChainCounter();
        n.accept(mcc, null);

//        MethodChainDetectedCounter mcd = new MethodChainDetectedCounter();
//        n.accept(mcd, null);
//        super.visit(n, arg);

    }

    private boolean detectMessageChaining() {
        return true;
    }

    public void loopThroughNodes(List<Node> nodes) {
        for (Node node : nodes) {
            System.out.println(node.getClass().getName());
            if (node instanceof AssignExpr) {

            }
            if (node instanceof MethodCallExpr) {
                ((MethodCallExpr) node).getParentNode().ifPresent(node1 -> System.out.println("WOOOW  " + ((MethodCallExpr) node).getName()));
            }
            loopThroughNodes(node.getChildNodes());

        }
    }

    class MethodChainCounter extends VoidVisitorAdapter<Void> {
        @Override
        public void visit(MethodCallExpr n, Void args) {
//            System.out.println("HERE " + n.getName());
            int count = 1;
            for (Node child : n.getChildNodes()) {
//                System.out.println("child " + child.toString());
                if (countMethodChain(child, count) > 2) {
                    System.out.println("MethodChain detected : " + n.toString());
                }
            }
            super.visit(n, args);
        }

        private int countMethodChain(Node node, int count) {
            count++;
            for (Node child : node.getChildNodes()) {
                System.out.println("child2 " + child.getClass().getName() + "  " + child.toString());
                if (child instanceof MethodCallExpr) {
//                    System.out.println("child2 " + child.getClass().getName() + "  " + count);
                    return countMethodChain(child, count);
                }
            }
            return count;
        }

    }

}

