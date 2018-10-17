import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.List;

public class MessageChainsDetector extends VoidVisitorAdapter<Void> {
    @Override
    public void visit(MethodDeclaration n, Void arg) {
        loopThroughNodes(n.getChildNodes());

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
            if (node instanceof MethodCallExpr) {
                System.out.println(((MethodCallExpr) node).getScope().get().getChildNodes().size());
            }
            loopThroughNodes(node.getChildNodes());

        }
    }

    class MethodChainDetectedCounter extends VoidVisitorAdapter<Void> {
        @Override
        public void visit(MethodCallExpr n, Void args) {
            System.out.println(n.getName());
            super.visit(n, args);
        }

    }

}

