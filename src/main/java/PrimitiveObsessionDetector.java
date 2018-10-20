import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class PrimitiveObsessionDetector extends VoidVisitorAdapter<Void> {

    @Override
    public void visit(MethodDeclaration n, Void args) {
        VariableCounter vc = new VariableCounter();
        n.accept(vc, null);
        double ratio = vc.getPrimitives()/vc.getVariables();
        if (vc.getPrimitives()> 5 && ratio > 0.5) {
            System.out.println("Method: \"" + n.getName() + "\" is obsessed with primitives. Primitive percentage: " + ratio);
        }
        super.visit(n, args);
    }

    private class VariableCounter extends VoidVisitorAdapter<Void> {
        private double primitiveCount = 0;
        private double variableCount = 0;

        @Override
        public void visit(VariableDeclarator n, Void args) {
            if (n.getType().isPrimitiveType()) {
                primitiveCount++;
            }
            variableCount++;
        }

        double getVariables() {
            return variableCount;
        }

        double getPrimitives() {
            return primitiveCount;
        }
    }

}
