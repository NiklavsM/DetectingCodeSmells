import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.List;

public class PrimitiveObsessionDetector extends VoidVisitorAdapter<Void> {

    @Override
    public void visit(ClassOrInterfaceDeclaration n, Void args) {
        int primitiveCount;
        primitiveCount = countPrimitiveVariables(n.getChildNodes());
        if (primitiveCount > 10) { //TODO what number. Also should we care about parameters
            System.out.println("Class: \"" + n.getName() + "\" is obsessed with primitives. Primitive cound: " + primitiveCount);
        }
        super.visit(n, args);
    }

    @Override
    public void visit(MethodDeclaration n, Void args) {
        VariableDeclaratorCounter vdc = new VariableDeclaratorCounter();
        n.accept(vdc, null);
        if (vdc.getCount() > 8) { //TODO what number. Also should we care about parameters
            System.out.println("Method: \"" + n.getName() + "\" is obsessed with primitives. Primitive cound: " + vdc.getCount());
        }
    }

    private int countPrimitiveVariables(List<Node> nodes) {
        int primitiveFieldCount = 0;
        for (Node node : nodes) {
            if (node instanceof FieldDeclaration) {
                primitiveFieldCount += countPrimitiveVariables(node.getChildNodes());
            }
            if (node instanceof VariableDeclarator) {
                if (((VariableDeclarator) node).getType().isPrimitiveType()) {
                    primitiveFieldCount++;
                }
            }

        }
        return primitiveFieldCount;


    }

    private class VariableDeclaratorCounter extends VoidVisitorAdapter<Void> {
        int count = 0;

        @Override
        public void visit(VariableDeclarator n, Void args) {
            System.out.println(" VariableDeclarator " + n.getName());
            count++;
        }

        int getCount() {
            return count;
        }
    }

}
