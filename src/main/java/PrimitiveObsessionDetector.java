import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class PrimitiveObsessionDetector extends VoidVisitorAdapter<Void> {

    @Override
    public void visit(MethodDeclaration n, Void args) {
        VariableAnalyser va = new VariableAnalyser();
        n.accept(va, null);

        double ratio = va.getPrimitives() / va.getVariables();
        if (va.getPrimitives() > 5 && ratio > 0.7) {
            System.out.println("Method: \"" + n.getName() + "\" is obsessed with primitives. Primitive percentage: " + String.format("%.2f", ratio * 100) + "%");
        }
        super.visit(n, args);
    }

    private class VariableAnalyser extends VoidVisitorAdapter<Void> {
        private double primitiveCount = 0;
        private double variableCount = 0;

        @Override
        public void visit(VariableDeclarator n, Void args) {
            if (n.getType().isPrimitiveType()) {
                primitiveCount++;
            }
            variableCount++;
            super.visit(n, args);
        }

        double getVariables() {
            return variableCount;
        }

        double getPrimitives() {
            return primitiveCount;
        }
    }

}
