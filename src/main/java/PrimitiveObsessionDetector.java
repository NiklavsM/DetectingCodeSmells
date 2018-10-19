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
        VariableCounter vc = new VariableCounter();
        n.accept(vc, null);
        double ratio = vc.getPrimitives()/vc.getVariables();
        if (vc.getPrimitives()> 5 && ratio > 0.5) {
            System.out.println("Class: \"" + n.getName() + "\" is obsessed with primitives. Primitive percentage: " + ratio);
        }
        super.visit(n, args);
    }

//    @Override
//    public void visit(MethodDeclaration n, Void args) {
//        VariableCounter pc = new VariableCounter();
//        n.accept(pc, null);
//        if (pc.getCount() > 8) { //TODO what number. Also should we care about parameters
//            System.out.println("Method: \"" + n.getName() + "\" is obsessed with primitives. Primitive cound: " + vdc.getCount());
//        }
//    }

    private class VariableCounter extends VoidVisitorAdapter<Void> {
        private double primitiveCount = 0;
        private double variableCount = 0;

        @Override
        public void visit(VariableDeclarator n, Void args) {
            if (n.getType().isPrimitiveType()) {
                primitiveCount++;
                System.out.println("Primitive: " + n.getName());
            }else{
                System.out.println("Not primitive count: " + n.getName());
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
